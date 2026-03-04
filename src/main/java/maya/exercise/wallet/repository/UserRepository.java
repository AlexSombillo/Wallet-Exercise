package maya.exercise.wallet.repository;


import maya.exercise.wallet.dto.User;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

// User repository for User DB operations
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("""
        SELECT
            balance
        FROM User userAccount
        WHERE userAccount.id = :id
    """)
    User checkBalance(Integer id);


}
