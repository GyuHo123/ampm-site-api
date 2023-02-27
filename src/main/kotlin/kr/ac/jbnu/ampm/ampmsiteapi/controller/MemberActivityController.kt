package kr.ac.jbnu.ampm.ampmsiteapi.controller

import kr.ac.jbnu.ampm.ampmsiteapi.dto.MemberActivityDTO
import kr.ac.jbnu.ampm.ampmsiteapi.service.MemberActivityService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/admin/memberManage")
class MemberActivityController(private val memberActivityService: MemberActivityService) {
    @GetMapping("")
    fun getAllMembers(): ResponseEntity<List<MemberActivityDTO>> {
        val members = memberActivityService.getAllMembers()
        return ResponseEntity.ok(members)
    }

    @GetMapping("/{id}")
    fun getMemberbyId(@PathVariable("id") id: Long): ResponseEntity<MemberActivityDTO> {
        val member = memberActivityService.getMemberById(id)
        return ResponseEntity.ok(member)
    }

    @PostMapping("")
    fun createMember(@RequestBody memberActivityDTO: MemberActivityDTO): ResponseEntity<MemberActivityDTO> {
        val createdMember = memberActivityService.createMember(memberActivityDTO)
        return ResponseEntity.ok(createdMember)
    }

    @PutMapping("/{id}")
    fun updateMemberbyId(@PathVariable("id") id: Long, @RequestBody memberActivityDTO: MemberActivityDTO): ResponseEntity<MemberActivityDTO>{
        val updatedMember = memberActivityService.updateMemberByID(id, memberActivityDTO)
        return ResponseEntity.ok(updatedMember)
    }
}
