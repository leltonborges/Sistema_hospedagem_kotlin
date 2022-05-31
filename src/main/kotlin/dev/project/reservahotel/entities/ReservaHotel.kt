package dev.project.reservahotel.entities

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "tb_reserva_hotel")
data class ReservaHotel(
    @field:Id @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,
    val criacaoReserva: LocalDateTime,
    @field:OneToOne
    val hotel: Hotel,
    @field:OneToOne
    val diarias: Diarias
)
