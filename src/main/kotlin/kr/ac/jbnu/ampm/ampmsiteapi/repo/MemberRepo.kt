package kr.ac.jbnu.ampm.ampmsiteapi.repo

import kr.ac.jbnu.ampm.ampmsiteapi.entity.MemberEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface MemberRepo : JpaRepository<MemberEntity, Long?> {
}