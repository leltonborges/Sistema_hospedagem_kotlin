package dev.project.reservahotel.repositories

import dev.project.reservahotel.entities.Titular
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TitularRepository: JpaRepository<Titular, Long>