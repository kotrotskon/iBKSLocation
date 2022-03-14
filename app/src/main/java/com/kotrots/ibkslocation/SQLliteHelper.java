package com.kotrots.ibkslocation;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class SQLliteHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "rssi_db.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_MEASUREMENTS = "measurements";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_RSSI_A = "rssi_a";
    public static final String COLUMN_RSSI_B = "rssi_b";
    public static final String COLUMN_RSSI_C = "rssi_c";
    public static final String COLUMN_RSSI_D = "rssi_d";
    public static final String COLUMN_RSSI_E = "rssi_e";
    public static final String COLUMN_RSSI_F = "rssi_f";
    public static final String COLUMN_RSSI_G = "rssi_g";
    public static final String COLUMN_RSSI_H = "rssi_h";
    public static final String COLUMN_RSSI_I = "rssi_i";
    public static final String COLUMN_RSSI_J = "rssi_j";
    public static final String COLUMN_DISTANCE_A = "distance_a";
    public static final String COLUMN_DISTANCE_B = "distance_b";
    public static final String COLUMN_DISTANCE_C = "distance_c";
    public static final String COLUMN_DISTANCE_D = "distance_d";
    public static final String COLUMN_DISTANCE_E = "distance_e";
    public static final String COLUMN_DISTANCE_F = "distance_f";
    public static final String COLUMN_DISTANCE_G = "distance_g";
    public static final String COLUMN_DISTANCE_H = "distance_h";
    public static final String COLUMN_DISTANCE_I = "distance_i";
    public static final String COLUMN_DISTANCE_J = "distance_j";
    public static final String COLUMN_TIMESTAMP = "timestamp";

    private static final String DATABASE_CREATE_MEASUREMENTS = "create table "
            + TABLE_MEASUREMENTS + "(" + COLUMN_ID + " integer primary key autoincrement, "
            + COLUMN_RSSI_A  + " integer not null,"
            + COLUMN_RSSI_B  + " integer not null,"
            + COLUMN_RSSI_C  + " integer not null,"
            + COLUMN_RSSI_D  + " integer not null,"
            + COLUMN_RSSI_E  + " integer not null,"
            + COLUMN_RSSI_F  + " integer not null,"
            + COLUMN_RSSI_G  + " integer not null,"
            + COLUMN_RSSI_H  + " integer not null,"
            + COLUMN_RSSI_I  + " integer not null,"
            + COLUMN_RSSI_J  + " integer not null,"
            + COLUMN_DISTANCE_A + " real not null,"
            + COLUMN_DISTANCE_B + " real not null,"
            + COLUMN_DISTANCE_C + " real not null,"
            + COLUMN_DISTANCE_D + " real not null,"
            + COLUMN_DISTANCE_E + " real not null,"
            + COLUMN_DISTANCE_F + " real not null,"
            + COLUMN_DISTANCE_G + " real not null,"
            + COLUMN_DISTANCE_H + " real not null,"
            + COLUMN_DISTANCE_I + " real not null,"
            + COLUMN_DISTANCE_J + " real not null,"
            + COLUMN_TIMESTAMP + " text not null);";


    public SQLliteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE_MEASUREMENTS);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
