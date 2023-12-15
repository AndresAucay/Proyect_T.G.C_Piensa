package com.anonimous.T.G.C.controller

import com.anonimous.T.G.C.model.Register
import com.anonimous.T.G.C.service.RegisterService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody


class RegisterController {
    @Autowired
    lateinit var registerService: RegisterService

    @GetMapping
    fun list ():List <Register>{
        return registerService.list()
    }
    @PostMapping
    fun save (@RequestBody register: Register): ResponseEntity<Register> {
        return ResponseEntity(registerService.save(register), HttpStatus.OK)
    }
    @PutMapping
    fun update (@RequestBody register: Register): ResponseEntity<Register> {
        return ResponseEntity(registerService.update(register), HttpStatus.OK)
    }
    @PatchMapping
    fun updateName (@RequestBody register: Register): ResponseEntity<Register> {
        return ResponseEntity(registerService.updateName(register), HttpStatus.OK)
    }
    @GetMapping("/{id}")
    fun listById (@PathVariable("id") id: Long): ResponseEntity<*> {
        return ResponseEntity(registerService.listById (id), HttpStatus.OK)

    }
    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean?{
        return registerService.delete(id)
    }
}