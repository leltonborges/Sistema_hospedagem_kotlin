package dev.project.reservahotel.dtos

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDateTime
import javax.validation.constraints.NotNull

data class DiariasDTO(
    @NotNull
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    val dataEntrada: LocalDateTime,
    @NotNull
    val qtdDias: Int,
)
