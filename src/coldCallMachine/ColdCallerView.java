package coldCallMachine;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class ColdCallerView implements ItemListener, ActionListener {

	
	private JComboBox<Integer> j;
	private JButton button;
	private ColdCallerModel c;
	private JFrame frame; 
	private JPanel[] panel;
	private JPanel bigPanel;
	private Integer chosen;
	private JPanel titlePanel; 
	public ColdCallerView(ColdCallerModel c){
		this.setC(new ColdCallerModel());
		this.frame = new JFrame();
		this.j= new JComboBox<Integer>();
		this.titlePanel= new JPanel(new GridLayout(2,1));
		this.setChosen(c.getGroupSize());
		for(int x= 1; x< 21; x++){
			j.addItem(x);
		}
		this.button= new JButton("Shuffle");
		button.addActionListener(this);
		button.setActionCommand("press");
		j.addItemListener(this);
		titlePanel.setLayout(new  GridLayout(2,1));
		titlePanel.add(j);
		titlePanel.add(button);
		button.setBackground(Color.CYAN);
		frame.setLayout(new BorderLayout());
		frame.add(titlePanel, BorderLayout.NORTH);
		frame.setSize(500, 500);
		
		this.panel = new JPanel[20/c.getGroupSize()];
		this.bigPanel= new JPanel();
		bigPanel.setLayout(new GridLayout(20/c.getGroupSize(),1));
		for(int g = 0; g< (20/c.getGroupSize()); g++){
			
			this.panel[g]= new JPanel();
			for(int p = 0; p < c.getGroupSize(); p++){
				if(p==0){
					panel[g].add(new JLabel("Team "+ (g+1)+ ": "));
				}
				panel[g].add(new JLabel(c.getText()[g][p]));

			}
		}	for(int z= 0; z< 20/c.getGroupSize(); z++){

			bigPanel.add(panel[z]);
		}
		frame.add(bigPanel, BorderLayout.CENTER);
		frame.setVisible(true);
	}

	public ColdCallerModel getC() {
		return c;
	}
	public void setC(ColdCallerModel c) {
		this.c = new ColdCallerModel(getChosen());
	}
	
	

	public void itemStateChanged(ItemEvent e) {
		
			
			Integer i = (Integer) e.getItem();
			setChosen(i);
			setC(new ColdCallerModel(getChosen()));
			update();
		
		
	}
	


	public void actionPerformed(ActionEvent e) {
		
		setC(new ColdCallerModel(getChosen()));
		update();
		
	}

	public Integer getChosen() {
		if(chosen != null){
			return chosen;
		}
		return 1;
	}

	public void setChosen(Integer chosen) {
		if(chosen != null){
		this.chosen = chosen;
		} else {
			this.chosen= 1;
		}
	}

	public void setVisible(boolean b) {
		frame.setVisible(true);
		
	}
	public void update(){
	
	frame.remove(bigPanel);
	panel = new JPanel[20/getChosen()];
	bigPanel= new JPanel();
	bigPanel.setLayout(new GridLayout(20/getChosen(),1));
	for(int g = 0; g< (20/getChosen()); g++){

		this.panel[g]= new JPanel();
		for(int p = 0; p < getChosen(); p++){
			if(p==0){
				panel[g].add(new JLabel("Team "+ (g+1)+ ": "));
				
			}
				panel[g].add(new JLabel(c.getText()[g][p]));
			


		}
	}	for(int z= 0; z< 20/getChosen(); z++){

		bigPanel.add(panel[z]);
	}
	frame.add(bigPanel, BorderLayout.CENTER);
	frame.setVisible(true);
}


}
