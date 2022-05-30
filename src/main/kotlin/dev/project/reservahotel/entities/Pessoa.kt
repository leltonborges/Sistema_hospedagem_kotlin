package dev.project.reservahotel.entities

import java.io.Serializable
import javax.persistence.MappedSuperclass

@MappedSuperclass
abstract class Pessoa(
    open val cpf: Int,
    open val nome: String
): Serializable
