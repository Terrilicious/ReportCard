package com.example.admin.report.Helper;

/**
 * Created by Max on 2016/11/08.
 */
public class StudentClass {
    //{@link Name} will represent full names of the student.
    String mName;
    String mSurname;
    //The following are subjects enrolled by the students
    String mSub1;
    String mSub2;
    String mSub3;
    String mSub4;
    //The average of the students
    String mAverage;
    //{@link State} will represent whether a student have passed or failed.
    String mState;
    //Student Number or ID
    String mId;

    String subject1;
    String subject2;
    String subject3;

    public String getSubject4() {
        return subject4;
    }

    public void setSubject4(String subject4) {
        this.subject4 = subject4;
    }

    public String getSubject3() {
        return subject3;
    }

    public void setSubject3(String subject3) {
        this.subject3 = subject3;
    }

    public String getSubject2() {
        return subject2;
    }

    public void setSubject2(String subject2) {
        this.subject2 = subject2;
    }

    public String getSubject1() {
        return subject1;
    }

    public void setSubject1(String subject1) {
        this.subject1 = subject1;
    }

    String subject4;

    public StudentClass() {
    }

    public StudentClass(String mName, String mSurname) {
        this.mName = mName;
        this.mSurname = mSurname;
    }

    public StudentClass(String mName, String mSurname, String mState) {
        this.mName = mName;
        this.mSurname = mSurname;
        this.mState = mState;
    }

    public StudentClass(String subject1, String subject2, String subject3, String subject4) {
        this.subject1 = subject1;
        this.subject2 = subject2;
        this.subject3 = subject3;
        this.subject4 = subject4;
    }

    public StudentClass(String mId, String mName, String mSurname, String mSub1, String mSub2, String mSub3, String mSub4, String mAverage, String mState) {
        this.mAverage = mAverage;
        this.mId = mId;
        this.mName = mName;
        this.mState = mState;
        this.mSub1 = mSub1;
        this.mSub2 = mSub2;
        this.mSub3 = mSub3;
        this.mSub4 = mSub4;
        this.mSurname = mSurname;
    }

    public String getmAverage() {
        return mAverage;
    }

    public void setmAverage(String mAverage) {
        this.mAverage = mAverage;
    }

    public String getmId() {
        return mId;
    }

    public void setmId(String mId) {
        this.mId = mId;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmState() {
        return mState;
    }

    public void setmState(String mState) {
        this.mState = mState;
    }

    public String getmSub1() {
        return mSub1;
    }

    public void setmSub1(String mSub1) {
        this.mSub1 = mSub1;
    }

    public String getmSub2() {
        return mSub2;
    }

    public void setmSub2(String mSub2) {
        this.mSub2 = mSub2;
    }

    public String getmSub3() {
        return mSub3;
    }

    public void setmSub3(String mSub3) {
        this.mSub3 = mSub3;
    }

    public String getmSub4() {
        return mSub4;
    }

    public void setmSub4(String mSub4) {
        this.mSub4 = mSub4;
    }

    public String getmSurname() {
        return mSurname;
    }

    public void setmSurname(String mSurname) {
        this.mSurname = mSurname;
    }

}
