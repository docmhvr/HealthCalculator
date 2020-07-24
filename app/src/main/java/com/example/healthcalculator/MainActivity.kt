package com.example.healthcalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            val usrname = editTextTextPersonName.text.toString()
            val weight = editTextNumber.text.toString().toInt()
            val height = editTextNumber2.text.toString().toInt()
//            val msg = usrname+weight.toString()+height.toString()
//            Toast.makeText(this,msg, Toast.LENGTH_LONG).show()
            val intent = Intent(this, NextActivity::class.java)
            intent.putExtra("usr_name",usrname)
            intent.putExtra("_weight",weight)
            intent.putExtra("_height",height)
            startActivity(intent)

        }
    }

    override fun onResume() {
        super.onResume()
        editTextTextPersonName.text.clear()
        editTextNumber.text.clear()
        editTextNumber2.text.clear()
    }

}