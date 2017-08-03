package com.example.admin.report.model;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.admin.report.AddStudent;
import com.example.admin.report.R;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
    }

    public void networking(View view){
        startActivity(new Intent(this, Networking.class));
    }

    public void systemAnalysis(View view){
        startActivity(new Intent(this, System_Analysis.class));
    }

    public void itManagement(View view){
        startActivity(new Intent(this, IT_Management.class));
    }

    public void softwareDesign(View view){
        startActivity(new Intent(this, Software_Design.class));
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

    public void addStudent(){
        startActivity(new Intent(this, AddStudent.class));
    }

}
