package com.example.buttoncounterapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView

private const val TAG = "MainActivity"
private const val TEXT_CONTENTS = "TextContent"

class MainActivity : AppCompatActivity() {

    private var button: Button? = null
    private var textView: TextView? = null
    private var numTimesClicked = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button = findViewById<Button>(R.id.button)
        textView = findViewById<TextView>(R.id.textView)
        textView?.text = ""
        textView?.movementMethod = ScrollingMovementMethod()

        button?.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                numTimesClicked += 1
                textView?.append("You Clicked $numTimesClicked time")
                if (numTimesClicked == 1)
                    textView?.append("\n")
                if (numTimesClicked != 1)
                    textView?.append("s\n")
            }
        })
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        Log.d(TAG, "onRestoreInstanceState :called")
        super.onRestoreInstanceState(savedInstanceState)

        textView?.text = savedInstanceState.getString(TEXT_CONTENTS, "")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        Log.d(TAG, "onSaveInstanceState :called")
        super.onSaveInstanceState(outState)
        outState.putString(TEXT_CONTENTS, textView?.text.toString())
    }
}