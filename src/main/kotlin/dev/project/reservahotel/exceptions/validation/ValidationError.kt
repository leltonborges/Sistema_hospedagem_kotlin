package dev.project.reservahotel.exceptions.validation

import dev.project.reservahotel.exceptions.handler.StandardError
import java.io.Serializable

data class ValidationError(
    override val error: String,
    override val msg: String?,
    override val status: Int,
    override val uri: String,
    val fields: List<FieldMessage>
): StandardError(error, msg, status, uri), Serializable
