package maya.exercise.wallet.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
@RequestMapping("/accounts")
public class AccountController {


    @GetMapping
    public ResponseEntity<String> getAccountInfo(){

    }
}
