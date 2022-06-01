package dev.project.reservahotel.services

import dev.project.reservahotel.dtos.QuartoDTO
import dev.project.reservahotel.entities.Quarto
import dev.project.reservahotel.exceptions.NotFoundException
import dev.project.reservahotel.repositories.QuartoRepository
import ma.glasnost.orika.MapperFacade
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class QuartoService(
    private val quartoRepository: QuartoRepository,
    private val mapperFacade: MapperFacade
) {

    fun findAll(pageable: Pageable): Page<Quarto> {
        return this.quartoRepository.findAll(pageable)
    }

    fun findById(id: Long): Quarto {
        return this.quartoRepository
            .findById(id)
            .orElseThrow { NotFoundException("Not found quarto: $id", NotFoundException()) }
    }

    fun save(entity: Quarto): Quarto{
        return this.quartoRepository.save(entity)
    }

    fun delete(id: Long): Unit {
        val entity = this.findById(id)
        return this.quartoRepository.delete(entity);
    }

    fun update(id: Long, dto: QuartoDTO): Quarto {
        val entity = this.findById(id)
        this.mapperFacade.map(dto, entity)
        return this.save(entity)
    }
}