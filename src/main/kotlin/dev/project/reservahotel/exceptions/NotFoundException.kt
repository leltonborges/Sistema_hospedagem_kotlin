package dev.project.reservahotel.exceptions

class NotFoundException(msg: String, cause: Throwable?) : RuntimeException(msg, cause){
    constructor() : this("", null)
}