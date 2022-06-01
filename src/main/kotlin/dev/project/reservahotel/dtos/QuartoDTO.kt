package dev.project.reservahotel.dtos

import javax.validation.constraints.NotNull

data class QuartoDTO(
    @NotNull
    val qtdCama: Int
)
