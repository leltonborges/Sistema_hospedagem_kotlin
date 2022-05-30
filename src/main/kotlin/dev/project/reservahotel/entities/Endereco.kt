package dev.project.reservahotel.entities

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "tb_endereco")
data class Endereco(
    @field:Id
    @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val logradouro: String,
    val numero: Int,
    val cidade: String,
    val estado: String,
    val cep: Int
)
