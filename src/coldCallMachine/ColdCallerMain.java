package coldCallMachine;

public class ColdCallerMain {
	public ColdCallerMain(){
		
	}

	
	public static void main(String[] args){
		ColdCallerModel m = new ColdCallerModel();
		ColdCallerView v= new ColdCallerView(m);
		v.setVisible(true);
	}
	

}
