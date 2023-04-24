package com.example.tpormhospital;

import com.example.tpormhospital.entities.*;
import com.example.tpormhospital.repositories.ConsultationRepository;
import com.example.tpormhospital.repositories.MedecinRepository;
import com.example.tpormhospital.repositories.PatientRepository;
import com.example.tpormhospital.repositories.RendezVousRepository;
import com.example.tpormhospital.service.IHospitalService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class TpOrmHospitalApplication {

    public static void main(String[] args) {
        SpringApplication.run(TpOrmHospitalApplication.class, args);
    }
    @Bean
   /* CommandLineRunner start(PatientRepository patientRepository, MedecinRepository medecinRepository, RendezVousRepository rendezVousRepository, ConsultationRepository consultationRepository){
        return args -> {
            Stream.of("Dr.Ahmed","Dr.Fatima","Dr.Ilham")
                    .forEach(name->{
                        Medecin medecin = new Medecin();

                        medecin.setNom(name);
                        medecin.setMail(name+"@gmail.com");
                        medecin.setSpecialite(Math.random()>0.2?"Generaliste":"Specialiste");

                        medecinRepository.save(medecin);
                    });
            Stream.of("Ali","Amal","Sara","Sami")
                    .forEach(name->{
                        Patient patient = new Patient();

                        patient.setNom(name);
                        patient.setDateNaissance(new Date());
                        patient.setMalade(false);

                        patientRepository.save(patient);
                    });
            Patient patient = patientRepository.findByNom("Sara");
            Patient patient1 = patientRepository.findById(2L).orElse(null);

            Medecin medecin = medecinRepository.findByNom("Dr.Ahmed");

            RendezVous rendezVous = new RendezVous();
            rendezVous.setDateRDV(new Date());
            rendezVous.setStatut(StatusRDV.Confirmed);
            rendezVous.setPatient(patient);
            rendezVous.setMedecin(medecin);

            rendezVousRepository.save(rendezVous);

            RendezVous rendezVous1 = rendezVousRepository.findById(1L).get();

            Consultation consultation = new Consultation();

            consultation.setDateConsulation(rendezVous1.getDateRDV());
            consultation.setRendezVous(rendezVous1);
            consultation.setRapport("Rapport ....");

            consultationRepository.save(consultation);

        };
    }*/
    CommandLineRunner start(IHospitalService hospitalService){
        return args -> {
            Stream.of("Dr.Ahmed","Dr.Fatima","Dr.Ilham")
                    .forEach(name->{
                        Medecin medecin = new Medecin();

                        medecin.setNom(name);
                        medecin.setMail(name+"@gmail.com");
                        medecin.setSpecialite(Math.random()>0.2?"Generaliste":"Specialiste");

                        hospitalService.saveMedecin(medecin);
                    });
            Stream.of("Ali","Amal","Sara","Sami")
                    .forEach(name->{
                        Patient patient = new Patient();

                        patient.setNom(name);
                        patient.setDateNaissance(new Date());
                        patient.setMalade(false);

                        hospitalService.savePatient(patient);
                    });
            Patient patient = hospitalService.findPatientByName("Sara");
            Patient patient1 = hospitalService.findPatientById(2L);

            Medecin medecin = hospitalService.findMedecinByName("Dr.Ahmed");

            RendezVous rendezVous = new RendezVous();
            rendezVous.setDateRDV(new Date());
            rendezVous.setStatut(StatusRDV.Confirmed);
            rendezVous.setPatient(patient);
            rendezVous.setMedecin(medecin);

            hospitalService.saveRDV(rendezVous);

            RendezVous rendezVous1 = hospitalService.findRDVById(1L);

            Consultation consultation = new Consultation();

            consultation.setDateConsulation(rendezVous1.getDateRDV());
            consultation.setRendezVous(rendezVous1);
            consultation.setRapport("Rapport ....");

            hospitalService.saveConsultation(consultation);

        };
    }

}
