package com.example.medication.model;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Data;

@Entity
@Data
public class Prescription {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotNull(message = "Notes or remarks is a mandotory field")
	private String notes;

	@CreationTimestamp
	@PastOrPresent
	private LocalDateTime dateTimeOfPrescription;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "patientId")
	@Valid
	private Patient patient;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "doctorId")
	@Valid
	private Doctor doctor;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "medicationId")
	@Valid
	private List<Medication> medication;
}