package com.luismichu.interfazandroid.JSONmanager;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.luismichu.interfazandroid.Data.Dato;
import com.luismichu.interfazandroid.Data.Factura;
import com.luismichu.interfazandroid.Data.Proveedor;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class JSONreader {
    private JSONreader(){}

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public static Factura readFactura(String ruta){
        JSONParser jsonParser = new JSONParser();
        JSONObject facturaJSON = null;

        try (FileReader reader = new FileReader(ruta))
        {
            facturaJSON = (JSONObject) jsonParser.parse(reader);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Factura factura = new Factura();
        try{
            assert facturaJSON != null;
            factura.setCIF_PROVEEDOR((String) facturaJSON.get(Dato.CIF_PROVEEDOR));
            factura.setRAZ_PROVEEDOR((String)facturaJSON.get(Dato.RAZ_PROVEEDOR));
            factura.setNUM_FACTURA(((Long)facturaJSON.get(Dato.NUM_FACTURA)).intValue());
            factura.setDES_FACTURA((String)facturaJSON.get(Dato.DES_FACTURA));
            factura.setBAS_IMPONIBLE(((Double)facturaJSON.get(Dato.BAS_IMPONIBLE)).floatValue());
            factura.setIVA_IMPORTE(((Double)facturaJSON.get(Dato.IVA_IMPORTE)).floatValue());
            factura.setTOT_IMPORTE(((Double)facturaJSON.get(Dato.TOT_IMPORTE)).floatValue());
            factura.setFEC_FACTURA(new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz YYYY", Locale.ENGLISH).parse((String)facturaJSON.get(Dato.FEC_FACTURA)));
            factura.setFEC_VENCIMIENTO(new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz YYYY", Locale.ENGLISH).parse((String)facturaJSON.get(Dato.FEC_VENCIMIENTO)));
        }catch (Exception e){
            e.printStackTrace();
        }

        return factura;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public static Proveedor readProveedor(String ruta){
        JSONParser jsonParser = new JSONParser();
        JSONObject proveedorJSON = null;

        try (FileReader reader = new FileReader(ruta))
        {
            proveedorJSON = (JSONObject) jsonParser.parse(reader);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Proveedor proveedor = new Proveedor();
        try{
            assert proveedorJSON != null;
            proveedor.setCIF_PROVEEDOR((String)proveedorJSON.get(Dato.CIF_PROVEEDOR));
            proveedor.setRAZ_PROVEEDOR((String)proveedorJSON.get(Dato.RAZ_PROVEEDOR));
            proveedor.setREG_NOTARIAL((int)proveedorJSON.get(Dato.REG_NOTARIAL));
            proveedor.setSEG_RESPONSABILIDAD((String)proveedorJSON.get(Dato.SEG_RESPONSABILIDAD));
            proveedor.setSEG_IMPORTE((float)proveedorJSON.get(Dato.SEG_IMPORTE));
            proveedor.setFEC_HOMOLOGACION((Date)proveedorJSON.get(Dato.FEC_HOMOLOGACION));
        }catch (Exception e){
            e.printStackTrace();
        }

        return proveedor;
    }
}
