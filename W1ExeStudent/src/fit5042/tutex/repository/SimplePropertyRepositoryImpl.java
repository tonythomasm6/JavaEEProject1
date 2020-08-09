/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.tutex.repository;

import fit5042.tutex.repository.entities.Property;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * TODO Exercise 1.3 Step 2 Complete this class.
 * 
 * This class implements the PropertyRepository class. You will need to add the keyword
 * "implements" PropertyRepository. 
 * 
 * @author Tony Thomas
 */
public class SimplePropertyRepositoryImpl implements PropertyRepository{

	private ArrayList prop = new ArrayList();
	
    public SimplePropertyRepositoryImpl() {
        
    }

	@Override
	public void addProperty(Property property) throws Exception {
		prop.add(property);
		
	}

	@Override
	public Property searchPropertyById(int id) throws Exception {
		Iterator p = prop.iterator();
		while(p.hasNext()) {
			Property ptemp = (Property)p.next();
			if(ptemp.getId() == id) {
				return ptemp;
			}
			
		}
		return null;
	}

	@Override
	public List<Property> getAllProperties() throws Exception {
		return prop;
	}
    
    
    
}
