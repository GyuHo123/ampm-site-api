package kr.ac.jbnu.ampm.ampmsiteapi.repo

import kr.ac.jbnu.ampm.ampmsiteapi.entity.MemberActivityEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MemberActivityRepo : JpaRepository<MemberActivityEntity, Long?> {
}