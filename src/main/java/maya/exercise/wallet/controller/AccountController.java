package maya.exercise.wallet.controller;

import maya.exercise.wallet.dto.User;
import maya.exercise.wallet.exception.ApplicationException;
import maya.exercise.wallet.service.AuthService;
import maya.exercise.wallet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private UserService userService;

    @GetMapping("/balance")
    public ResponseEntity<String> getAccountInfo(@RequestHeader HttpHeaders headers, @RequestBody User user ){

        return new ResponseEntity<>(userService.getBalance(user.getId()).toString(), HttpStatus.OK);
    }

    @PostMapping("/sendMoney")
    public ResponseEntity<String> sendMoney(){
        return new ResponseEntity<>(" Something", HttpStatus.OK);
    }
}
