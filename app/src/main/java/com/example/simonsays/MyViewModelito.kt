package com.example.simonsays

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.room.Room
import androidx.room.*

class MyViewModelito(application: Application) : AndroidViewModel(application) {

    val context = getApplication<Application>().applicationContext
    val db = Room.databaseBuilder(
        context,
        AppDatabase::class.java, "simon-dice"
    ).build()
    val datosDAO = db.partidaDao()

    val rondas = mutableListOf<Int>()
    val puntos = mutableListOf<Int>()

    val puntosLiveData = MutableLiveData<MutableList<Int>>()
    val rondaliveData = MutableLiveData<MutableList<Int>>()

    init {
        rondaliveData.value = rondas
    }

    fun addList(ronda: Int){
        rondas.add(ronda)
        rondaliveData.value = rondas
    }

    fun addPunto(punto : Int){
        puntos.add(punto)
        puntosLiveData.value = puntos
    }

    fun checar(){

    }



}