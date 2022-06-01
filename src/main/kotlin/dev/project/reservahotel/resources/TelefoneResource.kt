package dev.project.reservahotel.resources

import dev.project.reservahotel.dtos.TelefoneDTO
import dev.project.reservahotel.entities.Telefone
import dev.project.reservahotel.services.TelefoneService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/telefone")
class TelefoneResource(
    private val telefoneService: TelefoneService
) {

    @GetMapping
    fun findAll(
        @PageableDefault pageable: Pageable
    ): ResponseEntity<Page<Telefone>> {
        return ResponseEntity.ok(this.telefoneService.findAll(pageable))
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<Telefone> {
        return ResponseEntity.ok(this.telefoneService.findById(id))
    }

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable id: Long): ResponseEntity<Void> {
        this.telefoneService.delete(id)
        return ResponseEntity.noContent().build()
    }

    @PutMapping("/{id}")
    fun updateById(
        @PathVariable id: Long,
        @RequestBody @Valid telefoneDTO: TelefoneDTO
    ): ResponseEntity<Telefone> {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.telefoneService.update(id, telefoneDTO))
    }

    @PostMapping
    fun save(@RequestBody @Valid entity: Telefone): ResponseEntity<Telefone> {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.telefoneService.save(entity))
    }
}