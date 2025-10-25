package rest.controller;

import rest.util.UserMapper;
import rest.dto.UserDto;
import rest.entity.User;
import rest.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping("/current")
    public ResponseEntity<UserDto> getCurrentUser(Authentication authentication) {
        User user = userService.getUserByEmail(authentication.getName());
        UserDto userDto = userMapper.toDto(user);
        return ResponseEntity.ok(userDto);
    }
}
