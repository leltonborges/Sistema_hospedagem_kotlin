package dev.project.reservahotel.resources

import dev.project.reservahotel.dtos.TitularSaveDTO
import dev.project.reservahotel.dtos.TitularUpdateDTO
import dev.project.reservahotel.entities.Titular
import dev.project.reservahotel.services.TitularService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/titular")
class TitularResource(
    private val titularService: TitularService
) {

    @GetMapping
    fun findAll(
        @PageableDefault pageable: Pageable
    ): ResponseEntity<Page<Titular>> {
        return ResponseEntity.ok(this.titularService.findAll(pageable))
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<Titular> {
        return ResponseEntity.ok(this.titularService.findById(id))
    }

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable id: Long): ResponseEntity<Void> {
        this.titularService.delete(id)
        return ResponseEntity.noContent().build()
    }

    @PutMapping("/{id}")
    fun updateById(
        @PathVariable id: Long,
        @RequestBody dto: TitularUpdateDTO
    ): ResponseEntity<Titular> {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.titularService.update(id, dto))
    }

    @PostMapping
    fun save(@RequestBody @Valid entity: TitularSaveDTO): ResponseEntity<Titular> {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.titularService.save(entity))
    }
}