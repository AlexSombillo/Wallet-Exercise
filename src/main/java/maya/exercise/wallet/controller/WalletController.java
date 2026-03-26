package maya.exercise.wallet.controller;

import maya.exercise.wallet.dto.Transaction;
import maya.exercise.wallet.dto.UserAccount;
import maya.exercise.wallet.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/wallet")
public class WalletController {
    @Autowired
    private WalletService walletService;

    @GetMapping("/balance")
    public Double getBalance(@RequestHeader("X-UserAccount-Id") String userId) {
        return walletService.getBalance(userId);
    }

    @PostMapping("/send")
    public Transaction sendMoney(@RequestHeader("X-UserAccount-Id") String userId,
                                 @RequestParam Long recipientId,
                                 @RequestParam Double amount) {
        return walletService.sendMoney(userId, recipientId, amount);
    }

    @PostMapping("/user")
    public UserAccount createUser(@RequestHeader("X-UserAccount-Id") String externalId,
                                  @RequestParam String name,
                                  @RequestParam(required = false) Double initialBalance) {
        return walletService.createUser(externalId, name, initialBalance);
    }

    @GetMapping("/transactions")
    public List<Transaction> getTransactions(@RequestHeader("X-UserAccount-Id") String userId) {
        UserAccount sender = walletService.getUser(userId);
        return walletService.getTransactions(sender.getId());
    }

    @GetMapping("/transactions/{id}")
    public Transaction getTransaction(@RequestHeader("X-UserAccount-Id") String userId,
                                      @PathVariable Integer id) {
        return walletService.getTransaction(userId, id);
    }
}
