package com.udemy.quizapp.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.udemy.quizapp.MainActivity
import com.udemy.quizapp.R
import com.udemy.quizapp.utils.Constants

class ResultActivity : AppCompatActivity() {
    private lateinit var textViewScore: TextView
    private lateinit var textViewName: TextView
    private lateinit var finishButton: Button
    private lateinit var playAgainButton: Button

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)

        textViewScore = findViewById(R.id.textView_score)
        textViewName = findViewById(R.id.textView_username)
        finishButton = findViewById(R.id.button_finish)
        playAgainButton = findViewById(R.id.button_play_again)

        val totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS, 0)
        val score = intent.getIntExtra(Constants.SCORE, 0)
        val name = intent.getStringExtra(Constants.USER_NAME)

        textViewScore.text = "Your Score is $score out of $totalQuestions"
        textViewName.text = name

        finishButton.setOnClickListener {
            Intent(this, MainActivity::class.java).apply {
                startActivity(this)
            }
        }
        playAgainButton.setOnClickListener {
            Intent(this, QuestionActivity::class.java).apply {
                startActivity(this)
            }
        }

    }
}