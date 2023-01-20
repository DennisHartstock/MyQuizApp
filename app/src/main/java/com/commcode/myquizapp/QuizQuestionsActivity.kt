package com.commcode.myquizapp

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class QuizQuestionsActivity : AppCompatActivity() {

    private lateinit var pbCountQuestions: ProgressBar
    private lateinit var tvCountQuestions: TextView
    private lateinit var tvQuestion: TextView
    private lateinit var tvOptions1: TextView
    private lateinit var tvOptions2: TextView
    private lateinit var tvOptions3: TextView
    private lateinit var tvOptions4: TextView
    private lateinit var btSubmit: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)
        initViews()

        val questionsList = Constants.getQuestions()
        Log.i("QuizQuestionsActivity", "questionsList size is ${questionsList.size}")
    }

    private fun initViews() {
        pbCountQuestions = findViewById(R.id.pbCountQuestions)
        tvCountQuestions = findViewById(R.id.tvCountQuestions)
        tvQuestion = findViewById(R.id.tvQuestion)
        tvOptions1 = findViewById(R.id.tvOption1)
        tvOptions2 = findViewById(R.id.tvOption2)
        tvOptions3 = findViewById(R.id.tvOption3)
        tvOptions4 = findViewById(R.id.tvOption4)
        btSubmit = findViewById(R.id.btSubmit)
    }
}