
package com.xtra.mile.controller;
import java.util.HashMap;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xtra.mile.exception.ResourceNotFoundException;
import com.xtra.mile.model.Patient;
import com.xtra.mile.repository.PatientRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class PatientController {
	@Autowired
	private PatientRepository patientRepository;

	@GetMapping("/patients")
	public List<Patient> getAllPatients() {
		return patientRepository.findAll();
	}

	@GetMapping("/patient/{id}")
	public ResponseEntity<Patient> getPatientById(@PathVariable(value = "id") Long patientId)
			throws ResourceNotFoundException {
                Patient patient = patientRepository.findById(patientId)
				.orElseThrow(() -> new ResourceNotFoundException("Patient not found for this id :: " + patientId));
		return ResponseEntity.ok().body(patient);
	}

	@PostMapping("/patient")
	public Patient createPatient(@Valid @RequestBody Patient patient) {
		return patientRepository.save(patient);
	}

	@PutMapping("/patient/{id}")
	public ResponseEntity<Patient> updatePatient(@PathVariable(value = "id") Long patientId,
			@Valid @RequestBody Patient patientDetails) throws ResourceNotFoundException {
                Patient patient = patientRepository.findById(patientId)
				.orElseThrow(() -> new ResourceNotFoundException("Patient not found for this id :: " + patientId));

                patient.setGender(patientDetails.getGender());
                patient.setLastName(patientDetails.getLastName());
                patient.setFirstName(patientDetails.getFirstName());
		final Patient updatePatient = patientRepository.save(patient);
		return ResponseEntity.ok(updatePatient);
	}

	@DeleteMapping("/patient/{id}")
	public Map<String, Boolean> deletePatient(@PathVariable(value = "id") Long patientId)
			throws ResourceNotFoundException {
                Patient patient = patientRepository.findById(patientId)
				.orElseThrow(() -> new ResourceNotFoundException("Patient not found for this id :: " + patientId));

                patientRepository.delete(patient);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}