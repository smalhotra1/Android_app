package com.example.androidtestproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;

public class DBManager extends SQLiteOpenHelper {
    private static final String AANSWER = "anss";
    private static final String AKEY_ID = "idd";
    private static final String ANSWER = "ans";
    private static final String AOPTION_1 = "opt11";
    private static final String AOPTION_2 = "opt22";
    private static final String AOPTION_3 = "opt33";
    private static final String AOPTION_4 = "opt44";
    private static final String AQUESTION = "questionn";
    private static final String AQUESTION_ID = "qidd";
    private static final String CANSWER = "cans";
    private static final String CKEY_ID = "cid";
    private static final String COPTION_1 = "copt1";
    private static final String COPTION_2 = "copt2";
    private static final String COPTION_3 = "copt3";
    private static final String COPTION_4 = "copt4";
    private static final String CQUESTION = "cquestion";
    private static final String CQUESTION_ID = "cqid";
    private static final String Database_Name = "MyDatabase.db";
    private static final int Database_Version = 1;
    private static final String KEY_ID = "id";
    private static final String OPTION_1 = "opt1";
    private static final String OPTION_2 = "opt2";
    private static final String OPTION_3 = "opt3";
    private static final String OPTION_4 = "opt4";
    private static final String QUESTION = "question";
    private static final String QUESTION_ID = "qid";
    private static final String VANSWER = "vans";
    private static final String VKEY_ID = "vid";
    private static final String VOPTION_1 = "vopt1";
    private static final String VOPTION_2 = "vopt2";
    private static final String VOPTION_3 = "vopt3";
    private static final String VOPTION_4 = "vopt4";
    private static final String VQUESTION = "vquestion";
    private static final String VQUESTION_ID = "vqid";
    private final String CREATE_TABLE;
    private final String CREATE_TABLE_apti;
    private final String CREATE_TABLE_prog;
    private final String CREATE_TABLE_verb;

    public DBManager(Context context) {
        super(context, Database_Name, null, Database_Version);
        this.CREATE_TABLE = "create table Qbase (id INTEGER PRIMARY KEY, qid INTEGER, question TEXT, opt1 TEXT, opt2 TEXT, opt3 TEXT, opt4 TEXT, ans TEXT)";
        this.CREATE_TABLE_apti = "create table Qbase_apti (idd INTEGER PRIMARY KEY, qidd INTEGER, questionn TEXT, opt11 TEXT, opt22 TEXT, opt33 TEXT, opt44 TEXT, anss TEXT)";
        this.CREATE_TABLE_verb = "create table Qbase_verb (vid INTEGER PRIMARY KEY, vqid INTEGER, vquestion TEXT, vopt1 TEXT, vopt2 TEXT, vopt3 TEXT, vopt4 TEXT, vans TEXT)";
        this.CREATE_TABLE_prog = "create table Qbase_prog (cid INTEGER PRIMARY KEY, cqid INTEGER, cquestion TEXT, copt1 TEXT, copt2 TEXT, copt3 TEXT, copt4 TEXT, cans TEXT)";
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table Qbase (id INTEGER PRIMARY KEY, qid INTEGER, question TEXT, opt1 TEXT, opt2 TEXT, opt3 TEXT, opt4 TEXT, ans TEXT)");
        db.execSQL("create table Qbase_apti (idd INTEGER PRIMARY KEY, qidd INTEGER, questionn TEXT, opt11 TEXT, opt22 TEXT, opt33 TEXT, opt44 TEXT, anss TEXT)");
        db.execSQL("create table Qbase_verb (vid INTEGER PRIMARY KEY, vqid INTEGER, vquestion TEXT, vopt1 TEXT, vopt2 TEXT, vopt3 TEXT, vopt4 TEXT, vans TEXT)");
        db.execSQL("create table Qbase_prog (cid INTEGER PRIMARY KEY, cqid INTEGER, cquestion TEXT, copt1 TEXT, copt2 TEXT, copt3 TEXT, copt4 TEXT, cans TEXT)");
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Qbase");
        db.execSQL("DROP TABLE IF EXISTS Qbase_apti");
        db.execSQL("DROP TABLE IF EXISTS Qbase_verb");
        db.execSQL("DROP TABLE IF EXISTS Qbase_prog");
    }

