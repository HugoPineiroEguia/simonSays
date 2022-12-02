package com.example.simonsays

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query


    @Dao
    interface Datos{
        @Query("SELECT * FROM Partida")
        fun getAll(): List<Entidades.Partida>
        @Insert
        fun insertAll(partida: Entidades.Partida)
    }


