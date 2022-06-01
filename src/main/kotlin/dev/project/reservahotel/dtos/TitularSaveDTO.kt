package dev.project.reservahotel.dtos

data class TitularSaveDTO(
    val email: String,
    val pessoa: PessoaSaveDTO,
    val id_reserva: Long
)
