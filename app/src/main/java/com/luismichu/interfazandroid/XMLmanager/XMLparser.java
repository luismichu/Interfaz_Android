package com.luismichu.interfazandroid.XMLmanager;

import com.luismichu.interfazandroid.Data.Dato;
import com.luismichu.interfazandroid.Data.Factura;
import com.luismichu.interfazandroid.Data.Proveedor;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class XMLparser {
    private XMLparser(){}

    public static String parseFactura(Factura factura){
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.newDocument();

            Element facturaXML = doc.createElement(Dato.FACTURA);
            doc.appendChild(facturaXML);

            Element CIF_PROVEEDOR = doc.createElement(Dato.CIF_PROVEEDOR);
            CIF_PROVEEDOR.appendChild(doc.createTextNode(factura.getCIF_PROVEEDOR()));
            facturaXML.appendChild(CIF_PROVEEDOR);

            Element RAZ_PROVEEDOR = doc.createElement(Dato.RAZ_PROVEEDOR);
            RAZ_PROVEEDOR.appendChild(doc.createTextNode(factura.getRAZ_PROVEEDOR()));
            facturaXML.appendChild(RAZ_PROVEEDOR);

            Element NUM_FACTURA = doc.createElement(Dato.NUM_FACTURA);
            NUM_FACTURA.appendChild(doc.createTextNode(String.valueOf(factura.getNUM_FACTURA())));
            facturaXML.appendChild(NUM_FACTURA);

            Element DES_FACTURA = doc.createElement(Dato.DES_FACTURA);
            DES_FACTURA.appendChild(doc.createTextNode(factura.getDES_FACTURA()));
            facturaXML.appendChild(DES_FACTURA);

            Element BAS_IMPONIBLE = doc.createElement(Dato.BAS_IMPONIBLE);
            BAS_IMPONIBLE.appendChild(doc.createTextNode(String.valueOf(factura.getBAS_IMPONIBLE())));
            facturaXML.appendChild(BAS_IMPONIBLE);

            Element IVA_IMPORTE = doc.createElement(Dato.IVA_IMPORTE);
            IVA_IMPORTE.appendChild(doc.createTextNode(String.valueOf(factura.getIVA_IMPORTE())));
            facturaXML.appendChild(IVA_IMPORTE);

            Element TOT_IMPORTE = doc.createElement(Dato.TOT_IMPORTE);
            TOT_IMPORTE.appendChild(doc.createTextNode(String.valueOf(factura.getTOT_IMPORTE())));
            facturaXML.appendChild(TOT_IMPORTE);

            Element FEC_FACTURA = doc.createElement(Dato.FEC_FACTURA);
            FEC_FACTURA.appendChild(doc.createTextNode(factura.getFEC_FACTURA().toString()));
            facturaXML.appendChild(FEC_FACTURA);

            Element FEC_VENCIMIENTO = doc.createElement(Dato.FEC_VENCIMIENTO);
            FEC_VENCIMIENTO.appendChild(doc.createTextNode(factura.getFEC_VENCIMIENTO().toString()));
            facturaXML.appendChild(FEC_VENCIMIENTO);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("factura" + factura.getNUM_FACTURA() + ".xml"));

            transformer.transform(source, result);
        } catch(Exception e) {
            e.printStackTrace();
        }

        return "factura" + factura.getNUM_FACTURA() + ".xml";
    }

    public static void parseProveedor(Proveedor proveedor){
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.newDocument();

            Element facturaXML = doc.createElement(Dato.FACTURA);
            doc.appendChild(facturaXML);

            Element CIF_PROVEEDOR = doc.createElement(Dato.CIF_PROVEEDOR);
            CIF_PROVEEDOR.appendChild(doc.createTextNode(proveedor.getCIF_PROVEEDOR()));
            facturaXML.appendChild(CIF_PROVEEDOR);

            Element RAZ_PROVEEDOR = doc.createElement(Dato.RAZ_PROVEEDOR);
            RAZ_PROVEEDOR.appendChild(doc.createTextNode(proveedor.getRAZ_PROVEEDOR()));
            facturaXML.appendChild(RAZ_PROVEEDOR);

            Element REG_NOTARIAL = doc.createElement(Dato.REG_NOTARIAL);
            REG_NOTARIAL.appendChild(doc.createTextNode(String.valueOf(proveedor.getREG_NOTARIAL())));
            facturaXML.appendChild(REG_NOTARIAL);

            Element SEG_RESPONSABILIDAD = doc.createElement(Dato.SEG_RESPONSABILIDAD);
            SEG_RESPONSABILIDAD.appendChild(doc.createTextNode(proveedor.getSEG_RESPONSABILIDAD()));
            facturaXML.appendChild(SEG_RESPONSABILIDAD);

            Element SEG_IMPORTE = doc.createElement(Dato.SEG_IMPORTE);
            SEG_IMPORTE.appendChild(doc.createTextNode(String.valueOf(proveedor.getSEG_IMPORTE())));
            facturaXML.appendChild(SEG_IMPORTE);

            Element FEC_HOMOLOGACION = doc.createElement(Dato.FEC_HOMOLOGACION);
            FEC_HOMOLOGACION.appendChild(doc.createTextNode(proveedor.getFEC_HOMOLOGACION().toString()));
            facturaXML.appendChild(FEC_HOMOLOGACION);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("Proveedores/proveedor" + proveedor.getCIF_PROVEEDOR() + ".xml"));

            transformer.transform(source, result);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
