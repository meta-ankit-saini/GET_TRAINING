package Asssignment4_DSA;

/**
 * class for storing Employee property and METHODS
 * @author ankit.saini_metacube
 *
 */
public class Employee {
	private int empployeeId ;
	private String name ,address;
	
	Employee(int empployeeId, String name,  String address){
		this.empployeeId = empployeeId;
		this.name = name;
		this.address = address;
	}

	public int getEmpployeeId() {
		return empployeeId;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + empployeeId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (empployeeId != other.empployeeId)
			return false;
		return true;
	}

	
}
