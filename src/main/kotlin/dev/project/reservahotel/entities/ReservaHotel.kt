package dev.project.reservahotel.entities

import com.fasterxml.jackson.annotation.JsonFormat
import io.swagger.v3.oas.annotations.Hidden
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "tb_reserva_hotel")
data class ReservaHotel(
    @Hidden
    @field:Id
    @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    val criacaoReserva: LocalDateTime,
    @field:OneToOne
    var hotel: Hotel,
    @field:OneToOne
    var diarias: Diarias
)
