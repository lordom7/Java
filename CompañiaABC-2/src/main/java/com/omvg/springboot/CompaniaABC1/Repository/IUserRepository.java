package com.omvg.springboot.CompaniaABC1.Repository;

import com.omvg.springboot.CompaniaABC1.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IUserRepository extends JpaRepository<User, UUID>{
	User findByEmail(String email);
	boolean existsByEmail(String email);

}
