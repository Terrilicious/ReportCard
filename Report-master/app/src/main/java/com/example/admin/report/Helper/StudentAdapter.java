package com.example.admin.report.Helper;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.admin.report.Display;
import com.example.admin.report.R;

import java.util.ArrayList;

/**
 * Created by Max on 2016/11/08.
 */
public class StudentAdapter extends BaseAdapter {

    Context c;
    ArrayList<StudentClass> students;
    LayoutInflater inflater;
    private int mColourResouceId;

    public StudentAdapter(Context c, ArrayList<StudentClass> students, int ColourResouceId) {
        this.c = c;
        this.students = students;
        mColourResouceId = ColourResouceId;
    }

    @Override
    public int getCount() {
        return students.size();
    }

    @Override
    public Object getItem(int position) {
        return students.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (inflater == null) {
            inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_item, parent, false);
        }

        final TextView nameTextView = (TextView) convertView.findViewById(R.id.name_textview);
        nameTextView.setText(students.get(position).getmName() + " " + students.get(position).getmSurname());

        final TextView stateTextView = (TextView) convertView.findViewById(R.id.state_textview);
        stateTextView.setText(students.get(position).getmState());

        final TextView idTextView = (TextView) convertView.findViewById(R.id.tv_student_id);
        idTextView.setText("S/N: "+students.get(position).getmId());

        View textContainer = convertView.findViewById(R.id.text_container);

        int colour = ContextCompat.getColor(c, mColourResouceId);

        textContainer.setBackgroundColor(colour);

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String disStudentId = students.get(position).getmId();
                String disName = students.get(position).getmName();
                String disSurname = students.get(position).getmSurname();
                String disSub1 = students.get(position).getmSub1();
                String disSub2 = students.get(position).getmSub2();
                String disSub3 = students.get(position).getmSub3();
                String disSub4 = students.get(position).getmSub4();
                String disAverage = students.get(position).getmAverage();
                String disState = students.get(position).getmState();


                openDisplayActivity(disStudentId, disName, disSurname, disSub1, disSub2, disSub3, disSub4, disAverage, disState);
            }
        });

        return convertView;
    }



    public void openDisplayActivity(String student_id, String name, String surname, String mark1, String mark2, String mark3, String mark4, String average, String state) {
        Intent i = new Intent(c, Display.class);
        i.putExtra("STUDENT_ID_KEY", student_id);
        i.putExtra("NAME_KEY", name);
        i.putExtra("SURNAME_KEY", surname);
        i.putExtra("MARK1_KEY", mark1);
        i.putExtra("MARK2_KEY", mark2);
        i.putExtra("MARK3_KEY", mark3);
        i.putExtra("MARK4_KEY", mark4);
        i.putExtra("AVERAGE_KEY", average);
        i.putExtra("STATE_KEY", state);
        c.startActivity(i);
    }

}
