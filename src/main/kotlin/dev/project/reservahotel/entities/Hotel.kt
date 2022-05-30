package dev.project.reservahotel.entities

import javax.persistence.*

@Entity
@Table(name = "tb_hotel")
data class Hotel(
    @field:Id @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    @field:OneToOne
    val endereco: Endereco,

    @field:JoinTable(
        name = "TB_HOTEL_QUARTO",
        joinColumns = [JoinColumn(name = "HOTEL_ID", referencedColumnName = "ID")],
        inverseJoinColumns = [JoinColumn(name = "QUARTO_ID", referencedColumnName = "id")]
    )
    @field:OneToMany(fetch = FetchType.EAGER, cascade = [CascadeType.ALL])
    val quartos: List<Quarto>,
)
