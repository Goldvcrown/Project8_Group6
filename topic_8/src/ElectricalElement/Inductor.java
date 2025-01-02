package ElectricalElement;

import org.apache.commons.math3.complex.Complex;

import VoltageSource.VoltageSource;

public class Inductor extends ElectricalElement{
	private double inductance;
		
	public Inductor() {
		// TODO Auto-generated constructor stub
		super();
		String lName = String.format("L%s", super.getId());
		super.setName(lName);
	}
	
	public Inductor(double inductance, String unit) {
		this();
		this.inductance = inductance;
		this.setUnit(unit);
	}

	public double getInductance() {
		return inductance;
	}

	public void setInductance(double inductance) {
		this.inductance = inductance;
	}
	
	public double getSIInductance() {
	    String unit = this.getUnit();  
	    if (unit.equals("H")) {
	        return this.getInductance(); 
	    } else if (unit.equals("mH")) {
	        return this.getInductance() * 1e-3; 
	    } else if (unit.equals("µH")) {
	        return this.getInductance() * 1e-6;  
	    } else if (unit.equals("nH")) {
	        return this.getInductance() * 1e-9;  
	    } else {
	        throw new IllegalArgumentException("Invalid unit for inductance: " + unit);
	    }
	}


	
	public String toString() {
	    String voltageStr = (super.getVoltage() != null) ? super.getVoltage().getReal() + "+" + super.getVoltage().getImaginary() + "i" : "N/A";
	    String currentStr = (super.getCurrentIntensity() != null) ? super.getCurrentIntensity().getReal() + "+" + super.getCurrentIntensity().getImaginary() + "i" : "N/A";
	    String resistanceStr = (super.getResistance() != null) ? super.getResistance().getReal() + "+" + super.getResistance().getImaginary() + "i" : "N/A";
	    return String.format("%s = %sH, U = %s, I = %s, R_L = %s", super.getName(), inductance, voltageStr, currentStr, resistanceStr);
	}


	@Override
	public Complex computeResistace(VoltageSource s) {
		// TODO Auto-generated method stub
		Complex lRes = j.multiply(2*Math.PI*s.getSIFrequency()*this.getSIInductance());
		return lRes;
	}

}