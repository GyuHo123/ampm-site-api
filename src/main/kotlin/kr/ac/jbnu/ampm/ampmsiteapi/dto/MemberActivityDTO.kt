package kr.ac.jbnu.ampm.ampmsiteapi.dto

import kr.ac.jbnu.ampm.ampmsiteapi.entity.MemberActivityEntity

data class MemberActivityDTO(
    var id: Long?,
    var name: String,
    var email: String,
    var studentNum: Long?,
    var bio: String,
    var interest: String,
    var status: Int?,
    var applyStatus : Int?
)
fun MemberActivityDTO.toEntity() = MemberActivityEntity(id, name, email, studentNum, bio, interest, status, applyStatus)