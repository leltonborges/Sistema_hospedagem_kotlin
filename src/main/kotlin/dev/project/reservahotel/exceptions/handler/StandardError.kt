package dev.project.reservahotel.exceptions.handler

import java.io.Serializable

open class StandardError(
    open val error: String,
    open val msg: String?,
    open val status: Int,
    open val uri: String,
    val timestamp: Long = System.currentTimeMillis()
): Serializable