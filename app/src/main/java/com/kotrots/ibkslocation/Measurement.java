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
    private double distanceA;
    private double distanceB;
    private double distanceC;
    private double distanceD;
    private double distanceE;
    private long timeStamp;

    public Measurement() {

    }

    public Measurement(HashMap<String, Integer> rssi, HashMap<String, Double> distance){
        this.rssiA = rssi.get("rssi_A");
        this.rssiB = rssi.get("rssi_B");
        this.rssiC = rssi.get("rssi_C");
        this.rssiD = rssi.get("rssi_D");
        this.rssiE = rssi.get("rssi_E");

        this.distanceA = distance.get("distance_A");
        this.distanceB = distance.get("distance_B");
        this.distanceC = distance.get("distance_C");
        this.distanceD = distance.get("distance_D");
        this.distanceE = distance.get("distance_E");
    }

    public void save(Context context){
        Log.d("SAVE", "A:"+this.rssiA+" "+this.distanceA+", " +
                "B:"+this.rssiB+" "+this.distanceB+", " +
                "C:"+this.rssiC+" "+this.distanceC+", " +
                "D:"+this.rssiD+" "+this.distanceD+", " +
                "E:"+this.rssiE+" "+this.distanceE);

        DataSource dataSource = new DataSource(context);
        try {
            dataSource.open();
            ContentValues values = new ContentValues();
            values.put(SQLliteHelper.COLUMN_RSSI_A, this.rssiA);
            values.put(SQLliteHelper.COLUMN_RSSI_B, this.rssiB);
            values.put(SQLliteHelper.COLUMN_RSSI_C, this.rssiC);
            values.put(SQLliteHelper.COLUMN_RSSI_D, this.rssiD);
            values.put(SQLliteHelper.COLUMN_RSSI_E, this.rssiE);
            values.put(SQLliteHelper.COLUMN_DISTANCE_A, this.distanceA);
            values.put(SQLliteHelper.COLUMN_DISTANCE_B, this.distanceB);
            values.put(SQLliteHelper.COLUMN_DISTANCE_C, this.distanceC);
            values.put(SQLliteHelper.COLUMN_DISTANCE_D, this.distanceD);
            values.put(SQLliteHelper.COLUMN_DISTANCE_E, this.distanceE);
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            values.put(SQLliteHelper.COLUMN_TIMESTAMP, timestamp.getTime());

            dataSource.database.insert(SQLliteHelper.TABLE_MEASUREMENTS, null, values);
            dataSource.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
