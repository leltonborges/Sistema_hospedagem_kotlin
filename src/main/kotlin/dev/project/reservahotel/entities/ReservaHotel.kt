package dev.project.reservahotel.entities

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "tb_reserva_hotel")
data class ReservaHotel(
    @field:Id @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Long,
    private val criacaoReserva: LocalDateTime,
    @field:OneToOne
    private val hotel: Hotel,
    @field:OneToOne
    private val diarias: Diarias
)
