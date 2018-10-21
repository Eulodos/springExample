package pl.sda.springtraining.spring.user;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {

    //JPQL używa aliasów zamiast gwiazdki
    //Zapytanie tożsame z metodą bez adnotacji
    @Query("SELECT r FROM Role r WHERE r.roleName=?1")
    Role findRoleByRoleName(String roleName);
}
