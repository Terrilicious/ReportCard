package com.example.admin.report;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.admin.report.Helper.DbHelper;

import java.util.Random;

public class AddStudent extends AppCompatActivity {
    Spinner spinner_course;
    EditText etsub1, etsub2, etsub3, etsub4;
    EditText Et_fullnames, Et_surname;
    RadioGroup radioGroup;
    RadioButton radioButton;

    String[] courseArray;
    DbHelper db;

    int average;
    int w, r, e, g;
    String state;
    String grade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        db = new DbHelper(this);

        Et_fullnames = (EditText) findViewById(R.id.te_fullnames);
        Et_surname = (EditText) findViewById(R.id.te_surname);

        etsub1 = (EditText) findViewById(R.id.te_sub1);
        etsub2 = (EditText) findViewById(R.id.te_sub2);
        etsub3 = (EditText) findViewById(R.id.te_sub3);
        etsub4 = (EditText) findViewById(R.id.te_sub4);

        radioGroup = (RadioGroup) findViewById(R.id.radio_group);





    }

    public void insertStudent() {


        try {
            final int sub1 = Integer.parseInt(etsub1.getText().toString());
            final int sub2 = Integer.parseInt(etsub2.getText().toString());
            final int sub3 = Integer.parseInt(etsub3.getText().toString());
            final int sub4 = Integer.parseInt(etsub4.getText().toString());

            Random random = new Random();
            int randomNum = random.nextInt(214783647);


            /*
            * CALCULATING THE GRADE AVERAGE
            * */
            w = Integer.parseInt(etsub1.getText().toString());
            r = Integer.parseInt(etsub2.getText().toString());
            e = Integer.parseInt(etsub3.getText().toString());
            g = Integer.parseInt(etsub4.getText().toString());

            int x = w + r + e + g;
            final int average = (int) (x * 100.0f) / 400;
            System.out.println(average);

            if (w >= 60 && r >= 60 && e >= 60 && g >= 60 && average >= 60) {
                state = "Passed";
            } else {
                state = "Failed";
            }


            int selected_id = radioGroup.getCheckedRadioButtonId();
            radioButton = (RadioButton) findViewById(selected_id);

            /*
            * COMPUTER NETWORKING INSERT METHOD TO THE DATABASE
            * */
            if (radioButton.getText().equals("Computer Networking")){
                boolean isInserted = db.insertData(Integer.valueOf(randomNum),Et_fullnames.getText().toString().trim(),
                        Et_surname.getText().toString().trim(), sub1, sub2, sub3, sub4, average, state.toString());
                if (isInserted == true) {
                    Toast.makeText(AddStudent.this, "Information Added", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(AddStudent.this, "There was a problem in processing your entry.\nTry again later.", Toast.LENGTH_SHORT).show();
                }
            }

            /*
            * IT MANAGEMENT INSERT METHOD TO THE DATABASE
            * */
            if (radioButton.getText().equals("Information Technology Management")){
                boolean isInserted = db.insertItManagementData(Integer.valueOf(randomNum),Et_fullnames.getText().toString().trim(),
                        Et_surname.getText().toString().trim(), sub1, sub2, sub3, sub4, average, state.toString());
                if (isInserted == true) {
                    Toast.makeText(AddStudent.this, "Information Added", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(AddStudent.this, "There was a problem in processing your entry.\nTry again later.", Toast.LENGTH_SHORT).show();
                }
            }

            /*
            * SOFTWARE DESIGN AND DEVELOPMENT INSERT METHOD TO THE DATABASE
            * */
            if (radioButton.getText().equals("Software Design and Development")){
                boolean isInserted = db.insertSoftwareDesigntData(Integer.valueOf(randomNum),Et_fullnames.getText().toString().trim(),
                        Et_surname.getText().toString().trim(), sub1, sub2, sub3, sub4, average, state.toString());
                if (isInserted == true) {
                    Toast.makeText(AddStudent.this, "Information Added", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(AddStudent.this, "There was a problem in processing your entry.\nTry again later.", Toast.LENGTH_SHORT).show();
                }
            }

            /*
            * SYSTEM ANALYSIS INSERT METHOD TO THE DATABASE
            * */
            if (radioButton.getText().equals("System Analysis")){
                boolean isInserted = db.insertSysAnalysisData(Integer.valueOf(randomNum),Et_fullnames.getText().toString().trim(),
                        Et_surname.getText().toString().trim(), sub1, sub2, sub3, sub4, average, state.toString());
                if (isInserted == true) {
                    Toast.makeText(AddStudent.this, "Information Added", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(AddStudent.this, "There was a problem in processing your entry.\nTry again later.", Toast.LENGTH_SHORT).show();
                }
            }
        } catch (Exception e) {
            Toast.makeText(this, "Something we wrong.. Try again later.", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_done, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.done_add:
                insertStudent();
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
