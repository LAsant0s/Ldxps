package com.assis.ldxps.dominio;

public class Cliente {
	private String cdCl; 
	private String dsNome;
	private String cdVend; 
	private String idTipo; 
	private double dsLim;
	
	public Cliente(String dsNome, String cdVend, String idTipo, double dsLim) {
		this.dsNome = dsNome;
		this.cdVend = cdVend;
		this.idTipo = idTipo;
		this.dsLim = dsLim;
	}
	
	public Cliente(String cdCl, String dsNome, String cdVend, String idTipo, double dsLim) {
		this.cdCl = cdCl;
		this.dsNome = dsNome;
		this.cdVend = cdVend;
		this.idTipo = idTipo;
		this.dsLim = dsLim;
	}
	public Cliente(String cdCl, double dsLim, String dsNome, String idTipo) {
		this.cdCl = cdCl;
		this.dsNome = dsNome;
		this.idTipo = idTipo;
		this.dsLim = dsLim;
	}

	
	public Cliente() {
		
	}
	
	public String getDsNome() {
		return dsNome;
	}
	
	public void setDsNome(String dsNome) {
		this.dsNome = dsNome;
	}
	
	public String getIdTipo() {
		return idTipo;
	}
	
	public void setIdTipo(String idTipo) {
		this.idTipo = idTipo;
	}
	
	public double getDsLim() {
		return dsLim;
	}
	
	public void setDsLim(double dsLim) {
		this.dsLim = dsLim;
	}
	
	public String getCdCl() {
		System.out.println("Imprimindo: " + cdCl);
		return cdCl;
	}
	
	public String getCdVend() {
		return cdVend;
	} 
	public void setCdVend(String cdVend) {
		this.cdVend = cdVend;
	}
}
