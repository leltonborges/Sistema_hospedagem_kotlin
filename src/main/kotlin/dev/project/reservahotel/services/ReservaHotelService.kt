package dev.project.reservahotel.services

import dev.project.reservahotel.dtos.ReservaUpdateDTO
import dev.project.reservahotel.dtos.ReservalHotelSaveDTO
import dev.project.reservahotel.entities.ReservaHotel
import dev.project.reservahotel.exceptions.NotFoundException
import dev.project.reservahotel.repositories.ReservaHotelRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class ReservaHotelService(
    private val reservaHotelRepository: ReservaHotelRepository,
    private val hotelService: HotelService,
    private val diariasService: DiariasService
) {

    fun findAll(pageable: Pageable): Page<ReservaHotel> {
        return this.reservaHotelRepository.findAll(pageable)
    }

    fun findById(id: Long): ReservaHotel {
        return this.reservaHotelRepository
            .findById(id)
            .orElseThrow { NotFoundException("Not found reservaHotel: $id", NotFoundException()) }
    }

    fun save(entity: ReservaHotel): ReservaHotel {
        return this.reservaHotelRepository.save(entity);
    }

    fun save(dto: ReservalHotelSaveDTO): ReservaHotel {
        val reservaHotel = parserNewReservaHotel(dto)
        return this.save(reservaHotel);
    }

    fun delete(id: Long): Unit {
        val entity = this.findById(id)
        return this.reservaHotelRepository.delete(entity);
    }


    fun update(id: Long, dto: ReservaUpdateDTO): ReservaHotel {
        val entity = this.findById(id)
        val hotel = this.hotelService.findById(dto.id_hotel)
        val diarias = this.diariasService.findById(dto.id_diarias)

        entity.apply {
            this.hotel = hotel
            this.diarias = diarias
        }

        return this.save(entity)
    }

    private fun parserNewReservaHotel(reservalHotelSaveDTO: ReservalHotelSaveDTO): ReservaHotel {
        return ReservaHotel(
            id = null,
            criacaoReserva = reservalHotelSaveDTO.criacaoReserva,
            hotel = hotelService.findById(reservalHotelSaveDTO.id_hotel),
            diarias = diariasService.findById(reservalHotelSaveDTO.id_diarias)
        )
    }
}
