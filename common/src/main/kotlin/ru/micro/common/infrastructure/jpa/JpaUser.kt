package ru.micro.common.infrastructure.jpa

import org.hibernate.annotations.NaturalId
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "users_table")
class JpaUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    var id: UUID? = null

    @NaturalId
    @Column(unique = true)
    var name: String = ""

    @Column(unique = true)
    var email: String = ""

    @Column
    var description: String = ""

    @Column
    var photoUrl: String? = null
}
