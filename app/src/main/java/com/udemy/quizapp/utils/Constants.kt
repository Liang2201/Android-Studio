package com.udemy.quizapp.utils

import com.udemy.quizapp.R
import com.udemy.quizapp.model.Question

object Constants {

    const val USER_NAME = "user_name"
    const val TOTAL_QUESTIONS = "total_questions"
    const val SCORE = "score"

    fun getQuestions(): MutableList<Question> {
        val questions = mutableListOf<Question>()
        val quest1 = Question(
            1, "What country does this flag belong to?",
            R.drawable.australia, "New Zealand", "Australia",
            "Fiji", "Papua New Guinea", 2
        )
        questions.add(quest1)

        val quest2 = Question(
            2, "What country does this flag belong to?",
            R.drawable.mali, "Mali", "Senegal",
            "Gabon", "Niger", 1
        )
        questions.add(quest2)

        val quest3 = Question(
            3, "What country does this flag belong to?",
            R.drawable.indonesia, "Monaco", "Mali",
            "Senegal", "Indonesia", 4
        )
        questions.add(quest3)
        val quest4 = Question(
            4, "What country does this flag belong to?",
            R.drawable.new_zealand, "Australia", "Belgium",
            "New Zealand", "Mali", 3
        )
        questions.add(quest4)
        val quest5 = Question(
            5, "What country does this flag belong to?",
            R.drawable.nederland, "France", "Nederland",
            "Russia", "Papua New Guinea", 2
        )
        questions.add(quest5)
        val quest6 = Question(
            6, "What country does this flag belong to?",
            R.drawable.france, "France", "Nederland",
            "Russia", "Germany", 1
        )
        questions.add(quest6)
        val quest7 = Question(
            7, "What country does this flag belong to?",
            R.drawable.belgium, "Belgium", "Nederland",
            "Russia", "Germany", 1
        )
        questions.add(quest7)
        val quest8 = Question(
            8, "What country does this flag belong to?",
            R.drawable.germany, "Belgium", "Germany",
            "Russia", "Mexico", 2
        )
        questions.add(quest8)
        val quest9 = Question(
            9, "What country does this flag belong to?",
            R.drawable.russia, "France", "Ukraine",
            "Russia", "Nederland", 3
        )
        questions.add(quest9)
        val quest10 = Question(
            10, "What country does this flag belong to?",
            R.drawable.senegal, "Mali", "Yugoslavia",
            "Dominica", "Senegal", 4
        )
        questions.add(quest10)
        val quest11 = Question(
            11, "What country does this flag belong to?",
            R.drawable.monaco, "Dominica", "Indonesia",
            "Monaco", "Senegal", 3
        )
        questions.add(quest11)
        return questions

    }
}