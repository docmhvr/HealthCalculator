package com.example.healthcalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_next.*

class NextActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_next)

        val bundle: Bundle? = intent.extras
//        val _wght: Bundle? = intent.extras
//        val _hght: Bundle? = intent.extras
//        _name.getString("usr_name")
//        _wght.getInt("_weight")
//        _hght.getInt("_height")
        val nname = bundle!!.getString("usr_name")
        val nwght = bundle.getInt("_weight")
        val nhght = bundle.getInt("_height")

        val bmi: Double = nwght/(nhght*nhght*0.0254*0.0254)
//        print(bmi)
//        val text = "$nname $nwght $nhght $bmi"
//        Toast.makeText(this, text , Toast.LENGTH_LONG).show()
        var out = "$nname you BMI is $bmi\n"
        var out2 = "According to your BMI\n"
        if (bmi<18.5){
            out+= "You are Underweight"
            out2+= "You have to gain weight!"
        }
        if (18<bmi && bmi<23){
            out+= "You are Normal"
            out2+= "You are fit and healthy!"
        }
        if (bmi>23){
            out+= "You are Overweight"
            out2+= "You have to reduce weight!"
        }
        textView3.text = out
        textView4.text = out2

        button2.setOnClickListener {
            finish()
        }

        button3.setOnClickListener {
            val msgshr = out
            val i = Intent()
            i.action = Intent.ACTION_SEND
            i.putExtra(Intent.EXTRA_TEXT, msgshr)
            i.type = "text/plain"
            startActivity(Intent.createChooser(i, "Share to:"))
        }
    }

}