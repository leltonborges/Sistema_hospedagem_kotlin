package dev.project.reservahotel.services

import dev.project.reservahotel.entities.Endereco
import dev.project.reservahotel.exceptions.NotFoundException
import dev.project.reservahotel.repositories.EnderecoRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class EnderecoService(
    private val enderecoRepository: EnderecoRepository
) {

    fun findAll(pageable: Pageable): Page<Endereco> {
        return this.enderecoRepository.findAll(pageable)
    }

    fun findById(id: Long): Endereco {
        return this.enderecoRepository
            .findById(id)
            .orElseThrow { NotFoundException("Not found endereco: $id", NotFoundException()) }
    }

    fun save(entity: Endereco): Long{
        return this.enderecoRepository.save(entity).id;
    }

    fun delete(id: Long): Unit {
        val entity = this.findById(id)
        return this.enderecoRepository.delete(entity);
    }
}