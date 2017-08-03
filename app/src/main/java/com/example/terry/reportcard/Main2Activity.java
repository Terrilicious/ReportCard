package com.example.terry.reportcard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    private LeanersDatabase sd;
    private EditText edtstudentno,edtname,edttest1,edttest2,edttest3,id;
    private TextView txtaverage;
    private Spinner spinner;
    Student student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        sd = new LeanersDatabase(this);
        edtstudentno = (EditText) findViewById(R.id.edtstudentnumber);
        edtname = (EditText) findViewById(R.id.edtname);
        edttest1 = (EditText) findViewById(R.id.edtmark1);
        edttest2 = (EditText) findViewById(R.id.edtmark2);
        edttest3 = (EditText) findViewById(R.id.edtmark3);
        txtaverage = (TextView) findViewById(R.id.txtaverage);
        id=(EditText)findViewById(R.id.edtid);
        spinner= (Spinner) findViewById(R.id.spinner);
    }

    public void add(View view){
        int i = 0;

        int studentNu = Integer.parseInt(edtstudentno.getText().toString());
        String name = edtname.getText().toString();
        String faculty= (String) spinner.getSelectedItem();
        int mark = Integer.parseInt(edttest1.getText().toString());
        int mark2 = Integer.parseInt(edttest2.getText().toString());
        int mark3 = Integer.parseInt(edttest3.getText().toString());
        int avarage = Integer.parseInt(txtaverage.getText().toString());

        txtaverage.setText("YOU GOT"+ avarage);
        avarage=(mark+mark2+mark3)/3;


        Student student = new Student(i++,studentNu, name,faculty,mark,mark2,mark3, avarage);

        sd.addStudent(student);

        Intent intent = new Intent(this, Main3Activity.class);
        startActivity(intent);
    }
    public void delete(View view){

        String name = edtname.getText().toString();
        sd.deleteStudent(name);

        Intent intent = new Intent(this, Main3Activity.class);
        startActivity(intent);
    }
    public void update(View view){
         long colomnID= Long.parseLong(id.getText().toString());
        String name =String.valueOf( edtname.getText().toString() );
        String faculty= (String) spinner.getSelectedItem();
        int studnu= Integer.parseInt(edtstudentno.getText().toString());
        int test1= Integer.parseInt(edttest1.getText().toString());
        int test2= Integer.parseInt(edttest2.getText().toString());
        int test3= Integer.parseInt(edttest3.getText().toString());
        int average= Integer.parseInt(txtaverage.getText().toString());
        average=(test1+test2+test3)/3;

        sd.updateShow(colomnID,studnu,name,faculty,test1,test2,test3,average);

        txtaverage.setText("YOU GOT"+ average);


        Intent intent = new Intent(this, Main3Activity.class);
        startActivity(intent);

    }
        public void view(View view){
           Student student=sd.search(edtname.getText().toString());
    if (student !=null){
    id.setText(String.valueOf(student.getId()));
    edtstudentno.setText(String.valueOf(student.getStudentNo()));
    edttest1.setText(String.valueOf(student.getTest1()));
    edttest2.setText(String.valueOf(student.getTest2()));
    edttest3.setText(String.valueOf(student.getTest3()));
    txtaverage.setText(String.valueOf(student.getAvarage()));
        spinner.setSelected(Boolean.parseBoolean(student.getFaculty()));

    }else{
    id.setText("No match found");
        }
    }}