package dev.project.reservahotel.dtos

import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

data class PessoaSaveDTO(
    @NotBlank
    val nome: String,
    @NotNull
    val cpf: Int,
    @NotNull
    val enderecos: LongArray,
    @NotNull
    val telefones: LongArray
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as PessoaSaveDTO

        if (nome != other.nome) return false
        if (cpf != other.cpf) return false
        if (!enderecos.contentEquals(other.enderecos)) return false
        if (!telefones.contentEquals(other.telefones)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = nome.hashCode()
        result = 31 * result + cpf
        result = 31 * result + enderecos.contentHashCode()
        result = 31 * result + telefones.contentHashCode()
        return result
    }
}
