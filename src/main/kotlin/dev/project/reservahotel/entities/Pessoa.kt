package dev.project.reservahotel.entities

import java.io.Serializable
import javax.persistence.Embeddable
import javax.persistence.FetchType
import javax.persistence.JoinColumn
import javax.persistence.JoinTable
import javax.persistence.OneToMany

@Embeddable
data class Pessoa(
    val nome: String,
    val cpf: Int,

    @field:JoinTable(
        name = "TB_PESSOA_ENDERECO",
        joinColumns = [JoinColumn(name = "TITULAR_ID", referencedColumnName = "ID")],
        inverseJoinColumns = [JoinColumn(name = "ENDERECO_ID", referencedColumnName = "id")]
    )
    @field:OneToMany(fetch = FetchType.EAGER)
    val enderecos: List<Endereco>,

    @field:JoinTable(
        name = "TB_PESSOA_TELEFONE",
        joinColumns = [JoinColumn(name = "TITULAR_ID", referencedColumnName = "ID")],
        inverseJoinColumns = [JoinColumn(name = "TELEFONE_ID", referencedColumnName = "id")]
    )
    @field:OneToMany
    val telefones: List<Telefone>
) : Serializable
