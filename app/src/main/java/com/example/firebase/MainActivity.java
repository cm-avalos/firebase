package com.example.firebase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

public class MainActivity extends AppCompatActivity {
    Button btnRegistrar;
    EditText etNombre, etApellido, etEdad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        llamadoBtnRegistrar();
        etNombre = (EditText) findViewById(R.id.etNombre);
        etApellido = (EditText) findViewById(R.id.etApellido);
        etEdad = (EditText) findViewById(R.id.etEdad);
        //llamadoBD();

    }

    private void llamadoBD(){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("alumno").child("r1");
        myRef.child("nombre").setValue("carlos");
        myRef.child("apellido").setValue("madariaga");
        myRef.child("edad").setValue("21");


    }


    public void llamadoBtnRegistrar(){
        btnRegistrar = (Button) findViewById(R.id.btnRegistrar);
        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etNombre = (EditText) findViewById(R.id.etNombre);
                etApellido = (EditText) findViewById(R.id.etApellido);
                etEdad = (EditText) findViewById(R.id.etEdad);
                String nombre = etNombre.getText().toString();
                String apellido = etApellido.getText().toString();
                String edad = etEdad.getText().toString();
                String key= UUID.randomUUID().toString();

                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("alumno").child(nombre);
                myRef.child("nombre").setValue(nombre);
                myRef.child("apellido").setValue(apellido);
                myRef.child("edad").setValue(edad);
                Toast.makeText(MainActivity.this, "ssss", Toast.LENGTH_SHORT).show();


            }
        });
    }
}