package dev.project.reservahotel.entities

import javax.persistence.*

@Entity
@Table(name = "tb_quarto")
data class Quarto(
    @field:Id @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,
    val numero: Int,
    var qtdCama: Int
)
