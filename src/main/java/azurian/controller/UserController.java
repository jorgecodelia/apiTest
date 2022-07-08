package azurian.controller;


import azurian.domain.User;
import azurian.domain.UserResponse;
import azurian.service.UserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {
    @Autowired private UserService userService;
    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);


    @GetMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserResponse> getUsers(){
        LOGGER.info("get all users");
        return ResponseEntity.ok().body(userService.getUsers());
    }

    @GetMapping(value = "/user/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getUserById(@PathVariable String userId){
        LOGGER.info("get user by id");
        return ResponseEntity.ok().body(userService.getUserById(userId));
    }

    @PutMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> createUser(@RequestBody User user){
        LOGGER.info("Create user");
        return ResponseEntity.ok().body(userService.createUser(user));
    }

    @PostMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> updateUser(@RequestBody User user){
        LOGGER.info("Update user");
        return ResponseEntity.ok().body(userService.updateUser(user));
    }

    @DeleteMapping(value = "/user/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> deleteUserById(@PathVariable String userId){
        LOGGER.info("Delete user");
        return ResponseEntity.ok().body(userService.deleteUserById(userId));
    }

}
