package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

class UpdateActivity : AppCompatActivity() {
    lateinit var userDBHelper: DBHelper
    lateinit var inputemail: EditText
    lateinit var inputpass: EditText
    lateinit var inputusername: EditText
    lateinit var inputfullname: EditText
    lateinit var inputaddress: EditText
    lateinit var inputphone: EditText
    lateinit var inputgender: EditText
    lateinit var emmail: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update)

        inputemail = findViewById(R.id.email)
        inputpass = findViewById(R.id.pass)
        inputusername = findViewById(R.id.uname)
        inputfullname = findViewById(R.id.fullname)
        inputaddress = findViewById(R.id.address)
        inputphone = findViewById(R.id.phone)
        inputgender = findViewById(R.id.gender)
        userDBHelper = DBHelper(this)

        val bundle = intent.extras
        if (bundle != null) {
            emmail = bundle.getString("email").toString()
            inputemail.setText(bundle.getString("email"))
            inputpass.setText(bundle.getString("pass"))
            inputusername.setText(bundle.getString("username"))
            inputfullname.setText(bundle.getString("fullname"))
            inputaddress.setText(bundle.getString("address"))
            inputphone.setText(bundle.getString("phone"))
            inputgender.setText(bundle.getString("gender"))
        }
        userDBHelper = DBHelper(this)
    }

    fun updateData(v: View){
        var emailin = emmail
        var passin = inputpass.text.toString()
        var usernamein = inputusername.text.toString()
        var fullnamein = inputfullname.text.toString()
        var addressin = inputaddress.text.toString()
        var phonein = inputphone.text.toString()
        var genderin = inputgender.text.toString()

        userDBHelper.updateData(emailin, passin, usernamein, fullnamein, addressin, phonein, genderin)
        startActivity(Intent(this, RvDbActivity::class.java))
    }

    fun cancelData(v: View){
        startActivity(Intent(this, RvDbActivity::class.java))
    }

}
