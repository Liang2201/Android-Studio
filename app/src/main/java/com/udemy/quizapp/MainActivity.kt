package com.udemy.quizapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.udemy.quizapp.ui.QuestionActivity
import com.udemy.quizapp.utils.Constants


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val submitButton: Button = findViewById(R.id.buttonsubmit)
        val editTextName: EditText = findViewById(R.id.editTextname)

        submitButton.setOnClickListener {
            if (!editTextName.text.isNullOrBlank()){
                Intent(this@MainActivity, QuestionActivity::class.java).also{
                    it.putExtra(Constants.USER_NAME, editTextName.text.toString())
                    startActivity(it)
                    finish()
                }
            }
            else{
                Toast.makeText(this, "Please enter your name", Toast.LENGTH_SHORT).show()
            }
        }
    }
}