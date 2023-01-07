import java.util.*;


public class RandomDrawing<T> implements RandomDrawingInterface <T>{
    private List<T> arrList ;
   // private Set<T> arrSet;
    private boolean dup;
    public RandomDrawing(boolean dup){
    	this.dup=dup;
    	if(dup) {
    	this.arrList= new ArrayList<>();
    	}else {
    		Set<T> arrSet=new HashSet<>();
    		
    		this.arrList= new ArrayList<>(arrSet);
    	}
    }

	@Override
	public boolean addEntry(T entry) {
		if(dup) {
			return arrList.add(entry);
			
		}else {
			if(arrList.contains(entry)) {
				return false;
			}else { 
				
				 return arrList.add(entry);
			}
		}
		
		}
	

	@Override
	public T selectWinner(boolean removeWinner) {
		int num=0;
		Random random= new Random();
		if(arrList.size()==0) {
			return null;
		}else {
	
			num= random.nextInt(arrList.size());
			
			
		System.out.println("selsectWinner! "+num);
		 T winner = arrList.get(num);
		 if(removeWinner) {
			return arrList.remove(num);
		 }else {
		 return winner;
		 }
		}
		
		
	}

	@Override
	public int size() {
		
			return arrList.size();
		
		
	}

	@Override
	public boolean allowsDuplicates() {
		
		return this.dup;
	}

	@Override
	public void displayEntries() {
		
			for(T entry: arrList) {
				System.out.println(entry);
			}
		
			
		}
		
	}


