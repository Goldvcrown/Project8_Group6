package screen;

import ElectricalElement.Inductor;

public class AddInductor extends AddComponent{
	
	public AddInductor(int index) {
		super();
		
		this.index = index;
		this.setName("L" + index);
		this.getUnit().addItem("H");
		this.getUnit().addItem("mH");
		this.getUnit().addItem("µH");
		this.getUnit().addItem("nH");
		this.getUnit().addItem("pH");
		
		this.construct();
	}
}
