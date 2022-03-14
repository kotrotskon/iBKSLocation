package com.kotrots.ibkslocation;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Kostas on 05/11/2015.
 */
public class DataSource {

    public SQLiteDatabase database;
    private SQLliteHelper dbHelper;
    private String[] allColumns = { SQLliteHelper.COLUMN_ID,
            SQLliteHelper.COLUMN_RSSI_A, SQLliteHelper.COLUMN_RSSI_B, SQLliteHelper.COLUMN_RSSI_C,
            SQLliteHelper.COLUMN_RSSI_D, SQLliteHelper.COLUMN_RSSI_E, SQLliteHelper.COLUMN_RSSI_F,
            SQLliteHelper.COLUMN_RSSI_G, SQLliteHelper.COLUMN_RSSI_H, SQLliteHelper.COLUMN_RSSI_I,
            SQLliteHelper.COLUMN_RSSI_J,
            SQLliteHelper.COLUMN_DISTANCE_A, SQLliteHelper.COLUMN_DISTANCE_B,
            SQLliteHelper.COLUMN_DISTANCE_C, SQLliteHelper.COLUMN_DISTANCE_D,
            SQLliteHelper.COLUMN_DISTANCE_E, SQLliteHelper.COLUMN_DISTANCE_F,
            SQLliteHelper.COLUMN_DISTANCE_G, SQLliteHelper.COLUMN_DISTANCE_H,
            SQLliteHelper.COLUMN_DISTANCE_I, SQLliteHelper.COLUMN_DISTANCE_J,
            SQLliteHelper.COLUMN_TIMESTAMP};

    public DataSource(Context context){
        dbHelper = new SQLliteHelper(context);
    }

    public void open() throws SQLException {
        this.database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }
}

