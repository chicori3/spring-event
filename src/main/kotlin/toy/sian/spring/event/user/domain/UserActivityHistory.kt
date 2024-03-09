package toy.sian.spring.event.user.domain

import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import toy.sian.spring.event.common.BaseEntity

@Entity
class UserActivityHistory(
    id: Long = 0,
    userId: Long,
    type: ActivityType,
) : BaseEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id = id
        protected set

    var userId = userId
        protected set

    @Enumerated(EnumType.STRING)
    var type = type
        protected set

    enum class ActivityType {
        SIGN_IN, SIGN_OUT
    }
}
