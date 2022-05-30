package dev.project.reservahotel.entities

import javax.persistence.*

@Entity
@Table(name = "tb_hotel")
data class Hotel(
    @field:Id @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    @field:OneToOne
    val endereco: Endereco,
    @field:OneToMany(fetch = FetchType.EAGER, cascade = [CascadeType.ALL])
    val quartos: List<Quarto>,
)
