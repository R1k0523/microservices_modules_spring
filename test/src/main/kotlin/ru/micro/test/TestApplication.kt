package ru.micro.test

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class TestApplication

fun main(args: Array<String>) {
    runApplication<TestApplication>(*args)
}

@RestController
@RequestMapping("")
class TestApplicationWeb {
    @GetMapping("/one")
    fun test1() = MessageResponse()
}

data class MessageResponse(
    val bald_white: String = "ЛАПТА",
    val pepos: Pepe = Pepe()

)
data class Pepe(
    val arre: String = "arre",
    val arre1: String = "arre1",
    val arre23: String = "arre2",
    val arre4: String = "arre3",
    val arre5: String = "arre4"
)

