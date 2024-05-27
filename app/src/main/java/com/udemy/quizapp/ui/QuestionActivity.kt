package com.udemy.quizapp.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.udemy.quizapp.R
import com.udemy.quizapp.model.Question
import com.udemy.quizapp.utils.Constants

class QuestionActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var progressBar: ProgressBar
    private lateinit var textViewProgress: TextView
    private lateinit var textViewQuestion: TextView
    private lateinit var flagImage: ImageView

    private lateinit var textViewOptionOne: TextView
    private lateinit var textViewOptionTwo: TextView
    private lateinit var textViewOptionThree: TextView
    private lateinit var textViewOptionFour: TextView

    private lateinit var checkButton: Button


    private lateinit var questionList: MutableList<Question>
    private var selectedAnswer = 0
    private var questionsCounter = 0
    private lateinit var currentQuestion: Question
    private var answer = false
    private lateinit var name: String
    private var score = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_question)


        progressBar = findViewById(R.id.progress_bar)
        textViewProgress = findViewById(R.id.text_view_progress)
        textViewQuestion = findViewById(R.id.question_text_view)
        flagImage = findViewById(R.id.flag_image_view)

        checkButton = findViewById(R.id.check_button)

        textViewOptionOne = findViewById(R.id.textView_option_one)
        textViewOptionTwo = findViewById(R.id.textView_option_two)
        textViewOptionThree = findViewById(R.id.textView_option_three)
        textViewOptionFour = findViewById(R.id.textView_option_four)

        textViewOptionOne.setOnClickListener(this)
        textViewOptionTwo.setOnClickListener(this)
        textViewOptionThree.setOnClickListener(this)
        textViewOptionFour.setOnClickListener(this)
        checkButton.setOnClickListener(this)

        questionList = Constants.getQuestions()
        Log.d("QuestionSize", "${questionList.size}")
        showNextQuestion()

        if (intent.hasExtra(Constants.USER_NAME)) {
            name = intent?.getStringExtra(Constants.USER_NAME).toString()
        }


    }

    @SuppressLint("SetTextI18n")
    private fun showNextQuestion() {
        if (questionsCounter < questionList.size) {
            currentQuestion = questionList[questionsCounter]
            checkButton.text = "CHECK"

            resetOption()
            val question = questionList[questionsCounter]
            flagImage.setImageResource(question.image)
            progressBar.progress = questionsCounter
            textViewProgress.text = "${questionsCounter + 1}/${progressBar.max + 1}"
            textViewQuestion.text = question.question
            textViewOptionOne.text = question.optionOne
            textViewOptionTwo.text = question.optionTwo
            textViewOptionThree.text = question.optionThree
            textViewOptionFour.text = question.optionFour
        } else {
            checkButton.text = "FINISH"
            Intent(this, ResultActivity::class.java).also {
                it.putExtra(Constants.USER_NAME, name)
                it.putExtra(Constants.SCORE, score)
                it.putExtra(Constants.TOTAL_QUESTIONS, questionList.size)
                startActivity(it)


            }
        }
        questionsCounter++
        answer = false
    }

    private fun resetOption() {
        val options = mutableListOf<TextView>()
        options.add(textViewOptionOne)
        options.add(textViewOptionTwo)
        options.add(textViewOptionThree)
        options.add(textViewOptionFour)

        for (option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.default_option_border_bg
            )
        }
    }

    private fun selectedOption(textView: TextView, selectedOptionNumber: Int) {
        resetOption()
        selectedAnswer = selectedOptionNumber


        textView.setTextColor(Color.parseColor("#363A43"))
        textView.setTypeface(textView.typeface, Typeface.BOLD)
        textView.background = ContextCompat.getDrawable(
            this,
            R.drawable.selected_option_border_bg
        )

    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.textView_option_one -> {
                selectedOption(textViewOptionOne, 1)
            }

            R.id.textView_option_two -> {
                selectedOption(textViewOptionTwo, 2)
            }

            R.id.textView_option_three -> {
                selectedOption(textViewOptionThree, 3)
            }

            R.id.textView_option_four -> {
                selectedOption(textViewOptionFour, 4)
            }

            R.id.check_button -> {
                if (!answer) {
                    checkAnswer()
                } else {
                    showNextQuestion()
                }

            }
        }

    }

    private fun checkAnswer() {
        answer = true
        if (selectedAnswer == currentQuestion.correctAnswer) {
            highlightAnswer(selectedAnswer)
            score++
        } else {
            when (selectedAnswer) {
                1 -> {
                    textViewOptionOne.background =
                        ContextCompat.getDrawable(this, R.drawable.wrong_option_border_bg)
                }

                2 -> {
                    textViewOptionTwo.background =
                        ContextCompat.getDrawable(this, R.drawable.wrong_option_border_bg)
                }

                3 -> {
                    textViewOptionThree.background =
                        ContextCompat.getDrawable(this, R.drawable.wrong_option_border_bg)
                }

                4 -> {
                    textViewOptionFour.background =
                        ContextCompat.getDrawable(this, R.drawable.wrong_option_border_bg)
                }
            }
        }
        checkButton.text = "NEXT"
        showSolution()
    }

    private fun showSolution() {
        selectedAnswer = currentQuestion.correctAnswer
        highlightAnswer(selectedAnswer)
    }

    private fun highlightAnswer(answer: Int) {
        when (answer) {
            1 -> {
                textViewOptionOne.background =
                    ContextCompat.getDrawable(this, R.drawable.correct_option_border_bg)
            }

            2 -> {
                textViewOptionTwo.background =
                    ContextCompat.getDrawable(this, R.drawable.correct_option_border_bg)
            }

            3 -> {
                textViewOptionThree.background =
                    ContextCompat.getDrawable(this, R.drawable.correct_option_border_bg)
            }

            4 -> {
                textViewOptionFour.background =
                    ContextCompat.getDrawable(this, R.drawable.correct_option_border_bg)
            }
        }
    }
}



