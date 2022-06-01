package dev.project.reservahotel.repositories

import dev.project.reservahotel.entities.Telefone
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TelefoneRepository: JpaRepository<Telefone, Long>