package fit5042.tutex;

import fit5042.tutex.repository.PropertyRepository;
import fit5042.tutex.repository.PropertyRepositoryFactory;
import fit5042.tutex.repository.entities.Property;

import java.io.Console;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * TODO Exercise 1.3 Step 3 Complete this class. Please refer to tutorial instructions.
 * This is the main driver class. This class contains the main method for Exercise 1A
 * 
 * This program can run without the completion of Exercise 1B.
 * 
 * @author Tony
 */
public class RealEstateAgency {
    private String name;
    private final PropertyRepository propertyRepository;

    public RealEstateAgency(String name) throws Exception {
        this.name = name;
        this.propertyRepository = PropertyRepositoryFactory.getInstance();
        
    }
    
    // this method is for initializing the property objects
    // complete this method
    public void createProperty() {
    	Property p1 = new Property( "33 Dunferline Cranbourne", 3, 200, 10000, 11);
    	Property p2 = new Property( "35 Lane Frankston", 5, 400, 20000, 12);
    	Property p3 = new Property( "37 Dunferline Cranbourne", 2, 300, 30000, 13);
    	Property p4 = new Property( "39 Crescent Cranbourne", 4, 250, 40000, 14);
    	Property p5 = new Property( "15 Casey Melbourne", 4, 350, 40000, 15);
	    	
    	try {
	    	propertyRepository.addProperty(p1);
	    	propertyRepository.addProperty(p2);
	    	propertyRepository.addProperty(p3);
	    	propertyRepository.addProperty(p4);
	    	propertyRepository.addProperty(p5);
    	}catch(Exception e) {
    		
    	}
	    	
    }
    
    // this method is for displaying all the properties .
    // complete this method
    public void displayProperties() throws Exception {
        ArrayList properties = (ArrayList) propertyRepository.getAllProperties();
        
       for(int i=0;i<properties.size();i++) {
    	  System.out.println(properties.get(i));
       }
    }
    
    // this method is for searching the property by ID
    // complete this method
    public void searchPropertyById() {
    	Scanner s = new Scanner(System.in);
    	System.out.println("Enter ID of property to serch");
    	int id = s.nextInt();
        try {
			Property p = propertyRepository.searchPropertyById(id);
			if(p == null) {
				System.out.println("No property for ID entered found !!!");
			}
			else {
				System.out.println("Details of property with id "+id+" is "+p);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void run() throws Exception {
        createProperty();
        System.out.println("********************************************************************************");
        displayProperties();
        System.out.println("********************************************************************************");
        searchPropertyById();
    }
    
    public static void main(String[] args) {
        try {
            new RealEstateAgency("FIT5042 Real Estate Agency").run();
        } catch (Exception ex) {
            System.out.println("Application fail to run: " + ex.getMessage());
        }
    }
}
