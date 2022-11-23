package ru.micro.common.domain.service

import org.springframework.stereotype.Service
import ru.micro.common.domain.base.BaseService
import ru.micro.common.domain.entity.User
import ru.micro.common.infrastructure.jpa.JpaUser
import ru.micro.common.infrastructure.mappers.toJpa
import ru.micro.common.infrastructure.mappers.toModel
import ru.micro.common.infrastructure.repository.UserRepo
import java.util.*

@Service
class UserService(repo: UserRepo) : BaseService<User, JpaUser, UUID>(repo) {
    override fun toJpa(dto: User): JpaUser? = dto.toJpa()
    override fun toDto(jpa: JpaUser?): User? = jpa?.toModel()
    override fun getId(dto: User): UUID? = dto.id
}
