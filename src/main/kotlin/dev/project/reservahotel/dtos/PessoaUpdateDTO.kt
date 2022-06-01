package dev.project.reservahotel.dtos

import javax.validation.constraints.NotNull

data class PessoaUpdateDTO(
    @NotNull
    val enderecos: LongArray,
    @NotNull
    val telefones: LongArray
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as PessoaUpdateDTO

        if (!enderecos.contentEquals(other.enderecos)) return false
        if (!telefones.contentEquals(other.telefones)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = enderecos.contentHashCode()
        result = 31 * result + telefones.contentHashCode()
        return result
    }
}
