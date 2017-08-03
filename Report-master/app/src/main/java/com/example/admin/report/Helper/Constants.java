package com.example.admin.report.Helper;

/**
 * Created by Max on 2016/11/14.
 */
public class Constants {

    public static final int VERSION_NAME = 5;
    public static final String DATABASE_NAME = "tinga_institute.db";

    //Common Tables
    //State basically indicates whether you have passed or not.
    public static final String NAME = "name";
    public static final String SURNAME = "surname";
    public static final String STUDENT_ID = "id";
    public static final String STATE = "state";
    public static final String AVERAGE = "average";

    //Table Names
    public static final String NET_TABLE_NAME = "networking_students";
    public static final String IT_MANAGEMENT_TABLE_NAME = "it_management_students";
    public static final String DESIGN_TABLE_NAME = "software_design_students";
    public static final String SYS_ANALYSIS_TABLE_NAME = "sys_analysis_students";

    //All Subject for Computer Networking
    public static final String SUBJECT_1 = "itc_571";
    public static final String SUBJECT_2 = "itc_431";
    public static final String SUBJECT_3 = "itc_513";
    public static final String SUBJECT_4 = "itc_542";

    //All Subjects for IT Management
    public static final String SUB_1 = "itc_571";
    public static final String SUB_2 = "itc_516";
    public static final String SUB_3 = "itc_595";
    public static final String SUB_4 = "itc_596";

    //All Subject for Software Design
    public static final String SUBJECT1 = "itc_571";
    public static final String SUBJECT2 = "itc_412";
    public static final String SUBJECT3 = "itc_421";
    public static final String SUBJECT4 = "itc_521";

    //All Subjects for System Analysis
    public static final String SUB1 = "itc_571";
    public static final String SUB2 = "itc_415";
    public static final String SUB3 = "itc_516";
    public static final String SUB4 = "itc_596";

    /*
    * Networking Table
    * */
    public static final String NETWORKING_TABLE = "create table " + NET_TABLE_NAME + "("
            + STUDENT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + NAME +" TEXT, " + SURNAME + " TEXT, " + SUBJECT_1 + " INTEGER, " + SUBJECT_2 + " INTEGER, " + SUBJECT_3 + " INTEGER, "
            + SUBJECT_4 + " INTEGER, " + AVERAGE + " INTEGER, " + STATE + " TEXT" + ")";

    /*
    * IT Management Table
    * */
    public static final String IT_MANAGEMENT_TABLE = "create table " + IT_MANAGEMENT_TABLE_NAME + "("
            + STUDENT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + NAME +" TEXT, " + SURNAME + " TEXT, " + SUB_1 + " INTEGER, " + SUB_2 + " INTEGER, " + SUB_3 + " INTEGER, "
            + SUB_4 + " INTEGER, " + AVERAGE + " INTEGER, " + STATE + " TEXT" + ")";

    /*
    * Software Design Table
    * */
    public static final String SOFTWARE_DESIGN_TABLE = "create table " + DESIGN_TABLE_NAME + "("
            + STUDENT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + NAME +" TEXT, " + SURNAME + " TEXT, " + SUBJECT1 + " INTEGER, " + SUBJECT2 + " INTEGER, " + SUBJECT3 + " INTEGER, "
            + SUBJECT4 + " INTEGER, " + AVERAGE + " INTEGER, " + STATE + " TEXT" + ")";

    /*
    * System Analysis Table
    * */
    public static final String SYS_ANALYSIS_TABLE = "create table " + SYS_ANALYSIS_TABLE_NAME + "("
            + STUDENT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + NAME +" TEXT, " + SURNAME + " TEXT, " + SUB1 + " INTEGER, " + SUB2 + " INTEGER, " + SUB3 + " INTEGER, "
            + SUB4 + " INTEGER, " + AVERAGE + " INTEGER, " + STATE + " TEXT" + ")";


}
