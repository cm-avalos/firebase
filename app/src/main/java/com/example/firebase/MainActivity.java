package com.example.firebase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.firebase.Modelo.Alumno;
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
                int edad = Integer.parseInt(etEdad.getText().toString());
                String key= UUID.randomUUID().toString();

                Alumno a = new Alumno(nombre, apellido,edad);

                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("alumno");
                myRef.setValue(a);

            }
        });
    }
}