package dev.project.reservahotel.resources

import dev.project.reservahotel.dtos.ReservaUpdateDTO
import dev.project.reservahotel.dtos.ReservalHotelSaveDTO
import dev.project.reservahotel.entities.ReservaHotel
import dev.project.reservahotel.services.ReservaHotelService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/reserva")
class ReservaResource(
    private val reservaHotelService: ReservaHotelService
) {

    @GetMapping
    fun findAll(
        @PageableDefault pageable: Pageable
    ): ResponseEntity<Page<ReservaHotel>> {
        return ResponseEntity.ok(this.reservaHotelService.findAll(pageable))
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<ReservaHotel> {
        return ResponseEntity.ok(this.reservaHotelService.findById(id))
    }

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable id: Long): ResponseEntity<Void> {
        this.reservaHotelService.delete(id)
        return ResponseEntity.noContent().build()
    }

    @PutMapping("/{id}")
    fun updateById(
        @PathVariable id: Long,
        @RequestBody dto: ReservaUpdateDTO
    ): ResponseEntity<ReservaHotel> {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.reservaHotelService.update(id, dto))
    }

    @PostMapping
    fun save(@RequestBody @Valid entity: ReservalHotelSaveDTO): ResponseEntity<ReservaHotel> {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.reservaHotelService.save(entity))
    }
}