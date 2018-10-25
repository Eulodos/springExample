package pl.sda.springtraining.spring.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

    @Query("SELECT r FROM Role r WHERE r.roleName = ?1") // to jest tozsame z sama metoda, nawias opcjonalny
    Role findRoleByRoleName(String roleName);
}
