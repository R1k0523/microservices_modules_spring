package ru.micro.common.application.controller

import org.apache.coyote.Response
import org.springframework.web.bind.annotation.*
import ru.micro.common.application.dto.ListResponse
import ru.micro.common.application.dto.MessageResponse
import ru.micro.common.domain.base.CustomException
import ru.micro.common.domain.entity.User
import ru.micro.common.domain.service.UserService
import java.util.*

@RestController
@RequestMapping("user")
class UserController(val service: UserService) {

    @PostMapping
    fun add(
        @RequestBody dto: User
    ): User? {
        try {
            return service.add(dto)
        } catch (e: Exception) {
            throw CustomException.InvalidCreds
        }
    }
    @RequestMapping(method = [RequestMethod.PATCH, RequestMethod.PUT])
    fun update(
        @RequestBody dto: User)
    : User? {
        try {
            return service.update(dto)
        } catch (e: Exception) {
            throw CustomException.NotFound
        }

    }
    @DeleteMapping("/{id}")
    fun delete(
        @PathVariable id: UUID
    ): MessageResponse {
        try {
            service.delete(id)
            return MessageResponse("Запись удалена")
        } catch (e: Exception) {
            throw CustomException.NotFound
        }
    }


    @GetMapping
    fun get(): ListResponse<User> = ListResponse(service.get())

    @GetMapping("/{id}")
    fun get(@PathVariable id: UUID): User =
        service.get(id) ?: throw CustomException.NotFound

    @ExceptionHandler(CustomException::class)
    fun handleException(e: CustomException): Response? {
        return Response().apply {
            message = e.reason
            status = e.rawStatusCode
        }
    }

    @GetMapping("gen") //TO DELETE
    fun genUser(): User? = add(User.random())
}
