package maya.exercise.wallet.controller;

import maya.exercise.wallet.dto.Transaction;
import maya.exercise.wallet.dto.User;
import maya.exercise.wallet.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/wallet")
public class WalletController {
    @Autowired
    private WalletService walletService;

    @GetMapping("/balance")
    public Double getBalance(@RequestHeader("X-User-Id") String userId) {
        return walletService.getBalance(userId);
    }

    @PostMapping("/send")
    public Transaction sendMoney(@RequestHeader("X-User-Id") String userId,
                                 @RequestParam Long recipientId,
                                 @RequestParam Double amount) {
        return walletService.sendMoney(userId, recipientId, amount);
    }

    @PostMapping("/user")
    public User createUser(@RequestHeader("X-User-Id") String externalId,
                           @RequestParam String name,
                           @RequestParam(required = false) Double initialBalance) {
        return walletService.createUser(externalId, name, initialBalance);
    }

    @GetMapping("/transactions")
    public List<Transaction> getTransactions(@RequestHeader("X-User-Id") String userId) {
        User sender = walletService.getUser(userId);
        return walletService.getTransactions(sender.getId());
    }

    @GetMapping("/transactions/{id}")
    public Transaction getTransaction(@RequestHeader("X-User-Id") String userId,
                                      @PathVariable Long id) {
        return walletService.getTransaction(userId, id);
    }
}
