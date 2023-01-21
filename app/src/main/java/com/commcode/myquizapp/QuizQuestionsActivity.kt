package com.commcode.myquizapp

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition = 0
    private var mQuestionsList: ArrayList<Question>? = null
    private var mSelectedOptionPosition = 0

    private lateinit var pbCountQuestions: ProgressBar
    private lateinit var tvCountQuestions: TextView
    private lateinit var tvQuestion: TextView
    private lateinit var ivFlag: ImageView
    private lateinit var tvOption1: TextView
    private lateinit var tvOption2: TextView
    private lateinit var tvOption3: TextView
    private lateinit var tvOption4: TextView
    private lateinit var btSubmit: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)
        initViews()

        mQuestionsList = Constants.getQuestions()
        setNewQuestion()

        btSubmit.setOnClickListener {
            Toast.makeText(this, "Button submit clicked", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setNewQuestion() {
        val newQuestion: Question = mQuestionsList!![mCurrentPosition]
        pbCountQuestions.progress = mCurrentPosition
        val countQuestions = "$mCurrentPosition/${pbCountQuestions.max}"
        tvCountQuestions.text = countQuestions
        tvQuestion.text = newQuestion.question
        ivFlag.setImageResource(newQuestion.image)
        tvOption1.text = newQuestion.option1
        tvOption2.text = newQuestion.option2
        tvOption3.text = newQuestion.option3
        tvOption4.text = newQuestion.option4

        if (mCurrentPosition == pbCountQuestions.max) btSubmit.text = getString(R.string.bt_finish)
    }

    private fun initViews() {
        pbCountQuestions = findViewById(R.id.pbCountQuestions)
        tvCountQuestions = findViewById(R.id.tvCountQuestions)
        tvQuestion = findViewById(R.id.tvQuestion)
        ivFlag = findViewById(R.id.ivFlag)
        tvOption1 = findViewById(R.id.tvOption1)
        tvOption2 = findViewById(R.id.tvOption2)
        tvOption3 = findViewById(R.id.tvOption3)
        tvOption4 = findViewById(R.id.tvOption4)
        btSubmit = findViewById(R.id.btSubmit)
    }

    override fun onClick(view: View?) {
        when (view) {
            tvOption1 -> {
                mSelectedOptionPosition = 1
                view.background =
                    ContextCompat.getDrawable(this, R.drawable.selected_option_bg)
                tvOption2.setBackgroundResource(android.R.color.darker_gray)
                tvOption3.setBackgroundResource(android.R.color.darker_gray)
                tvOption4.setBackgroundResource(android.R.color.darker_gray)
            }
            tvOption2 -> {
                mSelectedOptionPosition = 2
                view.background =
                    ContextCompat.getDrawable(this, R.drawable.selected_option_bg)
                tvOption1.setBackgroundResource(android.R.color.darker_gray)
                tvOption3.setBackgroundResource(android.R.color.darker_gray)
                tvOption4.setBackgroundResource(android.R.color.darker_gray)
            }
            tvOption3 -> {
                mSelectedOptionPosition = 3
                view.background =
                    ContextCompat.getDrawable(this, R.drawable.selected_option_bg)
                tvOption2.setBackgroundResource(android.R.color.darker_gray)
                tvOption1.setBackgroundResource(android.R.color.darker_gray)
                tvOption4.setBackgroundResource(android.R.color.darker_gray)
            }
            tvOption4 -> {
                mSelectedOptionPosition = 4
                view.background =
                    ContextCompat.getDrawable(this, R.drawable.selected_option_bg)
                tvOption2.setBackgroundResource(android.R.color.darker_gray)
                tvOption3.setBackgroundResource(android.R.color.darker_gray)
                tvOption1.setBackgroundResource(android.R.color.darker_gray)
            }
            else -> {
                tvOption1.setBackgroundResource(android.R.color.darker_gray)
                tvOption2.setBackgroundResource(android.R.color.darker_gray)
                tvOption3.setBackgroundResource(android.R.color.darker_gray)
                tvOption4.setBackgroundResource(android.R.color.darker_gray)
            }
        }
    }
}