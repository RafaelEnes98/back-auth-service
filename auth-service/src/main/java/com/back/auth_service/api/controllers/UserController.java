package com.back.auth_service.api.controllers;

import com.back.auth_service.api.dtos.request.UserRequest;
import com.back.auth_service.api.dtos.response.UserResponse;
import com.back.auth_service.application.usecases.CreateUser;
import com.back.auth_service.domain.model.User;
import com.back.auth_service.infra.mapper.UserApiMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/users")
public class UserController {

    private final CreateUser createUser;
    private final UserApiMapper userApiMapper;

    @PostMapping("/create")
    public ResponseEntity<UserResponse> create(@RequestBody UserRequest request) {
        User user = userApiMapper.toDomain(request);
        User created = createUser.execute(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(userApiMapper.toResponse(created));
    }
}
