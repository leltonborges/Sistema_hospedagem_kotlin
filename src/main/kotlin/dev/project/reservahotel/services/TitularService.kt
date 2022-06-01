package dev.project.reservahotel.services

import dev.project.reservahotel.dtos.TitularSaveDTO
import dev.project.reservahotel.dtos.TitularUpdateDTO
import dev.project.reservahotel.entities.Pessoa
import dev.project.reservahotel.entities.Titular
import dev.project.reservahotel.exceptions.NotFoundException
import dev.project.reservahotel.repositories.TitularRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class TitularService(
    private val titularRepository: TitularRepository,
    private val telefoneService: TelefoneService,
    private val enderecoService: EnderecoService,
    private val reservaHotelService: ReservaHotelService
) {

    fun findAll(pageable: Pageable): Page<Titular> {
        return this.titularRepository.findAll(pageable)
    }

    fun findById(id: Long): Titular {
        return this.titularRepository
            .findById(id)
            .orElseThrow { NotFoundException("Not found titular: $id", NotFoundException()) }
    }

    fun save(entity: Titular): Titular{
        return this.titularRepository.save(entity)
    }

    fun save(dto: TitularSaveDTO): Titular{
        val pessoa = Pessoa(
            nome = dto.pessoa.nome,
            cpf = dto.pessoa.cpf,
            enderecos = dto.pessoa.enderecos.map { i -> enderecoService.findById(i) },
            telefones = dto.pessoa.telefones.map { i -> telefoneService.findById(i) }
        )

        val entity = Titular(
            id = null,
            email = dto.email,
            pessoa = pessoa,
            reservaHotel = reservaHotelService.findById(dto.id_reserva)
        )

        return this.save(entity)
    }

    fun delete(id: Long): Unit {
        val telefone = this.findById(id)
        return this.titularRepository.delete(telefone);
    }

    fun update(id: Long, dto: TitularUpdateDTO): Titular {
        val entity = this.findById(id)
        val enderecos = dto.pessoa.enderecos.map { this.enderecoService.findById(it) }
        val telefones = dto.pessoa.telefones.map { this.telefoneService.findById(it) }

        entity.apply {
            email = dto.email
            pessoa.enderecos = enderecos
            pessoa.telefones = telefones
        }

        return this.save(entity)
    }
}