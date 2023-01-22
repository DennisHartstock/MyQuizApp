package com.commcode.myquizapp

object Constants {

    const val USERNAME = "username"
    const val TOTAL_QUESTIONS = "total_questions"
    const val COUNT_CORRECT_ANSWERS = "count_correct_answers"

    fun getQuestions(): ArrayList<Question> {
        val questionsList = ArrayList<Question>()

        val question1 = Question(
            1,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_argentina,
            "Argentina",
            "Australia",
            "Belgium",
            "Brazil",
            1
        )
        questionsList.add(question1)

        val question2 = Question(
            2,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_australia,
            "Denmark",
            "Australia",
            "Belgium",
            "Brazil",
            2
        )
        questionsList.add(question2)

        val question3 = Question(
            3,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_belgium,
            "Fiji",
            "Australia",
            "Belgium",
            "Brazil",
            3
        )
        questionsList.add(question3)

        val question4 = Question(
            4,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_brazil,
            "Germany",
            "Australia",
            "Belgium",
            "Brazil",
            4
        )
        questionsList.add(question4)

        val question5 = Question(
            5,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_denmark,
            "Denmark",
            "Fiji",
            "Germany",
            "India",
            1
        )
        questionsList.add(question5)

        val question6 = Question(
            6,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_fiji,
            "Kuwait",
            "Fiji",
            "Germany",
            "India",
            2
        )
        questionsList.add(question6)

        val question7 = Question(
            7,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_germany,
            "New Zealand",
            "Fiji",
            "Germany",
            "India",
            3
        )
        questionsList.add(question7)

        val question8 = Question(
            8,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_india,
            "Argentina",
            "Fiji",
            "Germany",
            "India",
            4
        )
        questionsList.add(question8)

        val question9 = Question(
            6,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_kuwait,
            "Kuwait",
            "Australia",
            "Germany",
            "India",
            1
        )
        questionsList.add(question9)

        val question10 = Question(
            10,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_new_zealand,
            "Kuwait",
            "Fiji",
            "Belgium",
            "New Zealand",
            4
        )
        questionsList.add(question10)

        return questionsList
    }
}