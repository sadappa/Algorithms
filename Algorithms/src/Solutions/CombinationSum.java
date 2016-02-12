package Solutions;

import java.util.ArrayList;
import java.util.List;

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

public class CombinationSum {
  
  public static void findItems(List<FoodItem> items, double available, int j, List<String> result, List<List<String>> resultList) {
    
    if (available == 0) {
    	resultList.add(new ArrayList<String>(result));
    	return;
    } else {
    	
    	for(int i = j ;i < items.size();i++) {
    		
    		if (items.get(i).value > available) {
    			return;
    		}
	    		result.add(items.get(i).name);
	    		findItems(items, available - items.get(i).value, i, result, resultList);
	    		result.remove(result.size()-1);
    		
      	}  	
    }
  }
  
  
  public static void main(String[] args) {
    
    List<FoodItem> items = new ArrayList<>();
    
    items.add(new FoodItem("fruit", 2.15));
    items.add(new FoodItem("fries", 2.75));
    items.add(new FoodItem("salad", 3.35));

    List<String> result = new ArrayList<>();
    
    List<List<String>> resultList = new ArrayList<>();
    
    findItems(items, 15.05, 0, result, resultList);

    for (String string : resultList.get(0)) {
      System.out.println(string);
    }
  }
}
