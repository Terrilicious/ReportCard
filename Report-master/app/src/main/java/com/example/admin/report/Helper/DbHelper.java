package com.example.admin.report.Helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Max on 2016/11/09.
 */
public class DbHelper extends SQLiteOpenHelper {


    public DbHelper(Context context) {
        super(context, Constants.DATABASE_NAME, null, Constants.VERSION_NAME);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Constants.NETWORKING_TABLE);
        db.execSQL(Constants.IT_MANAGEMENT_TABLE);
        db.execSQL(Constants.SOFTWARE_DESIGN_TABLE);
        db.execSQL(Constants.SYS_ANALYSIS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Constants.NET_TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + Constants.IT_MANAGEMENT_TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + Constants.DESIGN_TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + Constants.SYS_ANALYSIS_TABLE_NAME);
        onCreate(db);
    }

    /*
    * Insert data method for NETWORKING
    * */
    public boolean insertData(Integer id, String name, String surname, Integer sub1, Integer sub2, Integer sub3, Integer sub4, Integer average, String state) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Constants.STUDENT_ID, id);
        contentValues.put(Constants.NAME, name);
        contentValues.put(Constants.SURNAME, surname);
        contentValues.put(Constants.SUBJECT_1, sub1);
        contentValues.put(Constants.SUBJECT_2, sub2);
        contentValues.put(Constants.SUBJECT_3, sub3);
        contentValues.put(Constants.SUBJECT_4, sub4);
        contentValues.put(Constants.AVERAGE, average);
        contentValues.put(Constants.STATE, state);

        long res = db.insert(Constants.NET_TABLE_NAME, null, contentValues);
        if (res == -1) {
            return false;
        } else {
            return true;
        }

    }

    /*
    * Insert data method for IT_MANAGEMENT
    * */
    public boolean insertItManagementData(Integer id, String name, String surname, Integer sub1, Integer sub2, Integer sub3, Integer sub4, Integer average, String state) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Constants.STUDENT_ID, id);
        contentValues.put(Constants.NAME, name);
        contentValues.put(Constants.SURNAME, surname);
        contentValues.put(Constants.SUB_1, sub1);
        contentValues.put(Constants.SUB_2, sub2);
        contentValues.put(Constants.SUB_3, sub3);
        contentValues.put(Constants.SUB_4, sub4);
        contentValues.put(Constants.AVERAGE, average);
        contentValues.put(Constants.STATE, state);

        long res = db.insert(Constants.IT_MANAGEMENT_TABLE_NAME, null, contentValues);
        if (res == -1) {
            return false;
        } else {
            return true;
        }

    }

    /*
    * Insert data method for IT_MANAGEMENT
    * */
    public boolean insertSoftwareDesigntData(Integer id, String name, String surname, Integer sub1, Integer sub2, Integer sub3, Integer sub4, Integer average, String state) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Constants.STUDENT_ID, id);
        contentValues.put(Constants.NAME, name);
        contentValues.put(Constants.SURNAME, surname);
        contentValues.put(Constants.SUBJECT1, sub1);
        contentValues.put(Constants.SUBJECT2, sub2);
        contentValues.put(Constants.SUBJECT3, sub3);
        contentValues.put(Constants.SUBJECT4, sub4);
        contentValues.put(Constants.AVERAGE, average);
        contentValues.put(Constants.STATE, state);

        long res = db.insert(Constants.DESIGN_TABLE_NAME, null, contentValues);
        if (res == -1) {
            return false;
        } else {
            return true;
        }

    }

    /*
    * Insert data method for IT_MANAGEMENT
    * */
    public boolean insertSysAnalysisData(Integer id,String name, String surname, Integer sub1, Integer sub2, Integer sub3, Integer sub4, Integer average, String state) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Constants.STUDENT_ID, id);
        contentValues.put(Constants.NAME, name);
        contentValues.put(Constants.SURNAME, surname);
        contentValues.put(Constants.SUB1, sub1);
        contentValues.put(Constants.SUB2, sub2);
        contentValues.put(Constants.SUB3, sub3);
        contentValues.put(Constants.SUB4, sub4);
        contentValues.put(Constants.AVERAGE, average);
        contentValues.put(Constants.STATE, state);

        long res = db.insert(Constants.SYS_ANALYSIS_TABLE_NAME, null, contentValues);
        if (res == -1) {
            return false;
        } else {
            return true;
        }

    }



    public Cursor getData() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from " + Constants.IT_MANAGEMENT_TABLE_NAME, null);
        return res;
    }

    /*
    * RETRIEVE DATA AND FILTER
    * */
    public Cursor retrieve(String searchTerm) {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = {Constants.STUDENT_ID, Constants.NAME, Constants.SURNAME,
                Constants.SUBJECT_1, Constants.SUBJECT_2, Constants.SUBJECT_3, Constants.SUBJECT_4,
                Constants.AVERAGE, Constants.STATE};
        Cursor c = null;

        if (searchTerm != null && searchTerm.length() > 0) {
            String sql = "SELECT * FROM " + Constants.NET_TABLE_NAME + " WHERE " + Constants.NAME + " LIKE '%" + searchTerm + "%'";
            c = db.rawQuery(sql, null);
            return c;
        }

        c = db.query(Constants.NET_TABLE_NAME, columns, null, null, null, null, null);
        return c;
    }

    /*
    * RETRIEVE DATA IT MANAGEMENT AND FILTER
    * */
    public Cursor retrieveItManagement(String searchTerm) {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = {Constants.STUDENT_ID, Constants.NAME, Constants.SURNAME,
                Constants.SUB_1, Constants.SUB_2, Constants.SUB_3, Constants.SUB_4,
                Constants.AVERAGE, Constants.STATE};
        Cursor c = null;

        if (searchTerm != null && searchTerm.length() > 0) {
            String sql = "SELECT * FROM " + Constants.IT_MANAGEMENT_TABLE_NAME + " WHERE " + Constants.NAME + " LIKE '%" + searchTerm + "%'";
            c = db.rawQuery(sql, null);
            return c;
        }

        c = db.query(Constants.IT_MANAGEMENT_TABLE_NAME, columns, null, null, null, null, null);
        return c;
    }

    /*
    * RETRIEVE SOFTWARE DESIGN DATA AND FILTER
    * */
    public Cursor retrieveSoftwareDesign(String searchTerm) {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = {Constants.STUDENT_ID, Constants.NAME, Constants.SURNAME,
                Constants.SUBJECT1, Constants.SUBJECT2, Constants.SUBJECT3, Constants.SUBJECT4,
                Constants.AVERAGE, Constants.STATE};
        Cursor c = null;

        if (searchTerm != null && searchTerm.length() > 0) {
            String sql = "SELECT * FROM " + Constants.DESIGN_TABLE_NAME + " WHERE " + Constants.NAME + " LIKE '%" + searchTerm + "%'";
            c = db.rawQuery(sql, null);
            return c;
        }

        c = db.query(Constants.DESIGN_TABLE_NAME, columns, null, null, null, null, null);
        return c;
    }

    /*
    * RETRIEVE System Analysis DATA AND FILTER
    * */
    public Cursor retrieveSysAnalysis(String searchTerm) {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = {Constants.STUDENT_ID, Constants.NAME, Constants.SURNAME,
                Constants.SUB1, Constants.SUB2, Constants.SUB3, Constants.SUB4,
                Constants.AVERAGE, Constants.STATE};
        Cursor c = null;

        if (searchTerm != null && searchTerm.length() > 0) {
            String sql = "SELECT * FROM " + Constants.SYS_ANALYSIS_TABLE_NAME + " WHERE " + Constants.NAME + " LIKE '%" + searchTerm + "%'";
            c = db.rawQuery(sql, null);
            return c;
        }

        c = db.query(Constants.SYS_ANALYSIS_TABLE_NAME, columns, null, null, null, null, null);
        return c;
    }

    /*
    * CLOSE DB
    * */
    public void closeDB() {
        SQLiteDatabase db = this.getReadableDatabase();
        if (db != null && db.isOpen())
            db.close();
    }

    /*
    * OPEN DB
    * */
    public void openDB() {
        SQLiteDatabase db = this.getReadableDatabase();
        db.isOpen();
    }
}
