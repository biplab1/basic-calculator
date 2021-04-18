package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun butNumberEvent(view:View){
        if (isNewOp){
            editShowNumber.setText("")
        }
        isNewOp = false

        val butSelect = view as Button
        var butClickValue:String = editShowNumber.text.toString()
        when (butSelect.id){
            but00.id ->{
                butClickValue += "00"
            }
            but0.id -> {
                    butClickValue += "0"
            }
            but1.id ->{
                butClickValue += "1"
            }
            but2.id ->{
                butClickValue += "2"
            }
            but3.id ->{
            butClickValue += "3"
            }
            but4.id ->{
                butClickValue += "4"
            }
            but5.id ->{
                butClickValue += "5"
            }
            but6.id ->{
                butClickValue += "6"
            }
            but7.id ->{
                butClickValue += "7"
            }
            but8.id ->{
                butClickValue += "8"
            }
            but9.id ->{
                butClickValue += "9"
            }
            butdot.id ->{
               if (!isDotOn) {
                    butClickValue += "."
                    isDotOn = true
                }
            }
            butPlusMinus.id ->{
                val toggle = butClickValue.toDouble() * (-1)
                butClickValue = toggle.toString()
            }
         }
        if (butClickValue == "0" || butClickValue == "00"){
            editShowNumber.setText("0")
            isNewOp = true
        }
        else {
            editShowNumber.setText(butClickValue)
        }
    }
var isDotOn = false
var oper = ""
var oldNumber = ""
var isNewOp = true
    fun butOpEvent(view: View){
        val butSelect = view as Button
        when (butSelect.id) {
            butMul.id -> {
                oper = "*"
            }
            butDiv.id -> {
                oper = "/"
            }
            butSub.id -> {
                oper = "-"
            }
            butAdd.id -> {
                oper = "+"
            }
        }
        oldNumber = editShowNumber.text.toString()
        isNewOp = true // for new operation it is set to true
        isDotOn = false
    }

    fun butEqualEvent(view: View){
        val newNumber = editShowNumber.text.toString()
        var finalNumber:Double?= newNumber.toDouble()
        when (oper){
            "/" ->{
                finalNumber = oldNumber.toDouble() / newNumber.toDouble()
            }
            "*" ->{
                finalNumber = oldNumber.toDouble() * newNumber.toDouble()
            }
            "-" ->{
                finalNumber = oldNumber.toDouble() - newNumber.toDouble()
            }
            "+" ->{
                finalNumber = oldNumber.toDouble() + newNumber.toDouble()
            }

        }
        editShowNumber.setText(finalNumber.toString())
        isNewOp = true
        isDotOn = false
    }
    fun butPercent(view: View){
        val number:Double = editShowNumber.text.toString().toDouble()/100

        editShowNumber.setText(number.toString())
        isNewOp = true //cleanup after percent
        isDotOn = false

    }
    fun butClear(view: View){
        editShowNumber.setText("0")
        isNewOp = true  // consider a new operation after pressing AC button
        isDotOn = false
    }
}
