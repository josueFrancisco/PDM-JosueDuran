package com.jfpduno.labo03moviles

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
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
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

data class Persona(var nombre: String)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            val navController = rememberNavController()

            NavHost(
                navController = navController,
                startDestination = "ventana_principal"
            ) {
                composable("ventana_principal") {
                    Ventana(navController)
                }

                composable("sensores") {
                    VentanaListado(navController)
                }
            }


        }
    }
}

@Composable
fun Ventana(navController: NavHostController) {
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
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = {
                    navController.navigate("sensores")
                }
            ) {
                Text("Vista sensores")
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

@Composable
fun VentanaListado(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = {
                    navController.popBackStack()
                }
            ) {
                Text("Volver")
            }
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .border(BorderStroke(3.dp, Color.Blue))
                .padding(12.dp)
        ) {
            LightSensor()
        }
    }
}

@Composable
fun useSensor(sensorType: Int): List<Float> {
    val context = LocalContext.current
    val sensorManager = remember { context.getSystemService(Context.SENSOR_SERVICE) as SensorManager }
    val sensor = sensorManager.getDefaultSensor(sensorType) ?: return emptyList()
    var sensorValues by remember { mutableStateOf(listOf(0f, 0f, 0f)) }

    DisposableEffect(sensorType) {
        val listener = object : SensorEventListener {
            override fun onSensorChanged(event: SensorEvent?) {
                event?.values?.let {
                    sensorValues = it.toList()
                }
            }

            override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {}
        }

        sensorManager.registerListener(listener, sensor, SensorManager.SENSOR_DELAY_UI)

        onDispose {
            sensorManager.unregisterListener(listener)
        }
    }

    return sensorValues
}
@Composable
fun LightSensor () {
    val lightValues = useSensor(Sensor.TYPE_LIGHT)

    Scaffold { innerPadding ->
        Column (
            modifier = Modifier.fillMaxSize().padding(innerPadding),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Sensor de Luz", fontSize = 24.sp, fontWeight = FontWeight.Bold)
            Text(text = "Intensidad:${lightValues[0]} lx", fontSize = 18.sp)
        }
    }
}