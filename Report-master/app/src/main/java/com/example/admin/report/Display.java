package com.example.admin.report;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Display extends AppCompatActivity {

    TextView tv_name, tv_studentId, tv_average, tv_surname, tv_passed;
    TextView tv_mark1, tv_mark2, tv_mark3, tv_mark4;

    TextView tv_res1, tv_res2, tv_res3, tv_res4;
    TextView tv_sub1, tv_sub2, tv_sub3, tv_sub4;

    String grade1, grade2, grade3, grade4, grade5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        tv_name = (TextView) findViewById(R.id.tv_name);
        tv_passed = (TextView) findViewById(R.id.tv_passed);
        tv_studentId = (TextView) findViewById(R.id.tv_studentId);
        tv_average = (TextView) findViewById(R.id.tv_average);
        tv_surname = (TextView) findViewById(R.id.tv_surname);
        tv_mark1 = (TextView) findViewById(R.id.tv_mark1);
        tv_mark2 = (TextView) findViewById(R.id.tv_mark2);
        tv_mark3 = (TextView) findViewById(R.id.tv_mark3);
        tv_mark4 = (TextView) findViewById(R.id.tv_mark4);

        tv_res1 = (TextView) findViewById(R.id.tv_res1);
        tv_res2 = (TextView) findViewById(R.id.tv_res2);
        tv_res3 = (TextView) findViewById(R.id.tv_res3);
        tv_res4 = (TextView) findViewById(R.id.tv_res4);

        tv_sub1 = (TextView) findViewById(R.id.tv_sub1);
        tv_sub2 = (TextView) findViewById(R.id.tv_sub2);
        tv_sub3 = (TextView) findViewById(R.id.tv_sub3);
        tv_sub4 = (TextView) findViewById(R.id.tv_sub4);


        Intent i = getIntent();
        String student_id = i.getExtras().getString("STUDENT_ID_KEY");
        String name = i.getExtras().getString("NAME_KEY");
        String surname = i.getExtras().getString("SURNAME_KEY");
        String mark1 = i.getExtras().getString("MARK1_KEY");
        String mark2 = i.getExtras().getString("MARK2_KEY");
        String mark3 = i.getExtras().getString("MARK3_KEY");
        String mark4 = i.getExtras().getString("MARK4_KEY");
        String average = i.getExtras().getString("AVERAGE_KEY");
        String state = i.getExtras().getString("STATE_KEY");

        String sub1 = i.getExtras().getString("SUB1_KEY");
        String sub2 = i.getExtras().getString("SUB2_KEY");
        String sub3 = i.getExtras().getString("SUB3_KEY");
        String sub4 = i.getExtras().getString("SUB4_KEY");



        if (100 == Integer.parseInt(mark1)){
            grade1 = ("A+");
            tv_res1.setText(grade1);
        }
        if (90 <= Integer.parseInt(mark1) && 99 >= Integer.parseInt(mark1)){
            grade1 = ("A");
            tv_res1.setText(grade1);
        }if(80 <= Integer.parseInt(mark1) && 89 >= Integer.parseInt(mark1)){
            grade1 = ("B");
            tv_res1.setText(grade1);
        }if (70 <= Integer.parseInt(mark1) && 79 >= Integer.parseInt(mark1)){
            grade1 = ("C");
            tv_res1.setText(grade1);
        }if (60 <= Integer.parseInt(mark1) && 69 >= Integer.parseInt(mark1)){
            grade1 = ("D");
            tv_res1.setText(grade1);
        }if (59 >= Integer.parseInt(mark1)){
            grade1 = ("F");
            tv_res1.setText(grade1);
        }

        if (100 == Integer.parseInt(mark2)){
            grade2 = ("A+");
            tv_res2.setText(grade2);
        }
        if (90 <= Integer.parseInt(mark2) && 99 >= Integer.parseInt(mark2)){
            grade2 = ("A");
            tv_res2.setText(grade2);
        }if(80 <= Integer.parseInt(mark2) && 89 >= Integer.parseInt(mark2)){
            grade2 = ("B");
            tv_res2.setText(grade2);
        }if (70 <= Integer.parseInt(mark2) && 79 >= Integer.parseInt(mark2)){
            grade2 = ("C");
            tv_res2.setText(grade2);
        }if (60 <= Integer.parseInt(mark2) && 69 >= Integer.parseInt(mark2)){
            grade2 = ("D");
            tv_res2.setText(grade2);
        }if (59 >= Integer.parseInt(mark2)){
            grade2 = ("F");
            tv_res2.setText(grade2);
        }

        if (100 == Integer.parseInt(mark3)){
            grade3 = ("A+");
            tv_res3.setText(grade3);
        }
        if (90 <= Integer.parseInt(mark3) && 99 >= Integer.parseInt(mark3)){
            grade3 = ("A");
            tv_res3.setText(grade3);
        }if(80 <= Integer.parseInt(mark3) && 89 >= Integer.parseInt(mark3)){
            grade3 = ("B");
            tv_res3.setText(grade3);
        }if (70 <= Integer.parseInt(mark3) && 79 >= Integer.parseInt(mark3)){
            grade3 = ("C");
            tv_res3.setText(grade3);
        }if (60 <= Integer.parseInt(mark3) && 69 >= Integer.parseInt(mark3)){
            grade3 = ("D");
            tv_res3.setText(grade3);
        }if (59 >= Integer.parseInt(mark3)){
            grade3 = ("F");
            tv_res3.setText(grade3);
        }

        if (100 == Integer.parseInt(mark4)){
            grade4 = ("A+");
            tv_res4.setText(grade4);
        }
        if (90 <= Integer.parseInt(mark4) && 99 >= Integer.parseInt(mark4)){
            grade4 = ("A");
            tv_res4.setText(grade4);
        }if(80 <= Integer.parseInt(mark4) && 89 >= Integer.parseInt(mark4)){
            grade4 = ("B");
            tv_res4.setText(grade4);
        }if (70 <= Integer.parseInt(mark4) && 79 >= Integer.parseInt(mark4)){
            grade4 = ("C");
            tv_res4.setText(grade4);
        }if (60 <= Integer.parseInt(mark4) && 69 >= Integer.parseInt(mark4)){
            grade4 = ("D");
            tv_res4.setText(grade4);
        }if (59 >= Integer.parseInt(mark4)){
            grade4 = ("F");
            tv_res4.setText(grade4);
        }


        //Set Text to their respective data from intent
        tv_studentId.setText("S/N: "+student_id);
        tv_name.setText(name);
        tv_surname.setText(surname);
        tv_mark1.setText(mark1);
        tv_mark2.setText(mark2);
        tv_mark3.setText(mark3);
        tv_mark4.setText(mark4);
        tv_average.setText(average + "%");
        tv_passed.setText(state);


    }
}
