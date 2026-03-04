package maya.exercise.wallet.service;

import maya.exercise.wallet.dto.User;
import maya.exercise.wallet.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getBalance(Integer id) {
        return userRepository.checkBalance(id);
    }
}
