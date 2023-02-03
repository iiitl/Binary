package com.example.quizify

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo

import kotlinx.android.synthetic.main.activity_questions.*

var score = 0

class QuestionsActivity : AppCompatActivity() {
    private var currentQuestionId = -1
    private var selectedAnswers = mutableMapOf<Int, String>()

    private val originalOptionTextColor = Color.parseColor("#4A4A4A")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)

        val allOptions = arrayListOf(Option1, Option2, Option3, Option4)
        val questions: ArrayList<Question> = getQuestions()

        fun changeQuestion() {
            if (currentQuestionId + 1 == questions.size) {
                return startActivity(
                    Intent(
                        this,
                        ResultsActivity::class.java,
                    )
                )
            }
            currentQuestionId += 1

            val question = questions[currentQuestionId]

            tvQuestion.text = question.text
            ivQuestion.setImageResource(question.image)
            progressBar.progress = currentQuestionId
            progress?.text =  "$currentQuestionId /${progressBar?.max}"
            Option1.text = question.option1
            Option2.text = question.option2
            Option3.text = question.option3
            Option4.text = question.option4
        }

          fun animate(){
            YoYo.with(Techniques.BounceInDown)
                .duration(1000)
                .repeat(0)
                .playOn(findViewById(R.id.ivQuestion));
            YoYo.with(Techniques.BounceInDown)
                .duration(1000)
                .repeat(0)
                .playOn(findViewById(R.id.tvQuestion));
            YoYo.with(Techniques.BounceInUp)
                .duration(1000)
                .repeat(0)
                .playOn(findViewById(R.id.Option1));
            YoYo.with(Techniques.BounceInUp)
                .duration(1000)
                .repeat(0)
                .playOn(findViewById(R.id.Option2));
            YoYo.with(Techniques.BounceInUp)
                .duration(1000)
                .repeat(0)
                .playOn(findViewById(R.id.Option3));
            YoYo.with(Techniques.BounceInUp)
                .duration(1000)
                .repeat(0)
                .playOn(findViewById(R.id.Option4));
            YoYo.with(Techniques.BounceInUp)
                .duration(1000)
                .repeat(0)
                .playOn(findViewById(R.id.btnSubmitAnswer));

        }

        fun resetOptionsColor() {
            for (option in allOptions) {
                option.setTextColor(originalOptionTextColor)
                option.typeface = Typeface.DEFAULT
                option.background = ContextCompat.getDrawable(
                    this,
                    R.drawable.default_option_border
                )
            }
        }
        for (option in allOptions) {
            option.setOnClickListener {
                resetOptionsColor()

                option.setTextColor(Color.parseColor("#417EFF"))
                option.background = ContextCompat.getDrawable(
                    this,
                    R.drawable.selected_option_border
                )
                selectedAnswers[currentQuestionId] = option.text.toString()
            }
        }

        animate()
        changeQuestion()

        btnSubmitAnswer.setOnClickListener {
            animate()

            if (selectedAnswers.containsKey(currentQuestionId)) {
                if (currentQuestionId + 1 == questions.size) {
                    for ((questionIndex, answer) in selectedAnswers) {
                        println("${questionIndex.toString()} ${answer.toString()}")
                        if (questions[questionIndex].correctAnswer == answer) {
                            score += 1
                        }
                    }
                }
                changeQuestion()
                resetOptionsColor()
            }
            }

        }


}