package ua.test.PhoneContacts.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import ua.test.PhoneContacts.exceptions.ContactNotAddedOrUpdatedException;
import ua.test.PhoneContacts.exceptions.UserErrorRegister;
import ua.test.PhoneContacts.exceptions.UserNotRegistrated;
import ua.test.PhoneContacts.models.User;
import ua.test.PhoneContacts.services.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;


    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> showAllUsers(){
        return userService.findAll();
    }

    @GetMapping("{id}")
    public User showOne(@PathVariable("id") int id){
        return userService.findOne(id);
    }

    @PostMapping
    public ResponseEntity<HttpStatus> registerNewUser(@RequestBody @Valid User user,
                                                    BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            StringBuilder errorMsg = new StringBuilder();

            List<FieldError> errors = bindingResult.getFieldErrors();

            for(FieldError error : errors){
                errorMsg.append(error.getField())
                        .append(" - ").append(error.getDefaultMessage())
                        .append(";");
            }

            throw new ContactNotAddedOrUpdatedException(errorMsg.toString());
        }
        userService.save(user);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @ExceptionHandler
    private ResponseEntity<UserErrorRegister> handleException(UserNotRegistrated e){
        UserErrorRegister response = new UserErrorRegister(
                e.getMessage()
        );

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
