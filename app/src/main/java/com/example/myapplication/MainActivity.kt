package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.core.content.ContextCompat.startActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_secant_activiti2.*
import kotlin.random.Random




class MainActivity : AppCompatActivity() {
    private var one: Int = 0
    private var two: Int = 0
    private var total: Int = 0
    private var wrong: Int = 0
    private var belgi: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        PlGame()
    }

    fun onClick (button: View){
        val intent = Intent(this,SecantActiviti2::class.java)
        when {
            total + wrong == 10 -> {
                intent.putExtra("res","Right $total")
                intent.putExtra("res1","Wrong $wrong")
                startActivity(intent)
            }
            (button as Button).text == genRightAnswer().toString() -> {
                total++
                PlGame()
            }
            else -> {
                wrong++
                PlGame()
            }
        }
    }
    private fun PlGame(){
        belgi = operRan()
        txt2.text = belgi
        if ("/" == belgi) {
            do {
                one = genRan(10, 100)
                two = genRan(10, 100)
            } while (one % two != 0)
        }
        else{
            one = genRan(10,100)
            two = genRan(10,100)
        }
        txt1.text = one.toString()
        txt3.text = two.toString()
        genRightAnswer()
        genWrongAnswer()
        setRightRes()
        operRan()
    }

    private fun genRan(start: Int, end:Int) : Int = Random.nextInt(start,end)

    private fun operRan() : String {
        return when (genRan(0, 4)) {
            0 -> "+"
            1 -> "-"
            2 -> "*"
            3 -> "/"
            else -> "+"
        }
    }
    private fun genRightAnswer() : Int {
        val res = when(belgi){
            "+" -> one + two
            "-" -> one - two
            "*" -> one * two
            "/" -> one / two
            else -> one + two
        }
        return res
    }
    private fun genWrongAnswer(){
        val ras = genRightAnswer()
        val test1 = when(genRan(0,2)){
            0 -> 100 + genRan(5,99)
            1 -> 100 - genRan(5,99)
            else -> ras - genRan(5,ras)
        }
        val test2 = when(genRan(0,2)){
            0 -> 100 + genRan(5,99)
            1 -> 100 - genRan(5,99)
            else -> ras - genRan(5,ras)
        }
        val test3 = when(genRan(0,2)){
            0 -> 100 + genRan(5,99)
            1 -> 100 - genRan(5,99)
            else -> ras - genRan(5,ras)
        }
        val test4 = when(genRan(0,2)){
            0 -> 100 + genRan(5,99)
            1 -> 100 - genRan(5,99)
            else -> ras - genRan(5,ras)
        }
        btn1.text = test1.toString()
        btn2.text = test2.toString()
        btn3.text = test3.toString()
        btn4.text = test4.toString()
    }
    private fun setRightRes(){
        val ras = genRightAnswer()
        when(genRan(0,4)){
            0 -> btn1.text = ras.toString()
            1 -> btn2.text = ras.toString()
            2 -> btn3.text = ras.toString()
            3 -> btn4.text = ras.toString()
        else  -> btn1.text = ras.toString()
        }
    }
}










