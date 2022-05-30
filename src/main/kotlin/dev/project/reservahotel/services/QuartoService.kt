package dev.project.reservahotel.services

import dev.project.reservahotel.entities.Quarto
import dev.project.reservahotel.exceptions.NotFoundException
import dev.project.reservahotel.repositories.QuartoRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class QuartoService(
    private val quartoRepository: QuartoRepository
) {

    fun findAll(pageable: Pageable): Page<Quarto> {
        return this.quartoRepository.findAll(pageable)
    }

    fun findById(id: Long): Quarto {
        return this.quartoRepository
            .findById(id)
            .orElseThrow { NotFoundException("Not found quarto: $id", NotFoundException()) }
    }

    fun save(entity: Quarto): Long{
        return this.quartoRepository.save(entity).id;
    }

    fun delete(id: Long): Unit {
        val entity = this.findById(id)
        return this.quartoRepository.delete(entity);
    }
}