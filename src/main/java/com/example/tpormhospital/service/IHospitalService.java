package com.example.tpormhospital.service;

import com.example.tpormhospital.entities.Consultation;
import com.example.tpormhospital.entities.Medecin;
import com.example.tpormhospital.entities.Patient;
import com.example.tpormhospital.entities.RendezVous;

import java.util.List;

public interface IHospitalService {
    Patient savePatient(Patient patient);
    Patient findPatientByName(String nom);
    Patient findPatientById(Long id);
    List<Patient> findAllPatient();
    Medecin saveMedecin(Medecin medecin);
    Medecin findMedecinByName(String nom);
    Medecin findMedecinById(Long id);
    List<Medecin> findAllMedecin();
    RendezVous saveRDV(RendezVous rendezVous);
    RendezVous findRDVById(Long id);
    List<RendezVous> findAllRDV();
    Consultation saveConsultation(Consultation consultation);
    Consultation findConsultationById(Long id);
    List<Consultation> findAllConsultation();

}
