package com.example.kalkulyator

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.kalkulyator.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception
import java.math.BigDecimal

class MainActivity : AppCompatActivity() , View.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn0.setOnClickListener(this)
        binding.btn1.setOnClickListener(this)
        binding.btn2.setOnClickListener(this)
        binding.btn3.setOnClickListener(this)
        binding.btn4.setOnClickListener(this)
        binding.btn5.setOnClickListener(this)
        binding.btn6.setOnClickListener(this)
        binding.btn7.setOnClickListener(this)
        binding.btn8.setOnClickListener(this)
        binding.btn9.setOnClickListener(this)
        binding.btnAnswer.setOnClickListener(this)
        binding.btnClear.setOnClickListener(this)
        binding.btnClose.setOnClickListener(this)
        binding.btnMinus.setOnClickListener(this)
        binding.btnOpen.setOnClickListener(this)
        binding.btnPlus.setOnClickListener(this)
        binding.btnRemove.setOnClickListener(this)
        binding.btnSlash.setOnClickListener(this)
        binding.btnX.setOnClickListener(this)
        binding.btnDot.setOnClickListener(this)

    }

    @SuppressLint("SetTextI18n")
    override fun onClick(v: View?) {
        when (v?.id){
            R.id.btn_0 ->{
                emtyAdd()
                binding.tvAnswer.append("0")
            }
            R.id.btn_1 ->{
                emtyAdd()
                binding.tvAnswer.append("1")
            }
            R.id.btn_2 ->{
                emtyAdd()
                binding.tvAnswer.append("2")
            }
            R.id.btn_3 ->{
                emtyAdd()
                binding.tvAnswer.append("3")
            }
            R.id.btn_4 ->{
                emtyAdd()
                binding.tvAnswer.append("4")
            }
            R.id.btn_5 ->{
                emtyAdd()
                binding.tvAnswer.append("5")
            }
            R.id.btn_6 ->{
                emtyAdd()
                binding.tvAnswer.append("6")
            }
            R.id.btn_7 ->{
                emtyAdd()
                binding.tvAnswer.append("7")
            }
            R.id.btn_8 ->{
                emtyAdd()
                binding.tvAnswer.append("8")
            }
            R.id.btn_9 ->{
                emtyAdd()
                binding.tvAnswer.append("9")
            }
            R.id.btn_close ->{
                emtyAdd()
                binding.tvAnswer.append(")")
            }
            R.id.btn_open ->{
                emtyAdd()
                binding.tvAnswer.append("(")
            }
            R.id.btn_dot ->{
                val text = binding.tvAnswer.text.toString()
                if (!text.endsWith("+") && !text.endsWith("-") && !text.endsWith("*") && !text.endsWith("/") && !text.endsWith(".")){
                    binding.tvAnswer.append(".")
                }else{

                }
            }
            R.id.btn_minus ->{
                val text = binding.tvAnswer.text.toString()
                if (!text.endsWith("+") && !text.endsWith("-") && !text.endsWith("*") && !text.endsWith("/") && !text.endsWith(".")){
                    binding.tvAnswer.append("-")
                }else{

                }
            }
            R.id.btn_plus ->{
                val text = binding.tvAnswer.text.toString()
                if (!text.endsWith("+") && !text.endsWith("-") && !text.endsWith("*") && !text.endsWith("/") && !text.endsWith(".")) {
                    binding.tvAnswer.append("+")
                }else {

                }
            }
            R.id.btn_slash ->{
                val text = binding.tvAnswer.text.toString()
                if (!text.endsWith("+") && !text.endsWith("-") && !text.endsWith("*") && !text.endsWith("/") && !text.endsWith(".")){
                    binding.tvAnswer.append("/")
                }else{

                }
            }
            R.id.btn_x ->{
                val text = binding.tvAnswer.text.toString()
                if (!text.endsWith("+") && !text.endsWith("-") && !text.endsWith("*") && !text.endsWith("/") && !text.endsWith(".")){
                    binding.tvAnswer.append("*")
                }else{

                }
            }
            R.id.btn_answer ->{
                try {
                    val build = ExpressionBuilder(binding.tvAnswer.text.toString()).build()
                    binding.tvAnswer.text = BigDecimal(build.evaluate()).toString()
                }catch (e: Exception){
                    Toast.makeText(this, "Xatolik", Toast.LENGTH_SHORT).show()
                }
            }
            R.id.btn_clear ->{
                binding.tvAnswer.text = "0"
            }
            R.id.btn_remove ->{
                try {
                    val txt = binding.tvAnswer.text.toString()
                    if (txt != "0") {
                        binding.tvAnswer.text = txt.substring(0, txt.length - 1)
                        if (txt.isEmpty()){
                            binding.tvAnswer.text = "0"
                        }
                    }
                }catch (e: Exception){
                    val txt = binding.tvAnswer.text
                    if (txt.isEmpty()){
                        binding.tvAnswer.text = "0"
                    }
                }
            }
        }
    }

    private fun emtyAdd() {
        val text = binding.tvAnswer.text.toString()
        if (text == "0"){
            binding.tvAnswer.text = ""
        }
    }
}