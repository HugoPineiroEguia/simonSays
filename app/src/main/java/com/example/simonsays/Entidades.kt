package com.example.simonsays

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

    @Entity
    data class Partida(
        @PrimaryKey (autoGenerate = true)
        @ColumnInfo(name = "rondas") var rondas: Int,
        @ColumnInfo(name = "puntuacionTotal") var puntos: Int
    )

