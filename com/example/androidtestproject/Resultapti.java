package com.example.androidtestproject;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayList;

public class Resultapti extends Activity {
    private static LinearLayout alays;
    ArrayList<String> aanslist;
    int acorr;
    TextView acorrectans;
    ArrayList<String> auserlist;
    TextView awrongans;

    public Resultapti() {
        this.acorr = 0;
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C0057R.layout.resultaptitude);
        this.auserlist = new ArrayList();
        this.aanslist = new ArrayList();
        this.acorrectans = (TextView) findViewById(C0057R.id.correctans);
        this.awrongans = (TextView) findViewById(C0057R.id.wrongans);
        alays = (LinearLayout) findViewById(C0057R.id.lay2);
        Bundle bb = getIntent().getExtras();
        this.auserlist = bb.getStringArrayList("aanswers");
        this.aanslist = bb.getStringArrayList("arealans");
        for (int i = 0; i < this.auserlist.size(); i++) {
            String mm = (String) this.auserlist.get(i);
            String nn = (String) this.aanslist.get(i);
            if (mm.equals(nn)) {
                this.acorr++;
            } else {
                TextView tv1 = new TextView(this);
                tv1.setText("Your Answer: " + mm);
                TextView tv2 = new TextView(this);
                tv2.setText("Correct Answer: " + nn);
                alays.addView(tv1);
                alays.addView(tv2);
            }
        }
        int awrong = this.aanslist.size() - this.acorr;
        this.acorrectans.setText("Correct Answers: " + this.acorr);
        this.awrongans.setText("Wrong Answers: " + awrong);
    }
}
