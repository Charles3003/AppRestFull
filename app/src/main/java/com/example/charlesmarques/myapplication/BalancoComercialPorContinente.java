package com.example.charlesmarques.myapplication;

public class BalancoComercialPorContinente {
    private int AnoBase ;
    private String Continente ;
    private double ValorExportado ;
    private double ValorImportado ;

    public int getAnoBase() {
        return AnoBase;
    }

    public void setAnoBase(int anoBase) {
        AnoBase = anoBase;
    }

    public String getContinente() {
        return Continente;
    }

    public void setContinente(String continente) {
        Continente = continente;
    }

    public double getValorExportado() {
        return ValorExportado;
    }

    public void setValorExportado(double valorExportado) {
        ValorExportado = valorExportado;
    }

    public double getValorImportado() {
        return ValorImportado;
    }

    public void setValorImportado(double valorImportado) {
        ValorImportado = valorImportado;
    }
}
