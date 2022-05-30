package dev.project.reservahotel.entities

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "tb_telefone")
data class Telefone(
    @field:Id @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Long,
    private val apelido: String,
    private val numero: Int,
    private val ddd: Int
)
