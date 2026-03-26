package maya.exercise.wallet.repository;

import maya.exercise.wallet.dto.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    List<Transaction> findBySenderId(Integer senderId);
}

