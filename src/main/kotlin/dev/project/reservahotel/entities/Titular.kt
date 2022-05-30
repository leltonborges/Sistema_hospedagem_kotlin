package dev.project.reservahotel.entities

import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name = "tb_titular")
data class Titular(
    @field:Id @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val emal: String,
    override val nome: String,
    override val cpf: Int
): Pessoa(cpf, nome), Serializable
