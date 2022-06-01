package dev.project.reservahotel.repositories

import dev.project.reservahotel.entities.ReservaHotel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ReservaHotelRepository: JpaRepository<ReservaHotel, Long>