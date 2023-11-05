package com.omvg.springboot.CompaniaABC1.Service;

import com.omvg.springboot.CompaniaABC1.Model.Campaing;
import com.omvg.springboot.CompaniaABC1.Model.User;
import com.omvg.springboot.CompaniaABC1.Repository.ICampaingRepository;
import com.omvg.springboot.CompaniaABC1.Repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CampaingService {
	
	@Autowired
	private ICampaingRepository iCampaingRepository;
	
	@Autowired
	private IUserRepository iUserRepository;
	
	//Crear Campaña
	public Campaing cteCampaing(Campaing campaing) {
		return iCampaingRepository.save(campaing);
	}
	
	//Actualizar Campaña
	public Campaing actCampaingStatus(Integer idCampaing, boolean status) {
		Optional<Campaing> optionalCampaing = iCampaingRepository.findById(idCampaing);
				
		return optionalCampaing.map(campaing -> {
					campaing.setStatus(status);
					return iCampaingRepository.save(campaing);
				}).orElse(null);
	}
	
	//Total de correos enviados
	public int totalEmailsByUser(UUID idUser) {
		User user = iUserRepository.findById(idUser).orElse(null);
		if (user == null) {
			return 0;
		}
		List<Campaing> campaigns = iCampaingRepository.findByIdUserAndStatusOrderByDateCreated(idUser, 1);
		int total = 0;
		for (Campaing campaign : campaigns) {
			total += campaign.getNumberOfRecipients();
		}
		return total;
	}
	
	//Historial de Campaña
	public List<Campaing> getCampaingHistoryByUser(UUID IdUser){
		Optional<User> optionalUser = iUserRepository.findById(IdUser);
		return optionalUser.map(user -> iCampaingRepository.findAllByIdUserOrderByDateCreatedDesc(user)).orElse(Collections.emptyList());
	}	
}
