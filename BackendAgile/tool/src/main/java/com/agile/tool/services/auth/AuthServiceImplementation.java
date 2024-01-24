package com.agile.tool.services.auth;


import com.agile.tool.dtos.SignupRequest;
import com.agile.tool.dtos.UserDto;
import com.agile.tool.entities.User;
import com.agile.tool.enums.UserRole;
import com.agile.tool.repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImplementation implements AuthService{

    private final UserRepository userRepository;

    public AuthServiceImplementation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto createUser(SignupRequest signupRequest) {
        User user = new User();
        user.setFirstName(signupRequest.getFirstName());
        user.setLastName(signupRequest.getLastName());
        user.setEmail(signupRequest.getEmail());
        user.setPassword(new BCryptPasswordEncoder().encode(signupRequest.getPassword()));
        user.setContactNumber(signupRequest.getContactNumber());
        user.setCompanyName(signupRequest.getCompanyName());
        user.setCountryCode(signupRequest.getCountryCode());
        user.setUserRole(UserRole.CUSTOMER);
        User createdUser = userRepository.save(user);

        UserDto createdUserDto = new UserDto();

        createdUserDto.setId(createdUser.getId());
        createdUserDto.setFirstName(createdUser.getFirstName());
        createdUserDto.setLastName(createdUser.getLastName());
        createdUserDto.setEmail(createdUser.getEmail());
        createdUserDto.setContactNumber(createdUser.getContactNumber());
        createdUserDto.setCompanyName(createdUser.getCompanyName());
        createdUserDto.setCountryCode(createdUser.getCountryCode());
        createdUserDto.setUserRole(createdUserDto.getUserRole());

        return createdUserDto;
    }
}
