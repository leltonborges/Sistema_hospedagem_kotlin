package dev.project.reservahotel.entities

sealed class Pessoa(
    private val nome: String,
    private val cpf: Int
)
