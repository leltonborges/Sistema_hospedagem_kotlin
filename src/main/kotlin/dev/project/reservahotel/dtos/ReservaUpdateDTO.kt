package dev.project.reservahotel.dtos

import javax.validation.constraints.NotNull

data class ReservaUpdateDTO(
    @NotNull
    val id_hotel: Long,
    @NotNull
    val id_diarias: Long
)
