package dev.project.reservahotel.resources

import dev.project.reservahotel.dtos.QuartoDTO
import dev.project.reservahotel.entities.Quarto
import dev.project.reservahotel.services.QuartoService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/quarto")
class QuartoResource(
    private val quartoService: QuartoService
) {

    @GetMapping
    fun findAll(
        @PageableDefault pageable: Pageable
    ): ResponseEntity<Page<Quarto>> {
        return ResponseEntity.ok(this.quartoService.findAll(pageable))
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<Quarto> {
        return ResponseEntity.ok(this.quartoService.findById(id))
    }

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable id: Long): ResponseEntity<Void> {
        this.quartoService.delete(id)
        return ResponseEntity.noContent().build()
    }

    @PutMapping("/{id}")
    fun updateById(
        @PathVariable id: Long,
        @RequestBody dto: QuartoDTO
    ): ResponseEntity<Quarto> {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.quartoService.update(id, dto))
    }

    @PostMapping
    fun save(@RequestBody @Valid entity: Quarto): ResponseEntity<Quarto> {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.quartoService.save(entity))
    }
}