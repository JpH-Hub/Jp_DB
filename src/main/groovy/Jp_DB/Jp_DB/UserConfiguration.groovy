package Jp_DB.Jp_DB

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@EnableJpaRepositories
@Configuration
class UserConfiguration {

    @Bean
    UserController userController(UserService userService){
        return new UserController(userService)
    }

    @Bean
    UserService userService(UserRepository userRepository){
        return new UserService(userRepository)
    }


}
