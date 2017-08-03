package com.example.terry.reportcard;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import com.example.terry.reportcard.Student;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by TERRY on 2017/07/20.
 */

public class LeanersDatabase extends SQLiteOpenHelper{


    private static final  String TABLE_LEARNER="student";
    private  final String COLUMN_ID="_id";
    private final String COLUMN_STUDENT_NUMBER="studentNumber";
    private final String COLUMN_NAME="name";
    private final String COLUMN_FACULTY="faculty";
    private final String COLUMN_TEST1="test1";
    private final String COLUMN_TEST2="test2";
    private final String COLUMN_TEST3="test3";
    private final String COLUMN_AVERAGE="average";
    private final static String  DATABASE_NAME="student.db";
    private final   static int DATABASE_VERSION=2;
    private final  String DATABASE_CREATE="create table " + TABLE_LEARNER +"(" + COLUMN_ID +" integer primary key autoincrement," +
            COLUMN_STUDENT_NUMBER + " text not null,"+ COLUMN_NAME + " text not null,"+ COLUMN_FACULTY + " text not null, " + COLUMN_TEST1+ " text not null, "+ COLUMN_TEST2+" text not null, "+ COLUMN_TEST3+" text not null, "+ COLUMN_AVERAGE+" text not null);";
    Student student = new Student();

    public  LeanersDatabase(Context context){
        super(context, DATABASE_NAME,null,DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
       db.execSQL(DATABASE_CREATE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_LEARNER);
        onCreate(db);
    }
    public void addStudent(Student student){
        SQLiteDatabase db=this.getWritableDatabase();
                ContentValues contentValues=new ContentValues();

        contentValues.put(COLUMN_STUDENT_NUMBER,student.getStudentNo());
        contentValues.put(COLUMN_NAME,student.getName());
        contentValues.put(COLUMN_FACULTY,student.getFaculty());
        contentValues.put(COLUMN_TEST1,student.getTest1());
        contentValues.put(COLUMN_TEST2,student.getTest2());
        contentValues.put(COLUMN_TEST3,student.getTest3());
        contentValues.put(COLUMN_AVERAGE,student.getAvarage());
        db.insert(TABLE_LEARNER,null,contentValues);

    }

    public ArrayList<String>getAllStudent(){
        ArrayList<String>students=new ArrayList<>();
        //SELECT ALL Query
        String selectQuery="SELECT * FROM "+ TABLE_LEARNER;
        SQLiteDatabase db =this.getWritableDatabase();
        Cursor cursor=db.rawQuery(selectQuery,null);
        if (cursor.moveToFirst()) {
            do {
                //
                int id = cursor.getInt(0);
                int stdNum = cursor.getInt(1);
                String sdtName = cursor.getString(2);
                String sdtfaculty=cursor.getString(3);
                int sdttest1 = cursor.getInt(4);
                int sdttest2 = cursor.getInt(5);
                int sdttest3 = cursor.getInt(6);
                int sdtaverage = cursor.getInt(7);

                String display = id + " " + "Student number: " + "" + stdNum + "   " + "Name  :" + sdtName + "   " + "Faculty :" + sdtfaculty + " "+ "Test 1  :" + sdttest1 + "   " + "Test 2  :" + sdttest2 + "   " + "Test 3  :" + sdttest3 + "   " +"Average   :" + sdtaverage;
                students.add(display);
            }
            while (cursor.moveToNext());
        }
        return students;
        }
    public int deleteStudent(String x) {
        SQLiteDatabase db=this.getWritableDatabase();
        String[]whereArgs={x};
        int count=db.delete(this.TABLE_LEARNER,this.COLUMN_NAME+"=?",whereArgs);
        return count;

    }
    public void updateShow(long colomnID, int studnu,String name,String faculty ,int test1,int test2,int test3,int average) {
       ContentValues values=new ContentValues();

        SQLiteDatabase db=this.getWritableDatabase();
        values.put(COLUMN_STUDENT_NUMBER,studnu);
        values.put(COLUMN_NAME,name);
        values.put(COLUMN_FACULTY,faculty);
        values.put(COLUMN_TEST1,test1);
        values.put(COLUMN_TEST2,test2);
        values.put(COLUMN_TEST3,test3);
        values.put(COLUMN_AVERAGE,average);
        db.update(TABLE_LEARNER,values,COLUMN_ID + "=" + colomnID,null);
    }
    public Student getAStudent(int id) {
        Student s = new Student();
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM " + TABLE_LEARNER + " where " + COLUMN_ID + " = ? ";
        String args[] = {String.valueOf(id)};
        Cursor c = db.rawQuery(selectQuery, args);
        if (c.moveToFirst()) {     s.setId(c.getInt(c.getColumnIndex(COLUMN_ID)));
            s.setName(c.getString(c.getColumnIndex(COLUMN_NAME)));
            s.setFaculty(c.getString(c.getColumnIndex(COLUMN_FACULTY)));
            s.setStudentNo(c.getInt(c.getColumnIndex(COLUMN_STUDENT_NUMBER)));
            s.setTest1(c.getInt(c.getColumnIndex(COLUMN_TEST1)));
            s.setTest2(c.getInt(c.getColumnIndex(COLUMN_TEST2)));
            s.setTest3(c.getInt(c.getColumnIndex(COLUMN_TEST3)));
            s.setAvarage(c.getInt(c.getColumnIndex(COLUMN_AVERAGE)));   }
        return s;
    }
    public Student search(String name) {
        String query = " Select * from " + TABLE_LEARNER + " WHERE " + COLUMN_NAME + " = \"" + name + "\"";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        Student student = new Student();

        if (cursor.moveToFirst()) {
            cursor.moveToFirst();
            student.setId(Integer.parseInt(cursor.getString(0)));
            student.setStudentNo(Integer.parseInt(cursor.getString(1)));
            student.setName(cursor.getString(2));
            student.setFaculty(cursor.getString(3));
            student.setTest1(Integer.parseInt(cursor.getString(4)));
            student.setTest2(Integer.parseInt(cursor.getString(5)));
            student.setTest3(Integer.parseInt(cursor.getString(6)));
            student.setAvarage(Integer.parseInt(cursor.getString(7)));
            cursor.close();
        } else {
            student = null;

            db.close();
        }
        return student;
    }
}

