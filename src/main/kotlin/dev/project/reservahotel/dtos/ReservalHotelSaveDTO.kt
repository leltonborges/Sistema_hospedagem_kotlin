package dev.project.reservahotel.dtos

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDateTime
import javax.validation.constraints.NotNull

data class ReservalHotelSaveDTO(
    @NotNull
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    val criacaoReserva: LocalDateTime,
    @NotNull
    val id_hotel: Long,
    @NotNull
    val id_diarias: Long
)
