package Circuit;

import ElectricalElement.Resistor;
import VoltageSource.DC;

public class TestCircuit {
	public static void main(String[] args) {
		Circuit cc = new SerialCircuit();
		cc.addVoltageSource(new DC(6, "V"));
		cc.addElement(new Resistor(6, ""));
		cc.trigger();
		cc.print();
	}
}
