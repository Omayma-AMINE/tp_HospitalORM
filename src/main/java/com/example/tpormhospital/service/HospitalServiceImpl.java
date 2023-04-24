package com.example.tpormhospital.service;

import com.example.tpormhospital.entities.Consultation;
import com.example.tpormhospital.entities.Medecin;
import com.example.tpormhospital.entities.Patient;
import com.example.tpormhospital.entities.RendezVous;
import com.example.tpormhospital.repositories.ConsultationRepository;
import com.example.tpormhospital.repositories.MedecinRepository;
import com.example.tpormhospital.repositories.PatientRepository;
import com.example.tpormhospital.repositories.RendezVousRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class HospitalServiceImpl implements IHospitalService {
    private PatientRepository patientRepository;
    private RendezVousRepository rendezVousRepository;
    private MedecinRepository medecinRepository;
    private ConsultationRepository consultationRepository;

    public HospitalServiceImpl(PatientRepository patientRepository, RendezVousRepository rendezVousRepository, MedecinRepository medecinRepository, ConsultationRepository consultationRepository) {
        this.patientRepository = patientRepository;
        this.rendezVousRepository = rendezVousRepository;
        this.medecinRepository = medecinRepository;
        this.consultationRepository = consultationRepository;
    }

    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Patient findPatientByName(String nom) {
        return patientRepository.findByNom(nom);
    }

    @Override
    public Patient findPatientById(Long id) {
        return patientRepository.findById(id).orElse(null);
    }

    @Override
    public List<Patient> findAllPatient() {
        return patientRepository.findAll();
    }

    @Override
    public Medecin saveMedecin(Medecin medecin) {

        return medecinRepository.save(medecin);
    }

    @Override
    public Medecin findMedecinByName(String nom) {
        return medecinRepository.findByNom(nom);
    }

    @Override
    public Medecin findMedecinById(Long id) {
        return medecinRepository.findById(id).orElse(null);
    }

    @Override
    public List<Medecin> findAllMedecin() {
        return medecinRepository.findAll();
    }

    @Override
    public RendezVous saveRDV(RendezVous rendezVous) {
        return rendezVousRepository.save(rendezVous);
    }

    @Override
    public RendezVous findRDVById(Long id) {
        return rendezVousRepository.findById(id).orElse(null);
    }

    @Override
    public List<RendezVous> findAllRDV() {
        return rendezVousRepository.findAll();
    }

    @Override
    public Consultation saveConsultation(Consultation consultation) {
        return consultationRepository.save(consultation);
    }

    @Override
    public Consultation findConsultationById(Long id) {
        return consultationRepository.findById(id).orElse(null);
    }

    @Override
    public List<Consultation> findAllConsultation() {
        return consultationRepository.findAll();
    }
}
