package com.luismichu.interfazandroid.Data;

import java.util.Date;

public class Factura {
    private String CIF_PROVEEDOR;
    private String RAZ_PROVEEDOR;
    private int NUM_FACTURA;
    private String DES_FACTURA;
    private float BAS_IMPONIBLE;
    private float IVA_IMPORTE;
    private float TOT_IMPORTE;
    private Date FEC_FACTURA;
    private Date FEC_VENCIMIENTO;

    public Factura() {}

    public Factura(String CIF_PROVEEDOR, String RAZ_PROVEEDOR, int NUM_FACTURA, String DES_FACTURA,
                   float BAS_IMPONIBLE, float IVA_IMPORTE, float TOT_IMPORTE, Date FEC_FACTURA,
                   Date FEC_VENCIMIENTO) {
        this.CIF_PROVEEDOR = CIF_PROVEEDOR;
        this.RAZ_PROVEEDOR = RAZ_PROVEEDOR;
        this.NUM_FACTURA = NUM_FACTURA;
        this.DES_FACTURA = DES_FACTURA;
        this.BAS_IMPONIBLE = BAS_IMPONIBLE;
        this.IVA_IMPORTE = IVA_IMPORTE;
        this.TOT_IMPORTE = TOT_IMPORTE;
        this.FEC_FACTURA = FEC_FACTURA;
        this.FEC_VENCIMIENTO = FEC_VENCIMIENTO;
    }

    public String getCIF_PROVEEDOR() {
        return CIF_PROVEEDOR;
    }

    public String getRAZ_PROVEEDOR() {
        return RAZ_PROVEEDOR;
    }

    public int getNUM_FACTURA() {
        return NUM_FACTURA;
    }

    public String getDES_FACTURA() {
        return DES_FACTURA;
    }

    public float getBAS_IMPONIBLE() {
        return BAS_IMPONIBLE;
    }

    public float getIVA_IMPORTE() {
        return IVA_IMPORTE;
    }

    public float getTOT_IMPORTE() {
        return TOT_IMPORTE;
    }

    public Date getFEC_FACTURA() {
        return FEC_FACTURA;
    }

    public Date getFEC_VENCIMIENTO() {
        return FEC_VENCIMIENTO;
    }

    public void setCIF_PROVEEDOR(String CIF_PROVEEDOR) {
        this.CIF_PROVEEDOR = CIF_PROVEEDOR;
    }

    public void setRAZ_PROVEEDOR(String RAZ_PROVEEDOR) {
        this.RAZ_PROVEEDOR = RAZ_PROVEEDOR;
    }

    public void setNUM_FACTURA(int NUM_FACTURA) {
        this.NUM_FACTURA = NUM_FACTURA;
    }

    public void setDES_FACTURA(String DES_FACTURA) {
        this.DES_FACTURA = DES_FACTURA;
    }

    public void setBAS_IMPONIBLE(float BAS_IMPONIBLE) {
        this.BAS_IMPONIBLE = BAS_IMPONIBLE;
    }

    public void setIVA_IMPORTE(float IVA_IMPORTE) {
        this.IVA_IMPORTE = IVA_IMPORTE;
    }

    public void setTOT_IMPORTE(float TOT_IMPORTE) {
        this.TOT_IMPORTE = TOT_IMPORTE;
    }

    public void setFEC_FACTURA(Date FEC_FACTURA) {
        this.FEC_FACTURA = FEC_FACTURA;
    }

    public void setFEC_VENCIMIENTO(Date FEC_VENCIMIENTO) {
        this.FEC_VENCIMIENTO = FEC_VENCIMIENTO;
    }
}
