package dev.project.reservahotel.dtos

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDateTime

data class ReservalHotelSaveDTO(
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    val criacaoReserva: LocalDateTime,
    val id_hotel: Long,
    val id_diarias: Long
)
