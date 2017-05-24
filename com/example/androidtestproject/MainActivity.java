package com.example.androidtestproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.media.TransportMediator;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
    Button addq;
    Button apti;
    Button cpgm;
    DBManager dbaa;
    DBManager dbb;
    DBManager dbc;
    DBManager dbm;
    Button formm;
    Button practice;
    Button start;
    Button verb;

    /* renamed from: com.example.androidtestproject.MainActivity.1 */
    class C00461 implements OnClickListener {
        C00461() {
        }

        public void onClick(View v) {
            MainActivity.this.startActivity(new Intent("com.example.androidtestproject.Programques"));
        }
    }

    /* renamed from: com.example.androidtestproject.MainActivity.2 */
    class C00472 implements OnClickListener {
        C00472() {
        }

        public void onClick(View v) {
            MainActivity.this.startActivity(new Intent("com.example.androidtestproject.Verbalquestions"));
        }
    }

    /* renamed from: com.example.androidtestproject.MainActivity.3 */
    class C00483 implements OnClickListener {
        C00483() {
        }

        public void onClick(View v) {
            MainActivity.this.startActivity(new Intent("com.example.androidtestproject.Formulas"));
        }
    }

    /* renamed from: com.example.androidtestproject.MainActivity.4 */
    class C00494 implements OnClickListener {
        C00494() {
        }

        public void onClick(View v) {
            MainActivity.this.startActivity(new Intent("com.example.androidtestproject.AddQuestion"));
        }
    }

    /* renamed from: com.example.androidtestproject.MainActivity.5 */
    class C00505 implements OnClickListener {
        C00505() {
        }

        public void onClick(View v) {
            MainActivity.this.startActivity(new Intent("com.example.androidtestproject.Test"));
        }
    }

    /* renamed from: com.example.androidtestproject.MainActivity.6 */
    class C00516 implements OnClickListener {
        C00516() {
        }

        public void onClick(View v) {
            MainActivity.this.startActivity(new Intent("com.example.androidtestproject.AptitudeTest"));
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C0057R.layout.activity_main);
        this.dbm = new DBManager(getApplicationContext());
        this.dbb = new DBManager(getApplicationContext());
        this.dbaa = new DBManager(getApplicationContext());
        this.dbc = new DBManager(getApplicationContext());
        this.dbm.insertQuestion(124, "1. Solve 2*7+10/5", "10", "16", "20", "4.8", "16");
        this.dbm.insertQuestion(125, "2. IC chips used in computers are usually made of", "Lead", "Silicon", "Chromium", "Aluminium", "Silicon");
        this.dbm.insertQuestion(TransportMediator.KEYCODE_MEDIA_PLAY, "3. One kilobyte is equal to", "1000 bytes", "100 bytes", "1024 bytes", "1023 bytes", "1024 bytes");
        this.dbm.insertQuestion(TransportMediator.KEYCODE_MEDIA_PAUSE, "4. Which of the following is not an example of Operating System?", "Windows 98", "BSD Unix", "Microsoft Office XP", "Red Hat Linux", "Microsoft Office XP");
        this.dbm.insertQuestion(TransportMediator.FLAG_KEY_MEDIA_NEXT, "5. Which supercomputer is developed by the Indian Scientists?", "Param", "Super 301", "Compaq Presario", "CRAY YMP", "Param");
        this.dbm.insertQuestion(129, "6. One Gigabyte is Approximately equal is", "1000,000 bytes", "1000,000,000 bytes", "1000,000,000,000 bytes", "None of these", "1000,000,000 bytes");
        this.dbm.insertQuestion(TransportMediator.KEYCODE_MEDIA_RECORD, "7. Check the odd term out", "Internet", "Unix", "Linux", "Windows", "Internet");
        this.dbm.insertQuestion(131, "8. The errors that can be pointed out by the compiler are", "Syntax error", "Symantic error", "Logical error", "Internal error", "Syntax error");
        this.dbb.insertaptiQuestion(1, "Solve 2*7+10/5", "10", "16", "20", "4.8", "16");
        this.dbb.insertaptiQuestion(2, "Solve 2+2", "1", "2", "3", "4", "4");
        this.dbb.insertaptiQuestion(3, "Solve 2*3", "1", "2", "6", "5", "6");
        this.dbb.insertverbalques(11, "aaa", "b", "c", "d", "e", "c");
        this.dbb.insertverbalques(12, "afgdf", "bfg", "c", "df", "e", "c");
        this.dbb.insertverbalques(13, "accc", "b", "c", "d", "e", "c");
        this.dbc.insertprogques(1, "aaaaccc", "d", "v", "h", "h", "h");
        this.dbc.insertprogques(2, "bbbbbbb", "d", "v", "h", "h", "h");
        this.dbc.insertprogques(3, "cccccc", "d", "v", "h", "h", "h");
        this.cpgm = (Button) findViewById(C0057R.id.cprogram);
        this.cpgm.setOnClickListener(new C00461());
        this.verb = (Button) findViewById(C0057R.id.verbal);
        this.verb.setOnClickListener(new C00472());
        this.formm = (Button) findViewById(C0057R.id.formula);
        this.formm.setOnClickListener(new C00483());
        this.addq = (Button) findViewById(C0057R.id.addq);
        this.addq.setOnClickListener(new C00494());
        this.start = (Button) findViewById(C0057R.id.start_test);
        this.start.setOnClickListener(new C00505());
        this.apti = (Button) findViewById(C0057R.id.apti);
        this.apti.setOnClickListener(new C00516());
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(C0057R.menu.main, menu);
        return true;
    }

    protected void onPause() {
        super.onPause();
    }
}
