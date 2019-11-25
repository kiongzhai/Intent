package com.example.intent

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        //get the extra value
        val message = intent.getStringExtra(MainActivity.EXTRA_MSG)
        val lucky = intent.getStringExtra(MainActivity.EXTRA_LUCKY)

        //display message
        textViewMessage.text = String.format("%s %s %s", getString(R.string.message), message, lucky)


        buttonDone.setOnClickListener {

            intent = getIntent() //who called me

            if(!editTextReplyHint.text.isEmpty()) {
                val reply = editTextReplyHint.text.toString()
                intent.putExtra(MainActivity.EXTRA_REPLY, reply)
                setResult(Activity.RESULT_OK, intent)
            }else{
                setResult(Activity.RESULT_CANCELED)
            }

            //terminate second activity
            finish()
        }
    }
}
