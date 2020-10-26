package com.alex.primerproyecto.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Content (
    @PrimaryKey(autoGenerate = true)
    val id: Long?=null,
    val nombre: String,
    val correo: String,
    val telefono: Long,
    val genero: String,
    val peliculas : String


){

    override fun equals(other: Any?): Boolean {
        if (other is Content)
            return other.id==this.id
        return false
    }
}