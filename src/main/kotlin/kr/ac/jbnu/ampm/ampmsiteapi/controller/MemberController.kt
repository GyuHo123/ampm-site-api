package kr.ac.jbnu.ampm.ampmsiteapi.controller

import kr.ac.jbnu.ampm.ampmsiteapi.dto.MemberDTO
import kr.ac.jbnu.ampm.ampmsiteapi.service.MemberService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/admin/memberList")
class MemberController(private val memberService: MemberService) {
    @GetMapping("")
    fun getAllMembers(): ResponseEntity<List<MemberDTO>> {
        val members = memberService.getAllMembers()
        return ResponseEntity.ok(members)
    }

    @GetMapping("/{id}")
    fun getMemberbyId(@PathVariable("id") id: Long): ResponseEntity<MemberDTO> {
        val member = memberService.getMemberById(id)
        return ResponseEntity.ok(member)
    }

    @PostMapping("")
    fun createMember(@RequestBody memberDTO: MemberDTO): ResponseEntity<MemberDTO> {
        val createdMember = memberService.createMember(memberDTO)
        return ResponseEntity.ok(createdMember)
    }

    @PutMapping("/{id}")
    fun updateMemberbyId(@PathVariable("id") id: Long, @RequestBody memberDTO: MemberDTO): ResponseEntity<MemberDTO>{
        val updatedMember = memberService.updateMemberByID(id, memberDTO)
        return ResponseEntity.ok(updatedMember)
    }
}
