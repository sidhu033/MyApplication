package com.example.user.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.user.myapplication.pojo.AddReading;
import com.example.user.myapplication.pojo.FeedReaderContract;

import java.util.ArrayList;
import java.util.List;

public class FeedReaderDbHelper extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "redoxer_db";

    /*constructor */
    public FeedReaderDbHelper(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db)
    {
        // create notes table
        db.execSQL(FeedReaderContract.CREATE_TABLE);
        db.execSQL(AddReading.CREATE_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + FeedReaderContract.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + AddReading.TABLE_NAME);
        // Create tables again
        onCreate(db);
    }

    public long insertNote(String username, String password, String userId, String status) {
        // get writable database as we want to write data
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        // `id` and `timestamp` will be inserted automatically.
        // no need to add them
        values.put(FeedReaderContract.USER_ID, userId);
        values.put(FeedReaderContract.USERNAME, username);
        values.put(FeedReaderContract.PASSWORD, password);
        values.put(FeedReaderContract.STATUS, status);
        // insert row
        long id = db.insert(FeedReaderContract.TABLE_NAME, null, values);
        // close db connection
        db.close();
        // return newly inserted row id
        return id;
    }

    public long insertReading(String userId, String syncStatus,
                              String rSys, String rDys, String rPulse, String lSys,
                              String lDys, String lPulse) {
        // get writable database as we want to write data
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        // `id` and `timestamp` will be inserted automatically.
        // no need to add them
        values.put(AddReading.USER_ID, userId);
        values.put(AddReading.SYNC_STATUS, syncStatus);
        values.put(AddReading.RSYS, rSys);
        values.put(AddReading.RDYS, rDys);
        values.put(AddReading.RPULSE, rPulse);
        values.put(AddReading.LSYS, lSys);
        values.put(AddReading.LDYS, lDys);
        values.put(AddReading.LPULSE, lPulse);
        // insert row
        long id = db.insert(AddReading.TABLE_NAME, null, values);
        // close db connection
        db.close();
        // return newly inserted row id
        return id;
    }


    public FeedReaderContract getUserId(String status) {

            // get readable database as we are not inserting anything
            SQLiteDatabase db = this.getReadableDatabase();

            Cursor cursor = db.query(FeedReaderContract.TABLE_NAME,
                    new String[]{FeedReaderContract._ID, FeedReaderContract.USER_ID,
                            FeedReaderContract.USERNAME, FeedReaderContract.PASSWORD,
                            FeedReaderContract.STATUS},
                    FeedReaderContract.STATUS + "=?",
                    new String[]{status}, null, null, FeedReaderContract._ID + " DESC", null);

            if (cursor != null)
                cursor.moveToFirst();

        FeedReaderContract contract = new FeedReaderContract(
                    cursor.getInt(cursor.getColumnIndex(FeedReaderContract._ID)),
                    cursor.getString(cursor.getColumnIndex(FeedReaderContract.USER_ID)),
                    cursor.getString(cursor.getColumnIndex(FeedReaderContract.USERNAME)),
                    cursor.getString(cursor.getColumnIndex(FeedReaderContract.PASSWORD)),
                    cursor.getString(cursor.getColumnIndex(FeedReaderContract.STATUS)));

            // close the db connection
            cursor.close();
            return contract;
        }


    public List<AddReading> getAllReadings(String userId)
    {
        List<AddReading> addReadings = new ArrayList<>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + AddReading.TABLE_NAME
                + " where " + AddReading.USER_ID + " = " + userId
                + " ORDER BY " +
                AddReading._ID + " DESC";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst())
        {
            do {
                AddReading note = new AddReading();
                note.setId(cursor.getInt(cursor.getColumnIndex(AddReading._ID)));
                note.setUserId(cursor.getString(cursor.getColumnIndex(AddReading.USER_ID)));
                note.setSyncStatus(cursor.getString(cursor.getColumnIndex(AddReading.SYNC_STATUS)));
                note.setrSys(cursor.getString(cursor.getColumnIndex(AddReading.RSYS)));
                note.setrDys(cursor.getString(cursor.getColumnIndex(AddReading.RDYS)));
                note.setrPulse(cursor.getString(cursor.getColumnIndex(AddReading.RPULSE)));
                note.setlSys(cursor.getString(cursor.getColumnIndex(AddReading.LSYS)));
                note.setlDys(cursor.getString(cursor.getColumnIndex(AddReading.LDYS)));
                note.setlPulse(cursor.getString(cursor.getColumnIndex(AddReading.LPULSE)));

                addReadings.add(note);
            } while (cursor.moveToNext());
        }

        // close db connection
        db.close();

        // return notes list
        return addReadings;

    }

    public List<AddReading> getAllReadingsUnsync(String userId) {

        List<AddReading> addReadings = new ArrayList<>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + AddReading.TABLE_NAME
                + " where " + AddReading.USER_ID + " = " + userId +" and  " + AddReading.SYNC_STATUS + " = 0"
                + " ORDER BY " +
                AddReading._ID + " DESC";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                AddReading note = new AddReading();
                note.setId(cursor.getInt(cursor.getColumnIndex(AddReading._ID)));
                note.setUserId(cursor.getString(cursor.getColumnIndex(AddReading.USER_ID)));
                note.setSyncStatus(cursor.getString(cursor.getColumnIndex(AddReading.SYNC_STATUS)));
                note.setrSys(cursor.getString(cursor.getColumnIndex(AddReading.RSYS)));
                note.setrDys(cursor.getString(cursor.getColumnIndex(AddReading.RDYS)));
                note.setrPulse(cursor.getString(cursor.getColumnIndex(AddReading.RPULSE)));
                note.setlSys(cursor.getString(cursor.getColumnIndex(AddReading.LSYS)));
                note.setlDys(cursor.getString(cursor.getColumnIndex(AddReading.LDYS)));
                note.setlPulse(cursor.getString(cursor.getColumnIndex(AddReading.LPULSE)));

                addReadings.add(note);
            } while (cursor.moveToNext());
        }

        // close db connection
        db.close();

        // return notes list
        return addReadings;


    }

    public void changeSyncStatus(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "UPDATE "+AddReading.TABLE_NAME +" SET " + AddReading.SYNC_STATUS+ " = 1 WHERE "+AddReading._ID+ " = "+id;
        db.execSQL(sql);
    }
}