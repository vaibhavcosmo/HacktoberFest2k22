package com.example.test

import android.graphics.Color
import android.graphics.Typeface
import android.graphics.text.TextRunShaper
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_game.*

class GameActivity : AppCompatActivity(), View.OnClickListener {
    private var mcurrentPosition:Int=1
    private var mQuestionList:ArrayList<Question>?=null
    private var mSelectedOption:Int = 0
    private var mCorrectAnswers:Int=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        mQuestionList = Constants.getQuestions()
        setQuestion()
        op1.setOnClickListener(this)
        op2.setOnClickListener(this)
        op3.setOnClickListener(this)
        op4.setOnClickListener(this)
        btnsubmit.setOnClickListener(this)

    }
    private fun setQuestion(){
        defaultoptionsview()
        if(mcurrentPosition==mQuestionList!!.size){
            btnsubmit.text="FINISH"
        }else{
            btnsubmit.text="SUBMIT"
        }
        val question = mQuestionList!![mcurrentPosition-1]
        tv1.text=question.questions
        op1.text=question.option1
        op2.text=question.option2
        op3.text=question.option3
        op4.text=question.option4
    }
    private fun defaultoptionsview(){
        val options=ArrayList<TextView>()
        options.add(0,op1)
        options.add(1,op2)
        options.add(2,op3)
        options.add(3,op4)
        for (option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface= Typeface.DEFAULT
            option.background=ContextCompat.getDrawable(this,R.drawable.default_option)
        }
    }

    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.op1->{
                selectedoptionview(op1,1)
            }
            R.id.op2->{
                selectedoptionview(op2,2)
            }
            R.id.op3->{
                selectedoptionview(op3,3)
            }
            R.id.op4->{
                selectedoptionview(op4,4)
            }
            R.id.btnsubmit->{
                if(mSelectedOption==0){
                    mcurrentPosition++
                    when {
                        mcurrentPosition <= mQuestionList!!.size -> {
                            setQuestion()
                        }else->{
                            Toast.makeText(this,"finished",Toast.LENGTH_SHORT).show()
                        }
                    }
                }else{
                    val question=mQuestionList!!.get(mcurrentPosition-1)
                    if (question.correctAnswer!=mSelectedOption){
                        answerview(mSelectedOption,R.drawable.wrong_option)
                    }else{
                        mCorrectAnswers++
                    }
                    answerview(question.correctAnswer,R.drawable.correct_option)
                    if(mcurrentPosition==mQuestionList!!.size){
                        btnsubmit.text="FINISH"
                    }else{
                        btnsubmit.text="GO TO NEXT QUESTION"
                    }
                    mSelectedOption=0
                }
            }
        }
    }
    private fun answerview(answer:Int,drawableview:Int){
        when(answer){
            1->{
                op1.background=ContextCompat.getDrawable(this,drawableview)
            }
            2->{
                op2.background=ContextCompat.getDrawable(this,drawableview)
            }
            3->{
                op3.background=ContextCompat.getDrawable(this,drawableview)
            }
            4->{
                op4.background=ContextCompat.getDrawable(this,drawableview)
            }
        }
    }
    private fun selectedoptionview(v:TextView,num:Int){
        defaultoptionsview()
        mSelectedOption = num
        v.setTextColor(Color.parseColor("#363A43"))
        v.setTypeface(v.typeface,Typeface.BOLD)
        v.background=ContextCompat.getDrawable(this,R.drawable.selected_option)

    }
}