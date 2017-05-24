package com.example.androidtestproject;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Roughwork extends Activity implements OnClickListener {
    Button cl;
    Button div;
    Button dot;
    EditText ed1;
    Button eig;
    Button eq;
    EditText et;
    Button fiv;
    Button four;
    char lO;
    Button mins;
    Button mul;
    Button nine;
    Button one;
    Button plus;
    int result;
    String f3s;
    Button sev;
    Button six;
    Button thr;
    Button two;
    Button zero;

    public Roughwork() {
        this.f3s = "0";
        this.result = 0;
        this.lO = ' ';
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C0057R.layout.roughwork);
        this.nine = (Button) findViewById(C0057R.id.b9);
        this.eig = (Button) findViewById(C0057R.id.b8);
        this.sev = (Button) findViewById(C0057R.id.b7);
        this.six = (Button) findViewById(C0057R.id.b6);
        this.fiv = (Button) findViewById(C0057R.id.b5);
        this.four = (Button) findViewById(C0057R.id.b4);
        this.thr = (Button) findViewById(C0057R.id.b3);
        this.two = (Button) findViewById(C0057R.id.b2);
        this.one = (Button) findViewById(C0057R.id.b1);
        this.zero = (Button) findViewById(C0057R.id.b0);
        this.dot = (Button) findViewById(C0057R.id.bd);
        this.plus = (Button) findViewById(C0057R.id.bpl);
        this.mins = (Button) findViewById(C0057R.id.bmin);
        this.div = (Button) findViewById(C0057R.id.bdiv);
        this.mul = (Button) findViewById(C0057R.id.bmul);
        this.eq = (Button) findViewById(C0057R.id.beq);
        this.cl = (Button) findViewById(C0057R.id.bcl);
        this.et = (EditText) findViewById(C0057R.id.Etext);
        this.nine.setOnClickListener(this);
        this.eig.setOnClickListener(this);
        this.sev.setOnClickListener(this);
        this.six.setOnClickListener(this);
        this.fiv.setOnClickListener(this);
        this.four.setOnClickListener(this);
        this.thr.setOnClickListener(this);
        this.two.setOnClickListener(this);
        this.one.setOnClickListener(this);
        this.dot.setOnClickListener(this);
        this.plus.setOnClickListener(this);
        this.mins.setOnClickListener(this);
        this.div.setOnClickListener(this);
        this.mul.setOnClickListener(this);
        this.eq.setOnClickListener(this);
        this.cl.setOnClickListener(this);
        this.et.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case C0057R.id.b9:
            case C0057R.id.b8:
            case C0057R.id.b7:
            case C0057R.id.b6:
            case C0057R.id.b5:
            case C0057R.id.b4:
            case C0057R.id.b3:
            case C0057R.id.b2:
            case C0057R.id.b1:
            case C0057R.id.b0:
                String inDigit = ((Button) v).getText().toString();
                if (this.f3s.equals("0")) {
                    this.f3s = inDigit;
                } else {
                    this.f3s += inDigit;
                }
                this.et.setText(this.f3s);
                if (this.lO == '=') {
                    this.result = 0;
                    this.lO = ' ';
                }
            case C0057R.id.bpl:
                compute();
                this.lO = '+';
            case C0057R.id.bmin:
                compute();
                this.lO = '-';
            case C0057R.id.bmul:
                compute();
                this.lO = '*';
            case C0057R.id.bcl:
                this.result = 0;
                this.f3s = "0";
                this.lO = ' ';
                this.et.setText("0");
            case C0057R.id.beq:
                compute();
                this.lO = '=';
            case C0057R.id.bdiv:
                compute();
                this.lO = '/';
            default:
        }
    }

    private void compute() {
        int inNum = Integer.parseInt(this.f3s);
        this.f3s = "0";
        if (this.lO == ' ') {
            this.result = inNum;
        } else if (this.lO == '+') {
            this.result += inNum;
        } else if (this.lO == '-') {
            this.result -= inNum;
        } else if (this.lO == '*') {
            this.result *= inNum;
        } else if (this.lO == '/') {
            this.result /= inNum;
        }
        this.et.setText(String.valueOf(this.result));
    }
}
