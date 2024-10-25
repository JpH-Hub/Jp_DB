package Jp_DB.Jp_DB

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@EnableJpaRepositories
@Configuration
class UserConfiguration {

    @Bean
    UserController userController(UserRepository userRepository){
        return new UserController(userRepository)
    }


}
