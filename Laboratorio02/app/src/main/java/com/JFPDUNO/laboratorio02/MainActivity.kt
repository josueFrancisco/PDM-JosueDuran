package com.JFPDUNO.laboratorio02

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import com.JFPDUNO.laboratorio02.ui.theme.Laboratorio02Theme

data class Persona(var Nombre: String) {}
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Laboratorio02Theme {
                val listaPersona = remember { mutableListOf<Persona>() }
                Ventana()

            }
        }
    }
}

@Preview
@Composable
fun Ventana() {
    val nombre by remember { mutableStateOf("") }
    val listaPersona = remember { mutableListOf<Persona>() }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,


        ) {
     TextField(
         value = nombre,
         onValueChange = {
             val instancia = Persona(nombre)
             listaPersona.add(instancia)

         }
     )

        Button(
            onClick = {


            }
        ) {
            Text("Guardar Registro")
        }

        Row(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Red),
        )
        {
            Text("Listado de nombre y posicion en la lista")

            Button(
                onClick = {


                }
            ) {
                Text("Limpiar")
            }
        }

    }
}
