package com.example.simonsays

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.util.Log
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var random = (0..3).random()
        var contador:Int = 0
        var coloresMaquina = ArrayList<Int>()
        val start = findViewById<Button>(R.id.start)
        val red = findViewById<Button>(R.id.red)
        val blue = findViewById<Button>(R.id.blue)
        val green = findViewById<Button>(R.id.green)
        val yellow = findViewById<Button>(R.id.yellow)
        var startIf = false
        var puntos:Int = 0
        var coloresJugador:Array<Int> = arrayOf()


        start.setOnClickListener {
            var i:Int = 0

            if (startIf == true){
                Toast.makeText(this, "Ya se han indicado los colores", Toast.LENGTH_SHORT).show()
            }

            if (startIf == false) {

                startIf = true



                var random = (0..3).random()

                println(random)

                if (random == 0) {
                    Toast.makeText(this, "Rojo", Toast.LENGTH_SHORT).show()
                }
                if (random == 1) {
                    Toast.makeText(this, "Azul", Toast.LENGTH_SHORT).show()
                }
                if (random == 2) {
                    Toast.makeText(this, "Verde", Toast.LENGTH_SHORT).show()
                }
                if (random == 3) {
                    Toast.makeText(this, "Amarillo", Toast.LENGTH_SHORT).show()
                }

                coloresMaquina.add(random)

                i = i + 1


                coloresJugador = Array((puntos+1),{i -> 0})
                println("Size: "+coloresJugador.size)
            }




        }

        red.setOnClickListener {
            println("red")
            if (startIf==true){

                    coloresJugador[contador] = 0

                    if (coloresJugador[contador] == coloresMaquina[contador]){
                        contador = contador + 1
                        println(contador)
                    } else {
                        Toast.makeText(this, "Has fallado", Toast.LENGTH_SHORT).show()
                        coloresJugador = arrayOf()
                        var i:Int = 0
                        while (i<coloresMaquina.size) {
                            coloresMaquina.remove(i)
                        }
                        puntos = 0
                        startIf = false
                    }
                    if (contador==coloresJugador.size) {
                        Toast.makeText(this, "Has superado esta ronda", Toast.LENGTH_SHORT).show()
                        puntos = puntos + 1
                        coloresJugador = arrayOf()
                        startIf = false
                        contador = 0
                    }

            }
        }

        blue.setOnClickListener {
            println("blue")
            if (startIf==true){

                coloresJugador[contador] = 1
                if (coloresJugador[contador] == coloresMaquina[contador]){
                    contador = contador + 1
                    println(contador)
                } else {
                    Toast.makeText(this, "Has fallado", Toast.LENGTH_SHORT).show()
                    coloresJugador = arrayOf()
                    var i:Int = 0
                    while (i<coloresMaquina.size) {
                        coloresMaquina.remove(i)
                    }
                    puntos = 0
                    startIf = false
                }
                    if (contador==coloresJugador.size) {
                        Toast.makeText(this, "Has superado esta ronda", Toast.LENGTH_SHORT).show()
                        puntos = puntos + 1
                        coloresJugador = arrayOf()
                        startIf = false
                        contador = 0

                    }
                }
            }


        green.setOnClickListener {
            println("green")
            if (startIf==true){

                coloresJugador[contador] = 2
                if (coloresJugador[contador] == coloresMaquina[contador]){
                    contador = contador + 1
                    println(contador)
                } else {
                    Toast.makeText(this, "Has fallado", Toast.LENGTH_SHORT).show()
                    coloresJugador = arrayOf()
                    var i:Int = 0
                    while (i<coloresMaquina.size) {
                        coloresMaquina.remove(i)
                    }
                    puntos = 0
                    startIf = false
                }
                    if (contador==coloresJugador.size) {
                        Toast.makeText(this, "Has superado esta ronda", Toast.LENGTH_SHORT).show()
                        puntos = puntos + 1
                        coloresJugador = arrayOf()
                        startIf = false
                        contador = 0
                    }
                }
            }


        yellow.setOnClickListener {
            println("yellow")
            if (startIf==true){

                coloresJugador[contador] = 3
                if (coloresJugador[contador] == coloresMaquina[contador]){
                    contador = contador + 1
                    println(contador)
                } else {
                    Toast.makeText(this, "Has fallado", Toast.LENGTH_SHORT).show()
                    coloresJugador = arrayOf()
                    var i:Int = 0
                    while (i<coloresMaquina.size) {
                        coloresMaquina.remove(i)
                    }
                    puntos = 0
                    startIf = false
                }
                println(contador)
                println(coloresJugador.size)
                if (contador==coloresJugador.size) {
                        Toast.makeText(this, "Has superado esta ronda", Toast.LENGTH_SHORT).show()
                        puntos = puntos + 1
                        coloresJugador = arrayOf()
                        startIf = false
                    contador = 0
                }
                }
            }
        }





    override fun onStart(){
        super.onStart();
        Log.d("Estado","onStart")
    }

    override fun onPause() {
        super.onPause();
        Log.d("Estado","onResume")

    }

    override fun onRestart() {
        super.onRestart();
        Log.d("Estado","onRestart");
    }

    override fun onDestroy(){
        super.onDestroy();
        Log.d("Estado","onDestroy")
    }

    override fun onResume(){
        super.onResume();
        Log.d("Estado","onResume")
    }

    fun main(){
        println("Hola migente")
    }





}