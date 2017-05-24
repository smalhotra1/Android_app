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

public class AptitudeTest extends Activity {
    private static Button apnext;
    private static TextView apquestion;
    private static RadioButton aprbtn;
    private static RadioGroup aprgroup;
    private static Button aproug;
    private static TextView aptimer;
    private static RadioButton ar1;
    private static RadioButton ar2;
    private static RadioButton ar3;
    private static RadioButton ar4;
    private String aanswer_marked;
    ArrayList<String> aanswers;
    ArrayList<String> alist;
    ArrayList<String> arealans;
    DBManager dbb;
    private int f1i;

    /* renamed from: com.example.androidtestproject.AptitudeTest.1 */
    class C00411 implements OnCheckedChangeListener {
        C00411() {
        }

        public void onCheckedChanged(RadioGroup group, int checkedId) {
            AptitudeTest.aprbtn = (RadioButton) AptitudeTest.this.findViewById(checkedId);
            AptitudeTest.this.aanswer_marked = AptitudeTest.aprbtn.getText().toString();
        }
    }

    /* renamed from: com.example.androidtestproject.AptitudeTest.2 */
    class C00432 extends CountDownTimer {

        /* renamed from: com.example.androidtestproject.AptitudeTest.2.1 */
        class C00421 implements OnClickListener {
            C00421() {
            }

            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case ViewDragHelper.INVALID_POINTER /*-1*/:
                        Intent inn = new Intent(AptitudeTest.this, Aptianswers.class);
                        Bundle bun = new Bundle();
                        bun.putStringArrayList("aanswers", AptitudeTest.this.aanswers);
                        bun.putStringArrayList("arealans", AptitudeTest.this.arealans);
                        inn.putExtras(bun);
                        AptitudeTest.this.startActivity(inn);
                    default:
                }
            }
        }

        C00432(long $anonymous0, long $anonymous1) {
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
            AptitudeTest.aptimer.setText(new StringBuilder(String.valueOf(min)).append(" : ").append(sec).toString());
            if (min.equals("00") && sec.equals("02")) {
                Vibrator v = (Vibrator) AptitudeTest.this.getSystemService("vibrator");
                AptitudeTest.aptimer.setTextColor(Color.parseColor("#CC6666"));
                v.vibrate(2000);
            }
        }

        public void onFinish() {
            OnClickListener dc = new C00421();
            Builder ad = new Builder(AptitudeTest.this);
            ad.setTitle("Time Up !!!!");
            ad.setPositiveButton("Okay", dc);
            ad.show();
        }
    }

    /* renamed from: com.example.androidtestproject.AptitudeTest.3 */
    class C00443 implements View.OnClickListener {
        C00443() {
        }

        public void onClick(View v) {
            AptitudeTest.this.startActivity(new Intent("com.example.androidtestproject.Roughwork"));
        }
    }

    /* renamed from: com.example.androidtestproject.AptitudeTest.4 */
    class C00454 implements View.OnClickListener {
        C00454() {
        }

        public void onClick(View v) {
            if (AptitudeTest.aprbtn != null) {
                AptitudeTest.aprbtn.setChecked(false);
            }
            AptitudeTest.this.aanswers.add(AptitudeTest.this.aanswer_marked);
            if (AptitudeTest.this.f1i == 3) {
                Intent in = new Intent(AptitudeTest.this, Aptianswers.class);
                Bundle bunu = new Bundle();
                bunu.putStringArrayList("aanswers", AptitudeTest.this.aanswers);
                bunu.putStringArrayList("arealans", AptitudeTest.this.arealans);
                in.putExtras(bunu);
                AptitudeTest.this.startActivity(in);
                return;
            }
            if (AptitudeTest.this.f1i == 3) {
                AptitudeTest.apnext.setText("Submit");
            }
            String quet = String.valueOf(AptitudeTest.this.f1i);
            AptitudeTest.this.alist = AptitudeTest.this.dbb.getaptquestion(quet);
            AptitudeTest.aprgroup = (RadioGroup) AptitudeTest.this.findViewById(C0057R.id.rgroup);
            AptitudeTest.apquestion.setText((CharSequence) AptitudeTest.this.alist.get(0));
            AptitudeTest.ar1.setText((CharSequence) AptitudeTest.this.alist.get(1));
            AptitudeTest.ar2.setText((CharSequence) AptitudeTest.this.alist.get(2));
            AptitudeTest.ar3.setText((CharSequence) AptitudeTest.this.alist.get(3));
            AptitudeTest.ar4.setText((CharSequence) AptitudeTest.this.alist.get(4));
            AptitudeTest.this.arealans.add(((String) AptitudeTest.this.alist.get(5)).toString());
            AptitudeTest aptitudeTest = AptitudeTest.this;
            aptitudeTest.f1i = aptitudeTest.f1i + 1;
        }
    }

    public AptitudeTest() {
        this.f1i = 1;
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C0057R.layout.aptitudetest);
        this.dbb = new DBManager(getApplicationContext());
        this.alist = new ArrayList();
        this.arealans = new ArrayList();
        this.aanswers = new ArrayList();
        aptimer = (TextView) findViewById(C0057R.id.atimer);
        apnext = (Button) findViewById(C0057R.id.anext);
        aproug = (Button) findViewById(C0057R.id.arough);
        apquestion = (TextView) findViewById(C0057R.id.aquestion);
        aprgroup = (RadioGroup) findViewById(C0057R.id.argroup);
        ar1 = (RadioButton) findViewById(C0057R.id.aoption1);
        ar2 = (RadioButton) findViewById(C0057R.id.aoption2);
        ar3 = (RadioButton) findViewById(C0057R.id.aoption3);
        ar4 = (RadioButton) findViewById(C0057R.id.aoption4);
        aprgroup.setOnCheckedChangeListener(new C00411());
        new C00432(60000, 1000).start();
        this.alist = this.dbb.getaptquestion(String.valueOf(this.f1i));
        apquestion.setText((CharSequence) this.alist.get(0));
        ar1.setText((CharSequence) this.alist.get(1));
        ar2.setText((CharSequence) this.alist.get(2));
        ar3.setText((CharSequence) this.alist.get(3));
        ar4.setText((CharSequence) this.alist.get(4));
        this.arealans.add((String) this.alist.get(5));
        this.f1i++;
        aproug.setOnClickListener(new C00443());
        apnext.setOnClickListener(new C00454());
    }

    protected void onPause() {
        super.onPause();
    }
}
