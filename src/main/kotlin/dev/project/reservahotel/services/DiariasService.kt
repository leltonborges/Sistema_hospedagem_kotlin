package dev.project.reservahotel.services

import dev.project.reservahotel.entities.Diarias
import dev.project.reservahotel.exceptions.NotFoundException
import dev.project.reservahotel.repositories.DiariasRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class DiariasService(
    private val diariasRepository: DiariasRepository
) {

    fun findAll(pageable: Pageable): Page<Diarias> {
        return this.diariasRepository.findAll(pageable)
    }

    fun findById(id: Long): Diarias {
        return this.diariasRepository
            .findById(id)
            .orElseThrow { NotFoundException("Not found diaria: $id", NotFoundException()) }
    }

    fun save(entity: Diarias): Diarias{
        return this.diariasRepository.save(entity);
    }

    fun delete(id: Long): Unit {
        val entity = this.findById(id)
        return this.diariasRepository.delete(entity);
    }
}