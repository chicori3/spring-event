package toy.sian.spring.event.history.domain

import org.springframework.data.jpa.repository.JpaRepository

interface UserActivityHistoryRepository : JpaRepository<UserActivityHistory, Long>
