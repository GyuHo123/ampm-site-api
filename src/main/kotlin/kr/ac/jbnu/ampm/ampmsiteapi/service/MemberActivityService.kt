package kr.ac.jbnu.ampm.ampmsiteapi.service

import kr.ac.jbnu.ampm.ampmsiteapi.dto.MemberActivityDTO
import kr.ac.jbnu.ampm.ampmsiteapi.dto.toEntity
import kr.ac.jbnu.ampm.ampmsiteapi.entity.toDTO
import kr.ac.jbnu.ampm.ampmsiteapi.repo.MemberActivityRepo
import org.springframework.stereotype.Service

@Service
class MemberActivityService(private val memberActivityRepository : MemberActivityRepo) {
    fun getAllMembers():List<MemberActivityDTO>{
        return memberActivityRepository.findAll().map{it.toDTO()}
    }
    fun getMemberById(id: Long) : MemberActivityDTO {
        val member = memberActivityRepository.findById(id).orElseThrow{MemberNotFoundException()}
        return member.toDTO()
    }
    fun createMember(memberDTO: MemberActivityDTO): MemberActivityDTO {
        val memberEntity = memberDTO.toEntity()
        val savedMemberEntity = memberActivityRepository.save(memberEntity)
        return savedMemberEntity.toDTO()
    }
    fun updateMemberByID(id:Long, memberDTO: MemberActivityDTO): MemberActivityDTO {
        val member = memberActivityRepository.findById(id).orElseThrow{MemberNotFoundException()}
        member.name = memberDTO.name
        member.email = memberDTO.email
        member.studentNum = memberDTO.studentNum
        member.bio = memberDTO.bio
        member.interest = memberDTO.interest
        member.status = memberDTO.status
        member.applyStatus = memberDTO.applyStatus
        val updatedEntity = memberActivityRepository.save(member)
        return updatedEntity.toDTO()
    }
}

class MemberNotFoundException : RuntimeException("Member not found")