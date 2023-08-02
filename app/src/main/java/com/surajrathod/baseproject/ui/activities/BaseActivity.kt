package com.surajrathod.baseproject.ui.activities

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import com.surajrathod.baseproject.R

open class BaseActivity : AppCompatActivity() {

    lateinit var toolbar: Toolbar
    lateinit var template : FrameLayout
    lateinit var loading : ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)
    }

    fun showToast(msg : String,long : Boolean = false){
        if(long){
            Toast.makeText(this,msg,Toast.LENGTH_LONG).show()
        }else{
            Toast.makeText(this,msg,Toast.LENGTH_SHORT).show()
        }
    }

    fun getViewFromLayout(id : Int) : View {
        return layoutInflater.inflate(id,null,false)
    }

    fun showProgress(){
        loading = ProgressDialog(this)
        loading.setTitle("Loading")
        loading.show()
    }

    fun hideProgress(){
        if(this::loading.isInitialized && loading.isShowing){
            loading.dismiss()
        }
    }

    fun putLayout(id : Int){
        try {
            template = findViewById(R.id.contentFrame)
            template.addView(getViewFromLayout(id),0)
        }catch (e : Exception){
            Toast.makeText(this,e.message,Toast.LENGTH_LONG).show()
        }

    }

    fun setToolBarTitle(title : String){
        toolbar = findViewById(R.id.toolbar)
        toolbar.title = title
        setSupportActionBar(toolbar)
    }

    fun enableBack(){
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
    fun disableBack(){
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
    }
}