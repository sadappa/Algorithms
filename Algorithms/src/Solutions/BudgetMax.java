package Solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 
input: 

menu = {
fruit: 2.15,
fries: 2.75,
salad: 3.35,
wings: 3.55,
sticks: 4.20,
plate: 5.80,
rice: 10.0
}

budget = 15.05 



15.05 

output: [fruit, fruit, fruit, fruit, fruit, fruit, fruit]
2.15 * 7 = 15.05 

15.05 
output:  [plate, wings, wings, fruit]
5.80 + 3.55 * 2 + 2.15 = 15.05


5.0
output: []



string[] order (map<string, double> menu, double budget) 

 
 */

public class BudgetMax {
  
  public static void findItems(Map<String,Double> items, double available, String itemName, List<String> result) {
    
    if (available == 0) {
      return;
    } else {
    	
    	double itemValue = items.get(itemName);
        available = available - itemValue;
        
        if(available == 0) {
        	result.add(itemName);
        	return;
        } else if (available > 0) {
        	result.add(itemName);
        	for(Map.Entry<String,Double> item : items.entrySet()) {
    		  findItems(items, available, item.getKey(), result); 
        	}
        } 
    }
  }
  
  
  public static void main(String[] args) {
    
    Map<String,Double> items = new HashMap<>();
    
    items.put("fruit", 2.15);
    items.put("fries", 2.75);
    items.put("salad", 3.35);

    List<String> result = new ArrayList<>();
    
    String itemName = null;
    for(Map.Entry<String,Double> item : items.entrySet()) {
    	itemName = item.getKey();
      }
    
    findItems(items, 15.05, itemName, result);

    for (String string : result) {
      System.out.println(string);
    }
  }
}
