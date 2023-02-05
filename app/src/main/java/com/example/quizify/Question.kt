package com.example.quizify

data class Question(
    val id: Int,
    val text: String,
    val image: Int,
    val option1: String,
    val option2: String,
    val option3: String,
    val option4: String,
    val option5: String,
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
            "Routers",
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
            "Android Powerful Interface",
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
            "Black Berry",
            "Linux"
        )
    )

    questions.add(
        Question(
            3,
            "Why you are giving this foss event?",
            R.drawable.foss,
            "To Win",
            "For Knowledge",
            "For Learing git",
            "To show your capabilities",
            "Just for Fun",
            "For Knowledge"
        )
    )

    questions.add(
        Question(
            4,
            "Which operating system is owned by microsoft?",
            R.drawable.microsoft,
            "MAC",
            "Windows",
            "Linux",
            "Redhat",
            "Android",
            "Windows"
        )
    )
    return questions
}
