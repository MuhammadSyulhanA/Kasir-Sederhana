package com.example.learnthreekotlin

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {

    var uname: EditText? = null
    var pass:EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnMoveActivity: Button = findViewById(R.id.btn_move_activity)
        btnMoveActivity.setOnClickListener(this)

        val btnMoveWithDataActivity: Button = findViewById(R.id.btn_move_activity_data)
        btnMoveWithDataActivity.setOnClickListener(this)

        val btnDialPhone: Button = findViewById(R.id.btn_dial_number)
        btnDialPhone.setOnClickListener(this)

        uname = findViewById(R.id.username)
        pass = findViewById(R.id.password)
    }

    override fun onClick(v: View) {
        if (v.id  == R.id.btn_move_activity) {
            val inputUname = uname!!.getText().toString()
            val inputPass = Integer.valueOf(pass!!.getText().toString())
//            val inputPass = pass!!.text.toString().trim { it <= ' ' }

            var isEmptyFields = false
            if (TextUtils.isEmpty(inputUname)) {
                isEmptyFields = true
                uname!!.error = "Field ini tidak boleh kosong"
            }
            if (TextUtils.isEmpty(inputPass.toString())) {
                isEmptyFields = true
                pass!!.error = "Field ini tidak boleh kosong"
            }
            if (!isEmptyFields) {
                val moveWithDataIntent = Intent(this@MainActivity, MoveActivityOne::class.java)
                moveWithDataIntent.putExtra(MoveActivityOne.EXTRA_UNAME, inputUname)
                moveWithDataIntent.putExtra(MoveActivityOne.EXTRA_ANGKA, inputPass)
                startActivity(moveWithDataIntent)
            }
//            val moveIntent = Intent(this@MainActivity, MoveActivityOne::class.java)
//            startActivity(moveIntent)
        }
        else if (v.id  == R.id.btn_move_activity_data){
            val moveWithDataIntent = Intent(this@MainActivity, MoveActivityTwo::class.java)
            moveWithDataIntent.putExtra(MoveActivityTwo.EXTRA_NAME, "Sulhen")
            moveWithDataIntent.putExtra(MoveActivityTwo.EXTRA_AGE, 17)
            startActivity(moveWithDataIntent)
        }
        else if (v.id  == R.id.btn_dial_number) {
            val phoneNumber = "081210841382"
            val dialPhoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
            startActivity(dialPhoneIntent)
        }
    }
}