package restcontroller.controller;

import restcontroller.dto.RoleDto;
import restcontroller.service.RoleService;
import restcontroller.util.UserMapper;
import restcontroller.dto.UserDto;
import restcontroller.entity.User;
import restcontroller.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    private final UserService userService;
    private final RoleService roleService;
    private final UserMapper userMapper;

    public AdminController(UserService userService, RoleService roleService, UserMapper userMapper) {
        this.userService = userService;
        this.roleService = roleService;
        this.userMapper = userMapper;
    }

    @GetMapping("/users")
    public List<UserDto> getAllUsers() {
        return userMapper.toDto(userService.findAllUsers());
    }

    @GetMapping("/users/{id}")
    public UserDto getUserById(@PathVariable Long id) {
        return userMapper.toDto(userService.getUserById(id));
    }

    @PostMapping("/users")
    public ResponseEntity<UserDto> createUser(@RequestBody User user,
                                              @RequestParam List<Long> roleIds) {
        User savedUser = userService.saveUser(user, roleIds);
        return ResponseEntity.status(HttpStatus.CREATED).body(userMapper.toDto(savedUser));
    }

    @PutMapping("/users/{id}")
    public UserDto updateUser(@PathVariable Long id,
                              @RequestBody User user,
                              @RequestParam List<Long> roleIds) {
        User updatedUser = userService.updateUser(id, user, roleIds);
        return userMapper.toDto(updatedUser);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUserById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/roles")
    public List<RoleDto> getAllRoles() {
        return roleService.findAllRoles();
    }
}