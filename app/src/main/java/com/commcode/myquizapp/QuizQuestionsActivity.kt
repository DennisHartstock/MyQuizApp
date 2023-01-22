package com.commcode.myquizapp

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class QuizQuestionsActivity : AppCompatActivity() {

    private var mCurrentPosition = 0
    private var mQuestionsList: ArrayList<Question>? = null
    private var mSelectedOptionPosition = 0
    private var countCorrectAnswers = 0

    private lateinit var newQuestion: Question
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
            if (mSelectedOptionPosition != 0) {
                if (newQuestion.correctAnswer != mSelectedOptionPosition) {
                    answerView(mSelectedOptionPosition, R.drawable.wrong_answer_bg)
                } else {
                    countCorrectAnswers++
                }
                answerView(newQuestion.correctAnswer, R.drawable.correct_answer_bg)
                btSubmit.text = getString(R.string.bt_next_question)
                mSelectedOptionPosition = 0

            } else if (mCurrentPosition < mQuestionsList!!.size - 1) {
                setNewQuestion()
            } else {
                pbCountQuestions.progress = 0
                "$countCorrectAnswers/${pbCountQuestions.max}".also { tvCountQuestions.text = it }
                Toast.makeText(
                    this,
                    "You have $countCorrectAnswers of ${pbCountQuestions.max} correct answers",
                    Toast.LENGTH_LONG
                ).show()
                btSubmit.text = getString(R.string.bt_new_game)
                mCurrentPosition = 0
                countCorrectAnswers = 0
            }
        }

        tvOption1.setOnClickListener {
            setDefaultOptionViews()
            mSelectedOptionPosition = 1
            tvOption1.background =
                ContextCompat.getDrawable(this, R.drawable.selected_option_bg)
        }

        tvOption2.setOnClickListener {
            setDefaultOptionViews()
            mSelectedOptionPosition = 2
            tvOption2.background =
                ContextCompat.getDrawable(this, R.drawable.selected_option_bg)
        }

        tvOption3.setOnClickListener {
            setDefaultOptionViews()
            mSelectedOptionPosition = 3
            tvOption3.background =
                ContextCompat.getDrawable(this, R.drawable.selected_option_bg)
        }

        tvOption4.setOnClickListener {
            setDefaultOptionViews()
            mSelectedOptionPosition = 4
            tvOption4.background =
                ContextCompat.getDrawable(this, R.drawable.selected_option_bg)
        }
    }

    private fun answerView(answer: Int, drawable: Int) {
        when (answer) {
            1 -> tvOption1.background = ContextCompat.getDrawable(this, drawable)
            2 -> tvOption2.background = ContextCompat.getDrawable(this, drawable)
            3 -> tvOption3.background = ContextCompat.getDrawable(this, drawable)
            4 -> tvOption4.background = ContextCompat.getDrawable(this, drawable)
        }
    }

    private fun setNewQuestion() {
        newQuestion = mQuestionsList!![mCurrentPosition]
        pbCountQuestions.progress = mCurrentPosition
        val countQuestions = "$countCorrectAnswers/${pbCountQuestions.max}"
        tvCountQuestions.text = countQuestions
        tvQuestion.text = newQuestion.question
        ivFlag.setImageResource(newQuestion.image)
        tvOption1.text = newQuestion.option1
        tvOption2.text = newQuestion.option2
        tvOption3.text = newQuestion.option3
        tvOption4.text = newQuestion.option4
        setDefaultOptionViews()
        btSubmit.text = getString(R.string.bt_submit)
        mCurrentPosition++
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

    private fun setDefaultOptionViews() {
        tvOption1.setBackgroundResource(android.R.color.darker_gray)
        tvOption2.setBackgroundResource(android.R.color.darker_gray)
        tvOption3.setBackgroundResource(android.R.color.darker_gray)
        tvOption4.setBackgroundResource(android.R.color.darker_gray)
    }
}