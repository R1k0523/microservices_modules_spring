package ru.micro.common.infrastructure.repository

import org.springframework.data.jpa.repository.JpaRepository
import ru.micro.common.infrastructure.jpa.JpaUser
import java.util.*

interface UserRepo : JpaRepository<JpaUser, UUID>
