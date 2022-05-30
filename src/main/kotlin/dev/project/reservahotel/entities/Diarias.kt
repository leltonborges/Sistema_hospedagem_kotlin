package dev.project.reservahotel.entities

import java.math.BigDecimal
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "tb_diarias")
data class Diarias(
    @field:Id @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Long,
    private val dataEntrada: LocalDateTime,
    private val qtdDias: Int,
    private val precoDiaria: BigDecimal
)
