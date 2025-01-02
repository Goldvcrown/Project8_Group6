package screen;

import ElectricalElement.Capacitor;

public class AddCapacitor extends AddComponent{
	
	public AddCapacitor(int index) {
		super();
		
		this.index = index;
		this.setName("C" + index);
		this.getUnit().addItem("F");
		this.getUnit().addItem("mF");
		this.getUnit().addItem("μF");
		this.getUnit().addItem("nF");
		this.getUnit().addItem("pF");
		
		this.construct();
	}

}
