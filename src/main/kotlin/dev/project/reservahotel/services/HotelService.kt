package dev.project.reservahotel.services

import dev.project.reservahotel.dtos.HotelSaveDTO
import dev.project.reservahotel.dtos.HotelUpdateDTO
import dev.project.reservahotel.entities.Hotel
import dev.project.reservahotel.entities.Quarto
import dev.project.reservahotel.exceptions.NotFoundException
import dev.project.reservahotel.repositories.HotelRepository
import ma.glasnost.orika.MapperFacade
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class HotelService(
    private val hotelRepository: HotelRepository,
    private val enderecoService: EnderecoService,
    private val quartoService: QuartoService
) {

    fun findAll(pageable: Pageable): Page<Hotel> {
        return this.hotelRepository.findAll(pageable)
    }

    fun findById(id: Long): Hotel {
        return this.hotelRepository
            .findById(id)
            .orElseThrow { NotFoundException("Not found hotel: $id", NotFoundException()) }
    }

    fun save(dto: HotelSaveDTO): Hotel {
        val hotel = Hotel(
            id = null,
            nome = dto.nome,
            endereco = enderecoService.findById(dto.id_endereco),
            quartos = getQuartos(*dto.id_quartos)
        )
        return this.hotelRepository.save(hotel);
    }

    fun save(hotel: Hotel): Hotel {
        return this.hotelRepository.save(hotel);
    }

    fun delete(id: Long): Unit {
        val entity = this.findById(id)
        return this.hotelRepository.delete(entity);
    }

    fun update(id: Long, dto: HotelUpdateDTO): Hotel {
        val entity = this.findById(id)
        entity.apply { this.nome = dto.nome }
        return this.save(entity)
    }

    private fun getQuartos(vararg idQuarto: Long): List<Quarto> {
        return idQuarto.map { id -> quartoService.findById(id) };
    }
}