package dev.project.reservahotel.entities

import io.swagger.v3.oas.annotations.Hidden
import javax.persistence.*

@Entity
@Table(name = "tb_quarto")
data class Quarto(
    @Hidden
    @field:Id @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,
    val numero: Int,
    var qtdCama: Int
)
