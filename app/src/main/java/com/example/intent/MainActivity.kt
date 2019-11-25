package com.example.intent

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonSend.setOnClickListener {
            sendMessage()
        }
    }

    private fun sendMessage() {
        if(editTextMessageHint.text.isEmpty()){
            editTextMessageHint.setError("Value required")
            return
        }
        //explicit intent ; compenet name must be provided
        val intent = Intent(this,
            SecondActivity::class.java)


        //insert extra to the intent
        val message =editTextMessageHint.text.toString()
        val lucky =editTextLuckyHint.text.toString()
        intent.putExtra(EXTRA_MSG, message)
        intent.putExtra(EXTRA_LUCKY, lucky)

        //no return value from the SecondActivity
        //startActivity(intent)

        //return value from the SecondActivity
        startActivityForResult(intent, REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == Activity.RESULT_OK){
            val reply = data?.getStringExtra(EXTRA_REPLY)
            //display reply here
            textViewReply.text = String.format("%s %s",
                "Reply :", reply)

        }
    }

    companion object{
        const val EXTRA_MSG = "com.example.intent.EXTRA_MSG"
        const val EXTRA_LUCKY = "com.example.intent.EXTRA_LUCKY"
        const val EXTRA_REPLY = "com.example.intent.EXTRA_REPLY"
        const val REQUEST_CODE = 1
    }
}
