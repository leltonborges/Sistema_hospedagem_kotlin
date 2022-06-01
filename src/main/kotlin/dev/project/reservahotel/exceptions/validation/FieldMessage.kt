package dev.project.reservahotel.exceptions.validation

import java.io.Serializable

data class FieldMessage(
    val fieldName: String,
    val message: String?
): Serializable