package com.jenifer.desarrollo_apps_android_tarea2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;;


import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    //Seteo de las variables a capturar////////////////////////////
    public EditText fechaNac;
    public Calendar calendario;
    public final EditText nameField;
    public String name;

    public final EditText emailField;
    public String email;

    public final EditText telefono1;
    public String telefono;

    public final EditText descField;
    public String descripcion;

//////////Getters y setters///////////////////////////////////////
    public EditText getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(EditText fechaNac) {
        this.fechaNac = fechaNac;
    }

    public Calendar getCalendario() {
        return calendario;
    }

    public void setCalendario(Calendar calendario) {
        this.calendario = calendario;
    }

    public EditText getNameField() {
        return nameField;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EditText getEmailField() {
        return emailField;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public EditText getTelefono1() {
        return telefono1;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public DatePickerDialog.OnDateSetListener getDate() {
        return date;
    }

    public void setDate(DatePickerDialog.OnDateSetListener date) {
        this.date = date;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    /////////////////////////////////////////////////////////////////

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calendario = Calendar.getInstance();
        nameField = (EditText) findViewById(R.id.EditNombre);
        name = nameField.getText().toString();

        emailField = (EditText) findViewById(R.id.EditEmail);
        email = emailField.getText().toString();

        telefono1 = (EditText) findViewById(R.id.EditTelefono);
        telefono = telefono1.getText().toString();

        descField = (EditText) findViewById(R.id.EditDescripContacto);
        descripcion = descField.getText().toString();


        fechaNac = findViewById(R.id.Fecha_Nac);
        fechaNac.setOnClickListener() = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            new DatePickerDialog(MainActivity.this, date, calendario.get(Calendar.YEAR),
                    calendario.get(Calendar.MONTH),
                    calendario.get(Calendar.DAY_OF_MONTH)).show();
        }
    };
        sendFeedback();
}

    DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            // TODO Auto-generated method stub
            calendario.set(Calendar.YEAR, year);
            calendario.set(Calendar.MONTH, monthOfYear);
            calendario.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            actualizarInput();
        }

    };

    private void actualizarInput() {
        String formatoDeFecha = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(formatoDeFecha, Locale.US);

        fechaNac.setText(sdf.format(calendario.getTime()));
    }

}

//////////////Para el botón///////
    public void sendFeedback() {
        Button miBoton= (Button) findViewById(R.id.BotonEnviar);
        miBoton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent datos = new Intent(MainActivity.this, Confirmacion.class);
                datos.putExtra(Confirmacion.nombre,name.trim());
                datos.putExtra(Confirmacion.fechaNac,fechaNac);
                datos.putExtra(Confirmacion.telefono,telefono.trim());
                datos.putExtra(Confirmacion.email,email.trim());
                datos.putExtra(Confirmacion.descripcion,descripcion.trim());
                startActivity(datos);
                finish();
            }
            );
        }
    }
};
