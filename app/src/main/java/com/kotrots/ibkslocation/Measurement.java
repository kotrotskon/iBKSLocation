package com.kotrots.ibkslocation;

import android.content.ContentValues;
import android.content.Context;
import android.util.Log;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.HashMap;

public class Measurement {

    private int rssiA;
    private int rssiB;
    private int rssiC;
    private int rssiD;
    private int rssiE;
    private int rssiF;
    private int rssiG;
    private int rssiH;
    private int rssiJ;
    private int rssiI;
    private double distanceA;
    private double distanceB;
    private double distanceC;
    private double distanceD;
    private double distanceE;
    private double distanceF;
    private double distanceG;
    private double distanceH;
    private double distanceI;
    private double distanceJ;
    private long timeStamp;

    public Measurement() {

    }

    public Measurement(HashMap<String, Integer> rssi, HashMap<String, Double> distance){
        this.rssiA = rssi.get("rssi_A");
        this.rssiB = rssi.get("rssi_B");
        this.rssiC = rssi.get("rssi_C");
        this.rssiD = rssi.get("rssi_D");
        this.rssiE = rssi.get("rssi_E");
        this.rssiF = rssi.get("rssi_F");
        this.rssiG = rssi.get("rssi_G");
        this.rssiH = rssi.get("rssi_H");
        this.rssiI = rssi.get("rssi_I");
        this.rssiJ = rssi.get("rssi_J");

        this.distanceA = distance.get("distance_A");
        this.distanceB = distance.get("distance_B");
        this.distanceC = distance.get("distance_C");
        this.distanceD = distance.get("distance_D");
        this.distanceE = distance.get("distance_E");
        this.distanceF = distance.get("distance_F");
        this.distanceG = distance.get("distance_G");
        this.distanceH = distance.get("distance_H");
        this.distanceI = distance.get("distance_I");
        this.distanceJ = distance.get("distance_J");
    }

    public void save(Context context){
        Log.d("SAVE", "A:"+this.rssiA+" "+this.distanceA+", " +
                "B:"+this.rssiB+" "+this.distanceB+", " +
                "C:"+this.rssiC+" "+this.distanceC+", " +
                "D:"+this.rssiD+" "+this.distanceD+", " +
                "D:"+this.rssiE+" "+this.distanceE+", " +
                "D:"+this.rssiF+" "+this.distanceF+", " +
                "D:"+this.rssiG+" "+this.distanceG+", " +
                "D:"+this.rssiH+" "+this.distanceH+", " +
                "D:"+this.rssiI+" "+this.distanceI+", " +
                "E:"+this.rssiJ+" "+this.distanceJ);

        DataSource dataSource = new DataSource(context);
        try {
            dataSource.open();
            ContentValues values = new ContentValues();
            values.put(SQLliteHelper.COLUMN_RSSI_A, this.rssiA);
            values.put(SQLliteHelper.COLUMN_RSSI_B, this.rssiB);
            values.put(SQLliteHelper.COLUMN_RSSI_C, this.rssiC);
            values.put(SQLliteHelper.COLUMN_RSSI_D, this.rssiD);
            values.put(SQLliteHelper.COLUMN_RSSI_E, this.rssiE);
            values.put(SQLliteHelper.COLUMN_RSSI_F, this.rssiF);
            values.put(SQLliteHelper.COLUMN_RSSI_G, this.rssiG);
            values.put(SQLliteHelper.COLUMN_RSSI_H, this.rssiH);
            values.put(SQLliteHelper.COLUMN_RSSI_I, this.rssiI);
            values.put(SQLliteHelper.COLUMN_RSSI_J, this.rssiJ);
            values.put(SQLliteHelper.COLUMN_DISTANCE_A, this.distanceA);
            values.put(SQLliteHelper.COLUMN_DISTANCE_B, this.distanceB);
            values.put(SQLliteHelper.COLUMN_DISTANCE_C, this.distanceC);
            values.put(SQLliteHelper.COLUMN_DISTANCE_D, this.distanceD);
            values.put(SQLliteHelper.COLUMN_DISTANCE_E, this.distanceE);
            values.put(SQLliteHelper.COLUMN_DISTANCE_F, this.distanceF);
            values.put(SQLliteHelper.COLUMN_DISTANCE_G, this.distanceG);
            values.put(SQLliteHelper.COLUMN_DISTANCE_H, this.distanceH);
            values.put(SQLliteHelper.COLUMN_DISTANCE_I, this.distanceI);
            values.put(SQLliteHelper.COLUMN_DISTANCE_J, this.distanceJ);
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            values.put(SQLliteHelper.COLUMN_TIMESTAMP, timestamp.getTime());

            dataSource.database.insert(SQLliteHelper.TABLE_MEASUREMENTS, null, values);
            dataSource.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
