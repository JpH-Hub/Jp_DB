package Jp_DB.Jp_DB

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class UserController {

    private UserRepository userRepository

    UserController(UserRepository userRepository) {
        this.userRepository = userRepository
    }

    @GetMapping
    List<User> getAllUsers(){
        userRepository.findAll()
    }

    @GetMapping("/{id}")
    User getUserById(@PathVariable Long id) {
        userRepository.findById(id).orElseThrow {
            new RuntimeException("User not found with id: $id")
        }
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    User createUser(@RequestBody User user) {
        userRepository.save(user)
    }
    @PutMapping("/{id}")
    User updateUser(@PathVariable Long id, @RequestBody User userDetails) {
        User user = userRepository.findById(id).orElseThrow {
            new RuntimeException("User not found with id: $id")
        }
        user.name = userDetails.name
        user.email = userDetails.email
        userRepository.save(user)
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteUser(@PathVariable Long id) {
        User user = userRepository.findById(id).orElseThrow {
            new RuntimeException("User not found with id: $id")
        }
        userRepository.delete(user)
    }
}