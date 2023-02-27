package kr.ac.jbnu.ampm.ampmsiteapi.dto

import kr.ac.jbnu.ampm.ampmsiteapi.entity.MemberEntity

data class MemberDTO(
    var id: Long?,
    var name: String,
    var email: String,
    var studentNum: Long?,
    var bio: String,
    var interest: String,
    var status: Int?
)

fun MemberDTO.toEntity() = MemberEntity(id, name, email, studentNum, bio, interest, status)