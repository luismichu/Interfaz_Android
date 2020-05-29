package com.luismichu.interfazandroid;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.luismichu.interfazandroid.Data.Factura;
import com.luismichu.interfazandroid.JSONmanager.JSONparser;
import com.luismichu.interfazandroid.XMLmanager.XMLparser;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class FacturaActivity extends AppCompatActivity {
    private SharedPreferences SP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_factura);

        EditText cifFactura = findViewById(R.id.cifFactura);
        EditText razonFactura = findViewById(R.id.razonFactura);
        final EditText numeroFactura = findViewById(R.id.numeroFactura);
        final EditText descripcionFactura = findViewById(R.id.descripcionFactura);
        final EditText baseImponible = findViewById(R.id.baseImponible);
        final EditText ivaImporte = findViewById(R.id.ivaImporte);
        final EditText totalImporte = findViewById(R.id.totalImporte);
        final EditText fechaFactura = findViewById(R.id.fechaFactura);
        final EditText fechaVencimiento = findViewById(R.id.fechaVencimiento);

        SP = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        if(SP.getBoolean("proveedorIntroducido", false)){
            cifFactura.setText(SP.getString("cifProveedor", ""));
            razonFactura.setText(SP.getString("razonProveedor", ""));
        }

        Button btAceptar = findViewById(R.id.btAceptarFactura);
        btAceptar.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View view) {
                if(numeroFactura.getText().toString().equals("") ||
                    descripcionFactura.getText().toString().equals("") ||
                    baseImponible.getText().toString().equals("") ||
                    ivaImporte.getText().toString().equals("") ||
                    totalImporte.getText().toString().equals("") ||
                    fechaFactura.getText().toString().equals("") ||
                    fechaVencimiento.getText().toString().equals(""))
                {
                    Toast.makeText(getApplicationContext(), "Por favor rellene todos los campos", Toast.LENGTH_SHORT).show();
                }
                else{
                    Factura factura = new Factura();
                    factura.setNUM_FACTURA(Integer.parseInt(numeroFactura.getText().toString()));
                    factura.setDES_FACTURA(descripcionFactura.getText().toString());
                    factura.setBAS_IMPONIBLE(Float.parseFloat(baseImponible.getText().toString()));
                    factura.setIVA_IMPORTE(Float.parseFloat(ivaImporte.getText().toString()));
                    factura.setTOT_IMPORTE(Float.parseFloat(totalImporte.getText().toString()));
                    SimpleDateFormat formatter = new SimpleDateFormat("DD/MM/YYYY");
                    try {
                        factura.setFEC_FACTURA(formatter.parse(fechaFactura.getText().toString()));
                        factura.setFEC_VENCIMIENTO(formatter.parse(fechaVencimiento.getText().toString()));

                        final String ficJSON = JSONparser.parseFactura(factura);
                        final String ficXML = XMLparser.parseFactura(factura);

                        Toast.makeText(getApplicationContext(), "Factura guardada correctamente", Toast.LENGTH_SHORT).show();
                        AlertDialog.Builder builder = new AlertDialog.Builder(FacturaActivity.this);
                        builder.setMessage("¿Desea enviar por e-mail la factura?")
                                .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        Intent emailIntent = new Intent(Intent.ACTION_SEND);
                                        emailIntent.setData(Uri.parse("mailto:"));
                                        emailIntent.setType("text/plain");
                                        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Factura " + numeroFactura.getText().toString());
                                        String mail = "Numero de factura: " + numeroFactura.getText().toString() + "\n" +
                                                "Descripcion de factura: " + descripcionFactura.getText().toString() + "\n" +
                                                "Base imponible: " + baseImponible.getText().toString() + "\n" +
                                                "IVA: " + ivaImporte.getText().toString() + "\n" +
                                                "Total: " + totalImporte.getText().toString() + "\n" +
                                                "Fecha de factura: " + fechaFactura.getText().toString() + "\n" +
                                                "Fecha de vencimiento: " + fechaVencimiento.getText().toString();
                                        emailIntent.putExtra(Intent.EXTRA_TEXT, mail);
                                        File ficlocationJSON = new File(Environment.getExternalStorageDirectory().getAbsolutePath(), ficJSON);
                                        File ficlocationXML = new File(Environment.getExternalStorageDirectory().getAbsolutePath(), ficXML);
                                        Uri rutaJSON = Uri.parse(ficlocationJSON.toString());
                                        Uri rutaXML = Uri.parse(ficlocationXML.toString());
                                        emailIntent.putExtra(Intent.EXTRA_STREAM, rutaJSON);
                                        emailIntent.putExtra(Intent.EXTRA_STREAM, rutaXML);
                                        try {
                                            startActivity(Intent.createChooser(emailIntent, "Enviar mail..."));
                                        } catch (android.content.ActivityNotFoundException ex) {
                                            Toast.makeText(FacturaActivity.this, "No hay clientes mail instalados", Toast.LENGTH_SHORT).show();
                                        }

                                        onBackPressed();
                                    }
                                })
                                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                        onBackPressed();
                                    }
                                });
                        builder.create().show();

                    } catch (ParseException e) {
                        Toast.makeText(getApplicationContext(), "Formato de la fecha incorrecto, el formato es DD/MM/AAAA", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        Button btCancelar = findViewById(R.id.btCancelarFactura);
        btCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}
