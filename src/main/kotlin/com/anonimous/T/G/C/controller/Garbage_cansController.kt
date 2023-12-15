package com.anonimous.T.G.C.controller

import com.anonimous.T.G.C.model.Garbage_cans
import com.anonimous.T.G.C.service.Garbage_cansService
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


class Garbage_cansController {
    @Autowired
    lateinit var garbageCansservice: Garbage_cansService

    @GetMapping
    fun list ():List <Garbage_cans>{
        return garbageCansservice.list()
    }
    @PostMapping
    fun save (@RequestBody garbageCans: Garbage_cans): ResponseEntity<Garbage_cans> {
        return ResponseEntity(garbageCansservice.save(garbageCans), HttpStatus.OK)
    }
    @PutMapping
    fun update (@RequestBody garbageCans: Garbage_cans): ResponseEntity<Garbage_cans> {
        return ResponseEntity(garbageCans.update(garbageCans), HttpStatus.OK)
    }
    @PatchMapping
    fun updateName (@RequestBody garbageCans: Garbage_cans): ResponseEntity<Garbage_cans> {
        return ResponseEntity(garbageCans.updateName(garbageCans), HttpStatus.OK)
    }
    @GetMapping("/{id}")
    fun listById (@PathVariable("id") id: Long): ResponseEntity<*> {
        return ResponseEntity(garbageCansservice.listById (id), HttpStatus.OK)

    }
    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean?{
        return garbageCansservice.delete(id)
    }
}