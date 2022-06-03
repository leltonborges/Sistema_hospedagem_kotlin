package dev.project.reservahotel.entities

import io.swagger.v3.oas.annotations.Hidden
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "tb_telefone")
data class Telefone(
    @Hidden
    @field:Id
    @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,
    val apelido: String,
    var numero: Int,
    var ddd: Int
)
