package ElectricalElement;

import org.apache.commons.math3.complex.*;

import VoltageSource.VoltageSource;

public abstract class ElectricalElement {
	private Complex voltage;
	private Complex currentIntensity;
	private Complex resistance;
	private String name;
	private int id;
	private static int nbElement;
	private String unit;
	public static Complex j = new Complex(0, 1);
	
	public ElectricalElement() {
	    this.voltage = new Complex(0, 0); 
	    this.currentIntensity = new Complex(0, 0); 
	    this.resistance = new Complex(0, 0); 
	    nbElement++;
	    this.id = nbElement;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Complex getVoltage() {
		return voltage;
	}

	public Complex getCurrentIntensity() {
		return currentIntensity;
	}

	public static int getNbElement() {
		return nbElement;
	}

	public void setVoltage(Complex voltage) {
		this.voltage = voltage;
	}

	public void setCurrentIntensity(Complex curInt) {
		this.currentIntensity = curInt;
	}

	public Complex getResistance() {
	    if (resistance == null) {   
	        return new Complex(0, 0); 
	    }
	    return resistance;
	}


	public void setResistance(Complex resistance) {
		this.resistance = resistance;
	}
	
	public String getUnit() {
		return unit;
	}
	
	public void setUnit(String unit) {
		this.unit = unit;
	}

	public int getId() {
		return id;
	}
	
	public String toString() {
	    String voltageStr = (voltage != null) ? formatComplex(voltage) : "N/A";
	    String currentStr = (currentIntensity != null) ? formatComplex(currentIntensity) : "N/A";
	    String resistanceStr = (resistance != null) ? formatComplex(resistance) : "N/A";
	    return String.format("%s: U = %s, I = %s, R = %s", name, voltageStr, currentStr, resistanceStr);
	}

	private String formatComplex(Complex complex) {
	    double real = complex.getReal();
	    double imag = complex.getImaginary();
	    if (imag == 0) {
	        return String.format("%.2f", real); // Chỉ hiển thị phần thực
	    }
	    if (real == 0) {
	        return String.format("%.2fi", imag); // Chỉ hiển thị phần ảo
	    }
	    return String.format("%.2f + %.2fi", real, imag); // Cả phần thực và ảo
	}


	public void setId(int id) {
		this.id = id;
	}
	
	public abstract Complex computeResistace(VoltageSource s);
}