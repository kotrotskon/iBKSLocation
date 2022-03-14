package com.kotrots.ibkslocation;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanResult;
import android.bluetooth.le.ScanSettings;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

import static com.accent_systems.ibks_sdk.scanner.ASResultParser.byteArrayToHex;

public class MainActivity extends AppCompatActivity {

    BluetoothAdapter mBluetoothAdapter;
    BluetoothGatt mBluetoothGatt;
    BluetoothLeScanner scanner;
    ScanSettings scanSettings;

    EditText edTxt_iBKS105_A_RSSI;
    EditText edTxt_iBKS105_B_RSSI;
    EditText edTxt_iBKS105_C_RSSI;
    EditText edTxt_iBKS105_D_RSSI;
    EditText edTxt_iBKS105_E_RSSI;
    EditText edTxt_iBKS105_F_RSSI;
    EditText edTxt_iBKS105_G_RSSI;
    EditText edTxt_iBKS105_H_RSSI;
    EditText edTxt_iBKS105_I_RSSI;
    EditText edTxt_iBKS105_J_RSSI;

    EditText edTxt_iBKS105_A_distance;
    EditText edTxt_iBKS105_B_distance;
    EditText edTxt_iBKS105_C_distance;
    EditText edTxt_iBKS105_D_distance;
    EditText edTxt_iBKS105_E_distance;
    EditText edTxt_iBKS105_F_distance;
    EditText edTxt_iBKS105_G_distance;
    EditText edTxt_iBKS105_H_distance;
    EditText edTxt_iBKS105_I_distance;
    EditText edTxt_iBKS105_J_distance;

    Button btn_save;
    Button btn_clr;

    private static String TAG = "TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edTxt_iBKS105_A_RSSI = findViewById(R.id.edTxt_iBKS105_A_RSSI);
        edTxt_iBKS105_B_RSSI = findViewById(R.id.edTxt_iBKS105_B_RSSI);
        edTxt_iBKS105_C_RSSI = findViewById(R.id.edTxt_iBKS105_C_RSSI);
        edTxt_iBKS105_D_RSSI = findViewById(R.id.edTxt_iBKS105_D_RSSI);
        edTxt_iBKS105_E_RSSI = findViewById(R.id.edTxt_iBKS105_E_RSSI);
        edTxt_iBKS105_F_RSSI = findViewById(R.id.edTxt_iBKS105_F_RSSI);
        edTxt_iBKS105_G_RSSI = findViewById(R.id.edTxt_iBKS105_G_RSSI);
        edTxt_iBKS105_H_RSSI = findViewById(R.id.edTxt_iBKS105_H_RSSI);
        edTxt_iBKS105_I_RSSI = findViewById(R.id.edTxt_iBKS105_I_RSSI);
        edTxt_iBKS105_J_RSSI = findViewById(R.id.edTxt_iBKS105_J_RSSI);

        edTxt_iBKS105_A_distance = findViewById(R.id.edTxt_iBKS105_A_distance);
        edTxt_iBKS105_B_distance = findViewById(R.id.edTxt_iBKS105_B_distance);
        edTxt_iBKS105_C_distance = findViewById(R.id.edTxt_iBKS105_C_distance);
        edTxt_iBKS105_D_distance = findViewById(R.id.edTxt_iBKS105_D_distance);
        edTxt_iBKS105_E_distance = findViewById(R.id.edTxt_iBKS105_E_distance);
        edTxt_iBKS105_F_distance = findViewById(R.id.edTxt_iBKS105_F_distance);
        edTxt_iBKS105_G_distance = findViewById(R.id.edTxt_iBKS105_G_distance);
        edTxt_iBKS105_H_distance = findViewById(R.id.edTxt_iBKS105_H_distance);
        edTxt_iBKS105_I_distance = findViewById(R.id.edTxt_iBKS105_I_distance);
        edTxt_iBKS105_J_distance = findViewById(R.id.edTxt_iBKS105_J_distance);

        btn_save = findViewById(R.id.btn_save);
        btn_clr = findViewById(R.id.btn_clr);

