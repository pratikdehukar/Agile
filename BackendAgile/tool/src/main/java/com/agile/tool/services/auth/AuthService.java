package com.agile.tool.services.auth;

import com.agile.tool.dtos.SignupRequest;
import com.agile.tool.dtos.UserDto;

public interface AuthService {
    UserDto createUser(SignupRequest signupRequest);
}
