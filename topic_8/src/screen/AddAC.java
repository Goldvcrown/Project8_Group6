package screen;

import java.awt.Dimension;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
public class AddAC extends AddComponent{
	private JTextField optparameter = new JTextField();
	private JComboBox<String> optunit = new JComboBox<>();
	private String previousText = "";
	
	public AddAC() {
		super();
		
		this.setName("AC");
		this.getUnit().addItem("V");
		this.getUnit().addItem("kV");
		this.getUnit().addItem("MV");
		this.getUnit().addItem("mV");
		this.getUnit().addItem("µV");
		this.getUnit().addItem("nV");
		
		this.construct();

		this.setMaximumSize(new Dimension(500, 200));
		
		this.add(Box.createVerticalStrut(5));
		
		JPanel optcenter = new JPanel();
		optcenter.setLayout(new BoxLayout(optcenter, BoxLayout.X_AXIS));
		optcenter.add(Box.createHorizontalStrut(30));
		
		optcenter.add(optparameter);
		optparameter.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				handleTextChange();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				previousText = optparameter.getText();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			private void handleTextChange() {
			    Runnable doHighlight = new Runnable() {
			        @Override
			        public void run() {
			            try {
			                double test = Double.parseDouble(optparameter.getText());
			            } catch (NumberFormatException e) {
			                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number.");
			                optparameter.setText(previousText);
			            } finally {
			                previousText = optparameter.getText();
			            }
			        }
			    };
			    SwingUtilities.invokeLater(doHighlight);
			}

			
		});
		
		optunit.addItem("Hz");
		optunit.addItem("kHz");
		optunit.addItem("MHz");
		optunit.addItem("GHz");
		optunit.addItem("THz");
		optcenter.add(optunit);
		
		this.add(optcenter);
	}
	
	@Override
	public boolean blankInput() {
	    if (super.blankInput() && optparameter.getText().equals("")) {
	        return true;
	    }
	    return false;
	}

	
	public double getMoreDoubleParameter() {
	    try {
	        return Double.parseDouble(optparameter.getText());
	    } catch (NumberFormatException e) {
	        JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number.");
	        return 0.0; 
	    }
	}


	public JComboBox<String> getOptunit() {
		return optunit;
	}
}
