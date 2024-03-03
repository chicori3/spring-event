package toy.sian.spring.event.user.domain

import org.springframework.data.jpa.repository.JpaRepository

interface UserLoginHistoryRepository : JpaRepository<UserLoginHistory, Long>
