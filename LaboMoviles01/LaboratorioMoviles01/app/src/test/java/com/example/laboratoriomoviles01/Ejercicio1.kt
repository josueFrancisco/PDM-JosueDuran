package com.example.laboratoriomoviles01

import org.junit.Test

class Ejercicio1 {

    data class Computadora(
        var estado: Boolean,
        var memoriaRam: Int,
        var memoria: Int,
        var sistema: String
    ) {
        fun encender() {
            if (!estado) {
                estado = true
                println("Computadora encendida")
            } else {
                println("La computadora ya estaba encendida")
            }
        }

        fun apagar() {
            if (estado) {
                estado = false
                println("Computadora apagada")
            } else {
                println("La computadora ya estaba apagada")
            }
        }

        fun modificarRAM(nuevaRam: Int) {
            memoriaRam = nuevaRam
            println("memoria RAM modificada")
        }

        fun modificarMemoria(nuevaMemoria: Int) {
            memoria = nuevaMemoria
            println("Memoria modificada")
        }

        fun modificarSistema(nuevoSistema: String) {
            sistema = nuevoSistema
            println("Sistema modificado a $sistema")
        }

        fun mostrarEstado() {
            println("Estado: ${if (estado) "Encendida" else "Apagada"}")
            println("RAM: $memoriaRam GB")
            println("Memoria: $memoria GB")
            println("Sistema: $sistema")
        }
    }

    data class Programa(
        var nombre: String,
        var anio: Int
    )

    @Test
    fun main() {
        val pc = Computadora(false, 8, 240, "Windows")

        val programasInstalados = listOf(
            Programa("Resident Evil Requiem", 2026),
            Programa("Resident Evil 8 Village", 2021),
            Programa("Word 2026", 2026),
            Programa("Resident Evil 7 Biohazard", 2017),
            Programa("Resident Evil 4 Remake", 2023),
            Programa("GTA IV", 2026)
        )

        println("Estado computadora")
        pc.mostrarEstado()

        println("Encendiendo computadora....")
        pc.encender()

        println("Actualizando componentes")
        pc.modificarRAM(16)
        pc.modificarMemoria(512)
        pc.modificarSistema("Ubuntu")

        println("Estado computadora")
        pc.mostrarEstado()

        println("Programas de este año")
        val programasActuales = programasInstalados.filter { it.anio == 2026 }

        for (programa in programasActuales) {
            println("Programa: ${programa.nombre}")
        }

        println("Apagando computadora....")
        pc.apagar()
    }
}