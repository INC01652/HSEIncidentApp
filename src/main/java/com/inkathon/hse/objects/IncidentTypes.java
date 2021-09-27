package com.inkathon.hse.objects;

public class IncidentTypes {
	int fatal;
	int hazard;
	int veryLow;
	int minor;
	int serious;
	
	public IncidentTypes() {
		super();
		// TODO Auto-generated constructor stub
	}

	public IncidentTypes(int fatal, int hazard, int veryLow, int minor, int serious) {
		super();
		this.fatal = fatal;
		this.hazard = hazard;
		this.veryLow = veryLow;
		this.minor = minor;
		this.serious = serious;
	}
	
	public int getFatal() {
		return fatal;
	}
	public void setFatal(int fatal) {
		this.fatal = fatal;
	}
	public int getHazard() {
		return hazard;
	}
	public void setHazard(int hazard) {
		this.hazard = hazard;
	}
	public int getVeryLow() {
		return veryLow;
	}
	public void setVeryLow(int veryLow) {
		this.veryLow = veryLow;
	}
	public int getMinor() {
		return minor;
	}
	public void setMinor(int minor) {
		this.minor = minor;
	}
	public int getSerious() {
		return serious;
	}
	public void setSerious(int serious) {
		this.serious = serious;
	}
	
	
}
