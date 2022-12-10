package com.coderoom.cashapp.user;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;
    private PasswordEncoder encoder;

    public UserService(UserRepository userRepository ,
                        PasswordEncoder encoder){
        this.userRepository = userRepository;
        this.encoder = encoder;
    }

    public UserAccount registerUser(UserForm userRegistrationRequest){
        UserAccount userAccount = new UserAccount();
        userAccount.setUserName(userRegistrationRequest.getUserName());
        userAccount.setEmail(userRegistrationRequest.getEmail());
        userAccount.setPassword(encoder.encode(userRegistrationRequest.getPassword()));
        return userRepository.save(userAccount);
    }
}
