package com.luismichu.interfazandroid.XMLmanager;

import com.luismichu.interfazandroid.Data.Dato;
import com.luismichu.interfazandroid.Data.Factura;
import com.luismichu.interfazandroid.Data.Proveedor;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class XMLreader {
    private XMLreader(){}

    public static Factura readFactura(String ruta){
        Document facturaXML = null;
        Factura factura = new Factura();
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            facturaXML = dBuilder.parse(new File(ruta));
        } catch(Exception e) {
            e.printStackTrace();
        }

        try {
            assert facturaXML != null;
            Element lista = (Element) facturaXML.getElementsByTagName(Dato.FACTURA).item(0);
            factura.setCIF_PROVEEDOR(lista.getElementsByTagName(Dato.CIF_PROVEEDOR).item(0).getTextContent());
            factura.setRAZ_PROVEEDOR(lista.getElementsByTagName(Dato.RAZ_PROVEEDOR).item(0).getTextContent());
            factura.setNUM_FACTURA(Integer.parseInt(lista.getElementsByTagName(Dato.NUM_FACTURA).item(0).getTextContent()));
            factura.setDES_FACTURA(lista.getElementsByTagName(Dato.DES_FACTURA).item(0).getTextContent());
            factura.setBAS_IMPONIBLE(Float.parseFloat(lista.getElementsByTagName(Dato.BAS_IMPONIBLE).item(0).getTextContent()));
            factura.setIVA_IMPORTE(Float.parseFloat(lista.getElementsByTagName(Dato.IVA_IMPORTE).item(0).getTextContent()));
            factura.setTOT_IMPORTE(Float.parseFloat(lista.getElementsByTagName(Dato.TOT_IMPORTE).item(0).getTextContent()));
            factura.setFEC_FACTURA(new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz YYYY", Locale.ENGLISH).parse(lista.getElementsByTagName(Dato.FEC_FACTURA).item(0).getTextContent()));
            factura.setFEC_VENCIMIENTO(new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz YYYY", Locale.ENGLISH).parse(lista.getElementsByTagName(Dato.FEC_VENCIMIENTO).item(0).getTextContent()));
        } catch (Exception e){ e.printStackTrace(); }
        return factura;
    }

    public static Proveedor readProveedor(String ruta){
        Document facturaXML = null;
        Proveedor proveedor = new Proveedor();
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            facturaXML = dBuilder.parse(new File(ruta));
        } catch(Exception e) {
            e.printStackTrace();
        }

        try {
            assert facturaXML != null;
            Element lista = (Element) facturaXML.getElementsByTagName(Dato.FACTURA).item(0);
            proveedor.setCIF_PROVEEDOR(lista.getElementsByTagName(Dato.CIF_PROVEEDOR).item(0).getTextContent());
            proveedor.setRAZ_PROVEEDOR(lista.getElementsByTagName(Dato.RAZ_PROVEEDOR).item(0).getTextContent());
            proveedor.setREG_NOTARIAL(Integer.parseInt(lista.getElementsByTagName(Dato.REG_NOTARIAL).item(0).getTextContent()));
            proveedor.setSEG_RESPONSABILIDAD(lista.getElementsByTagName(Dato.SEG_RESPONSABILIDAD).item(0).getTextContent());
            proveedor.setSEG_IMPORTE(Float.parseFloat(lista.getElementsByTagName(Dato.SEG_IMPORTE).item(0).getTextContent()));
            proveedor.setFEC_HOMOLOGACION(new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz YYYY", Locale.ENGLISH).parse(lista.getElementsByTagName(Dato.FEC_HOMOLOGACION).item(0).getTextContent()));
        } catch (Exception e){ e.printStackTrace(); }
        return proveedor;
    }
}
