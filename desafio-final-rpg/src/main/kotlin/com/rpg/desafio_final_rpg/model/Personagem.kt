package com.rpg.desafio_final_rpg.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
data class Personagem(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val nome : String,
    var forca: Int,
    var velocidade: Int,
    var vida:Int,
)
