package com.example.abdelkader_imen_i1_devmobil_mesure_glycemie.controller;

import com.example.abdelkader_imen_i1_devmobil_mesure_glycemie.model.Patient;

public final class Controller {
    private static Patient patient;
    private static Controller instance= null;


    private Controller() {
        super();
    }
    public static Controller getInstance() {
        if (instance == null){
            instance = new Controller();
        }
        return instance;
    }
    //Fléche "userAction" View --> Controller
    public void createPatient(int age ,float valeurMesuree , boolean isFasting){
        //Fléche "Update" Controller --> Model
        patient = new Patient(age,valeurMesuree,isFasting);
    }

    //Fléche "Notify" Controller --> View
     public String getResult(){
         //Fléche "Notify" Model --> Controller
        return patient.getResult();
     }
}
