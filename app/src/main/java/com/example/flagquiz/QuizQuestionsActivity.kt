package com.example.flagquiz

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {

    private var mcurrentPosition: Int = 1
    private var mQuestionList: ArrayList<Question>? = null
    private var mSelectedOption: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        mQuestionList = Constants.getQuestion()

        setQuestion()
        val opt1 = findViewById<TextView>(R.id.opt_one)
        val opt2 = findViewById<TextView>(R.id.opt_two)
        val opt3 = findViewById<TextView>(R.id.opt_three)
        val opt4 = findViewById<TextView>(R.id.opt_four)
        opt1.setOnClickListener(this)
        opt2.setOnClickListener(this)
        opt3.setOnClickListener(this)
        opt4.setOnClickListener(this)

    }

     private fun setQuestion(){
        val mcurrentPosition = 1
        val question: Question? = mQuestionList!![mcurrentPosition-1]
        lookDefault()

        val progressbar = findViewById<ProgressBar>(R.id.progressbar)
        progressbar.progress = mcurrentPosition

        var progress = findViewById<TextView>(R.id.tv_progress)
        progress.text = "$mcurrentPosition" + "/" + progressbar.max

        val tv_question = findViewById<TextView>(R.id.tv_question)
        tv_question.text = question!!.question

        val iv_image = findViewById<ImageView>(R.id.iv_image)
        iv_image.setImageResource(question.image)

        val opt1 = findViewById<TextView>(R.id.opt_one)
        opt1.text = question.opt1

        val opt2 = findViewById<TextView>(R.id.opt_two)
        opt2.text = question.opt2

        val opt3 = findViewById<TextView>(R.id.opt_three)
        opt3.text = question.opt3

        val opt4 = findViewById<TextView>(R.id.opt_four)
        opt4.text = question.opt4

    }

    private fun lookDefault(){
        val options = ArrayList<TextView>()
        val opt1 = findViewById<TextView>(R.id.opt_one)
        val opt2 = findViewById<TextView>(R.id.opt_two)
        val opt3 = findViewById<TextView>(R.id.opt_three)
        val opt4 = findViewById<TextView>(R.id.opt_four)
        options.add(0,opt1)
        options.add(1,opt2)
        options.add(2,opt3)
        options.add(3,opt4)

        for (option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this,R.drawable.default_option_border_bg)

        }
    }

    override fun onClick(v: View?) {
        val opt1 = findViewById<TextView>(R.id.opt_one)
        val opt2 = findViewById<TextView>(R.id.opt_two)
        val opt3 = findViewById<TextView>(R.id.opt_three)
        val opt4 = findViewById<TextView>(R.id.opt_four)
        when (v?.id){
            R.id.opt_one ->{selectedView(opt1,1)}
            R.id.opt_two ->{selectedView(opt2,2)}
            R.id.opt_three ->{selectedView(opt3,3)}
            R.id.opt_four ->{selectedView(opt4,4)}
        }
    }

    private fun selectedView(tv: TextView, selected: Int){
        lookDefault()
        mSelectedOption = selected
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(this,R.drawable.selected_option_border_bg)


    }
}