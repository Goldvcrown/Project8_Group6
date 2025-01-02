package screen;

import ElectricalElement.Resistor;

public class AddResistor extends AddComponent{
	
	public AddResistor(int index) {
		super();
		
		this.index = index;
		this.setName("R" + index);
		this.getUnit().addItem("Ω");
		this.getUnit().addItem("kΩ");
		this.getUnit().addItem("MΩ");
		this.getUnit().addItem("GΩ");
		this.getUnit().addItem("mΩ");
		this.getUnit().addItem("µΩ");
		
		this.construct();
	}
}
