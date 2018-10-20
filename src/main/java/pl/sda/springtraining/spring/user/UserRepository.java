package pl.sda.springtraining.spring.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    //fixme:
    User findUserByEmail(String email);
}