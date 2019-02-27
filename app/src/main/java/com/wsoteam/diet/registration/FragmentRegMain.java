package com.wsoteam.diet.registration;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.wsoteam.diet.R;
import com.wsoteam.diet.onboarding.ActivityOnboarding;

public class FragmentRegMain extends Fragment implements View.OnClickListener, GoogleApiClient.OnConnectionFailedListener {

    private static final String TAG = "EmailPasswordReg";

    // [START declare_auth]
    private FirebaseAuth mAuth;
    GoogleSignInClient mGoogleSignInClient;
    // [END declare_auth]

    private EditText emailEditText;
    private EditText passwordEditText;
    private EditText nameEditText;
    private TextView statusTextView;

    private static final int RC_SIGN_IN = 9001;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.registration_fragment_main, null);

        // Configure Google Sign In
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        mGoogleSignInClient = GoogleSignIn.getClient(getActivity(), gso);

        // Button
        view.findViewById(R.id.btn_reg_email).setOnClickListener(this);
        view.findViewById(R.id.btn_facebook).setOnClickListener(this);
        view.findViewById(R.id.btn_google).setOnClickListener(this);

        // Set the dimensions of the sign-in button.
        SignInButton signInButton = view.findViewById(R.id.btn_google);
//        signInButton.setSize(SignInButton.SIZE_STANDARD);

        // View
        emailEditText = view.findViewById(R.id.et_reg_email);
        passwordEditText = view.findViewById(R.id.et_reg_pass);
        nameEditText = view.findViewById(R.id.et_reg_name);

        emailEditText.setText( "testuser7223@mail.ru");
        passwordEditText.setText("123456789");
        nameEditText.setText("Vasia");

        // [START initialize_auth]
        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
        // [END initialize_auth]

        return view;
    }


    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getActivity(), ActivityOnboarding.class);

        switch (v.getId()){
            case R.id.btn_reg_email:
                if (validateForm()) {
                    createAccount(emailEditText.getText().toString(),
                            passwordEditText.getText().toString());
                }
                break;
            case R.id.btn_google:
                    signIn();
                break;
            case R.id.btn_facebook:
                break;
        }

        Toast.makeText(getActivity(), "Вы нажали на кнопку " + v.getId(),
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
    }

    private void updateUI(FirebaseUser user) {

        if (user != null) {
//            statusTextView.setText(getString(R.string.emailpassword_status_fmt,
//                    user.getEmail(), user.isEmailVerified()));
//            detailTextView.setText(getString(R.string.firebase_status_fmt, user.getUid()));


        } else {
//            statusTextView.setText(R.string.signed_out);
//            detailTextView.setText(null);
        }
    }

    private boolean validateForm(){

        if (!emailEditText.getText().toString().matches("") ||
                !passwordEditText.getText().toString().matches("") ||
                !nameEditText.getText().toString().matches("")){
            return true;
        } else {

            return false;
        }
    }

    private void createAccount(String email, String password) {
        Log.d(TAG, "createAccount:" + email);
        if (!validateForm()) {
            return;
        }

        getActivity();

        // [START create_user_with_email]
        Task<AuthResult> task = mAuth.createUserWithEmailAndPassword(email, password);
        task.addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

            }
        });
    }


    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }
}
