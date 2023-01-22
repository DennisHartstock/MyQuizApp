package com.commcode.myquizapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var etUsername: EditText
    private lateinit var btStart: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()

        btStart.setOnClickListener {
            if (etUsername.text.isNotEmpty()) {
                val intent = Intent(this, QuizQuestionsActivity::class.java)
                intent.putExtra(Constants.USERNAME, etUsername.text.toString())
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Please enter your name", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun initViews() {
        etUsername = findViewById(R.id.etUsername)
        btStart = findViewById(R.id.btStart)
    }
}