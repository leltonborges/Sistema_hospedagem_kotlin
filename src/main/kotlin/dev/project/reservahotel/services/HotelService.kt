package dev.project.reservahotel.services

import dev.project.reservahotel.entities.Hotel
import dev.project.reservahotel.exceptions.NotFoundException
import dev.project.reservahotel.repositories.HotelRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class HotelService(
    private val hotelRepository: HotelRepository
) {

    fun findAll(pageable: Pageable): Page<Hotel> {
        return this.hotelRepository.findAll(pageable)
    }

    fun findById(id: Long): Hotel {
        return this.hotelRepository
            .findById(id)
            .orElseThrow { NotFoundException("Not found hotel: $id", NotFoundException()) }
    }

    fun save(entity: Hotel): Long{
        return this.hotelRepository.save(entity).id;
    }

    fun delete(id: Long): Unit {
        val entity = this.findById(id)
        return this.hotelRepository.delete(entity);
    }
}