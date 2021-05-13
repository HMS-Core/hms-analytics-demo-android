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

package com.huawei.hmsanalyticskitdemokotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

// TODO: Import classes from Analytics Kit.
import com.huawei.hms.analytics.HiAnalytics
import com.huawei.hms.analytics.HiAnalyticsInstance
import com.huawei.hms.analytics.HiAnalyticsTools
import com.huawei.hms.analytics.type.HAEventType.SUBMITSCORE
import com.huawei.hms.analytics.type.HAParamType.SCORE

import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var btnSetting: Button

    private val questions = arrayOf(R.string.q1, R.string.q2, R.string.q3, R.string.q4, R.string.q5)
    private val answers = arrayOf(true, true, false, false, true)

    private var curQuestionIdx = 0

    private lateinit var txtQuestion: TextView

    private lateinit var btnNext: Button

    private lateinit var btnTrue: Button

    private lateinit var btnFalse: Button

    private lateinit var postScore: Button

    private var score = 0

    // TODO: Define a var for Analytics Instance.
    private lateinit var instance: HiAnalyticsInstance

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // TODO: Initiate Analytics Kit.
        // Enable Analytics Kit logging.
        HiAnalyticsTools.enableLog()

        // Generate an Analytics Kit instance.
        instance = HiAnalytics.getInstance(this)

        // You can also use Context initialization.
        txtQuestion = findViewById(R.id.question_text_view)
        txtQuestion.setText(questions[curQuestionIdx])

        btnSetting = findViewById(R.id.setting_button)
        btnSetting.setOnClickListener { view ->
            var i = Intent(this, SettingActivity::class.java)
            startActivityForResult(i, 0)
        }

        btnNext = findViewById(R.id.next_button)
        btnNext.setOnClickListener {
            curQuestionIdx = (curQuestionIdx + 1) % questions.size
            nextQuestion()
        }

        btnTrue = findViewById(R.id.true_button)
        btnTrue.setOnClickListener {
            checkAnswer(true)
            reportAnswerEvt("true")
        }


        btnFalse = findViewById(R.id.false_button)
        btnFalse.setOnClickListener {
            checkAnswer(false)
            reportAnswerEvt("false")
        }

        postScore = findViewById(R.id.post_score_button)
        postScore.setOnClickListener {
            postScore()
        }
    }

    private fun nextQuestion() {
        txtQuestion.setText(questions[curQuestionIdx])
    }

    private fun checkAnswer(answer: Boolean): Boolean {
        val q = txtQuestion.text.toString().trim()
        if (answer == answers[curQuestionIdx]) {
            score = score + 20
            Toast.makeText(this, R.string.correct_answer, Toast.LENGTH_SHORT).show()
            // Report a custom Event.

        } else {
            Toast.makeText(this, R.string.wrong_answer, Toast.LENGTH_SHORT).show()
            // Report a custom Event.

        }
        return answers[curQuestionIdx]
    }

    private fun reportAnswerEvt(answer: String) {
        // TODO: Report a customzied Event.
        // Event Name: Answer
        // Event Parameters:
        //  -- question: String
        //  -- answer: String
        //  -- answerTime: String

        // Initialize parameters.
        val bundle = Bundle()
        bundle.putString("question", txtQuestion.text.toString().trim())
        bundle.putString("answer", answer)
        val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH)
        bundle.putString("answerTime", sdf.format(Date()))

        // Report a customzied Event
        instance.onEvent("Answer", bundle)
    }

    private fun postScore() {
        // TODO: Report the score by using the SUBMITSCORE event.
        // Initialize parameters.
        val bundle = Bundle()
        bundle.putLong(SCORE, score.toLong())

        // Report a predefined event.
        instance.onEvent(SUBMITSCORE, bundle)
    }
}
