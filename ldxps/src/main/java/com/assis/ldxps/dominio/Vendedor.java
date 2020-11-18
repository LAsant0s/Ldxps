package com.assis.ldxps.dominio;

import java.sql.Date;

public class Vendedor {
	private String cdVend;
	private String dsNome; 
	private int cdTab;
	private Date dtNasc;
	
	
	public Vendedor(String dsNome, int cdTab, Date dtNasc) {
		this.dsNome = dsNome;
		this.cdTab = cdTab;
		this.dtNasc = dtNasc;
	}
	
	public Vendedor(String cdVend, String dsNome, int cdTab, Date dtNasc) {
		this.cdVend = cdVend; 
		this.dsNome = dsNome;
		this.cdTab = cdTab;
		this.dtNasc = dtNasc;
	}
	
	public Vendedor() {; 
	
	}

	public String getCdVend() {
		return cdVend;
	}
	
	public void setCdVend(String cdVend) {	
		this.cdVend = cdVend; 
	}
	
	public String getDsNome() {
		return dsNome;
	}
	
	public void setDsNome(String dsNome) {
		this.dsNome = dsNome;
	}
	
	public int getCdTab() {
		return cdTab;
	}
	
	public void setCdTab(int cdTab) {
		this.cdTab = cdTab;
	}
	
	public Date getDtNasc() {
		return dtNasc;
	}
	
	public void setDtNasc(Date dtNasc) {
		this.dtNasc = dtNasc;
	} 
	
	
}
