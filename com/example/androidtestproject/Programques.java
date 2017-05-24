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

public class Programques extends Activity {
    private static Button cnext;
    private static TextView cpquestion;
    private static RadioButton cr1;
    private static RadioButton cr2;
    private static RadioButton cr3;
    private static RadioButton cr4;
    private static RadioButton crbtn;
    private static RadioGroup crgroup;
    private static Button croug;
    private static TextView ctimer;
    private String aanswer_marked;
    ArrayList<String> canswers;
    ArrayList<String> clist;
    ArrayList<String> crealans;
    DBManager dbc;
    private int f2i;

    /* renamed from: com.example.androidtestproject.Programques.1 */
    class C00521 implements OnCheckedChangeListener {
        C00521() {
        }

        public void onCheckedChanged(RadioGroup group, int checkedId) {
            Programques.crbtn = (RadioButton) Programques.this.findViewById(checkedId);
            Programques.this.aanswer_marked = Programques.crbtn.getText().toString();
        }
    }

    /* renamed from: com.example.androidtestproject.Programques.2 */
    class C00542 extends CountDownTimer {

        /* renamed from: com.example.androidtestproject.Programques.2.1 */
        class C00531 implements OnClickListener {
            C00531() {
            }

            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case ViewDragHelper.INVALID_POINTER /*-1*/:
                        Intent inn = new Intent(Programques.this, Aptianswers.class);
                        Bundle bun = new Bundle();
                        bun.putStringArrayList("canswers", Programques.this.canswers);
                        bun.putStringArrayList("crealans", Programques.this.crealans);
                        inn.putExtras(bun);
                        Programques.this.startActivity(inn);
                    default:
                }
            }
        }

        C00542(long $anonymous0, long $anonymous1) {
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
            Programques.ctimer.setText(new StringBuilder(String.valueOf(min)).append(" : ").append(sec).toString());
            if (min.equals("00") && sec.equals("02")) {
                Vibrator v = (Vibrator) Programques.this.getSystemService("vibrator");
                Programques.ctimer.setTextColor(Color.parseColor("#CC6666"));
                v.vibrate(2000);
            }
        }

        public void onFinish() {
            OnClickListener dc = new C00531();
            Builder ad = new Builder(Programques.this);
            ad.setTitle("Time Up !!!!");
            ad.setPositiveButton("Okay", dc);
            ad.show();
        }
    }

    /* renamed from: com.example.androidtestproject.Programques.3 */
    class C00553 implements View.OnClickListener {
        C00553() {
        }

        public void onClick(View v) {
            Programques.this.startActivity(new Intent("com.example.androidtestproject.Roughwork"));
        }
    }

    /* renamed from: com.example.androidtestproject.Programques.4 */
    class C00564 implements View.OnClickListener {
        C00564() {
        }

        public void onClick(View v) {
            if (Programques.crbtn != null) {
                Programques.crbtn.setChecked(false);
            }
            Programques.this.canswers.add(Programques.this.aanswer_marked);
            if (Programques.this.f2i == 3) {
                Intent in = new Intent(Programques.this, Aptianswers.class);
                Bundle bunu = new Bundle();
                bunu.putStringArrayList("canswers", Programques.this.canswers);
                bunu.putStringArrayList("crealans", Programques.this.crealans);
                in.putExtras(bunu);
                Programques.this.startActivity(in);
                return;
            }
            if (Programques.this.f2i == 3) {
                Programques.cnext.setText("Submit");
            }
            String quet = String.valueOf(Programques.this.f2i);
            Programques.this.clist = Programques.this.dbc.getprogques(quet);
            Programques.crgroup = (RadioGroup) Programques.this.findViewById(C0057R.id.crgroup);
            Programques.cpquestion.setText((CharSequence) Programques.this.clist.get(0));
            Programques.cr1.setText((CharSequence) Programques.this.clist.get(1));
            Programques.cr2.setText((CharSequence) Programques.this.clist.get(2));
            Programques.cr3.setText((CharSequence) Programques.this.clist.get(3));
            Programques.cr4.setText((CharSequence) Programques.this.clist.get(4));
            Programques.this.crealans.add(((String) Programques.this.clist.get(5)).toString());
            Programques programques = Programques.this;
            programques.f2i = programques.f2i + 1;
        }
    }

    public Programques() {
        this.f2i = 1;
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C0057R.layout.programquestions);
        this.dbc = new DBManager(getApplicationContext());
        this.clist = new ArrayList();
        this.crealans = new ArrayList();
        this.canswers = new ArrayList();
        ctimer = (TextView) findViewById(C0057R.id.ctimer);
        cnext = (Button) findViewById(C0057R.id.cnext);
        croug = (Button) findViewById(C0057R.id.crough);
        cpquestion = (TextView) findViewById(C0057R.id.cquestion);
        crgroup = (RadioGroup) findViewById(C0057R.id.crgroup);
        cr1 = (RadioButton) findViewById(C0057R.id.coption1);
        cr2 = (RadioButton) findViewById(C0057R.id.coption2);
        cr3 = (RadioButton) findViewById(C0057R.id.coption3);
        cr4 = (RadioButton) findViewById(C0057R.id.coption4);
        crgroup.setOnCheckedChangeListener(new C00521());
        new C00542(60000, 1000).start();
        this.clist = this.dbc.getprogques(String.valueOf(this.f2i));
        cpquestion.setText((CharSequence) this.clist.get(0));
        cr1.setText((CharSequence) this.clist.get(1));
        cr2.setText((CharSequence) this.clist.get(2));
        cr3.setText((CharSequence) this.clist.get(3));
        cr4.setText((CharSequence) this.clist.get(4));
        this.crealans.add((String) this.clist.get(5));
        this.f2i++;
        croug.setOnClickListener(new C00553());
        cnext.setOnClickListener(new C00564());
    }

    protected void onPause() {
        super.onPause();
    }
}
