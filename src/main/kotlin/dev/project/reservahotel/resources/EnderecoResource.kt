package dev.project.reservahotel.resources

import dev.project.reservahotel.dtos.EnderecoDTO
import dev.project.reservahotel.entities.Endereco
import dev.project.reservahotel.services.EnderecoService
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
@RequestMapping("/endereco")
class EnderecoResource(
    private val enderecoService: EnderecoService
) {

    @GetMapping
    fun findAll(
        @PageableDefault pageable: Pageable
    ): ResponseEntity<Page<Endereco>> {
        return ResponseEntity.ok(this.enderecoService.findAll(pageable))
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<Endereco> {
        return ResponseEntity.ok(this.enderecoService.findById(id))
    }

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable id: Long): ResponseEntity<Void> {
        this.enderecoService.delete(id)
        return ResponseEntity.noContent().build()
    }

    @PutMapping("/{id}")
    fun updateById(
        @PathVariable id: Long,
        @RequestBody @Valid enderecoDTO: EnderecoDTO
    ): ResponseEntity<Endereco> {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.enderecoService.update(id, enderecoDTO))
    }

    @PostMapping
    fun save(@RequestBody @Valid endereco: Endereco): ResponseEntity<Endereco> {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.enderecoService.save(endereco))
    }
}