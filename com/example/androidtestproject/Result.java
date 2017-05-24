package com.example.androidtestproject;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayList;

public class Result extends Activity {
    private static LinearLayout lays;
    ArrayList<String> anslist;
    int corr;
    TextView correctans;
    ArrayList<String> userlist;
    TextView wrongans;

    public Result() {
        this.corr = 0;
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C0057R.layout.result);
        this.userlist = new ArrayList();
        this.anslist = new ArrayList();
        this.correctans = (TextView) findViewById(C0057R.id.correctans);
        this.wrongans = (TextView) findViewById(C0057R.id.wrongans);
        lays = (LinearLayout) findViewById(C0057R.id.lay);
        Bundle b = getIntent().getExtras();
        this.userlist = b.getStringArrayList("answers");
        this.anslist = b.getStringArrayList("realans");
        for (int i = 0; i < this.userlist.size(); i++) {
            String m = (String) this.userlist.get(i);
            String n = (String) this.anslist.get(i);
            if (m.equals(n)) {
                this.corr++;
            } else {
                TextView tv1 = new TextView(this);
                tv1.setText("Your Answer: " + m);
                TextView tv2 = new TextView(this);
                tv2.setText("Correct Answer: " + n);
                lays.addView(tv1);
                lays.addView(tv2);
            }
        }
        int wrong = this.anslist.size() - this.corr;
        this.correctans.setText("Correct Answers: " + this.corr);
        this.wrongans.setText("Wrong Answers: " + wrong);
    }
}
