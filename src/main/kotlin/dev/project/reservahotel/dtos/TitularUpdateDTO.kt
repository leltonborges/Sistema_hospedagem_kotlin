package dev.project.reservahotel.dtos

import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

data class TitularUpdateDTO(
    @NotBlank
    val email: String,
    @NotNull
    val pessoa: PessoaUpdateDTO
)
