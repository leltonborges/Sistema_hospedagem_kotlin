package dev.project.reservahotel.resources

import dev.project.reservahotel.dtos.DiariasDTO
import dev.project.reservahotel.entities.Diarias
import dev.project.reservahotel.services.DiariasService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping(
    value = ["/diaria"],
    consumes = [MediaType.APPLICATION_JSON_VALUE],
    produces = [MediaType.APPLICATION_JSON_VALUE]
)
class DiariasResource(
    private val diariasService: DiariasService
) {

    @GetMapping
    fun findAll(
        @PageableDefault pageable: Pageable
    ): ResponseEntity<Page<Diarias>> {
        return ResponseEntity.ok(this.diariasService.findAll(pageable))
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<Diarias> {
        return ResponseEntity.ok(this.diariasService.findById(id))
    }

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable id: Long): ResponseEntity<Void> {
        this.diariasService.delete(id)
        return ResponseEntity.noContent().build()
    }

    @PutMapping("/{id}")
    fun updateById(
        @PathVariable id: Long,
        @RequestBody @Valid dto: DiariasDTO
    ): ResponseEntity<Diarias> {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.diariasService.update(id, dto))
    }

    @PostMapping
    fun save(@RequestBody @Valid entity: Diarias): ResponseEntity<Diarias> {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.diariasService.save(entity))
    }
}