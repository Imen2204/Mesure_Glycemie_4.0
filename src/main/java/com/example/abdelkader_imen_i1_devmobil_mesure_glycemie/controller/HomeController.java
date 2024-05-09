package com.example.abdelkader_imen_i1_devmobil_mesure_glycemie.controller;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.abdelkader_imen_i1_devmobil_mesure_glycemie.model.User;
import com.example.abdelkader_imen_i1_devmobil_mesure_glycemie.view.MainActivity;

public class HomeController {
    private static User user;
    private static HomeController instance =null;
    private  static final String SHARED_PREFES ="HomeActivitySharedPrefs";

    private HomeController() {super();
    }

    public static final HomeController getInstance(Context context){
        if(HomeController.instance==null){
            HomeController.instance= new HomeController();
        }
        recapUser(context);

        return HomeController.instance;
    }
    public  void creatUser(String email, String password, Context context){
        user= new User(email,password);
        // instance de la classe view qui est notre context = (HomeActivity.this) cette méthode est appelée dans HomeActivity creatUser(String email, String password, this)
        SharedPreferences sharedPreferences =context.getSharedPreferences(SHARED_PREFES,Context.MODE_PRIVATE); //private : accesible  seulement par HomeActivity et pas d'autre activité
        SharedPreferences.Editor editor= sharedPreferences.edit();
        editor.putString("email", email);
        editor.putString("password", password);
        editor.apply();

    }

    public static void recapUser(Context context){
        SharedPreferences sharedPreferences =context.getSharedPreferences(SHARED_PREFES,Context.MODE_PRIVATE);
        String email =sharedPreferences.getString("email","");
        String password = sharedPreferences.getString("password","");
        user= new User(email,password);
    }
    public  String getUserEmail(){ return user.getEmail();}
    public  String getUserPassword(){ return user.getPassword();}


}
