package com.anonimous.T.G.C.controller

import com.anonimous.T.G.C.model._user
import com.anonimous.T.G.C.service._userService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/_user")
class _userController {
    @Autowired
    lateinit var _userService: _userService

    @GetMapping
    fun list ():List <_user>{
        return _userService.list()
    }
    @PostMapping
    fun save (@RequestBody _user: _user): ResponseEntity<_user> {
        return ResponseEntity(_userService.save(_user), HttpStatus.OK)
    }
    @PutMapping
    fun update (@RequestBody _user: _user): ResponseEntity<_user> {
        return ResponseEntity(_userService.update(_user), HttpStatus.OK)
    }
    @PatchMapping
    fun updateName (@RequestBody _userService: _userService): ResponseEntity<_user> {
        return ResponseEntity(_userService.updateName(_user), HttpStatus.OK)
    }
    @GetMapping("/{id}")
    fun listById (@PathVariable("id") id: Long): ResponseEntity<*> {
        return ResponseEntity(_userService.listById (id), HttpStatus.OK)

    }
    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean?{
        return _userService.delete(id)
    }
}