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

public class Test extends Activity {
    private static Button next;
    private static TextView question;
    private static RadioButton r1;
    private static RadioButton r2;
    private static RadioButton r3;
    private static RadioButton r4;
    private static RadioButton rbtn;
    private static RadioGroup rgroup;
    private static Button roug;
    private static TextView timer;
    private String answer_marked;
    ArrayList<String> answers;
    DBManager dbm;
    private int f4i;
    ArrayList<String> list;
    ArrayList<String> realans;

    /* renamed from: com.example.androidtestproject.Test.1 */
    class C00581 implements OnCheckedChangeListener {
        C00581() {
        }

        public void onCheckedChanged(RadioGroup group, int checkedId) {
            Test.rbtn = (RadioButton) Test.this.findViewById(checkedId);
            Test.this.answer_marked = Test.rbtn.getText().toString();
        }
    }

    /* renamed from: com.example.androidtestproject.Test.2 */
    class C00602 extends CountDownTimer {

        /* renamed from: com.example.androidtestproject.Test.2.1 */
        class C00591 implements OnClickListener {
            C00591() {
            }

            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case ViewDragHelper.INVALID_POINTER /*-1*/:
                        Intent inn = new Intent(Test.this, Result.class);
                        Bundle bun = new Bundle();
                        bun.putStringArrayList("answers", Test.this.answers);
                        bun.putStringArrayList("realans", Test.this.realans);
                        inn.putExtras(bun);
                        Test.this.startActivity(inn);
                    default:
                }
            }
        }

        C00602(long $anonymous0, long $anonymous1) {
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
            Test.timer.setText(new StringBuilder(String.valueOf(min)).append(" : ").append(sec).toString());
            if (min.equals("00") && sec.equals("02")) {
                Vibrator v = (Vibrator) Test.this.getSystemService("vibrator");
                Test.timer.setTextColor(Color.parseColor("#CC6666"));
                v.vibrate(2000);
            }
        }

        public void onFinish() {
            OnClickListener dc = new C00591();
            Builder ad = new Builder(Test.this);
            ad.setTitle("Time Up !!!!");
            ad.setPositiveButton("Okay", dc);
            ad.show();
        }
    }

    /* renamed from: com.example.androidtestproject.Test.3 */
    class C00613 implements View.OnClickListener {
        C00613() {
        }

        public void onClick(View v) {
            Test.this.startActivity(new Intent("com.example.androidtestproject.Roughwork"));
        }
    }

    /* renamed from: com.example.androidtestproject.Test.4 */
    class C00624 implements View.OnClickListener {
        C00624() {
        }

        public void onClick(View v) {
            if (Test.rbtn != null) {
                Test.rbtn.setChecked(false);
            }
            Test.this.answers.add(Test.this.answer_marked);
            if (Test.this.f4i == 132) {
                Intent in = new Intent(Test.this, Result.class);
                Bundle bun = new Bundle();
                bun.putStringArrayList("answers", Test.this.answers);
                bun.putStringArrayList("realans", Test.this.realans);
                in.putExtras(bun);
                Test.this.startActivity(in);
                return;
            }
            if (Test.this.f4i == 131) {
                Test.next.setText("Submit");
            }
            String quet = String.valueOf(Test.this.f4i);
            Test.this.list = Test.this.dbm.getQuestion(quet);
            Test.rgroup = (RadioGroup) Test.this.findViewById(C0057R.id.rgroup);
            Test.question.setText((CharSequence) Test.this.list.get(0));
            Test.r1.setText((CharSequence) Test.this.list.get(1));
            Test.r2.setText((CharSequence) Test.this.list.get(2));
            Test.r3.setText((CharSequence) Test.this.list.get(3));
            Test.r4.setText((CharSequence) Test.this.list.get(4));
            Test.this.realans.add(((String) Test.this.list.get(5)).toString());
            Test test = Test.this;
            test.f4i = test.f4i + 1;
        }
    }

    public Test() {
        this.f4i = 124;
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C0057R.layout.test);
        this.dbm = new DBManager(getApplicationContext());
        this.list = new ArrayList();
        this.realans = new ArrayList();
        this.answers = new ArrayList();
        timer = (TextView) findViewById(C0057R.id.timer);
        next = (Button) findViewById(C0057R.id.next);
        roug = (Button) findViewById(C0057R.id.rough);
        question = (TextView) findViewById(C0057R.id.question);
        rgroup = (RadioGroup) findViewById(C0057R.id.rgroup);
        r1 = (RadioButton) findViewById(C0057R.id.option1);
        r2 = (RadioButton) findViewById(C0057R.id.option2);
        r3 = (RadioButton) findViewById(C0057R.id.option3);
        r4 = (RadioButton) findViewById(C0057R.id.option4);
        rgroup.setOnCheckedChangeListener(new C00581());
        new C00602(60000, 1000).start();
        this.list = this.dbm.getQuestion(String.valueOf(this.f4i));
        question.setText((CharSequence) this.list.get(0));
        r1.setText((CharSequence) this.list.get(1));
        r2.setText((CharSequence) this.list.get(2));
        r3.setText((CharSequence) this.list.get(3));
        r4.setText((CharSequence) this.list.get(4));
        this.realans.add((String) this.list.get(5));
        this.f4i++;
        roug.setOnClickListener(new C00613());
        next.setOnClickListener(new C00624());
    }

    protected void onPause() {
        super.onPause();
    }
}
