package dev.project.reservahotel.entities

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

@Entity
@Table(name = "tb_endereco")
data class Endereco(
    @field:Id
    @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,
    @field:NotBlank(message = "Não pode esta vazio")
    var logradouro: String,
    @field:NotNull(message = "Não pode ser nulo")
    var numero: Int,
    @field:NotBlank(message = "Não pode esta vazio")
    var cidade: String,
    @field:NotBlank(message = "Não pode esta vazio")
    val estado: String,
    @field:NotNull(message = "Não pode ser nulo")
    var cep: Int
)
