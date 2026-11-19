package com.example.myapplication;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private EditText edtFullName;
    private EditText edtEmail;
    private EditText edtPhone;
    private EditText edtPassword;
    private EditText edtAddress;

    private RadioGroup radioGroupGender;
    private Spinner spinnerProgramme;

    private CheckBox checkJava;
    private CheckBox checkAndroid;
    private CheckBox checkDatabase;
    private CheckBox checkTerms;

    private Switch switchNotification;

    private TextView txtDateOfBirth;
    private TextView txtResult;

    private Button btnSelectDate;
    private Button btnRegister;
    private Button btnClear;
   private Button btnClick;

    private String selectedDate = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userreg_constraint);
        Log.d("LifeCycleTest", "Activity Created");
        btnClick = findViewById(R.id.btnClick);
        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(i);
            }
        });

        initializeViews();
        setProgrammeSpinner();
        setClickListeners();
    }
    @Override
    protected void onStart(){
        super.onStart();
        Log.d("LifeCycleTest", "Activity Started");
    }
    @Override
    protected void onResume(){
        super.onResume();
        Log.d("LifeCycleTest", "Activity Resumed");
    }
    @Override
    protected void onRestart(){
        super.onRestart();
        Log.d("LifeCycleTest", "Activity Restarted");
    }
    @Override
    protected void onPause(){
        super.onPause();
        Log.d("LifeCycleTest", "Activity Paused");
    }
    @Override
    protected void onStop(){
        super.onStop();
        Log.d("LifeCycleTest", "Activity Stopped");
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d("LifeCycleTest", "Activity Destroy");
    }





    private void initializeViews() {
        edtFullName = findViewById(R.id.edtFullName);
        edtEmail = findViewById(R.id.edtEmail);
        edtPhone = findViewById(R.id.edtPhone);
        edtPassword = findViewById(R.id.edtPassword);
        edtAddress = findViewById(R.id.edtAddress);

        radioGroupGender = findViewById(R.id.radioGroupGender);
        spinnerProgramme = findViewById(R.id.spinnerProgramme);

        checkJava = findViewById(R.id.checkJava);
        checkAndroid = findViewById(R.id.checkAndroid);
        checkDatabase = findViewById(R.id.checkDatabase);
        checkTerms = findViewById(R.id.checkTerms);

        switchNotification = findViewById(R.id.switchNotification);

        txtDateOfBirth = findViewById(R.id.txtDateOfBirth);
        txtResult = findViewById(R.id.txtResult);

        btnSelectDate = findViewById(R.id.btnSelectDate);
        btnRegister = findViewById(R.id.btnRegister);
        btnClear = findViewById(R.id.btnClear);
    }

    private void setProgrammeSpinner() {
        String[] programmes = {
                "Select Programme",
                "BCA",
                "BSc CSIT",
                "BIT",
                "BIM",
                "BBA"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                programmes
        );

        adapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item
        );

        spinnerProgramme.setAdapter(adapter);
    }

    private void setClickListeners() {
        btnSelectDate.setOnClickListener(view -> showDatePicker());

        btnRegister.setOnClickListener(view -> registerUser());

        btnClear.setOnClickListener(view -> clearForm());
    }

    private void showDatePicker() {
        Calendar calendar = Calendar.getInstance();

        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(
                MainActivity.this,
                (datePicker, selectedYear, selectedMonth, selectedDay) -> {
                    selectedDate = selectedDay + "/"
                            + (selectedMonth + 1) + "/"
                            + selectedYear;

                    txtDateOfBirth.setText(selectedDate);
                },
                year,
                month,
                day
        );

        datePickerDialog.show();
    }

    private void registerUser() {
        String fullName = edtFullName.getText().toString().trim();
        String email = edtEmail.getText().toString().trim();
        String phone = edtPhone.getText().toString().trim();
        String password = edtPassword.getText().toString();
        String address = edtAddress.getText().toString().trim();

        if (fullName.isEmpty()) {
            edtFullName.setError("Please enter your full name");
            edtFullName.requestFocus();
            return;
        }

        if (email.isEmpty()) {
            edtEmail.setError("Please enter your email");
            edtEmail.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            edtEmail.setError("Please enter a valid email address");
            edtEmail.requestFocus();
            return;
        }

        if (phone.isEmpty()) {
            edtPhone.setError("Please enter your phone number");
            edtPhone.requestFocus();
            return;
        }

        if (phone.length() != 10) {
            edtPhone.setError("Phone number must contain 10 digits");
            edtPhone.requestFocus();
            return;
        }

        if (password.isEmpty()) {
            edtPassword.setError("Please enter a password");
            edtPassword.requestFocus();
            return;
        }

        if (password.length() < 6) {
            edtPassword.setError(
                    "Password must contain at least 6 characters"
            );
            edtPassword.requestFocus();
            return;
        }

        if (address.isEmpty()) {
            edtAddress.setError("Please enter your address");
            edtAddress.requestFocus();
            return;
        }

        int selectedGenderId =
                radioGroupGender.getCheckedRadioButtonId();

        if (selectedGenderId == -1) {
            Toast.makeText(
                    this,
                    "Please select your gender",
                    Toast.LENGTH_SHORT
            ).show();
            return;
        }

        if (selectedDate.isEmpty()) {
            Toast.makeText(
                    this,
                    "Please select your date of birth",
                    Toast.LENGTH_SHORT
            ).show();
            return;
        }

        String programme =
                spinnerProgramme.getSelectedItem().toString();

        if (spinnerProgramme.getSelectedItemPosition() == 0) {
            Toast.makeText(
                    this,
                    "Please select a programme",
                    Toast.LENGTH_SHORT
            ).show();
            return;
        }

        if (!checkTerms.isChecked()) {
            Toast.makeText(
                    this,
                    "Please accept the terms and conditions",
                    Toast.LENGTH_SHORT
            ).show();
            return;
        }

        RadioButton selectedGender =
                findViewById(selectedGenderId);

        String gender =
                selectedGender.getText().toString();

        String skills = getSelectedSkills();

        String notificationStatus;

        if (switchNotification.isChecked()) {
            notificationStatus = "Enabled";
        } else {
            notificationStatus = "Disabled";
        }

        String result =
                "Your information is as follows:\n\n" +
                        "Full Name: " + fullName + "\n" +
                        "Email: " + email + "\n" +
                        "Phone Number: " + phone + "\n" +
                        "Address: " + address + "\n" +
                        "Gender: " + gender + "\n" +
                        "Date of Birth: " + selectedDate + "\n" +
                        "Programme: " + programme + "\n" +
                        "Skills: " + skills + "\n" +
                        "Notifications: " + notificationStatus;
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);

        intent.putExtra("Your Details", result);
        txtResult.setText(result);
        txtResult.setVisibility(View.VISIBLE);

        Toast.makeText(
                this,
                "Registration successful",
                Toast.LENGTH_SHORT
        ).show();


    }

    private String getSelectedSkills() {
        StringBuilder skills = new StringBuilder();

        if (checkJava.isChecked()) {
            skills.append("Java");
        }

        if (checkAndroid.isChecked()) {
            appendSkill(skills, "Android");
        }

        if (checkDatabase.isChecked()) {
            appendSkill(skills, "Database");
        }

        if (skills.length() == 0) {
            return "Not selected";
        }

        return skills.toString();
    }

    private void appendSkill(
            StringBuilder skills,
            String newSkill
    ) {
        if (skills.length() > 0) {
            skills.append(", ");
        }

        skills.append(newSkill);
    }

    private void clearForm() {
        edtFullName.setText("");
        edtEmail.setText("");
        edtPhone.setText("");
        edtPassword.setText("");
        edtAddress.setText("");

        radioGroupGender.clearCheck();
        spinnerProgramme.setSelection(0);

        checkJava.setChecked(false);
        checkAndroid.setChecked(false);
        checkDatabase.setChecked(false);
        checkTerms.setChecked(false);

        switchNotification.setChecked(false);

        selectedDate = "";
        txtDateOfBirth.setText("No date selected");

        txtResult.setText("");
        txtResult.setVisibility(View.GONE);

        edtFullName.requestFocus();

        Toast.makeText(
                this,
                "Form cleared",
                Toast.LENGTH_SHORT
        ).show();
    }
}