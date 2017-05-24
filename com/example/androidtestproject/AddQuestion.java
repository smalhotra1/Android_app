package com.example.androidtestproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddQuestion extends Activity {
    Button add;
    EditText ans;
    DBManager dbm;
    EditText op1;
    EditText op2;
    EditText op3;
    EditText op4;
    EditText qid;
    EditText ques;

    /* renamed from: com.example.androidtestproject.AddQuestion.1 */
    class C00401 implements OnClickListener {
        C00401() {
        }

        public void onClick(View v) {
            int qidd = Integer.parseInt(AddQuestion.this.qid.getText().toString());
            String question = AddQuestion.this.ques.getText().toString();
            String opt1 = AddQuestion.this.op1.getText().toString();
            String opt2 = AddQuestion.this.op2.getText().toString();
            String opt3 = AddQuestion.this.op3.getText().toString();
            String opt4 = AddQuestion.this.op4.getText().toString();
            String answer = AddQuestion.this.ans.getText().toString();
            if (AddQuestion.this.ans == AddQuestion.this.op1 || AddQuestion.this.ans == AddQuestion.this.op2 || AddQuestion.this.ans == AddQuestion.this.op3 || AddQuestion.this.ans == AddQuestion.this.op4) {
                AddQuestion.this.dbm.insertQuestion(qidd, question, opt1, opt2, opt3, opt4, answer);
                Toast.makeText(AddQuestion.this.getApplicationContext(), "Question added successfully !!", 0).show();
            } else {
                Toast.makeText(AddQuestion.this.getApplicationContext(), "Question not added successfully !!", 0).show();
            }
            if (question.equals("") || opt1.equals("") || opt2.equals("") || opt3.equals("") || opt4.equals("") || answer.equals("")) {
                Toast.makeText(AddQuestion.this.getApplicationContext(), "Empty fields !!", 0).show();
            }
            AddQuestion.this.startActivity(new Intent(AddQuestion.this.getBaseContext(), AddQuestion.class));
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C0057R.layout.addquestion);
        this.dbm = new DBManager(getApplicationContext());
        this.qid = (EditText) findViewById(C0057R.id.qid);
        this.ques = (EditText) findViewById(C0057R.id.ques);
        this.op1 = (EditText) findViewById(C0057R.id.op1);
        this.op2 = (EditText) findViewById(C0057R.id.op2);
        this.op3 = (EditText) findViewById(C0057R.id.op3);
        this.op4 = (EditText) findViewById(C0057R.id.op4);
        this.ans = (EditText) findViewById(C0057R.id.ans);
        this.add = (Button) findViewById(C0057R.id.addques);
        this.add.setOnClickListener(new C00401());
    }

    protected void onPause() {
        super.onPause();
        this.dbm.close();
        finish();
    }
}
