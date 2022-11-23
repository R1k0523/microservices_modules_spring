package ru.micro.common.infrastructure.mappers

import ru.micro.common.domain.entity.User
import ru.micro.common.infrastructure.jpa.JpaUser

fun User.toJpa() = JpaUser().also {
    it.id = id
    it.name = name
    it.description = description
    it.email = email
    it.photoUrl = photoUrl
}

fun JpaUser.toModel() = User().also {
    it.id = id
    it.name = name
    it.description = description
    it.email = email
    it.photoUrl = photoUrl
}
