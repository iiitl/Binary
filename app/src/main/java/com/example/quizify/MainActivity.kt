package com.example.quizify

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo
import kotlinx.android.synthetic.main.activity_main.*


var name = ""

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        YoYo.with(Techniques.Tada)
            .duration(1500)
            .repeat(0)
            .playOn(findViewById(R.id.quiz));
        YoYo.with(Techniques.Tada)
            .duration(1500)
            .repeat(0)
            .playOn(findViewById(R.id.explore));
        YoYo.with(Techniques.Tada)
            .duration(1500)
            .repeat(0)
            .playOn(findViewById(R.id.tvNameParent));
        YoYo.with(Techniques.Tada)
            .duration(2500)
            .repeat(0)
            .playOn(findViewById(R.id.btnStartQuiz));


        btnStartQuiz.setOnClickListener {

            if (tvName.text.toString().isEmpty()) {
                tvNameParent.error = "Please provide a name"
                Toast.makeText(this,"Please provide a name",Toast.LENGTH_SHORT).show()
            } else {

                name = tvName.text.toString()
                Toast.makeText(this,"All the best $name !",Toast.LENGTH_SHORT).show()
                startActivity(
                    Intent(
                        this,
                        QuestionsActivity::class.java,
                    )
                )
            }

        }
    }

}
