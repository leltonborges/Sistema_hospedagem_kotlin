package dev.project.reservahotel.repositories

import dev.project.reservahotel.entities.Quarto
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface QuartoRepository: JpaRepository<Quarto, Long>