package dev.project.reservahotel.dtos

import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull


data class HotelSaveDTO(
    @field:NotBlank
    val nome: String,
    @field:NotNull
    val id_endereco: Long,
    @field:NotNull
    val id_quartos: LongArray
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as HotelSaveDTO

        if (nome != other.nome) return false
        if (id_endereco != other.id_endereco) return false
        if (!id_quartos.contentEquals(other.id_quartos)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = nome.hashCode()
        result = 31 * result + id_endereco.hashCode()
        result = 31 * result + id_quartos.contentHashCode()
        return result
    }
}
