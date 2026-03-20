package com.example.laboratoriomoviles01

import com.example.laboratoriomoviles01.Ejercicio1.Programa
import org.junit.Test

class Ejercicio3 {

    data class Estudiante(
        var nombre: String,
        var carnet: String,
        var materia: String
    )


    @Test
    fun main() {
        val Ciclo01 = listOf(
            Estudiante("Josue Peña", "00191223", "PDM"),
            Estudiante("Daniel Sermeño", "00245410", "PDM"),
            Estudiante("Steven Chen", "00123484", "PDM"),


            Estudiante("Lionel Messi", "00000010", "AN"),
            Estudiante("Lion S Kennedy", "00000007", "AN"),
            Estudiante("Ethan Winters", "10201020", "AN"),
            Estudiante("Chris Redfield", "48624862", "AN"),
        )

        println("Estudiantes escritos en PDM")
        val EstudiantesPDM = Ciclo01.filter { it.materia == "PDM" }
        for (estudiante in EstudiantesPDM) {
            println("Programa: ${estudiante.nombre}")
            println("Carnet: ${estudiante.carnet}")
            println("Materia: ${estudiante.materia}")
        }


    }

}

