package com.surajrathod.baseproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.surajrathod.baseproject.ui.activities.BaseActivity

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        putLayout(R.layout.activity_main)
        setToolBarTitle("Main Activity")
    }
}