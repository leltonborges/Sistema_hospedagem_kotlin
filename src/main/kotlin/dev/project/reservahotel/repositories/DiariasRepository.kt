package dev.project.reservahotel.repositories

import dev.project.reservahotel.entities.Diarias
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface DiariasRepository: JpaRepository<Diarias, Long>