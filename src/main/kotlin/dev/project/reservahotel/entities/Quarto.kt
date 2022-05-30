package dev.project.reservahotel.entities

import javax.persistence.*

@Entity
@Table(name = "tb_quarto")
data class Quarto(
    @field:Id @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Long,
    private val numero: Int,
    private val qtdCama: Int
)
