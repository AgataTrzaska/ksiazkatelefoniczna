package app.repositories;

import app.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    @Query(value = "delete from Person p where p.email=?1")
    @Transactional
    @Modifying
    void deleteByEmail(String email);

    @Query(value = "select p from Person p where p.email=?1")
    Optional<Person> findByEmail(String email);
}
