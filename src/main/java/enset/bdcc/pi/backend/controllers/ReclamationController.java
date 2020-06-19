package enset.bdcc.pi.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import enset.bdcc.pi.backend.dao.ReclamationRepository;
import enset.bdcc.pi.backend.entities.Reclamation;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ReclamationController {
	
	@Autowired
	private ReclamationRepository reclamationRepository;

	@GetMapping(path="/reclamations")
	public List<Reclamation> getReclamations(){
		return reclamationRepository.findAll();
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(path="/reclamation/{id}")
	public Reclamation getReclamation(@PathVariable Long id) {
		return reclamationRepository.findById(id).get();
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(path="/reclamation")
	public Reclamation saveReclamation(@RequestBody Reclamation reclam) {
		return reclamationRepository.save(reclam);
	}
	
	@DeleteMapping(path="/reclamation/{id}")
	public void deleteReclamation(@PathVariable Long id) {
		reclamationRepository.deleteById(id);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping(path="/reclamation/{id}")
	public Reclamation updateReclamation(@RequestBody Reclamation reclam,@PathVariable Long id) {
		System.out.println("Updating : " + id);
		Reclamation reclamation = reclamationRepository.findById(id).get();
		reclamation.setId(reclam.getId());
		reclamation = reclam;
		return reclamationRepository.save(reclamation);
	}
	
}
