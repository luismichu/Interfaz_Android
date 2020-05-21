package com.luismichu.interfazandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ProveedorActivity extends AppCompatActivity {
    private SharedPreferences SP;
    private SharedPreferences.Editor preferenceEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proveedor);

        final EditText cifProveedor = findViewById(R.id.cifProveedor);
        final EditText razonProveedor = findViewById(R.id.razonProveedor);
        final EditText registroNotarial = findViewById(R.id.registroNotarial);
        final EditText seguroResponsabilidad = findViewById(R.id.seguroResponsabilidad);
        final EditText seguroImporte = findViewById(R.id.seguroImporte);
        final EditText fechaHomologacion = findViewById(R.id.fechaHomologacion);
        final EditText codigoAutorizacion = findViewById(R.id.codigoAutorizacion);

        SP = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        if(SP.getBoolean("proveedorIntroducido", false)){
            cifProveedor.setText(SP.getString("cifProveedor", ""));
            razonProveedor.setText(SP.getString("razonProveedor", ""));
            registroNotarial.setText(String.valueOf(SP.getInt("registroNotarial", 0)));
            seguroResponsabilidad.setText(SP.getString("seguroResponsabilidad", ""));
            seguroImporte.setText(String.valueOf(SP.getFloat("seguroImporte", 0f)));
            fechaHomologacion.setText(SP.getString("fechaHomologacion", ""));
        }
        else{
            TextView txt = findViewById(R.id.txtProveedor);
            txt.setText("Añadir Proveedor");
        }

        Button btAceptar = findViewById(R.id.btAceptarFactura);
        btAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cifProveedor.getText().toString().equals("") ||
                    razonProveedor.getText().toString().equals("") ||
                    registroNotarial.getText().toString().equals("") ||
                    seguroResponsabilidad.getText().toString().equals("") ||
                    seguroImporte.getText().toString().equals("") ||
                    fechaHomologacion.getText().toString().equals("") ||
                    codigoAutorizacion.getText().toString().equals(""))
                {
                    Toast.makeText(getApplicationContext(), "Por favor rellene todos los campos", Toast.LENGTH_SHORT).show();
                }
                else{
                    preferenceEditor = SP.edit();

                    preferenceEditor.putString("cifProveedor", cifProveedor.getText().toString());
                    preferenceEditor.putString("razonProveedor", razonProveedor.getText().toString());
                    preferenceEditor.putInt("registroNotarial", Integer.parseInt(registroNotarial.getText().toString()));
                    preferenceEditor.putString("seguroResponsabilidad", seguroResponsabilidad.getText().toString());
                    preferenceEditor.putFloat("seguroImporte", Float.parseFloat(seguroImporte.getText().toString()));
                    preferenceEditor.putString("fechaHomologacion", fechaHomologacion.getText().toString());
                    preferenceEditor.putBoolean("proveedorIntroducido", true);
                    preferenceEditor.putString("codigoAutorizacion", codigoAutorizacion.getText().toString());

                    preferenceEditor.apply();

                    Toast.makeText(getApplicationContext(), "Proveedor guardado correctamente", Toast.LENGTH_SHORT).show();
                    onBackPressed();
                }
            }
        });

        Button btCancelar = findViewById(R.id.btCancelar);
        btCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}
