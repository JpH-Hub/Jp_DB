package Jp_DB.Jp_DB

import org.springframework.stereotype.Service

@Service
class UserService {

    private UserRepository userRepository

    UserService(UserRepository userRepository) {
        this.userRepository = userRepository
    }

    List<UserEntity> getAllUsers(String name) {
        if (name) {
            return userRepository.findByNameContainingIgnoreCase(name)
        }
        return userRepository.findAll()
    }

    UserEntity getUserById(Long id) {
        userRepository.findById(id).orElseThrow {
            new UserNotFoundException("User not found with id: $id")
        }
    }

    UserEntity createUser(UserEntity user) {
        if (!user.name || !user.email) {
            throw new InvalidRequestException("Name and email are required.")
        }
        userRepository.save(user)
    }

    UserEntity updateUser(Long id, UserEntity userDetails) {
        UserEntity user = userRepository.findById(id).orElseThrow {
            new UserNotFoundException("User not found with id: $id")
        }
        user.name = userDetails.name
        user.email = userDetails.email
        userRepository.save(user)
    }

    void deleteUser(Long id) {
        UserEntity user = userRepository.findById(id).orElseThrow {
            new UserNotFoundException("User not found with id: $id")
        }
        userRepository.delete(user)
    }
}

