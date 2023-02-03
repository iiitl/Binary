package com.example.quizify

data class Question(
    val id: Int,
    val text: String,
    val image: Int,
    val option1: String,
    val option2: String,
    val option3: String,
    val option4: String,
    val correctAnswer: String
)


fun getQuestions(): ArrayList<Question> {
    val questions = ArrayList<Question>()

    questions.add(
        Question(
            0,
            "For which of the following Android is mainly developed?",
            R.drawable.android,
            "Servers",
            "Desktops",
            "Laptops",
            "Mobile devices",
            "Mobile devices"
        )
    )

    questions.add(
        Question(
            1,
            "What does API stand for?",
            R.drawable.api,
            "Application Programming Interface",
            "Android Programming Interface",
            "Android Page Interface",
            "Application Page Interface",
            "Application Programming Interface"
        )
    )

    questions.add(
        Question(
            2,
            "Which of the following kernel is used in Android?",
            R.drawable.operatingsystem,
            "MAC",
            "Windows",
            "Linux",
            "Redhat",
            "Linux"
        )
    )
    return questions
}
