package com.example.tareasemana2;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import android.widget.EditText;

import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DatePicker calendario;
    EditText nombre,telefono,email,descripcion;
    Button boton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calendario = findViewById(R.id.dpFecha);
        nombre = findViewById(R.id.etNombre);
        telefono = findViewById(R.id.etTelefono);
        email = findViewById(R.id.etEmail);
        descripcion = findViewById(R.id.etDescripcion);
        boton = findViewById(R.id.btSiguiente);

        nombre.setText(getIntent().getStringExtra(getResources().getString(R.string.pnombre)));
        telefono.setText(getIntent().getStringExtra(getResources().getString(R.string.ptelefono)));
        email.setText(getIntent().getStringExtra(getResources().getString(R.string.pemail)));
        descripcion.setText(getIntent().getStringExtra(getResources().getString(R.string.pdescripcion)));

    }
    public void siguiente (View view){
        if (!nombre.getText().toString().isEmpty()&&!telefono.getText().toString().isEmpty()&&!email.getText().toString().isEmpty()){
            Intent registro = new Intent(MainActivity.this,Registro.class);
            registro.putExtra(getResources().getString(R.string.pnombre),nombre.getText().toString());
            registro.putExtra(getResources().getString(R.string.pfecha),calendario.getDayOfMonth()+"/"+(calendario.getMonth()+1)+"/"+calendario.getYear());
            registro.putExtra(getResources().getString(R.string.ptelefono),telefono.getText().toString());
            registro.putExtra(getResources().getString(R.string.pemail),email.getText().toString());
            registro.putExtra(getResources().getString(R.string.pdescripcion),descripcion.getText().toString());
            startActivity(registro);
            finish();
        }
        else
        {
            Toast.makeText(this,"Ingrese todos los datos",Toast.LENGTH_LONG).show();
        }
    }
}