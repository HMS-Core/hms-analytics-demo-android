package com.huawei.hmsanalyticskitdemokotlin

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.huawei.hms.analytics.HiAnalytics
import com.huawei.hms.analytics.HiAnalyticsInstance

class SettingActivity : AppCompatActivity() {

    private lateinit var btnSave: Button
    private lateinit var editFavorSport: EditText
    private lateinit var strFavorSport: String

    //Define a var for Analytics Instance
    internal lateinit var instance: HiAnalyticsInstance

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)

        // Genarate Analytics Kit Instance
        instance = HiAnalytics.getInstance(this)

        btnSave = findViewById(R.id.save_setting_button)
        editFavorSport = findViewById(R.id.edit_favoraite_sport)

        btnSave.setOnClickListener {

            strFavorSport = editFavorSport.text.toString().trim()

            // save favorite sport by user setUserProperty
            instance.setUserProfile("favor_sport", strFavorSport)
        }
    }
}