package dev.project.reservahotel.services

import dev.project.reservahotel.entities.Titular
import dev.project.reservahotel.exceptions.NotFoundException
import dev.project.reservahotel.repositories.TitularRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class TitularService(
    private val titularRepository: TitularRepository
) {

    fun findAll(pageable: Pageable): Page<Titular> {
        return this.titularRepository.findAll(pageable)
    }

    fun findById(id: Long): Titular {
        return this.titularRepository
            .findById(id)
            .orElseThrow { NotFoundException("Not found titular: $id", NotFoundException()) }
    }

    fun save(telefone: Titular): Long{
        return this.titularRepository.save(telefone).id;
    }

    fun delete(id: Long): Unit {
        val telefone = this.findById(id)
        return this.titularRepository.delete(telefone);
    }
}