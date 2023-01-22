package com.commcode.myquizapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {

    private var username = ""

    private lateinit var tvUsername: TextView
    private lateinit var tvScore: TextView
    private lateinit var btNewGame: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        initViews()

        username = intent.getStringExtra(Constants.USERNAME).toString()
        tvUsername.text = username
        val countCorrectAnswers = intent.getIntExtra(Constants.COUNT_CORRECT_ANSWERS, 0)
        val totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS, 0)
        "Your score is $countCorrectAnswers out of $totalQuestions".also { tvScore.text = it }

        btNewGame.setOnClickListener {
            val intent = Intent(this, QuizQuestionsActivity::class.java)
            intent.putExtra(Constants.USERNAME, username)
            startActivity(intent)
        }
    }

    private fun initViews() {
        tvUsername = findViewById(R.id.tvUsername)
        tvScore = findViewById(R.id.tvScore)
        btNewGame = findViewById(R.id.btNewGame)
    }
}