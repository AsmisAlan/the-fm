package com.example.umusic.services;

import android.content.res.Resources;

import com.example.umusic.R;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

import static android.provider.Settings.System.getString;


public class AuthenticationService  {

    private static AuthenticationService service;
    private  GoogleSignInOptions GoogleAuthOptions;

    public static  AuthenticationService GetInstance(){
        if(service == null)
        {
            service = new AuthenticationService();
        }
        return service;
    }

    private AuthenticationService()
    {
        String webClient = Resources.getSystem().getString(R.string.default_web_client_id);
        GoogleAuthOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(webClient)
                .requestEmail()
                .build();
    }



    public void singin(){
    }
}
