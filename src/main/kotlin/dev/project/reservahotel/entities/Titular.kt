package dev.project.reservahotel.entities

import javax.persistence.*

@Entity
@Table(name = "tb_titular")
data class Titular(
    @field:Id @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Long,
    private val nome: String,
    private val cpf: Int,
    private val emal: String
): Pessoa(nome, cpf)
