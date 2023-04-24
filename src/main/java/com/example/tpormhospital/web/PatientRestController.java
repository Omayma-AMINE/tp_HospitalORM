package com.example.tpormhospital.web;

import com.example.tpormhospital.entities.Medecin;
import com.example.tpormhospital.entities.Patient;
import com.example.tpormhospital.repositories.PatientRepository;
import com.example.tpormhospital.service.IHospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class PatientRestController {
    @Autowired
    private IHospitalService hospitalService;


    @GetMapping("/patients")
    public List<Patient> patientList(){
        return hospitalService.findAllPatient();
    }


}
