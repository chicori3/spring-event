package toy.sian.spring.event.history

import org.springframework.data.jpa.repository.JpaRepository

interface UserLoginHistoryRepository : JpaRepository<UserLoginHistory, Long>
