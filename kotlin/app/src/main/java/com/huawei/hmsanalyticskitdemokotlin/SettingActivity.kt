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

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

// TODO: Import classes from Analytics Kit.
import com.huawei.hms.analytics.HiAnalytics
import com.huawei.hms.analytics.HiAnalyticsInstance

class SettingActivity : AppCompatActivity() {
    private lateinit var btnSave: Button
    private lateinit var editFavorSport: EditText
    private lateinit var strFavorSport: String

    //TODO: Define a variable for the Analytics Kit instance.
    internal lateinit var instance: HiAnalyticsInstance

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)

        // TODO: Generate an Analytics Kit instance.
        instance = HiAnalytics.getInstance(this)

        btnSave = findViewById(R.id.save_setting_button)
        editFavorSport = findViewById(R.id.edit_favorite_sport)

        btnSave.setOnClickListener {

            strFavorSport = editFavorSport.text.toString().trim()

            // TODO: Set users' favorite sport using the setUserProfile API.
            instance.setUserProfile("favor_sport", strFavorSport)
        }
    }
}
