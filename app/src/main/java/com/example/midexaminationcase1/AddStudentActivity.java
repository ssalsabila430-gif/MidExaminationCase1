package com.example.midexaminationcase1;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddStudentActivity extends AppCompatActivity {

    private EditText etStudentName, etStudentId;
    private Spinner spinnerMajor;
    private Button btnSave;
    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        etStudentName = findViewById(R.id.etStudentName);
        etStudentId = findViewById(R.id.etStudentId);
        spinnerMajor = findViewById(R.id.spinnerMajor);
        btnSave = findViewById(R.id.btnSave);
        dbHelper = new DatabaseHelper(this);

        // Mengisi pilihan Major sesuai soal Case 1 (Informatics / Information Systems)
        String[] majors = {"Informatics", "Information Systems"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, majors);
        spinnerMajor.setAdapter(adapter);

        btnSave.setOnClickListener(v -> {
            String name = etStudentName.getText().toString().trim();
            String studentId = etStudentId.getText().toString().trim();
            String major = spinnerMajor.getSelectedItem().toString();

            if (name.isEmpty() || studentId.isEmpty()) {
                Toast.makeText(this, "Please fill all fields!", Toast.LENGTH_SHORT).show();
                return;
            }

            StudentModel student = new StudentModel(name, studentId, major);
            boolean success = dbHelper.addStudent(student);

            if (success) {
                Toast.makeText(this, "Student Added Successfully!", Toast.LENGTH_SHORT).show();
                finish();
            } else {
                Toast.makeText(this, "Failed to Add Student", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
