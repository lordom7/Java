package com.omvg.springboot.CompaniaABC1.Controller;

import com.omvg.springboot.CompaniaABC1.Model.Campaing;
import com.omvg.springboot.CompaniaABC1.Service.CampaingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/companiaabc/Campaing")
public class CampaingController {
	@Autowired
	private CampaingService campaingService;
	
	//Caso historial de Campaña
	@GetMapping("/{idUser}")
	public ResponseEntity<List<Campaing>> getCampaingHistoryByUser(@PathVariable("idUser")UUID idUser){
		List<Campaing> campaings = campaingService.getCampaingHistoryByUser(idUser);
		return ResponseEntity.ok(campaings);
	}
	
	//Caso Total de Correos Enviados
	@GetMapping("/total/{idUser}")
	public ResponseEntity<Integer> totalEmailsByUser(@PathVariable UUID idUser){
		int totalEmailsByUser = campaingService.totalEmailsByUser(idUser);
		return ResponseEntity.ok(totalEmailsByUser);
	}
	
	//Caso Crear Campaña
	@PostMapping("/create")
	public ResponseEntity<Campaing> cteCampaing(@RequestBody Campaing campaing){
		Campaing cteCampaing = campaingService.cteCampaing(campaing);
		return ResponseEntity.ok(cteCampaing);
	}
	
	//Actualizar estado campaña
	@PutMapping("/{idCampaing}/{status}")
	public ResponseEntity<Campaing> actCampaingStatus(@PathVariable Integer idCampaing, @PathVariable boolean status){
		Campaing campaing = campaingService.actCampaingStatus(idCampaing, status);
		return ResponseEntity.ok(campaing);
	}
	
	
}