        //init Bluetooth adapter
        initBT();
        //Start scan of bluetooth devices
        startLeScan(true);

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Handler handler = new Handler();
                    for (int i=0; i<300; i++){
                        final int finalI = i;
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                HashMap<String, Integer> rssi = new HashMap<>();
                                rssi.put("rssi_A", Integer.valueOf(edTxt_iBKS105_A_RSSI.getText().toString()));
                                rssi.put("rssi_B", Integer.valueOf(edTxt_iBKS105_B_RSSI.getText().toString()));
                                rssi.put("rssi_C", Integer.valueOf(edTxt_iBKS105_C_RSSI.getText().toString()));
                                rssi.put("rssi_D", Integer.valueOf(edTxt_iBKS105_D_RSSI.getText().toString()));
                                rssi.put("rssi_E", Integer.valueOf(edTxt_iBKS105_E_RSSI.getText().toString()));
                                rssi.put("rssi_F", Integer.valueOf(edTxt_iBKS105_F_RSSI.getText().toString()));
                                rssi.put("rssi_G", Integer.valueOf(edTxt_iBKS105_G_RSSI.getText().toString()));
                                rssi.put("rssi_H", Integer.valueOf(edTxt_iBKS105_H_RSSI.getText().toString()));
                                rssi.put("rssi_I", Integer.valueOf(edTxt_iBKS105_I_RSSI.getText().toString()));
                                rssi.put("rssi_J", Integer.valueOf(edTxt_iBKS105_J_RSSI.getText().toString()));

                                HashMap<String, Double> distance = new HashMap<>();
                                distance.put("distance_A", Double.valueOf(edTxt_iBKS105_A_distance.getText().toString()));
                                distance.put("distance_B", Double.valueOf(edTxt_iBKS105_B_distance.getText().toString()));
                                distance.put("distance_C", Double.valueOf(edTxt_iBKS105_C_distance.getText().toString()));
                                distance.put("distance_D", Double.valueOf(edTxt_iBKS105_D_distance.getText().toString()));
                                distance.put("distance_E", Double.valueOf(edTxt_iBKS105_E_distance.getText().toString()));
                                distance.put("distance_F", Double.valueOf(edTxt_iBKS105_F_distance.getText().toString()));
                                distance.put("distance_G", Double.valueOf(edTxt_iBKS105_G_distance.getText().toString()));
                                distance.put("distance_H", Double.valueOf(edTxt_iBKS105_H_distance.getText().toString()));
                                distance.put("distance_I", Double.valueOf(edTxt_iBKS105_I_distance.getText().toString()));
                                distance.put("distance_J", Double.valueOf(edTxt_iBKS105_J_distance.getText().toString()));

                                Measurement measurement = new Measurement(rssi, distance);

                                measurement.save(MainActivity.this);

                                Toast.makeText(MainActivity.this, "Save: " + finalI + "/300", Toast.LENGTH_LONG).show();

                                edTxt_iBKS105_A_RSSI.setTypeface(null, Typeface.NORMAL);
                                edTxt_iBKS105_B_RSSI.setTypeface(null, Typeface.NORMAL);
                                edTxt_iBKS105_C_RSSI.setTypeface(null, Typeface.NORMAL);
                                edTxt_iBKS105_D_RSSI.setTypeface(null, Typeface.NORMAL);
                                edTxt_iBKS105_E_RSSI.setTypeface(null, Typeface.NORMAL);
                                edTxt_iBKS105_F_RSSI.setTypeface(null, Typeface.NORMAL);
                                edTxt_iBKS105_G_RSSI.setTypeface(null, Typeface.NORMAL);
                                edTxt_iBKS105_H_RSSI.setTypeface(null, Typeface.NORMAL);
                                edTxt_iBKS105_I_RSSI.setTypeface(null, Typeface.NORMAL);
                                edTxt_iBKS105_J_RSSI.setTypeface(null, Typeface.NORMAL);

                                if(finalI == 300){
                                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                                    builder.setMessage("Collection has finish");
                                    builder.setTitle("Finish");
                                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialogInterface, int i) {
                                            dialogInterface.cancel();
                                        }
                                    });
                                    AlertDialog dialog = builder.create();
                                    dialog.show();
                                }
                            }
                        }, 1000 * 3 * i);

                    }

                } catch (NumberFormatException e){

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        btn_clr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edTxt_iBKS105_A_distance.setText("");
                edTxt_iBKS105_B_distance.setText("");
                edTxt_iBKS105_C_distance.setText("");
                edTxt_iBKS105_D_distance.setText("");
                edTxt_iBKS105_E_distance.setText("");
                edTxt_iBKS105_F_distance.setText("");
                edTxt_iBKS105_G_distance.setText("");
                edTxt_iBKS105_H_distance.setText("");
                edTxt_iBKS105_I_distance.setText("");
                edTxt_iBKS105_J_distance.setText("");
            }
        });
    }

    private void initBT(){
        final BluetoothManager bluetoothManager =  (BluetoothManager) getSystemService(Context.BLUETOOTH_SERVICE);
        mBluetoothAdapter = bluetoothManager.getAdapter();

        //Create the scan settings
        ScanSettings.Builder scanSettingsBuilder = new ScanSettings.Builder();
        //Set scan latency mode. Lower latency, faster device detection/more battery and resources consumption
        scanSettingsBuilder.setScanMode(ScanSettings.SCAN_MODE_LOW_LATENCY);
        //Wrap settings together and save on a settings var (declared globally).
        scanSettings = scanSettingsBuilder.build();
        //Get the BLE scanner from the BT adapter (var declared globally)
        scanner = mBluetoothAdapter.getBluetoothLeScanner();
    }

    private void startLeScan(boolean endis) {
        if (endis) {
            //********************
            //START THE BLE SCAN
            //********************
            //Scanning parameters FILTER / SETTINGS / RESULT CALLBACK. Filter are used to define a particular
            //device to scan for. The Callback is defined above as a method.
            scanner.startScan(null, scanSettings, mScanCallback);
        }else{
            //Stop scan
            scanner.stopScan(mScanCallback);
        }
    }

    private ScanCallback mScanCallback = new ScanCallback() {
        @Override
        public void onScanResult(int callbackType, ScanResult result) {
            super.onScanResult(callbackType, result);

            //Here will be received all the detected BLE devices around. "result" contains the device
            //address and name as a BLEPeripheral, the advertising content as a ScanRecord, the Rx RSSI
            //and the timestamp when received. Type result.get... to see all the available methods you can call.

            //Convert advertising bytes to string for a easier parsing. GetBytes may return a NullPointerException. Treat it right(try/catch).
            String advertisingString = byteArrayToHex(result.getScanRecord().getBytes());
            //Print the advertising String in the LOG with other device info (ADDRESS - RSSI - ADVERTISING - NAME)
            Log.i(TAG, result.getDevice().getAddress()+" - RSSI: "+result.getRssi()+"\t - "+advertisingString+" - "+result.getDevice().getName());

            if (result!=null && result.getDevice().getName()!=null) {
                printRSSI(result.getDevice().getName(), result.getRssi());
            }
        }
    };

    private void printRSSI(String name, int rssi){
        switch (name){
            case "iBKS105_A":
                edTxt_iBKS105_A_RSSI.setText(String.valueOf(rssi));
                edTxt_iBKS105_A_RSSI.setTypeface(null, Typeface.BOLD);
                break;
            case "iBKS105_B":
                edTxt_iBKS105_B_RSSI.setText(String.valueOf(rssi));
                edTxt_iBKS105_B_RSSI.setTypeface(null, Typeface.BOLD);
                break;
            case "iBKS105_C":
                edTxt_iBKS105_C_RSSI.setText(String.valueOf(rssi));
                edTxt_iBKS105_C_RSSI.setTypeface(null, Typeface.BOLD);
                break;
            case "iBKS105_D":
                edTxt_iBKS105_D_RSSI.setText(String.valueOf(rssi));
                edTxt_iBKS105_D_RSSI.setTypeface(null, Typeface.BOLD);
                break;
            case "iBKS105_E":
                edTxt_iBKS105_E_RSSI.setText(String.valueOf(rssi));
                edTxt_iBKS105_E_RSSI.setTypeface(null, Typeface.BOLD);
                break;
            case "iBKS105_F":
                edTxt_iBKS105_F_RSSI.setText(String.valueOf(rssi));
                edTxt_iBKS105_F_RSSI.setTypeface(null, Typeface.BOLD);
                break;
            case "iBKS105_G":
                edTxt_iBKS105_G_RSSI.setText(String.valueOf(rssi));
                edTxt_iBKS105_G_RSSI.setTypeface(null, Typeface.BOLD);
                break;
            case "iBKS105_H":
                edTxt_iBKS105_H_RSSI.setText(String.valueOf(rssi));
                edTxt_iBKS105_H_RSSI.setTypeface(null, Typeface.BOLD);
                break;
            case "iBKS105_I":
                edTxt_iBKS105_I_RSSI.setText(String.valueOf(rssi));
                edTxt_iBKS105_I_RSSI.setTypeface(null, Typeface.BOLD);
                break;
            case "iBKS105_J":
                edTxt_iBKS105_J_RSSI.setText(String.valueOf(rssi));
                edTxt_iBKS105_J_RSSI.setTypeface(null, Typeface.BOLD);
                break;
            default:
                break;

        }
    }
}
