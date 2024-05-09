package com.example.abdelkader_imen_i1_devmobil_mesure_glycemie.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.abdelkader_imen_i1_devmobil_mesure_glycemie.R;
import com.example.abdelkader_imen_i1_devmobil_mesure_glycemie.controller.HomeController;

public class HomeActivity extends AppCompatActivity {
    private Button btnConsultation;
    private EditText etUserEmail,etUserPassword;
    private HomeController homeController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        init();

        etUserEmail.setText(homeController.getUserEmail());
        btnConsultation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             String email , password;
             boolean verifEmail = false;
                boolean verifPassword = false;
                if(etUserEmail.getText().toString().isEmpty() && etUserPassword.getText().toString().isEmpty()){
                    Toast.makeText(HomeActivity.this,"Veuillez saisir votre email et votre mot de passe",Toast.LENGTH_SHORT).show();
                } else {
                    if(!etUserEmail.getText().toString().isEmpty())
                        verifEmail = true;
                    else
                        Toast.makeText(HomeActivity.this,"Veuillez saisir votre email",Toast.LENGTH_SHORT).show();

                    if (!etUserPassword.getText().toString().isEmpty()) {
                        if (etUserPassword.getText().toString().equals(homeController.getUserPassword())) {
                            verifPassword = true;
                        } else {
                            Toast.makeText(HomeActivity.this, "Mot de passe incorrect !", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(HomeActivity.this, "Veuillez saisir votre mot de passe", Toast.LENGTH_SHORT).show();
                    }

                }
                if(verifEmail&&verifPassword){
                    email = etUserEmail.getText().toString();
                    password= etUserPassword.getText().toString();

                    homeController.creatUser(email,password,HomeActivity.this);

                //intent expliciteetUserEmail.getText().toString()etUserEmail.getText().toString()
                //home activity est le contexte car AppCompatActivity herite d'Activity qui lui meme herite de Contexte
                Intent intent= new Intent(HomeActivity.this,MainActivity.class);
                //Intent intent2= new Intent(getApplicationContext(),MainActivity.class);
                //Naviguer vers MainActivity sans possibilité de retourner en arrière en utilisant la méthode startActivity().
                startActivity(intent);//démarer l'activity MainActivity
                //On utilise finish() si et seulement si on ne souhaite pas retourner vers HomeActivity.
                finish();
                }
            }
        });
    }
  
    private void  init(){
        etUserEmail = findViewById(R.id.etUserEmail);
        etUserPassword = findViewById(R.id.etUserPassword);
        btnConsultation= findViewById(R.id.btnConsultation);
        homeController = HomeController.getInstance(getApplicationContext());//getInstance(getApplicationContext());
    }
}