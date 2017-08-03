package com.example.terry.reportcard;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class Main3Activity extends AppCompatActivity {
    private LeanersDatabase sd = new LeanersDatabase(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        final ArrayList<String> students = sd.getAllStudent();
        ListView listView = (ListView) findViewById(R.id.list_item2);
        final Student student = new Student();

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, students);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Dialog dialog = new Dialog(Main3Activity.this);

                AlertDialog.Builder builder = new AlertDialog.Builder(Main3Activity.this);

                builder.setTitle("Optional");
                builder.setMessage("Update or Delete");
                builder.setPositiveButton("Update", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(Main3Activity.this, Main2Activity.class);
                        startActivity(intent);
                    }
                });

                builder.setNegativeButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Intent intent = new Intent(Main3Activity.this, Main2Activity.class);
                        startActivity(intent);
                    }
                });

                builder.setNeutralButton("Add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(Main3Activity.this, Main2Activity.class);
                        startActivity(intent);
                    }
                });

                dialog = builder.create();
                builder.show();

            }
        });


    }

    public void search(View view){
        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
    }

}





