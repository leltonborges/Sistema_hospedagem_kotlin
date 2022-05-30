package dev.project.reservahotel.services

import dev.project.reservahotel.entities.Telefone
import dev.project.reservahotel.exceptions.NotFoundException
import dev.project.reservahotel.repositories.TelefoneRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class TelefoneService(
    private val telefoneRepository: TelefoneRepository
) {

    fun findAll(pageable: Pageable): Page<Telefone> {
        return this.telefoneRepository.findAll(pageable)
    }

    fun findById(id: Long): Telefone {
        return this.telefoneRepository
            .findById(id)
            .orElseThrow { NotFoundException("Not found telefone: $id", NotFoundException()) }
    }

    fun save(telefone: Telefone): Long{
        return this.telefoneRepository.save(telefone).id;
    }

    fun delete(id: Long): Unit {
        val telefone = this.findById(id)
        return this.telefoneRepository.delete(telefone);
    }
}