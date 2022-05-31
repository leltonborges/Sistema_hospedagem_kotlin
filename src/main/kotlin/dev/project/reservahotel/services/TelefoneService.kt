package dev.project.reservahotel.services

import dev.project.reservahotel.dtos.TelefoneDTO
import dev.project.reservahotel.entities.Telefone
import dev.project.reservahotel.exceptions.NotFoundException
import dev.project.reservahotel.repositories.TelefoneRepository
import ma.glasnost.orika.MapperFacade
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class TelefoneService(
    private val telefoneRepository: TelefoneRepository,
    private val mapperFacade: MapperFacade
) {

    fun findAll(pageable: Pageable): Page<Telefone> {
        return this.telefoneRepository.findAll(pageable)
    }

    fun findById(id: Long): Telefone {
        return this.telefoneRepository
            .findById(id)
            .orElseThrow { NotFoundException("Not found telefone: $id", NotFoundException()) }
    }

    fun save(telefone: Telefone): Telefone {
        return this.telefoneRepository.save(telefone);
    }

    fun delete(id: Long): Unit {
        val telefone = this.findById(id)
        return this.telefoneRepository.delete(telefone);
    }

    fun update(id: Long, telefoneDTO: TelefoneDTO): Telefone {
        val entity = this.findById(id)
        this.mapperFacade.map(telefoneDTO, entity)
        return this.telefoneRepository.save(entity)
    }
}