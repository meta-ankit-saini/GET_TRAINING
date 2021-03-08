package Assignment5;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * class representing (row,col)->position of array
 * @author ankit.saini_metacube
 *
 */
public class Key {
	int row;
	int col;

	public Key(){
		
	}
	
	public Key(int row ,int col){
		this.row = row;
		this.col = col;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + col;
		result = prime * result + row;
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
		Key other = (Key) obj;
		if (col != other.col)
			return false;
		if (row != other.row)
			return false;
		return true;
	}
	
}


