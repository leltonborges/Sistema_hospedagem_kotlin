package dev.project.reservahotel.exceptions.handler

import com.fasterxml.jackson.module.kotlin.MissingKotlinParameterException
import dev.project.reservahotel.exceptions.NotFoundException
import dev.project.reservahotel.exceptions.validation.FieldMessage
import dev.project.reservahotel.exceptions.validation.ValidationError
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import javax.servlet.http.HttpServletRequest

@RestControllerAdvice
class ExceptionHandler {

    @ExceptionHandler(NotFoundException::class)
    fun handleNotFound(ex: NotFoundException, request: HttpServletRequest): ResponseEntity<StandardError> {
        val status = HttpStatus.NOT_FOUND.value()
        val error = StandardError("Not found", ex.message, status, request.requestURI)
        return ResponseEntity.status(status).body(error);
    }


    @ExceptionHandler(DataIntegrityViolationException::class)
    fun handleDataIntegrity(
        ex: DataIntegrityViolationException,
        request: HttpServletRequest
    ): ResponseEntity<StandardError> {
        val status = HttpStatus.BAD_REQUEST.value()
        val error = StandardError("Data integrity", ex.message, status, request.requestURI)
        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleFieldValidArgument(
        ex: MethodArgumentNotValidException,
        request: HttpServletRequest
    ): ResponseEntity<ValidationError> {
        val status = HttpStatus.UNPROCESSABLE_ENTITY.value()
        val fields: MutableList<FieldMessage> = mutableListOf()
        for (fieldError in ex.bindingResult.fieldErrors) {
            fields.add(FieldMessage(fieldError.field, fieldError.defaultMessage))
        }

        val validationError = ValidationError("Error validation", ex.message, status, request.requestURI, fields)

        return ResponseEntity.status(status).body(validationError)
    }

    @ExceptionHandler(MissingKotlinParameterException::class)
    fun handleValidation(ex: MissingKotlinParameterException, request: HttpServletRequest): ResponseEntity<StandardError> {
        val status = HttpStatus.NOT_FOUND.value()
        val error = StandardError(
            "Not present", "'${ex.parameter.name}' require ${ex.parameter.type}",
            status, request.requestURI)
        return ResponseEntity.status(status).body(error);
    }
}
