package com.anonimous.T.G.C.controller

import com.anonimous.T.G.C.model.Personal
import com.anonimous.T.G.C.service.PersonalService
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


class PersonalController {
    @Autowired
    lateinit var personalService: PersonalService

    @GetMapping
    fun list ():List <Personal>{
        return personalService.list()
    }
    @PostMapping
    fun save (@RequestBody personal: Personal): ResponseEntity<Personal> {
        return ResponseEntity(personalService.save(personal), HttpStatus  .OK)
    }
    @PutMapping
    fun update (@RequestBody personal: Personal): ResponseEntity<Personal> {
        return ResponseEntity(personalService.update(personal), HttpStatus.OK)
    }
    @PatchMapping
    fun updateName (@RequestBody personal: Personal): ResponseEntity<Personal> {
        return ResponseEntity(personalService.updateName(personal), HttpStatus.OK)
    }
    @GetMapping("/{id}")
    fun listById (@PathVariable("id") id: Long): ResponseEntity<*> {
        return ResponseEntity(personalService.listById (id), HttpStatus.OK)

    }
    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean?{
        return personalService.delete(id)
    }
}