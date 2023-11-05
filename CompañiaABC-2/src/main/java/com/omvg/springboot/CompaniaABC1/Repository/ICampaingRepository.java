package com.omvg.springboot.CompaniaABC1.Repository;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


import com.omvg.springboot.CompaniaABC1.Model.Campaing;
import com.omvg.springboot.CompaniaABC1.Model.User;

@Repository
public interface ICampaingRepository extends JpaRepository<Campaing, Integer>{
	
	
	List<Campaing> findAllByIdUserOrderByDateCreatedDesc(User user);
	List<Campaing> findByIdUserAndStatusOrderByDateCreated(UUID idUser, int status);
	
}
