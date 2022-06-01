package dev.project.reservahotel.resources

import dev.project.reservahotel.dtos.HotelSaveDTO
import dev.project.reservahotel.dtos.HotelUpdateDTO
import dev.project.reservahotel.entities.Hotel
import dev.project.reservahotel.services.HotelService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/hotel")
class HotelResource(
    private val hotelService: HotelService
) {

    @GetMapping
    fun findAll(
        @PageableDefault pageable: Pageable
    ): ResponseEntity<Page<Hotel>> {
        return ResponseEntity.ok(this.hotelService.findAll(pageable))
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<Hotel> {
        return ResponseEntity.ok(this.hotelService.findById(id))
    }

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable id: Long): ResponseEntity<Void> {
        this.hotelService.delete(id)
        return ResponseEntity.noContent().build()
    }

    @PutMapping("/{id}")
    fun updateById(
        @PathVariable id: Long,
        @RequestBody dto: HotelUpdateDTO
    ): ResponseEntity<Hotel> {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.hotelService.update(id, dto))
    }

    @PostMapping
    fun save(@RequestBody @Valid entity: HotelSaveDTO): ResponseEntity<Hotel> {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.hotelService.save(entity))
    }
}