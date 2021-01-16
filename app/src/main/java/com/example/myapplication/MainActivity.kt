package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    lateinit var userDBHelper: DBHelper
    lateinit var inputemail: EditText
    lateinit var inputpass: EditText
    lateinit var inputusername: EditText
    lateinit var inputfullname: EditText
    lateinit var inputaddress: EditText
    lateinit var inputphone: EditText
    lateinit var inputgender: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        inputemail = findViewById(R.id.email)
        inputpass = findViewById(R.id.pass)
        inputusername = findViewById(R.id.uname)
        inputfullname = findViewById(R.id.fullname)
        inputaddress = findViewById(R.id.address)
        inputphone = findViewById(R.id.phone)
        inputgender = findViewById(R.id.gender)
        userDBHelper = DBHelper(this)
    }

    fun addData(v: View){
        var emailin = inputemail.text.toString()
        var passin = inputpass.text.toString()
        var usernamein = inputusername.text.toString()
        var fullnamein = inputfullname.text.toString()
        var addressin = inputaddress.text.toString()
        var phonein = inputphone.text.toString()
        var genderin = inputgender.text.toString()
        userDBHelper.insertData(emailin, passin, usernamein, fullnamein, addressin, phonein, genderin)
        inputemail.setText("")
        inputpass.setText("")
        inputusername.setText("")
        inputfullname.setText("")
        inputaddress.setText("")
        inputphone.setText("")
        inputgender.setText("")

    }

    fun showAll(v: View){
        var pindah = Intent(this, RvDbActivity::class.java)
        startActivity(pindah)
    }
}