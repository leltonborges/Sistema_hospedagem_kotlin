package dev.project.reservahotel.services

import dev.project.reservahotel.dtos.EnderecoDTO
import dev.project.reservahotel.entities.Endereco
import dev.project.reservahotel.exceptions.NotFoundException
import dev.project.reservahotel.repositories.EnderecoRepository
import ma.glasnost.orika.BoundMapperFacade
import ma.glasnost.orika.MapperFacade
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class EnderecoService(
    private val enderecoRepository: EnderecoRepository,
    private val mapperFacade: MapperFacade
) {

    fun findAll(pageable: Pageable): Page<Endereco> {
        return this.enderecoRepository.findAll(pageable)
    }

    fun findById(id: Long): Endereco {
        return this.enderecoRepository
            .findById(id)
            .orElseThrow { NotFoundException("Not found endereco: $id", NotFoundException()) }
    }

    fun save(entity: Endereco): Endereco {
        return this.enderecoRepository.save(entity)
    }

    fun delete(id: Long) {
        val entity = this.findById(id)
        this.enderecoRepository.delete(entity);
    }

    fun update(id: Long, enderecoDTO: EnderecoDTO): Endereco {
        val entity = this.findById(id)
        this.mapperFacade.map(enderecoDTO, entity)
        return this.save(entity)
    }
}