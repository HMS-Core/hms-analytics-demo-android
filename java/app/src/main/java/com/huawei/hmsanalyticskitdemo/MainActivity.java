/*
 * Copyright 2020. Huawei Technologies Co., Ltd. All rights reserved.

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/

package com.huawei.hmsanalyticskitdemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import androidx.appcompat.app.AppCompatActivity;

// TODO: Import classes from Analytics Kit.
import com.huawei.hms.analytics.HiAnalytics;
import com.huawei.hms.analytics.HiAnalyticsInstance;
import com.huawei.hms.analytics.HiAnalyticsTools;

import static com.huawei.hms.analytics.type.HAEventType.*;
import static com.huawei.hms.analytics.type.HAParamType.*;

public class MainActivity extends AppCompatActivity {

    private Button btnSetting;

    private int[] questions = {R.string.q1, R.string.q2, R.string.q3, R.string.q4, R.string.q5};
    private boolean[] answers = {true, true, false, false, true};

    private int curQuestionIdx = 0;

    private TextView txtQuestion;

    private Button btnNext;

    private Button btnTrue;

    private Button btnFalse;

    private Button postScore;

    private int score = 0;


    // TODO: Define a variable for the Analytics Kit instance.
    HiAnalyticsInstance instance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO: Initialize Analytics Kit.
        // Enable Analytics Kit logging.
        HiAnalyticsTools.enableLog();

        // Generate an Analytics Kit instance.
        instance = HiAnalytics.getInstance(this);

        // You can also use Context initialization
        txtQuestion = (TextView) findViewById(R.id.question_text_view);
        txtQuestion.setText(questions[curQuestionIdx]);

        btnSetting = (Button) findViewById(R.id.setting_button);
        btnSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, SettingActivity.class);
                startActivityForResult(i, 0);
            }
        });

        btnNext = (Button) findViewById(R.id.next_button);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                curQuestionIdx = (curQuestionIdx + 1) % questions.length;
                nextQuestion();
            }
        });

        btnTrue = (Button) findViewById(R.id.true_button);
        btnTrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(true);
                reportAnswerEvt("true");
            }
        });


        btnFalse = (Button) findViewById(R.id.false_button);
        btnFalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(false);
                reportAnswerEvt("false");
            }
        });

        postScore = (Button) findViewById(R.id.post_score_button);
        postScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                postScore();
            }
        });
    }

    private void nextQuestion() {
        txtQuestion.setText(questions[curQuestionIdx]);
    }

    private boolean checkAnswer(boolean answer) {
        String q = txtQuestion.getText().toString().trim();

        if (answer == answers[curQuestionIdx]) {
            score = score + 20;
            Toast.makeText(this, R.string.correct_answer, Toast.LENGTH_SHORT).show();
            // Report a custom Event

        } else {
            Toast.makeText(this, R.string.wrong_answer, Toast.LENGTH_SHORT).show();
            // Report a custom Event

        }
        return answers[curQuestionIdx];
    }

    private void reportAnswerEvt(String answer) {
        // TODO: Report a custom event.
        // Event Name: Answer
        // Event Parameters:
        //  -- question: String
        //  -- answer: String
        //  -- answerTime: String

        // Initialize parameters.
        Bundle bundle = new Bundle();
        bundle.putString("question", txtQuestion.getText().toString().trim());
        bundle.putString("answer", answer);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
        bundle.putString("answerTime", sdf.format(new Date()));

        // Report a custom event.
        instance.onEvent("Answer", bundle);
    }

    private void postScore() {
        // TODO: Report the score by using the SUBMITSCORE event.
        // Initialize parameters.
        Bundle bundle = new Bundle();
        bundle.putLong(SCORE, score);

        // Report a predefined event.
        instance.onEvent(SUBMITSCORE, bundle);
    }
}
