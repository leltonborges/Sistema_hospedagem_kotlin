package dev.project.reservahotel.entities

import java.math.BigDecimal
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "tb_diarias")
data class Diarias(
    @field:Id @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,
    val dataEntrada: LocalDateTime,
    val qtdDias: Int,
    val precoDiaria: BigDecimal
)
