package toy.sian.spring.event.user.domain

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import toy.sian.spring.event.common.BaseEntity
import java.time.Instant

@Entity
class User(
    id: Long = 0,
    email: String,
    nickname: String,
    status: Status = Status.ACTIVE,
) : BaseEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id = id
        protected set

    var email = email
        protected set

    var nickname = nickname
        protected set

    var status = status
        protected set

    enum class Status {
        ACTIVE, INACTIVE
    }

    fun register(email: String, nickname: String) {
        raise(
            UserRegistered(
                email = email,
                nickname = nickname,
                createdAt = createdAt ?: Instant.now(),
            ),
        )
    }
}
