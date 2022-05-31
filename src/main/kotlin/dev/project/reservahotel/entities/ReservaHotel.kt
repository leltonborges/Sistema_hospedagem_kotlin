package dev.project.reservahotel.entities

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "tb_reserva_hotel")
data class ReservaHotel(
    @field:Id @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    val criacaoReserva: LocalDateTime,
    @field:OneToOne
    var hotel: Hotel,
    @field:OneToOne
    var diarias: Diarias
)
