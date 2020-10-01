package com.jenifer.desarrollo_apps_android_tarea2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Confirmacion extends AppCompatActivity {
    private TextView tvNombre;
    private TextView tvFechaNac;
    private TextView tvTelefono;
    private TextView tvEmail;
    private TextView tvDescripcion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmacion);
        Bundle parametros = getIntent().getExtras();
        String nombre=parametros.getString(getResources().getString(R.string.nombre));
        String fechaNac=parametros.getString(getResources().getString(R.string.fecha_nac));
        String telefono=parametros.getString(getResources().getString(R.string.telefono));
        String email=parametros.getString(getResources().getString(R.string.email));
        String descripcion =parametros.getString(getResources().getString(R.string.descripContacto));

        tvNombre = (TextView) findViewById(R.id.tvNombre);
        tvFechaNac = (TextView) findViewById(R.id.tvFecha_Nac);
        tvTelefono = (TextView) findViewById(R.id.tvTelefono);
        tvEmail = (TextView) findViewById(R.id.tvEmail);
        tvDescripcion = (TextView) findViewById(R.id.tvDescripContacto);

        tvNombre.setText("Nombre:\n" + nombre);
        tvFechaNac.setText("Fecha de Nacimiento:\n" + fechaNac);
        tvTelefono.setText("Telefono:\n" + telefono);
        tvEmail.setText("Email:\n" + email);
        tvDescripcion.setText("Descripción de contacto:\n" + descripcion);

    }
    public void Edition(View view){
        Intent edicion=new Intent(Confirmacion.this,MainActivity.class);
        edicion.putExtra(MainActivity.name, nombre);
        edicion.putExtra(MainActivity.fechaNac, fechaNac);
        edicion.putExtra(MainActivity.telefono, telefono);
        edicion.putExtra(MainActivity.email, email);
        edicion.putExtra(MainActivity.descripcion, descripcion);
        startActivity(edicion);
        finish();
    }
}