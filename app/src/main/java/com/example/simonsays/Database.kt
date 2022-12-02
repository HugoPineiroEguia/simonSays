package com.example.simonsays

import androidx.room.Database
import androidx.room.RoomDatabase

 @Database(entities = [Entidades.Partida::class], version = 1)
 abstract  class AppDatabase : RoomDatabase(){
        abstract  fun partidaDao(): Datos
 }
