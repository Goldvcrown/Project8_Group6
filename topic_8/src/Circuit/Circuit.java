package Circuit;


import java.util.ArrayList;
import org.apache.commons.math3.complex.*;
import ElectricalElement.*;
import VoltageSource.*;

public abstract class Circuit {
	private VoltageSource src;
	private ArrayList<ElectricalElement> elements = new ArrayList<ElectricalElement>();
	
	public static Complex j = new Complex(0, 1);
	
	public Circuit() {
		// TODO Auto-generated constructor stub
	}

	public VoltageSource getVoltageSource() {
		return src;
	}

	public ArrayList<ElectricalElement> getElements() {
		return elements;
	}
	
	public void addVoltageSource(VoltageSource src) {
		this.src = src;
	}
	
	public void addElement(ElectricalElement e) {
		int nbElement = this.getElements().size();
		e.setId(nbElement+1);
		elements.add(e);
		System.out.println("Successfully added " + e.getName() + " to the circuit");
	}
	
	public void removeElement(ElectricalElement e) {
		if (elements.contains(e)) {
			elements.remove(e);
			for (ElectricalElement ee : this.getElements()) {
				ee.setId(this.getElements().indexOf(ee)+1);
			}
			System.out.println("Successfully removed " + e.getName() + " from the circuit");
		} else {
			System.out.println("This element is not in the circuit");
		}
	}
	
	public abstract void trigger();
	
	public abstract void print();
	
	public abstract Complex getEquivalentResistance();
}
