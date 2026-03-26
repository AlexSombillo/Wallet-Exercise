package maya.exercise.wallet.service;

import maya.exercise.wallet.dto.Transaction;
import maya.exercise.wallet.dto.UserAccount;
import maya.exercise.wallet.repository.TransactionRepository;
import maya.exercise.wallet.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class WalletService {
    @Autowired
    private UserRepository userRepo;
    @Autowired private TransactionRepository txRepo;

    public Double getBalance(String externalId) {
        return userRepo.findByExternalId(externalId)
                .orElseThrow().getBalance();
    }

    public Transaction sendMoney(String externalId, Long recipientId, Double amount) {
        UserAccount sender = userRepo.findByExternalId(externalId).orElseThrow();
        UserAccount recipient = userRepo.findById(recipientId).orElseThrow();

        if (sender.getBalance() < amount) throw new RuntimeException("Insufficient funds");

        sender.setBalance(sender.getBalance() - amount);
        recipient.setBalance(recipient.getBalance() + amount);

        userRepo.save(sender);
        userRepo.save(recipient);

        Transaction tx = new Transaction();
        tx.setSenderId(sender.getId());
        tx.setRecipientId(recipient.getId());
        tx.setAmount(amount);
        tx.setTimestamp(LocalDateTime.now());
        tx.setStatus("SUCCESS");

        return txRepo.save(tx);
    }

    public UserAccount createUser(String externalId, String name, Double initialBalance) {
        if (userRepo.findByExternalId(externalId).isPresent()) {
            throw new RuntimeException("UserAccount with this X-UserAccount-Id already exists");
        }

        UserAccount userAccount = new UserAccount();
        userAccount.setExternalId(externalId);
        userAccount.setName(name);
        userAccount.setBalance(initialBalance != null ? initialBalance : 0.0);

        return userRepo.save(userAccount);
    }

    public UserAccount getUser(String externalId) {
        return userRepo.findByExternalId(externalId)
                .orElseThrow(() -> new RuntimeException("UserAccount not found"));
    }

    public List<Transaction> getTransactions(Integer senderId) {
        return txRepo.findBySenderId(senderId);
    }

    public Transaction getTransaction(String externalId, Integer txId) {
        UserAccount userAccount = getUser(externalId);
        Transaction tx = txRepo.findById(txId)
                .orElseThrow(() -> new RuntimeException("Transaction not found"));

        if (!tx.getSenderId().equals(userAccount.getId())) {
            throw new RuntimeException("Unauthorized access to transaction");
        }
        return tx;
    }
}
