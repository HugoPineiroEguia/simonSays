package com.example.simonsays

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class MyViewModelito: ViewModel() {

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


}