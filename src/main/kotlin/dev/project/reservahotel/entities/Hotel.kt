package dev.project.reservahotel.entities

import javax.persistence.*

@Entity
@Table(name = "tb_hotel")
data class Hotel(
    @field:Id @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Long,
    @field:OneToOne
    private val endereco: Endereco,
    @field:OneToMany(fetch = FetchType.EAGER, cascade = [CascadeType.ALL])
    private val quartos: List<Quarto>,
)
