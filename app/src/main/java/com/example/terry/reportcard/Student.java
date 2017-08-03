package com.example.terry.reportcard;

/**
 * Created by TERRY on 2017/07/20.
 */

public class Student {
    static private long id;
    static private int studentNo;
    static private String name;
    static private String faculty;
    static private int test1;
    static private int test2;
    static private int test3;
    static private int avarage;
    public Student(){

    }
    public Student(long id, int studentNo, String name,String faculty, int test1,int test2,int test3,int avarage) {
        this.id = id;
        this.studentNo = studentNo;
        this.name = name;
        this.faculty=faculty;
        this.test1=test1;
        this.test2=test2;
        this.test3=test3;
        this.avarage = avarage;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public int getStudentNo() {
        return studentNo;
    }
    public void setStudentNo(int studentNo) {
        this.studentNo = studentNo;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getTest1() {
        return test1;
    }
    public void setTest1(int test1) {
        this.test1 = test1;
    }

    public int getTest2() {
        return test2;
    }
    public void setTest2(int test2) {
        this.test2 = test2;
    }

    public int getTest3() {
        return test3;
    }
    public void setTest3(int test3) {
        this.test3 = test3;
    }

    public int getAvarage() {
        return avarage;
    }
    public void setAvarage(int avarage) {
        this.avarage = avarage;
    }

    public  String getFaculty() {
        return faculty;
    }

    public  void setFaculty(String faculty)
    {
        this.faculty = faculty;
    }
}
