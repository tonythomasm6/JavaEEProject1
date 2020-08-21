package fit5042.tutex.calculator;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateful;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import fit5042.tutex.repository.entities.Property;

@Stateful
public class ComparePropertySessionBean implements CompareProperty {
	
	ArrayList<Property> compareList = new ArrayList<Property>(); // Compare list variable in session to store all property added to compare
	
	//New method to get List of property in compare list
	public ArrayList<Integer> getComparePropertyList(){
		ArrayList<Integer> comparePropId = new ArrayList<Integer>();
		comparePropId.clear();
		for(Property p: compareList) {
			comparePropId.add(p.getPropertyId());
		}
		return comparePropId;
	}

	public void addProperty(Property property) {
		compareList.add(property);
		}
	
	@Override
	public void removeProperty(Property property) {
		boolean b = compareList.remove(property);
		for(int i=0;i<compareList.size();i++) {
			if(compareList.get(i).getPropertyId() == property.getPropertyId()) {
				compareList.remove(i);
			}
		}
	}
	
	@Override
	public int getBestPerRoom() {
		if(compareList.size() < 2) {
			FacesContext.getCurrentInstance().addMessage("MyForm:bestPerRoom", new FacesMessage("Minimum two properties must be entered to compare !!"));
		}
		double lowPrice = -1;
		int bestRoom = -100;
		for(Property p : compareList) {
			if(lowPrice == -1) {
				lowPrice = p.getPrice()/p.getNumberOfBedrooms();
				bestRoom = p.getPropertyId();
			}else if(lowPrice > p.getPrice()/p.getNumberOfBedrooms()) {
				lowPrice = p.getPrice()/p.getNumberOfBedrooms();
				bestRoom = p.getPropertyId();
			}
		}return bestRoom;
	}

}
