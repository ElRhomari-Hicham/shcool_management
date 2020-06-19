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
import enset.bdcc.pi.backend.dao.AttestationScolariteRepository;
import enset.bdcc.pi.backend.entities.Attestation_scolarite;

@RestController
public class AttestationScolariteController {
	
	@Autowired
	private AttestationScolariteRepository attestationRepository;
	
	@GetMapping(path="/attestations")
	public List<Attestation_scolarite> getAttestations(){
		return attestationRepository.findAll();
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(path="/attestation/{id}")
	public Attestation_scolarite getAttestation(@PathVariable Long id) {
		return attestationRepository.findAttestationByCodeEtudiant(id);
	}
	
	@PostMapping(path="/attestation")
	public Attestation_scolarite saveAttestation(@RequestBody Attestation_scolarite attest) {
		return attestationRepository.save(attest);
	}
	
	@DeleteMapping(path="/attestation/{id}")
	public void deleteAttestation(@PathVariable Long id) {
		attestationRepository.deleteById(id);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping(path="/attestation/{id}")
	public Attestation_scolarite updateAttestation(@RequestBody Attestation_scolarite attest,@PathVariable Long id) {
		System.out.println("Updating : " + id);
		Attestation_scolarite attestation = attestationRepository.findById(id).get();
		attestation.setId(attest.getId());
		attestation = attest;
		return attestationRepository.save(attestation);
	}
}
