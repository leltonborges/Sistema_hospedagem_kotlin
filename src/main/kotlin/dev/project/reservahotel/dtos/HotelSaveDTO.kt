package dev.project.reservahotel.dtos


data class HotelSaveDTO(
    val nome: String,
    val id_endereco: Long,
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
