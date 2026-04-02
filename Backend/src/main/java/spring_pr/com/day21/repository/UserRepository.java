package spring_pr.com.day21.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import spring_pr.com.day21.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("SELECT u FROM User u WHERE u.email = :email")
    User findByEmail(@Param("email") String email);

    // Sql:Select count(*) from user
    @Query("SELECT Count(u) from User u")
    Long countUsers();

    @Query("SELECT u.email FROM User u")
    List<String> findAllEmails(Pageable pageable);

}