package dev.project.reservahotel.repositories

import dev.project.reservahotel.entities.Endereco
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface EnderecoRepository: JpaRepository<Endereco, Long>