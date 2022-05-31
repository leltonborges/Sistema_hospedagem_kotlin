package dev.project.reservahotel.entities

import com.fasterxml.jackson.annotation.JsonFormat
import org.springframework.format.annotation.DateTimeFormat
import java.math.BigDecimal
import java.time.LocalDateTime
import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
@Table(name = "tb_diarias")
data class Diarias(
    @field:Id @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,
    @NotNull
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    var dataEntrada: LocalDateTime,
    @NotNull
    var qtdDias: Int,
    @NotNull
    val precoDiaria: BigDecimal
)
