package Jp_DB.Jp_DB

class UserNotFoundException extends RuntimeException{
    UserNotFoundException(String message) {
        super(message)
    }
}
