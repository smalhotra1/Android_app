package com.example.androidtestproject;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Vibrator;
import android.support.v4.widget.ViewDragHelper;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import java.util.ArrayList;

public class Verbalquestions extends Activity {
    private static Button vnext;
    private static TextView vquestion;
    private static RadioButton vr1;
    private static RadioButton vr2;
    private static RadioButton vr3;
    private static RadioButton vr4;
    private static RadioButton vrbtn;
    private static RadioGroup vrgroup;
    private static Button vroug;
    private static TextView vtimer;
    private String aanswer_marked;
    DBManager dbbb;
    private int f5i;
    ArrayList<String> vlist;
    ArrayList<String> vrealans;
    ArrayList<String> vvanswers;

    /* renamed from: com.example.androidtestproject.Verbalquestions.1 */
    class C00631 implements OnCheckedChangeListener {
        C00631() {
        }

        public void onCheckedChanged(RadioGroup group, int checkedId) {
            Verbalquestions.vrbtn = (RadioButton) Verbalquestions.this.findViewById(checkedId);
            Verbalquestions.this.aanswer_marked = Verbalquestions.vrbtn.getText().toString();
        }
    }

    /* renamed from: com.example.androidtestproject.Verbalquestions.2 */
    class C00652 extends CountDownTimer {

        /* renamed from: com.example.androidtestproject.Verbalquestions.2.1 */
        class C00641 implements OnClickListener {
            C00641() {
            }

            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case ViewDragHelper.INVALID_POINTER /*-1*/:
                        Intent inn = new Intent(Verbalquestions.this, Verbalansw.class);
                        Bundle bunt = new Bundle();
                        bunt.putStringArrayList("vvanswers", Verbalquestions.this.vvanswers);
                        bunt.putStringArrayList("vrealans", Verbalquestions.this.vrealans);
                        inn.putExtras(bunt);
                        Verbalquestions.this.startActivity(inn);
                    default:
                }
            }
        }

        C00652(long $anonymous0, long $anonymous1) {
            super($anonymous0, $anonymous1);
        }

        public void onTick(long millisUntilFinished) {
            String min;
            String sec;
            int seconds = ((int) (millisUntilFinished / 1000)) % 60;
            int minutes = (int) ((millisUntilFinished / 60000) % 60);
            int hours = (int) ((millisUntilFinished / 3600000) % 24);
            if (minutes < 10) {
                min = "0" + minutes;
            } else {
                min = minutes;
            }
            if (seconds < 10) {
                sec = "0" + seconds;
            } else {
                sec = seconds;
            }
            Verbalquestions.vtimer.setText(new StringBuilder(String.valueOf(min)).append(" : ").append(sec).toString());
            if (min.equals("00") && sec.equals("02")) {
                Vibrator v = (Vibrator) Verbalquestions.this.getSystemService("vibrator");
                Verbalquestions.vtimer.setTextColor(Color.parseColor("#CC6666"));
                v.vibrate(2000);
            }
        }

        public void onFinish() {
            OnClickListener dc = new C00641();
            Builder ad = new Builder(Verbalquestions.this);
            ad.setTitle("Time Up !!!!");
            ad.setPositiveButton("Okay", dc);
            ad.show();
        }
    }

    /* renamed from: com.example.androidtestproject.Verbalquestions.3 */
    class C00663 implements View.OnClickListener {
        C00663() {
        }

        public void onClick(View v) {
            Verbalquestions.this.startActivity(new Intent("com.example.androidtestproject.Roughwork"));
        }
    }

    /* renamed from: com.example.androidtestproject.Verbalquestions.4 */
    class C00674 implements View.OnClickListener {
        C00674() {
        }

        public void onClick(View v) {
            if (Verbalquestions.vrbtn != null) {
                Verbalquestions.vrbtn.setChecked(false);
            }
            Verbalquestions.this.vvanswers.add(Verbalquestions.this.aanswer_marked);
            if (Verbalquestions.this.f5i == 13) {
                Intent in = new Intent(Verbalquestions.this, Verbalansw.class);
                Bundle bunu = new Bundle();
                bunu.putStringArrayList("vvanswers", Verbalquestions.this.vvanswers);
                bunu.putStringArrayList("vrealans", Verbalquestions.this.vrealans);
                in.putExtras(bunu);
                Verbalquestions.this.startActivity(in);
                return;
            }
            if (Verbalquestions.this.f5i == 13) {
                Verbalquestions.vnext.setText("Submit");
            }
            String quet = String.valueOf(Verbalquestions.this.f5i);
            Verbalquestions.this.vlist = Verbalquestions.this.dbbb.getverbal(quet);
            Verbalquestions.vrgroup = (RadioGroup) Verbalquestions.this.findViewById(C0057R.id.vrgroup);
            Verbalquestions.vquestion.setText((CharSequence) Verbalquestions.this.vlist.get(0));
            Verbalquestions.vr1.setText((CharSequence) Verbalquestions.this.vlist.get(1));
            Verbalquestions.vr2.setText((CharSequence) Verbalquestions.this.vlist.get(2));
            Verbalquestions.vr3.setText((CharSequence) Verbalquestions.this.vlist.get(3));
            Verbalquestions.vr4.setText((CharSequence) Verbalquestions.this.vlist.get(4));
            Verbalquestions.this.vrealans.add(((String) Verbalquestions.this.vlist.get(5)).toString());
            Verbalquestions verbalquestions = Verbalquestions.this;
            verbalquestions.f5i = verbalquestions.f5i + 1;
        }
    }

    public Verbalquestions() {
        this.f5i = 11;
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C0057R.layout.verball);
        this.dbbb = new DBManager(getApplicationContext());
        this.vlist = new ArrayList();
        this.vrealans = new ArrayList();
        this.vvanswers = new ArrayList();
        vtimer = (TextView) findViewById(C0057R.id.vtimer);
        vnext = (Button) findViewById(C0057R.id.vnext);
        vroug = (Button) findViewById(C0057R.id.vrough);
        vquestion = (TextView) findViewById(C0057R.id.vquestion);
        vrgroup = (RadioGroup) findViewById(C0057R.id.vrgroup);
        vr1 = (RadioButton) findViewById(C0057R.id.voption1);
        vr2 = (RadioButton) findViewById(C0057R.id.voption2);
        vr3 = (RadioButton) findViewById(C0057R.id.voption3);
        vr4 = (RadioButton) findViewById(C0057R.id.voption4);
        vrgroup.setOnCheckedChangeListener(new C00631());
        new C00652(60000, 1000).start();
        this.vlist = this.dbbb.getverbal(String.valueOf(this.f5i));
        vquestion.setText((CharSequence) this.vlist.get(0));
        vr1.setText((CharSequence) this.vlist.get(1));
        vr2.setText((CharSequence) this.vlist.get(2));
        vr3.setText((CharSequence) this.vlist.get(3));
        vr4.setText((CharSequence) this.vlist.get(4));
        this.vrealans.add((String) this.vlist.get(5));
        this.f5i++;
        vroug.setOnClickListener(new C00663());
        vnext.setOnClickListener(new C00674());
    }

    protected void onPause() {
        super.onPause();
    }
}
