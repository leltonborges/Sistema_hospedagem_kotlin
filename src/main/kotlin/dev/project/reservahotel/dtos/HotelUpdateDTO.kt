package dev.project.reservahotel.dtos

import javax.validation.constraints.NotBlank

data class HotelUpdateDTO(
    @NotBlank
    val nome: String
)
