package dev.project.reservahotel.entities

import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name = "tb_titular")
data class Titular(
    @field:Id @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,
    var email: String,
    @Embedded
    val pessoa: Pessoa,
    @field:JoinColumn(name = "ID_RESERVA")
    @field:OneToOne
    val reservaHotel: ReservaHotel
): Serializable
