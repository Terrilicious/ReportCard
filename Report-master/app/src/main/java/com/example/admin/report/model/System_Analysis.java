package com.example.admin.report.model;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ListView;

import com.example.admin.report.AddStudent;
import com.example.admin.report.Helper.DbHelper;
import com.example.admin.report.Helper.StudentAdapter;
import com.example.admin.report.Helper.StudentClass;
import com.example.admin.report.R;

import java.util.ArrayList;

public class System_Analysis extends AppCompatActivity {

    ListView lv;
    EditText name;
    DbHelper db;
    StudentAdapter adapter;

    ArrayList<StudentClass> students = new ArrayList<StudentClass>();

    String subject1 = "itc";
    String subject2 = "fgf";
    String subject3 = "dfj";
    String subject4 = "fdg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_list);

        db = new DbHelper(this);

        adapter = new StudentAdapter(this, students, R.color.networking_items);
        lv = (ListView) findViewById(R.id.list);

        getStudents(null);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.student_add:
                addStudent();

                finish();

                return true;

        }
        return super.onOptionsItemSelected(item);
    }

    public void getStudents(String searchTerm) {

        db.openDB();
        StudentClass sc = null;
        Cursor c = db.retrieveSysAnalysis(searchTerm);

        //Initiating the while loop for the cursor to get data from the first row and
        // moving to the next
        while (c.moveToNext()) {
            //Getting the String at index 1 and 2 from every row.
            String id = c.getString(0);
            String name = c.getString(1);
            String surname = c.getString(2);
            String sub1 = c.getString(3);
            String sub2 = c.getString(4);
            String sub3 = c.getString(5);
            String sub4 = c.getString(6);
            String average = c.getString(7);
            String state = c.getString(8);

            //Calling the constructor which has no arguments
            sc = new StudentClass();
            //setting The name and surname to be displayed
            sc.setmId(id);
            sc.setmName(name);
            sc.setmSurname(surname);
            sc.setmSub1(sub1);
            sc.setmSub2(sub2);
            sc.setmSub3(sub3);
            sc.setmSub4(sub4);
            sc.setmAverage(average);
            sc.setmState(state);

            //Adding our constructor with 2 parameters in the arraylist {@link students}
            students.add(new StudentClass(id, name, surname, sub1, sub2, sub3, sub4, average, state));
            System.out.println("Results: " + students);
        }
        db.closeDB();
        lv.setAdapter(adapter);
    }

    public void addStudent(){
        startActivity(new Intent(this, AddStudent.class));
    }

}
