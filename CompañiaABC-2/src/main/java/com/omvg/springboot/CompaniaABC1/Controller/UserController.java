package com.omvg.springboot.CompaniaABC1.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.omvg.springboot.CompaniaABC1.Exceptions.IncorrectPasswordException;
import com.omvg.springboot.CompaniaABC1.Exceptions.UserAlreadyExistsException;
import com.omvg.springboot.CompaniaABC1.Exceptions.UserNotFoundException;
import com.omvg.springboot.CompaniaABC1.Model.User;
import com.omvg.springboot.CompaniaABC1.Service.UserService;

@RestController
@RequestMapping("api/v1/companiaabc/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	//Caso Registrar Usuario
	@PostMapping("/register")
	public ResponseEntity<User> register(@RequestBody User user){
        User registeredUser = userService.register(user);
        return ResponseEntity.ok(registeredUser);
    }

    
	//Caso inicio de sesion
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody User user){
        String token = userService.login(user.getEmail(), user.getPassword());
        return ResponseEntity.ok(token);
    }

    @ControllerAdvice
    class ExceptionHandlers {
    	
    	@ExceptionHandler(UserAlreadyExistsException.class)
        public ResponseEntity<String> handleUserAlreadyExistsException(UserAlreadyExistsException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

        @ExceptionHandler(UserNotFoundException.class)
        public ResponseEntity<String> userNotFoundExceptionHandler(UserNotFoundException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

        @ExceptionHandler(IncorrectPasswordException.class)
        public ResponseEntity<String> incorrectPasswordExceptionHandler(IncorrectPasswordException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
        
    }
}
