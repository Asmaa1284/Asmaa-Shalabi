

import java.util.Objects;

public class CustomerService extends Employee{
	private String caseNo;
	private boolean solved;
	public CustomerService(String n,int id) {
		super(id,n);
	}
	public CustomerService(String name,int id,String caseNo) {
		super(id,name);
		this.caseNo=caseNo;
		
	}
	public String getCaseNo() {
		return caseNo;
	}
	public void setCaseNo(String caseNo) {
		
		this.caseNo = caseNo;
	}
	@Override
	public String toString() {
		String s= super.toString();
	   s+= "CustomerService [caseNo=" + caseNo + ", solved=" + solved + "]";
	   return s;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		CustomerService other = (CustomerService) obj;
		return super.equals(obj)&& Objects.equals(caseNo, other.caseNo) && solved == other.solved;
	}
	public boolean isSolved() {
		return solved;
	}
	public void setSolved(boolean solved) {
		this.solved = solved;
	}
	public void caseInProgress() {
		System.out.println("your Case is in the progress");
	}

}
