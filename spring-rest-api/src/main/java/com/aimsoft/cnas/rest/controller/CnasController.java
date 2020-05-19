package com.aimsoft.cnas.rest.controller;

import com.aimsoft.cnas.rest.api.PatientsApi;
import com.aimsoft.cnas.rest.model.Patient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Controller
// @RestController
public class CnasController implements PatientsApi {

    @Override
    public ResponseEntity<Patient> getPatientByCNP(String cnp) {
//    public Patient getPatientByCNP(String cnp) {
        Optional<Patient> patient =  patientList().stream().filter(p->p.getCnp().equals(cnp)).findFirst();
        return patient.map(p->new ResponseEntity<>(p, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Override
    public ResponseEntity<List<Patient>> getPatients() {
        return new ResponseEntity<>(patientList(), HttpStatus.OK);
    }

    private List<Patient> patientList() {
        return Arrays.asList(patient1(), patient2(), patient3());
    }

    private Patient patient1() {
        Patient p1 = new Patient();
        p1.setCnp("1870326244514");
        p1.setBirthdate(LocalDate.of(1987, 03, 26));
        p1.setFirstName("Andrei");
        p1.setLastName("Mladin");
        p1.setStatus(Patient.StatusEnum.ANGAJAT);

        return p1;
    }

    private Patient patient2() {
        Patient p2 = new Patient();
        p2.setCnp("1870326244515");
        p2.setBirthdate(LocalDate.of(1987, 03, 26));
        p2.setFirstName("Mihai");
        p2.setLastName("Szocs");
        p2.setStatus(Patient.StatusEnum.NEASIGURAT);

        return p2;
    }

    private Patient patient3() {
        Patient p3 = new Patient();
        p3.setCnp("1870326244516");
        p3.setBirthdate(LocalDate.of(1987, 03, 26));
        p3.setFirstName("Robert");
        p3.setLastName("Paltan");
        p3.setStatus(Patient.StatusEnum.PENSIONAR);

        return p3;
    }
}
