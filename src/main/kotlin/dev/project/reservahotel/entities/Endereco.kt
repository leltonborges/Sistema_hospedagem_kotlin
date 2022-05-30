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
    private val id: Long,
    private val logradouro: String,
    private val numero: Int,
    private val cidade: String,
    private val estado: String,
    private val cep: Int
)
