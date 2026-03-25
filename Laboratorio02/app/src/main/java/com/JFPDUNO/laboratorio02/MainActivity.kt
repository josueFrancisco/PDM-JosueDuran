package com.JFPDUNO.laboratorio02

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

data class Persona(var nombre: String)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Ventana()


        }
    }
}

@Composable
fun Ventana() {
    var nombre by remember { mutableStateOf("") }
    val listaPersona = remember { mutableStateListOf<Persona>() }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
    ) {

        TextField(
            value = nombre,
            onValueChange = { nombre = it },
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text("Nombre") }
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = {
                    if (nombre.isNotEmpty()) {
                        listaPersona.add(Persona(nombre))
                        nombre = ""
                    }
                }
            ) {
                Text("Guardar")
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = "Listado de nombres y posición en la lista",
                modifier = Modifier.weight(1f)
            )

            Button(
                onClick = { listaPersona.clear() }
            ) {
                Text("Limpiar")
            }
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .border(BorderStroke(3.dp, Color.Blue))
                .padding(12.dp)
        ) {

            LazyColumn {
                itemsIndexed(listaPersona) { index, persona ->
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(persona.nombre)
                        Text("${index + 1}")
                    }
                }
            }
        }
    }
}