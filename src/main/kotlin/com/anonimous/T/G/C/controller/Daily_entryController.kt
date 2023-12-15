package com.anonimous.T.G.C.controller

import com.anonimous.T.G.C.model.Daily_entry
import com.anonimous.T.G.C.service.Daily_entryService
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


class Daily_entryController {
    @Autowired
    lateinit var dailyEntryservice: Daily_entryService

    @GetMapping
    fun list ():List <Daily_entry>{
        return dailyEntryservice.list()
    }
    @PostMapping
    fun save (@RequestBody dailyEntry: Daily_entry): ResponseEntity<Daily_entry> {
        return ResponseEntity(dailyEntry.save(dailyEntry), HttpStatus.OK)
    }
    @PutMapping
    fun update (@RequestBody dailyEntry: Daily_entry): ResponseEntity<Daily_entry> {
        return ResponseEntity(dailyEntry.update(dailyEntry), HttpStatus.OK)
    }
    @PatchMapping
    fun updateName (@RequestBody dailyEntry: Daily_entry): ResponseEntity<Daily_entry> {
        return ResponseEntity(dailyEntry.updateName(dailyEntry), HttpStatus.OK)
    }
    @GetMapping("/{id}")
    fun listById (@PathVariable("id") id: Long): ResponseEntity<*> {
        return ResponseEntity(dailyEntryservice.listById (id), HttpStatus.OK)

    }
    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean?{
        return dailyEntryservice.delete(id)
    }
}