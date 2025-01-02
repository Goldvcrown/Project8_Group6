package CircuitDrawing;

import javax.swing.JFrame;

import Circuit.Circuit;
import Circuit.SerialCircuit;
import ElectricalElement.Resistor;
import VoltageSource.DC;

public class TestDrawing {
	public static void main(String[] args) {
		Circuit cc = new SerialCircuit();
		cc.addVoltageSource(new DC(6, "V"));
		cc.addElement(new Resistor(6, ""));
		JFrame frame = new JFrame();
		frame.setSize(800, 800);
		frame.add(new MainGUI(cc));
		frame.setVisible(true);
	}
}
