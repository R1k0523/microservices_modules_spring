package ru.micro.common.domain.entity

import com.fasterxml.jackson.annotation.JsonInclude
import ru.micro.common.infrastructure.utils.StringUtils
import java.util.*

@JsonInclude(JsonInclude.Include.NON_NULL)
class User(
    var id: UUID? = null,
    var name: String = "",
    var description: String = "",
    var email: String = "",
    var photoUrl: String? = null,
) {
    companion object {
        fun random() = User(
            name = StringUtils.randomString(12),
            description = StringUtils.randomString(25),
            email = "${StringUtils.randomString(10)}@mail.com",
        )

    }
}

