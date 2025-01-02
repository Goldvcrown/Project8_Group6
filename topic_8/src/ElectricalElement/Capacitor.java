package ElectricalElement;

import org.apache.commons.math3.complex.Complex;

import VoltageSource.VoltageSource;

public class Capacitor extends ElectricalElement{
	private double capacitance;

	public Capacitor() {
		// TODO Auto-generated constructor stub
		super();
		String cName = String.format("C%s", super.getId());
		super.setName(cName);
	}
	
	public Capacitor(double capacitance, String unit) {
		this();
		this.capacitance = capacitance;
		this.setUnit(unit);
	}

	public double getCapacitance() {
		return capacitance;
	}

	public void setCapacitance(double capacitance) {
		this.capacitance = capacitance;
	}
	
	public double getSICapacitance() {
		if (this.getUnit().equals("mF")) {
			return capacitance*1e-3;
		}
		else if (this.getUnit().equals("μF")) {
			return capacitance*1e-6;
		}
		else if (this.getUnit().equals("nF")) {
			return capacitance*1e-9;
		}
		else if (this.getUnit().equals("pF")) {
			return capacitance*1e-12;
		}
		return capacitance;
	}
	
	public String toString() {
		return (super.getName() + " = " + this.capacitance + "F, U = " + super.getVoltage().getReal() + "+" + super.getVoltage().getImaginary() + "i V, I = " + super.getCurrentIntensity().getReal() + "+" + super.getCurrentIntensity().getImaginary() + "i A, R_C = " + super.getResistance().getReal() + "+" + super.getResistance().getImaginary() + "i ohm");
	}

	@Override
	public Complex computeResistace(VoltageSource s) {
		// TODO Auto-generated method stub
		Complex cRes = j.multiply(-1.0/(2*Math.PI*s.getSIFrequency()*this.getSICapacitance()));
		return cRes;
	}
}