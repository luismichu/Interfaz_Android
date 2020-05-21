package com.luismichu.interfazandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private SharedPreferences SP;
    private Button btFactura, btProveedor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btProveedor = findViewById(R.id.btProveedor);
        btProveedor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent proveedorIntent = new Intent(getApplicationContext(), ProveedorActivity.class);
                startActivity(proveedorIntent);
            }
        });

        btFactura = findViewById(R.id.btFactura);
        btFactura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent facturaIntent = new Intent(getApplicationContext(), FacturaActivity.class);
                startActivity(facturaIntent);
            }
        });

        SP = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        if(!SP.getBoolean("proveedorIntroducido", false)){
            btFactura.setEnabled(false);
            btProveedor.setText("Añadir Proveedor");
        }
    }

    @Override
    public void onResume() {
        super.onResume();

        if(SP.getBoolean("proveedorIntroducido", false)){
            btFactura.setEnabled(true);
            btProveedor.setText("Editar Proveedor");
        }
    }
}
