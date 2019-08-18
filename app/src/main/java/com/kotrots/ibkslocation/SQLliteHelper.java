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
    public static final String COLUMN_DISTANCE_A = "distance_a";
    public static final String COLUMN_DISTANCE_B = "distance_b";
    public static final String COLUMN_DISTANCE_C = "distance_c";
    public static final String COLUMN_DISTANCE_D = "distance_d";
    public static final String COLUMN_DISTANCE_E = "distance_e";
    public static final String COLUMN_TIMESTAMP = "timestamp";

    private static final String DATABASE_CREATE_MEASUREMENTS = "create table "
            + TABLE_MEASUREMENTS + "(" + COLUMN_ID + " integer primary key autoincrement, "
            + COLUMN_RSSI_A  + " integer not null,"
            + COLUMN_RSSI_B  + " integer not null,"
            + COLUMN_RSSI_C  + " integer not null,"
            + COLUMN_RSSI_D  + " integer not null,"
            + COLUMN_RSSI_E  + " integer not null,"
            + COLUMN_DISTANCE_A + " real not null,"
            + COLUMN_DISTANCE_B + " real not null,"
            + COLUMN_DISTANCE_C + " real not null,"
            + COLUMN_DISTANCE_D + " real not null,"
            + COLUMN_DISTANCE_E + " real not null,"
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
