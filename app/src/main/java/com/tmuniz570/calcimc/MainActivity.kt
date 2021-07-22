package com.tmuniz570.calcimc

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        et_peso.doOnTextChanged { _, _, _, _ ->
            calcularIMC()
        }

        et_altura.doOnTextChanged { _, _, _, _ ->
            calcularIMC()
        }
    }

    private fun calcularIMC(){
        val peso = et_peso.text.toString().toFloatOrNull()
        val altura = et_altura.text.toString().toFloatOrNull()

        if (peso != null && altura != null){
            val imc = peso / (altura * altura)

            when{
                imc < 18.5 -> {
                    tv_result.text = "Seu IMC é: %.2f\n\nClassificado como MAGREZA\n\nGrau de obesidade: 0".format(imc)
                }
                imc >= 18.5 && imc < 25 -> {
                    tv_result.text = "Seu IMC é: %.2f\n\nClassificado como NORMAL\n\nGrau de obesidade: 0".format(imc)
                }
                imc >= 25 && imc < 30 -> {
                    tv_result.text = "Seu IMC é: %.2f\n\nClassificado como SOBREPESO\n\nGrau de obesidade: 1".format(imc)
                }
                imc >= 30 && imc < 40 -> {
                    tv_result.text = "Seu IMC é: %.2f\n\nClassificado como OBESIDADE\n\nGrau de obesidade: 2".format(imc)
                }
                imc >= 40 -> {
                    tv_result.text = "Seu IMC é: %.2f\n\nClassificado como OBESIDADE GRAVE\t\n\nGrau de obesidade: 3".format(imc)
                }
            }
            tv_result.visibility = View.VISIBLE
        }
        else{
            tv_result.visibility = View.GONE
        }
    }
}