package dev.project.reservahotel.dtos

import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

data class EnderecoDTO(
    @NotBlank
    val logradouro: String,
    @NotNull
    val numero: Int,
    @NotNull
    val cidade: String
)
