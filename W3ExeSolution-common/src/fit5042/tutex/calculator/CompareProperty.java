package fit5042.tutex.calculator;

import java.util.ArrayList;

import javax.ejb.Remote;

import fit5042.tutex.repository.entities.Property;

@Remote
public interface CompareProperty {
	

	public void addProperty(Property property);
	
	public void removeProperty(Property property);
	
	public int getBestPerRoom();
	
	public ArrayList<Integer> getComparePropertyList();
	
	

}
