package kr.ac.jbnu.ampm.ampmsiteapi.service

import kr.ac.jbnu.ampm.ampmsiteapi.dto.MemberDTO
import kr.ac.jbnu.ampm.ampmsiteapi.dto.toEntity
import kr.ac.jbnu.ampm.ampmsiteapi.entity.toDTO
import kr.ac.jbnu.ampm.ampmsiteapi.repo.MemberRepo
import org.springframework.stereotype.Service

@Service
class MemberService(private var memberRepository : MemberRepo) {
    fun getAllMembers(): List<MemberDTO> {
        return memberRepository.findAll().map{it.toDTO()}
    }
    fun getMemberById(id: Long) : MemberDTO{
        val member = memberRepository.findById(id).orElseThrow{MemberNotFoundException()}
        return member.toDTO()
    }
    fun createMember(memberDTO: MemberDTO): MemberDTO{
        val memberEntity = memberDTO.toEntity()
        val savedMemberEntity = memberRepository.save(memberEntity)
        return savedMemberEntity.toDTO()
    }
    fun updateMemberByID(id:Long, memberDTO: MemberDTO):MemberDTO{
        val member = memberRepository.findById(id).orElseThrow{MemberNotFoundException()}
        member.name = memberDTO.name
        member.email = memberDTO.email
        member.studentNum = memberDTO.studentNum
        member.bio = memberDTO.bio
        member.interest = memberDTO.interest
        member.status = memberDTO.status
        val updatedEntity = memberRepository.save(member)
        return updatedEntity.toDTO()
    }
}