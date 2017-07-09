package coldCallMachine;

import java.util.List;
import java.util.ArrayList;

public class ColdCallerModel {
	private String[][] text;
	private int groupSize;
	
	private String[] names= new String[]{"Alison","Angelina","Cassie","Cody",
			"Edie","Ellerbe","Gabriela","Janet","Jordan","Kacie",
			"Karlee","Kayla","Lily","Liza","Melody","Nicole",
			"Sakura","Therrin","Tracy","Stephanie"};
	
	private List<String> people = new ArrayList<String>();
	private List<String> groups = new ArrayList<String>();
	
	private int x;
	

	
	public ColdCallerModel(int groupSize){
		this.setGroupSize(groupSize);
		this.text= new String[20/groupSize][groupSize];
		this.x=0;
		
		for(String s: names){
			people.add(s);
		}
		for(int y= 0; y< 20/groupSize; y++){
		for(x = 0; x< groupSize; x++){
				String next = people.get((int) (people.size()*Math.random()));
				if(groups.contains(next)){
					while(groups.contains(next)){
						next = people.get((int) (people.size()*Math.random()));
					}
					groups.add(next);
					text[y][x]= next;
					
				} else {
					groups.add(next);
					text[y][x]= next;
					
				}
					
			}

			
		}}
	
	
	public ColdCallerModel(){
		this(1);
		setGroupSize(1);
	}
	public String[][] getText(){
		return text;
	}
	public int getGroupSize() {
		return groupSize;
	}

	public void setGroupSize(int groupSize) {
		this.groupSize = groupSize;
	}
	

	}
