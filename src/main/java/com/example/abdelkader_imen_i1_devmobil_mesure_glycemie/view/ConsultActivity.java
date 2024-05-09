package com.example.abdelkader_imen_i1_devmobil_mesure_glycemie.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.abdelkader_imen_i1_devmobil_mesure_glycemie.R;

public class ConsultActivity extends AppCompatActivity {
    private TextView tvReponse;
    private Button btnRetour;
    private String reponse;

    private final String RESPONSE_KEY ="result";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consult);
        init();
        //Récupère l'intention qui a lancé cette activité.
        Intent intent = getIntent();
        //Récupère une chaîne de caractères supplémentaire incluse dans l'intention avec la clé RESPONSE_KEY
        reponse= intent.getStringExtra(RESPONSE_KEY);
        tvReponse.setText(reponse);
        //tvReponse.setText(getIntent().getStringExtra(reponse));
        btnRetour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                if (reponse == null){
                    setResult(RESULT_CANCELED,intent); //en cas de probleme retourne 0
                }else{
                    setResult(RESULT_OK,intent);//sinon retourne -1

                }
                finish();
            }
        });
    }
    private void init(){
        tvReponse = findViewById(R.id.tvReponse);
        btnRetour = findViewById(R.id.btnRetour);

    }
}