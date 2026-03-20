package com.example.laboratoriomoviles01

import androidx.compose.ui.text.font.Font
import com.example.laboratoriomoviles01.Ejercicio1.Computadora
import org.junit.Test

class Ejercicio2 {

    data class Calculadora(
        val marca: String,
        val aniosVida: Int,
        var precio: Double
    ) {
        fun mostrarCalculadora() {
            println("La calculadora es:")
            println("Marca: $marca ")
            println("Años de vida: $aniosVida ")
            println("Precio: $precio ")
        }

    }

    fun suma(valor1: Double, valor2: Double): Double {
        return valor1 + valor2
    }

    fun resta(valor1: Double, valor2: Double): Double {
        return valor1 - valor2
    }

    fun multiplicacion(valor1: Double, valor2: Double): Double {
        return valor1 * valor2
    }

    fun division(valor1: Double, valor2: Double): Double {
        return valor1 / valor2
    }

    @Test
    fun main() {
        val calcu = Calculadora("Casio", 8, 29.50)
        calcu.mostrarCalculadora()
        var valorInicial: Double
        var valorFinal: Double

        valorInicial = 10.00
        valorFinal = 35.00
        println("El primer valor es $valorInicial")
        println("El segundo valor es $valorFinal")
        println("Primer prueba calculadora (Suma): $valorInicial + $valorFinal")
        println("El resultado es: ${suma(valorInicial, valorFinal)}")

        println("--Siguientes datos--")
        valorInicial = 100.00
        valorFinal = 67.00
        println("El primer valor es $valorInicial")
        println("El segundo valor es $valorFinal")
        println("Segunda prueba calculadora (Resta): $valorInicial - $valorFinal")
        println("El resultado es: ${resta(valorInicial, valorFinal)}")

        println("--Siguientes datos--")
        valorInicial = 5.00
        valorFinal = 5.00
        println("El primer valor es $valorInicial")
        println("El segundo valor es $valorFinal")
        println("Tercera prueba calculadora (Multiplicacion): $valorInicial * $valorFinal")
        println("El resultado es: ${multiplicacion(valorInicial, valorFinal)}")

        println("--Siguientes datos--")
        valorInicial = 10.00
        valorFinal = 10.00
        println("El primer valor es $valorInicial")
        println("El segundo valor es $valorFinal")
        if (valorInicial.toInt() == 0 || valorFinal.toInt() == 0) {
            println("no se puede dividir entre 0")
        } else {
            println("Cuarta prueba calculadora (Division): $valorInicial / $valorFinal")
            println("El resultado es: ${division(valorInicial, valorFinal)}")
        }
    }

}