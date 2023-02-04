package com.example.quizify

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo
import com.example.quizify.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*


var name = ""

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        YoYo.with(Techniques.Tada)
            .duration(1500)
            .repeat(0)
            .playOn(binding.quiz);
        YoYo.with(Techniques.Tada)
            .duration(1500)
            .repeat(0)
            .playOn(binding.explore);
        YoYo.with(Techniques.Tada)
            .duration(1500)
            .repeat(0)
            .playOn(binding.tvNameParent);
        YoYo.with(Techniques.Tada)
            .duration(2500)
            .repeat(0)
            .playOn(binding.btnStartQuiz);


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
