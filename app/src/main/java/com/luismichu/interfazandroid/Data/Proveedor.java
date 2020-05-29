package com.luismichu.interfazandroid.Data;

import java.util.Date;

public class Proveedor {
    private String CIF_PROVEEDOR;
    private String RAZ_PROVEEDOR;
    private int REG_NOTARIAL;
    private String SEG_RESPONSABILIDAD;
    private float SEG_IMPORTE;
    private Date FEC_HOMOLOGACION;

    public Proveedor() {
    }

    public Proveedor(String CIF_PROVEEDOR, String RAZ_PROVEEDOR, int REG_NOTARIAL,
                     String SEG_RESPONSABILIDAD, float SEG_IMPORTE, Date FEC_HOMOLOGACION) {
        this.CIF_PROVEEDOR = CIF_PROVEEDOR;
        this.RAZ_PROVEEDOR = RAZ_PROVEEDOR;
        this.REG_NOTARIAL = REG_NOTARIAL;
        this.SEG_RESPONSABILIDAD = SEG_RESPONSABILIDAD;
        this.SEG_IMPORTE = SEG_IMPORTE;
        this.FEC_HOMOLOGACION = FEC_HOMOLOGACION;
    }

    public String getCIF_PROVEEDOR() {
        return CIF_PROVEEDOR;
    }

    public String getRAZ_PROVEEDOR() {
        return RAZ_PROVEEDOR;
    }

    public int getREG_NOTARIAL() {
        return REG_NOTARIAL;
    }

    public String getSEG_RESPONSABILIDAD() {
        return SEG_RESPONSABILIDAD;
    }

    public float getSEG_IMPORTE() {
        return SEG_IMPORTE;
    }

    public Date getFEC_HOMOLOGACION() {
        return FEC_HOMOLOGACION;
    }

    public void setCIF_PROVEEDOR(String CIF_PROVEEDOR) {
        this.CIF_PROVEEDOR = CIF_PROVEEDOR;
    }

    public void setRAZ_PROVEEDOR(String RAZ_PROVEEDOR) {
        this.RAZ_PROVEEDOR = RAZ_PROVEEDOR;
    }

    public void setREG_NOTARIAL(int REG_NOTARIAL) {
        this.REG_NOTARIAL = REG_NOTARIAL;
    }

    public void setSEG_RESPONSABILIDAD(String SEG_RESPONSABILIDAD) {
        this.SEG_RESPONSABILIDAD = SEG_RESPONSABILIDAD;
    }

    public void setSEG_IMPORTE(float SEG_IMPORTE) {
        this.SEG_IMPORTE = SEG_IMPORTE;
    }

    public void setFEC_HOMOLOGACION(Date FEC_HOMOLOGACION) {
        this.FEC_HOMOLOGACION = FEC_HOMOLOGACION;
    }
}
