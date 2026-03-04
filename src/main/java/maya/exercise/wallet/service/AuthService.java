package maya.exercise.wallet.service;

import lombok.RequiredArgsConstructor;
import maya.exercise.wallet.dto.User;
import maya.exercise.wallet.repository.UserRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {

    public boolean isValidUser(HttpHeaders headers){
        return headers.containsHeaderValue("X-User-Id", "sample");
    }
}
