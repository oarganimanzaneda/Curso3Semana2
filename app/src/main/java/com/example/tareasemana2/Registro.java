package com.example.tareasemana2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Registro extends AppCompatActivity {
    TextView tvNombre, tvFecha, tvTelefono,tvEmail,tvDescripcion;
    Button btEditar;
    Intent intentEditar = new Intent();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        tvNombre = findViewById(R.id.tvNombre);
        tvFecha = findViewById(R.id.tvFecha);
        tvTelefono = findViewById(R.id.tvTelefono);
        tvEmail = findViewById(R.id.tvEmail);
        tvDescripcion = findViewById(R.id.tvDescripcion);
        btEditar = findViewById(R.id.btEditar);

        Bundle parametros = getIntent().getExtras();

        tvNombre.setText(parametros.getString(getResources().getString(R.string.pnombre)));
        tvFecha.setText(getIntent().getStringExtra(getResources().getString(R.string.pfecha)));
        tvTelefono.setText(getIntent().getStringExtra(getResources().getString(R.string.ptelefono)));
        tvEmail.setText(getIntent().getStringExtra(getResources().getString(R.string.pemail)));
        tvDescripcion.setText(getIntent().getStringExtra(getResources().getString(R.string.pdescripcion)));
    }
    public void editar (View view){
        Intent editar = new Intent(Registro.this,MainActivity.class);
        editar.putExtra(getResources().getString(R.string.pnombre),tvNombre.getText().toString());
        editar.putExtra(getResources().getString(R.string.ptelefono),tvTelefono.getText().toString());
        editar.putExtra(getResources().getString(R.string.pemail),tvEmail.getText().toString());
        editar.putExtra(getResources().getString(R.string.pdescripcion),tvDescripcion.getText().toString());
        startActivity(editar);
        finish();
    }
}