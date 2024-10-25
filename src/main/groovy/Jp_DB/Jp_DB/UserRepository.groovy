package Jp_DB.Jp_DB

import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository extends JpaRepository<UserEntity, Long>{

}