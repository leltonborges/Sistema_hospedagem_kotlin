package dev.project.reservahotel.dtos

import javax.validation.constraints.NotNull

data class TelefoneDTO(
    @NotNull
    val numero: Int,
    @NotNull
    val ddd: Int
)
