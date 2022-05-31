package dev.project.reservahotel.services

import dev.project.reservahotel.entities.ReservaHotel
import dev.project.reservahotel.exceptions.NotFoundException
import dev.project.reservahotel.repositories.ReservaHotelRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class ReservaHotelService(
    private val reservaHotelRepository: ReservaHotelRepository
) {

    fun findAll(pageable: Pageable): Page<ReservaHotel> {
        return this.reservaHotelRepository.findAll(pageable)
    }

    fun findById(id: Long): ReservaHotel {
        return this.reservaHotelRepository
            .findById(id)
            .orElseThrow { NotFoundException("Not found reservaHotel: $id", NotFoundException()) }
    }

    fun save(entity: ReservaHotel): ReservaHotel{
        return this.reservaHotelRepository.save(entity);
    }

    fun delete(id: Long): Unit {
        val entity = this.findById(id)
        return this.reservaHotelRepository.delete(entity);
    }
}