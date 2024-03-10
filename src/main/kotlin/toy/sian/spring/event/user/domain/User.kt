package toy.sian.spring.event.user.domain

import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import toy.sian.spring.event.common.BaseEntity

@Entity
@Table(name = "users")
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

    @Enumerated(EnumType.STRING)
    var status = status
        protected set

    enum class Status {
        ACTIVE, INACTIVE
    }
}
