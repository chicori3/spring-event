package toy.sian.spring.event.user.domain

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import toy.sian.spring.event.common.BaseEntity

@Entity
class UserLoginHistory(
    id: Long = 0,
    userId: Long,
) : BaseEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id = id
        protected set

    var userId = userId
        protected set
}
