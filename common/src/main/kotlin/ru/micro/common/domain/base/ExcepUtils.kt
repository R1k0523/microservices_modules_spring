package ru.micro.common.domain.base

import org.springframework.http.HttpStatus
import org.springframework.web.server.ResponseStatusException

sealed class CustomException(status: HttpStatus, msg: String): ResponseStatusException(status, msg) {
    object InvalidCreds: CustomException(HttpStatus.UNAUTHORIZED, "Неверные имя пользователя или пароль")
    object NotFound: CustomException(HttpStatus.NOT_FOUND, "Запись не найдена")
    object Forbidden: CustomException(HttpStatus.FORBIDDEN, "Нет доступа")
    object Unauthorized: CustomException(HttpStatus.UNAUTHORIZED, "Токен не валиден")
    object Exists: CustomException(HttpStatus.BAD_REQUEST, "Запись с таким id уже присутствует")
    class Custom(message: String): CustomException(HttpStatus.BAD_REQUEST, message)
}
