package com.example.skoop.quizzo;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void displayResult() {
        TextView quantityTextView = (TextView) findViewById(R.id.order_summary_text_view);
        quantityTextView.setText("Answer 1: " + ans_of_Q_1() + "\nAnswer 2: " + ans_of_Q_2() + "\nAnswer 3: " + ans_of_Q_3() + "\nAnswer 4: " + ans_of_Q_4() + "\nAnswer 5: " + ans_of_Q_5() + "\nFinal Score: " + score);
        final Toast toast = Toast.makeText(getBaseContext(), "Your Score:" + score + " points", Toast.LENGTH_SHORT);
        toast.show();
        new CountDownTimer(1200, 1000) {
            public void onTick(long millisUntilFinished) {
                toast.show();
            }

            public void onFinish() {
                toast.cancel();
            }
        }.start();
        score = 0;
    }

    public String ans_of_Q_1() {
        CheckBox isInteger = (CheckBox) findViewById(R.id.checkBoxQ2A);
        boolean isinteger = isInteger.isChecked();
        CheckBox isBoolean = (CheckBox) findViewById(R.id.checkBoxQ2B);
        boolean isboolean = isBoolean.isChecked();
        CheckBox isString = (CheckBox) findViewById(R.id.checkBoxQ2C);
        boolean isstring = isString.isChecked();
        CheckBox isFloat = (CheckBox) findViewById(R.id.checkBoxQ2D);
        boolean isfloat = isFloat.isChecked();
        if (isinteger && isfloat && isstring && isboolean) {
            score++;
            return "Correct";
        } else return "Wrong";
    }

    public String ans_of_Q_2() {
        RadioGroup radioGroup;
        RadioButton radioButton;
        radioGroup = (RadioGroup) findViewById(R.id.radioGroupQ2);

        int selectedId = radioGroup.getCheckedRadioButtonId();
        radioButton = (RadioButton) findViewById(selectedId);
        String ans = radioButton.getText().toString();

        if (ans.equals("True")) {
            score++;
            return "Correct";
        } else return "Wrong";
    }

    public String ans_of_Q_3() {
        EditText edittext = (EditText) findViewById(R.id.ans3);
        String editText = edittext.getText().toString();
        if (editText.equals("1.8")) {
            score++;
            return "Correct";
        } else return "Wrong";
    }

    public String ans_of_Q_4() {
        RadioGroup radioGroup;
        RadioButton radioButton;
        radioGroup = (RadioGroup) findViewById(R.id.radioGroupQ4);
        int selectedId = radioGroup.getCheckedRadioButtonId();
        radioButton = (RadioButton) findViewById(selectedId);
        String ans = radioButton.getText().toString();
        if (ans.equals("True")) {
            score++;
            return "Correct";
        } else return "Wrong";
    }

    public String ans_of_Q_5() {
        CheckBox isAns1 = (CheckBox) findViewById(R.id.checkBoxQ5A);
        boolean isans1 = isAns1.isChecked();
        CheckBox isAns2 = (CheckBox) findViewById(R.id.checkBoxQ5B);
        boolean isans2 = isAns2.isChecked();
        CheckBox isAns3 = (CheckBox) findViewById(R.id.checkBoxQ5C);
        boolean isans3 = isAns3.isChecked();
        CheckBox isAns4 = (CheckBox) findViewById(R.id.checkBoxQ5D);
        boolean isans4 = isAns4.isChecked();
        if (!isans1 && !isans2 && !isans3 && isans4) {
            score++;
            return "Correct";
        } else return "Wrong";
    }

    public void submitAnswer(View view) {
        displayResult();
    }
}
