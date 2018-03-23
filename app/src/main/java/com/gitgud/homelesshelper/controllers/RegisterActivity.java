package com.gitgud.homelesshelper.controllers;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import com.gitgud.homelesshelper.R;
import com.gitgud.homelesshelper.model.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.*;

public class RegisterActivity extends AppCompatActivity {

    /**
     * A dummy authentication store containing known user names and passwords.
     * TODO: remove after connecting to a real authentication system.
     */
    private static final String[] DUMMY_CREDENTIALS = new String[]{
            "HelloWorld@gmail.com:foobar", "Main@gmail.com:integer", "Torvalds:opensourceordeath"
    };

    // Firebase Instance
    // Todo: this should eventually be passed as part of the intent from the welcome activity
    private FirebaseAuth mAuth;
    private FirebaseUser user;

    private EditText emailAddressView;
    private EditText usernameView;
    private EditText nameView;
    private EditText passwordView;
    private Button registerButtonView;

    // Todo: Remove once we can set from firebase
    private Spinner classification;
    private TextView type;

    private View mProgressView;
    private View mRegisterFormView;

    private UserRegisterTask mAuthTask = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        emailAddressView = (EditText) findViewById(R.id.email_address);
        usernameView = EditText) findViewById(R.id.username);
        nameView = (EditText) findViewById(R.id.name);
        passwordView = (EditText) findViewById(R.id.password);
        registerButtonView = (Button) findViewById(R.id.register_button);

        // Todo: Remove once we can set from firebase
        classification = (Spinner) findViewById(R.id.account_type_spinner);
        
        registerButtonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptRegistration();
            }
        });

        ArrayAdapter<String> classificationAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item, User.legalClassification);
        classificationAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        classification.setAdapter(classificationAdapter);
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        // Todo: This might need to jump to the dashboard if the login task doesnt already handle it
    }

    /**
     * Shows the progress UI and hides the login form.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    private void showProgress(final boolean show) {
        // On Honeycomb MR2 we have the ViewPropertyAnimator APIs, which allow
        // for very easy animations. If available, use these APIs to fade-in
        // the progress spinner.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);

            mRegisterFormView.setVisibility(show ? View.GONE : View.VISIBLE);
            mRegisterFormView.animate().setDuration(shortAnimTime).alpha(
                    show ? 0 : 1).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mRegisterFormView.setVisibility(show ? View.GONE : View.VISIBLE);
                }
            });

            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            mProgressView.animate().setDuration(shortAnimTime).alpha(
                    show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
                }
            });
        } else {
            // The ViewPropertyAnimator APIs are not available, so simply show
            // and hide the relevant UI components.
            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            mRegisterFormView.setVisibility(show ? View.GONE : View.VISIBLE);
        }
    }

    private void attemptRegistration() {
        // Todo: refactor so that the validation methods to user are instead in ValidationUtils
        if ((User.isEnterableUsername(emailAddressView.getText().toString())) && (User.isEnterablePassword(passwordView.getText().toString())) && ! nameView.getText().toString().equals("nameView")) {
            User.setPassword(passwordView.getText().toString());
            User.setUserName(emailAddressView.getText().toString());
            User.setName(nameView.getText().toString());
            User.setClassification(classification.getSelectedItem().toString());
            if (nameView.getText().toString().equals("nameView")) {
                User.setName(nameView.getText().toString());
            }
            //startActivity(new Intent(RegisterActivity.this, LoadingScreenActivity.class));
            emailAddressView.setText("validated");
            nameView.setText("validated");
            passwordView.setText("validated");

            if (emailAddressView.getText().toString().equals("validated")
                    && nameView.getText().toString().equals("validated")
                    && passwordView.getText().toString().equals("validated")) {

            }


        } else {
            if (! User.isEnterablePassword(passwordView.getText().toString())) {
               passwordView.setText("Invalid Password");

            }
            if (! User.isEnterableUsername(emailAddressView.getText().toString())){
               emailAddressView.setText("Invalid Username");
            }
            if (nameView.getText().toString().equals("nameView")) {
               nameView.setText("Invalid Name");
            }

            //Todo: Needs to kickoff this is entered text is valid
            showProgress(true);
            mAuthTask = new LoginActivity.UserLoginTask(email, password);
            mAuthTask.execute((Void) null);

        }

        class UserRegisterTask extends AsyncTask<Void, Void, Boolean> {

            private final String mEmail;
            private final String mPassword;
            private final String mUsername;
            private final String mName;

            UserRegisterTask(String email, String password) {
                mEmail = emailAddressView.getText().toString();
                mPassword = passwordView.getText().toString();
                mUsername = usernameView.getText().toString();
                mName = nameView.getText().toString();
            }

            @Override
            protected Boolean doInBackground(Void... params) {
                // TODO: attempt authentication against a network service
                mAuth.createUserWithEmailAndPassword(mEmail, mPassword)
                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Log.d(TAG, "createUserWithEmail:success");
                                    user = mAuth.getCurrentUser();
                                } else {
                                    // If sign in fails, display a message to the user.
                                    Log.w(TAG, "createUserWithEmail:failure", task.getException());
                                    Toast.makeText(RegisterActivity.this, "Registration failed.",
                                            Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                        .setDisplayName(mUsername)
                        .build();

                user.updateProfile(profileUpdates)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    Log.d(TAG, "User profile updated during registration");
                                }
                            }
                        });
                return if
            }


                @Override
            protected void onPostExecute(final Boolean success) {
                mAuthTask = null;
                showProgress(false);

                if (success) {
                    finish();

                    startActivity(new Intent(RegisterActivity.this, DashboardActivity.class));
                } else {
                    passwordView.setError(getString(R.string.error_incorrect_password));
                    passwordView.requestFocus();
                }
            }

            @Override
            protected void onCancelled() {
                mAuthTask = null;
                showProgress(false);
            }
        }

    }
}
