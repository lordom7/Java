package com.omvg.springboot.CompaniaABC1.Service;

import com.omvg.springboot.CompaniaABC1.Exceptions.IncorrectPasswordException;
import com.omvg.springboot.CompaniaABC1.Exceptions.UserAlreadyExistsException;
import com.omvg.springboot.CompaniaABC1.Exceptions.UserNotFoundException;
import com.omvg.springboot.CompaniaABC1.Model.User;
import com.omvg.springboot.CompaniaABC1.Repository.IUserRepository;
import com.omvg.springboot.CompaniaABC1.Util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class UserService {
	
	@Autowired
	private IUserRepository iUserRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordencoder;
	
	@Autowired
	private JwtTokenUtil JwtTokenUtil;
	
	//Registro
	public User register(User user) throws UserAlreadyExistsException {
        if (iUserRepository.existsByEmail(user.getEmail())) {
            throw new UserAlreadyExistsException("Usuario con email " + user.getEmail() + " ya existe");
        }
        user.setIdUser(UUID.randomUUID());
        String encodedPassword = passwordencoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        user.setdateCreated(Timestamp.valueOf(LocalDateTime.now()));

        return iUserRepository.save(user);
    }
	
	//inicio de sesion
	public String login(String email, String password) throws UserNotFoundException, IncorrectPasswordException{
		User user = iUserRepository.findByEmail(email);
		if(user == null) {
			throw new UserNotFoundException("Usuario con email"+email+"no encontrado");
		}
		if(!passwordencoder.matches(password, user.getPassword())) {
			throw new IncorrectPasswordException("Contraseña incorrecta");
		}
		return JwtTokenUtil.generateToken(user);
	}
	

}
