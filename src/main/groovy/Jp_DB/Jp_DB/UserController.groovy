package Jp_DB.Jp_DB

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class UserController {

    private UserService userService

    UserController(UserService userService) {
        this.userService = userService
    }

    @GetMapping
    List<UserEntity> getAllUsers(@RequestParam(required = false) String name) {
        userService.getAllUsers(name)
    }

    @GetMapping("/{id}")
    ResponseEntity<Map<String, String>> getUserById(@PathVariable("id") Long id) {
        try {
            UserEntity user = userService.getUserById(id)
            ResponseEntity.ok(user)
        } catch (UserNotFoundException ex) {
            ResponseEntity.status(HttpStatus.NOT_FOUND).body([erro: ex.message])
        }
    }

    @PostMapping
    ResponseEntity<Map<String, String>> createUser(@RequestBody UserEntity user) {
        try {
            UserEntity createdUser = userService.createUser(user)
            ResponseEntity.status(HttpStatus.CREATED).body(createdUser)
        } catch (InvalidRequestException ex) {
            ResponseEntity.status(HttpStatus.BAD_REQUEST).body([erro: ex.message])
        }
    }

    @PutMapping("/{id}")
    ResponseEntity<Map<String, String>> updateUser(@PathVariable("id") Long id, @RequestBody UserEntity userDetails) {
        try {
            UserEntity updatedUser = userService.updateUser(id, userDetails)
            ResponseEntity.ok(updatedUser)
        } catch (UserNotFoundException ex) {
            ResponseEntity.status(HttpStatus.NOT_FOUND).body([erro: ex.message])
        } catch (InvalidRequestException ex) {
            ResponseEntity.status(HttpStatus.BAD_REQUEST).body([erro: ex.message])
        }
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Map<String, String>> deleteUser(@PathVariable("id") Long id) {
        try {
            userService.deleteUser(id)
            ResponseEntity.status(HttpStatus.NO_CONTENT).build()
        } catch (UserNotFoundException ex) {
            ResponseEntity.status(HttpStatus.NOT_FOUND).body([erro: ex.message])
        }
    }
}


