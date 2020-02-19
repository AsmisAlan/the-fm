package com.example.umusic.services;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;

import com.example.umusic.R;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.firebase.auth.FirebaseAuth;

import static android.provider.Settings.System.getString;


public class AuthenticationService  {

    private static AuthenticationService service;
    private  GoogleSignInOptions GoogleAuthOptions;
    private GoogleSignInClient mGoogleSignInClient;
    private FirebaseAuth mAuth;
    private static final int RC_SIGN_IN = 9001;

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



        // [START initialize_auth]
        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
    }



    public void singin(Activity activity){
        mGoogleSignInClient = GoogleSignIn.getClient(activity, GoogleAuthOptions);

        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        activity.startActivityForResult(signInIntent, RC_SIGN_IN);
    }
}
