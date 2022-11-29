package ru.micro.common

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class CommonApplication

fun main(args: Array<String>) {
    runApplication<CommonApplication>(*args)
}

@RestController
@RequestMapping("")
class CommonApplicationWeb {
    @GetMapping("/two")
    fun test() = MessageResponse()
}

data class MessageResponse(
    val message: String = "не буду я тебя ведать!!!!",
    val boris: Pepe = Pepe()
)

data class Pepe(
    val boris: String = "boris",
    val boris1: String = "boris1",
    val boris3: String = "boris2",
    val boris4: String = "boris3",
)
