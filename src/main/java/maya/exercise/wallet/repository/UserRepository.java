package maya.exercise.wallet.repository;

import maya.exercise.wallet.dto.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserAccount, Long> {
    Optional<UserAccount> findByExternalId(String externalId);
}

