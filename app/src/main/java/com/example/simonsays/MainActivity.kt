package com.example.simonsays

import android.annotation.SuppressLint
import android.app.Application
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.room.Room
import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis


@Suppress("UNUSED_EXPRESSION")
class MainActivity : AppCompatActivity() {




    var coloresMaquina = ArrayList<Int>()
    var partida : Boolean = false
    var puntos:Int = 0
    var contador:Int = 0
    var ronda : Int = 0
    var recoRonda :Int = 0
    var recorPuntos :Int = 0
    val miModelo by viewModels<MyViewModelito>()
    var partidDB = Partida(0,0)
    val datosDao = miModelo.db.partidaDao()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val start = findViewById<Button>(R.id.start)
        val red = findViewById<Button>(R.id.red)
        val blue = findViewById<Button>(R.id.blue)
        val green = findViewById<Button>(R.id.green)
        val yellow = findViewById<Button>(R.id.yellow)


        setPuntuacion(0)

        start.setOnClickListener {
            inicioPartida()
            secuencia()
        }

            red.setOnClickListener {
                pulsar(0)
                if (comprobar(0)) {
                    if (contador == coloresMaquina.size) {
                        secuencia()
                    }
                } else {
                    fin()
                }
            }
            blue.setOnClickListener {
                pulsar(1)
                if (comprobar(1)) {
                    if (contador == coloresMaquina.size) {
                        secuencia()
                    }
                } else {
                    fin()
                }
            }
            green.setOnClickListener {
                pulsar(2)
                if (comprobar(2)) {
                    if (contador == coloresMaquina.size) {
                        secuencia()
                    }
                } else {
                    fin()
                }
            }
            yellow.setOnClickListener {
                pulsar(3)
                if (comprobar(3)) {
                    if (contador == coloresMaquina.size) {
                        secuencia()
                    }
                } else {
                    fin()
                }
            }

    }

    fun inicioPartida(){
        ronda = 0
        coloresMaquina = arrayListOf()
        puntos = 0
        setPuntuacion(0)
    }

    fun setRondas(rondas: Int){
        val wave = findViewById<TextView>(R.id.ronda)
        wave.setText("Ronda: "+rondas)
    }

    fun secuencia(){
        ronda++
        miModelo.addList(ronda)
        println("hasta aqui NO chucla")

        miModelo.rondaliveData.observe(
            this,
            Observer (
                fun(listaRondas : MutableList<Int>){
                    println("Array: "+listaRondas.toString())
                }
            )
        )
        setRondas(ronda)
        contador = 0
        var random = (0..3).random()


        coloresMaquina.add(random)
        leerSecuencia()

    }

    fun pulsar(color: Int){

        var corrutina: Job? = null
        val red = findViewById<Button>(R.id.red)
        val blue = findViewById<Button>(R.id.blue)
        val green = findViewById<Button>(R.id.green)
        val yellow = findViewById<Button>(R.id.yellow)


        corrutina = GlobalScope.launch(Dispatchers.Main) {

            when(color){
                0 -> red.setBackgroundColor(Color.parseColor("#FFFF837A"))
                1 -> blue.setBackgroundColor(Color.parseColor("#FF96DDFD"))
                2 -> green.setBackgroundColor(Color.parseColor("#FFC0FFC3"))
                3 -> yellow.setBackgroundColor(Color.parseColor("#FFFFCA7C"))
            }

            delay(150)


            red.setBackgroundColor(Color.parseColor("#E33124"))
            blue.setBackgroundColor(Color.parseColor("#03A9F4"))
            green.setBackgroundColor(Color.parseColor("#4CAF50"))
            yellow.setBackgroundColor(Color.parseColor("#FF9800"))


        }
    }

    fun leerSecuencia() {

        var i: Int = 0
        var corrutina: Job? = null
        corrutina = GlobalScope.launch(Dispatchers.Main) {

            while (i<coloresMaquina.size) {

                val red = findViewById<Button>(R.id.red)
                val blue = findViewById<Button>(R.id.blue)
                val green = findViewById<Button>(R.id.green)
                val yellow = findViewById<Button>(R.id.yellow)



                if(puntos<10){
                    delay(500)
                }
                if (puntos>=10 && puntos<20){
                    delay(350)
                }
                if (puntos>=20){
                    delay(250)
                }
                println(puntos)


                when (coloresMaquina[i]) {
                    0 -> red.setBackgroundColor(Color.WHITE)
                    1 -> blue.setBackgroundColor(Color.WHITE)
                    2 -> green.setBackgroundColor(Color.WHITE)
                    3 -> yellow.setBackgroundColor(Color.WHITE)
                }
                if(puntos<10){
                    delay(500)
                }
                if (puntos>=10 && puntos<20){
                    delay(350)
                }
                if (puntos>=20){
                        delay(250)
                }

                i++

                red.setBackgroundColor(Color.parseColor("#E33124"))
                blue.setBackgroundColor(Color.parseColor("#03A9F4"))
                green.setBackgroundColor(Color.parseColor("#4CAF50"))
                yellow.setBackgroundColor(Color.parseColor("#FF9800"))


            }


        }
    }

    fun comprobar(color: Int): Boolean {

        return if (color == coloresMaquina[contador]){
            contador++
            puntos++
            setPuntuacion(puntos)
            miModelo.addPunto(puntos)
            miModelo.puntosLiveData.observe(
                this,
                Observer(
                    fun (listaPuntos : MutableList<Int>){
                        print("Puntos: "+listaPuntos.toString())
                    }
                )
            )
            return true
        }
        else{
            return false
        }

    }

    fun fin(){

        partidDB.rondas=ronda
        partidDB.puntos=puntos
        datosDao.insertAll(partidDB)
        var partidas: List<Partida> = datosDao.getAll()
        println("Base de datos: "+partidas.size)
        partidas.forEach(){
            println("Rondas: "+it.rondas+" || Puntos: "+it.puntos)
        }

        val recortext = findViewById<TextView>(R.id.record)

        ronda = 0
        coloresMaquina = arrayListOf()
        puntos = 0
        partida = false

        setPuntuacion(0)
        setRondas(0)
        Toast.makeText(this, "FIN DEL JUEGO", Toast.LENGTH_SHORT).show()

        miModelo.rondas.forEach(){
            if (it>recoRonda) {
                recoRonda = it
            }
        }
        miModelo.puntos.forEach(){
            if (it>recorPuntos) {
                recorPuntos = it
            }
        }
        recortext.setText("Record -> RONDA: "+recoRonda+" || PUNTUACION: "+recorPuntos)
        miModelo.rondas.clear()


    }

    fun setPuntuacion(points: Int){
        val puntuacion = findViewById<TextView>(R.id.textView)
        puntuacion.setText("Puntuacion: "+points)
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