    public void insertQuestion(int qid, String question, String op1, String op2, String op3, String op4, String ans) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(QUESTION_ID, Integer.valueOf(qid));
        cv.put(QUESTION, question);
        cv.put(OPTION_1, op1);
        cv.put(OPTION_2, op2);
        cv.put(OPTION_3, op3);
        cv.put(OPTION_4, op4);
        cv.put(ANSWER, ans);
        db.insert("Qbase", null, cv);
    }

    public void insertaptiQuestion(int aqid, String aquestion, String aop1, String aop2, String aop3, String aop4, String aans) {
        SQLiteDatabase dbb = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(AQUESTION_ID, Integer.valueOf(aqid));
        cv.put(AQUESTION, aquestion);
        cv.put(AOPTION_1, aop1);
        cv.put(AOPTION_2, aop2);
        cv.put(AOPTION_3, aop3);
        cv.put(AOPTION_4, aop4);
        cv.put(AANSWER, aans);
        dbb.insert("Qbase_apti", null, cv);
    }

    public void insertverbalques(int vvqid, String vquestion, String vop1, String vop2, String vop3, String vop4, String vans) {
        SQLiteDatabase dbbb = getWritableDatabase();
        ContentValues cvv = new ContentValues();
        cvv.put(VQUESTION_ID, Integer.valueOf(vvqid));
        cvv.put(VQUESTION, vquestion);
        cvv.put(VOPTION_1, vop1);
        cvv.put(VOPTION_2, vop2);
        cvv.put(VOPTION_3, vop3);
        cvv.put(VOPTION_4, vop4);
        cvv.put(VANSWER, vans);
        dbbb.insert("Qbase_verb", null, cvv);
    }

    public void insertprogques(int cqid, String cquestion, String cop1, String cop2, String cop3, String cop4, String cans) {
        SQLiteDatabase dbbb = getWritableDatabase();
        ContentValues cvv = new ContentValues();
        cvv.put(CQUESTION_ID, Integer.valueOf(cqid));
        cvv.put(CQUESTION, cquestion);
        cvv.put(COPTION_1, cop1);
        cvv.put(COPTION_2, cop2);
        cvv.put(COPTION_3, cop3);
        cvv.put(COPTION_4, cop4);
        cvv.put(CANSWER, cans);
        dbbb.insert("Qbase_prog", null, cvv);
    }

    public ArrayList<String> getQuestion(String i) {
        String[] strArr = new String[Database_Version];
        strArr[0] = i;
        Cursor c = getReadableDatabase().query("Qbase", null, "qid=?", strArr, null, null, null);
        if (c.getCount() < Database_Version) {
            c.close();
            return null;
        }
        ArrayList<String> list = new ArrayList();
        c.moveToFirst();
        list.add(c.getString(c.getColumnIndex(QUESTION)));
        c.moveToFirst();
        list.add(c.getString(c.getColumnIndex(OPTION_1)));
        c.moveToFirst();
        list.add(c.getString(c.getColumnIndex(OPTION_2)));
        c.moveToFirst();
        list.add(c.getString(c.getColumnIndex(OPTION_3)));
        c.moveToFirst();
        list.add(c.getString(c.getColumnIndex(OPTION_4)));
        c.moveToFirst();
        list.add(c.getString(c.getColumnIndex(ANSWER)));
        c.moveToFirst();
        return list;
    }

    public ArrayList<String> getaptquestion(String i) {
        String[] strArr = new String[Database_Version];
        strArr[0] = i;
        Cursor c = getReadableDatabase().query("Qbase_apti", null, "qidd=?", strArr, null, null, null);
        if (c.getCount() < Database_Version) {
            c.close();
            return null;
        }
        ArrayList<String> list = new ArrayList();
        c.moveToFirst();
        list.add(c.getString(c.getColumnIndex(AQUESTION)));
        c.moveToFirst();
        list.add(c.getString(c.getColumnIndex(AOPTION_1)));
        c.moveToFirst();
        list.add(c.getString(c.getColumnIndex(AOPTION_2)));
        c.moveToFirst();
        list.add(c.getString(c.getColumnIndex(AOPTION_3)));
        c.moveToFirst();
        list.add(c.getString(c.getColumnIndex(AOPTION_4)));
        c.moveToFirst();
        list.add(c.getString(c.getColumnIndex(AANSWER)));
        c.moveToFirst();
        return list;
    }

    public ArrayList<String> getverbal(String i) {
        String[] strArr = new String[Database_Version];
        strArr[0] = i;
        Cursor c = getReadableDatabase().query("Qbase_verb", null, "vqid=?", strArr, null, null, null);
        if (c.getCount() < Database_Version) {
            c.close();
            return null;
        }
        ArrayList<String> list = new ArrayList();
        c.moveToFirst();
        list.add(c.getString(c.getColumnIndex(VQUESTION)));
        c.moveToFirst();
        list.add(c.getString(c.getColumnIndex(VOPTION_1)));
        c.moveToFirst();
        list.add(c.getString(c.getColumnIndex(VOPTION_2)));
        c.moveToFirst();
        list.add(c.getString(c.getColumnIndex(VOPTION_3)));
        c.moveToFirst();
        list.add(c.getString(c.getColumnIndex(VOPTION_4)));
        c.moveToFirst();
        list.add(c.getString(c.getColumnIndex(VANSWER)));
        c.moveToFirst();
        return list;
    }

    public ArrayList<String> getprogques(String i) {
        String[] strArr = new String[Database_Version];
        strArr[0] = i;
        Cursor c = getReadableDatabase().query("Qbase_prog", null, "cid=?", strArr, null, null, null);
        if (c.getCount() < Database_Version) {
            c.close();
            return null;
        }
        ArrayList<String> list = new ArrayList();
        c.moveToFirst();
        list.add(c.getString(c.getColumnIndex(CQUESTION)));
        c.moveToFirst();
        list.add(c.getString(c.getColumnIndex(COPTION_1)));
        c.moveToFirst();
        list.add(c.getString(c.getColumnIndex(COPTION_2)));
        c.moveToFirst();
        list.add(c.getString(c.getColumnIndex(COPTION_3)));
        c.moveToFirst();
        list.add(c.getString(c.getColumnIndex(COPTION_4)));
        c.moveToFirst();
        list.add(c.getString(c.getColumnIndex(CANSWER)));
        c.moveToFirst();
        return list;
    }
}
