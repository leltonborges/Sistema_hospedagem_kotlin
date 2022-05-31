package dev.project.reservahotel.mapper

import dev.project.reservahotel.dtos.EnderecoDTO
import dev.project.reservahotel.dtos.TelefoneDTO
import dev.project.reservahotel.entities.Endereco
import dev.project.reservahotel.entities.Telefone

fun Endereco.parseDTO(enderecoDTO: EnderecoDTO){
    this.logradouro = enderecoDTO.logradouro
    this.cidade = enderecoDTO.cidade
    this.numero = enderecoDTO.numero
}

fun Telefone.parseDTO(telefoneDTO: TelefoneDTO){
    this.numero = telefoneDTO.numero
    this.ddd = telefoneDTO.ddd
}
