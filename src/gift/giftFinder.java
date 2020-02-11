package gift;
import java.util.*;

public class giftFinder {

	static Scanner inp=new Scanner(System.in);
	static ArrayList<Chocolate> chocolates=new ArrayList<Chocolate>();
	static ArrayList<Chocolate> candies=new ArrayList<Chocolate>();
	static ArrayList<Sweet> sweets=new ArrayList<Sweet>();
	static HashMap<String,Integer> nameToWeight=new HashMap<String, Integer>();
	static HashMap<String,Integer> nameToPrice=new HashMap<String, Integer>();
	
public static void main(String [] args) {
	
		inChoco();
		inSweets();
		System.out.println("Total weight of gift:" + calcTW());
		System.out.println("Select the choice(1or2):"+"\n"+"1] By Weight"+"\n"+"2] By Price");
		int choice=inp.nextInt();
		if(choice==1)
		{
			Comparator<Chocolate> compareWeight=(Chocolate c1,Chocolate c2)->((Integer)c1.getWeight()).compareTo(c2.getWeight());
			Collections.sort(chocolates,compareWeight);
		}
		else{
			Comparator<Chocolate> comparePrice=(Chocolate c1,Chocolate c2)->((Integer)c1.getPrice()).compareTo(c2.getPrice());
			Collections.sort(chocolates,comparePrice);
		}
		
		System.out.println("Sorted result: ");
		for(Chocolate chocolate:chocolates) {
			System.out.println(chocolate.getPrice());
			}	
	
		calcRange(choice);
	
	
	
} 	

public static void inChoco() {
	System.out.println("Enter the number of chocolates in gifts: ");
	int numOfChocolates=inp .nextInt();
	
	for (int chocolateCount=1;chocolateCount<=numOfChocolates;chocolateCount++) {
		System.out.println("Enter the chocolate type:1.Candy 2.Wafer ");
		int chocolateType=inp.nextInt();
		
	System.out.println("Enter the weight of chocolate: ");
	int chocolateWeight=inp.nextInt();
	System.out.println("Enter the price of chocolate:");
	int chocolatePrice=inp.nextInt();
	if(chocolateType==1) {
		System.out.println("Enter the name of candy: ");
		String candyName=inp.next();
		if(nameToWeight.containsKey(candyName))
			nameToWeight.put(candyName,(int)nameToWeight.get(candyName)+chocolateWeight);
		
		else 
			nameToWeight.put(candyName,chocolateWeight);
			
	
		if(nameToPrice.containsKey(candyName))
			nameToPrice.put(candyName,(int)nameToPrice.get(candyName)+chocolatePrice);
		
		else 
			nameToPrice.put(candyName,chocolatePrice);
			
		
		}
	else{
		System.out.println("Enter the name of wafer: ");
		String waferName=inp.next();
		if(nameToWeight.containsKey(waferName))
			nameToWeight.put(waferName,(int)nameToWeight.get(waferName)+chocolateWeight);
		
		else 
			nameToWeight.put(waferName,chocolateWeight);
			
	
		if(nameToPrice.containsKey(waferName))
			nameToPrice.put(waferName,(int)nameToPrice.get(waferName)+chocolatePrice);
		
		else 
			nameToPrice.put(waferName,chocolatePrice);
			
		
		}
	}
	
	}

public static void inSweets() {
	System.out.println("Enter the number of sweets in gifts : ");
	int numberOfSweets=inp.nextInt();
	for(int sweetsCount=1;sweetsCount<=numberOfSweets;sweetsCount++) {
		System.out.println("Enter the weight of the sweet");
		int sweetWeight=inp.nextInt();
		System.out.println("Enter the price of the sweet");
		int sweetPrice=inp.nextInt();
		Sweet sweet=new Sweet(sweetWeight,sweetPrice);
		sweets.add(sweet);
		
	}
}

public static int calcTW() {
	int totalWeight=0;
	for(Chocolate choco:chocolates) {
		totalWeight+=choco.getWeight();
	}
	
	for(Sweet sweet: sweets) {
		totalWeight+=sweet.getWeight();
	}
	return totalWeight;
}

public static void calcRange(int sortType) {
		System.out.println("**Range** ");
		int lowerLimit,higherLimit;
		if(sortType==1) {
			System.out.println("Enter the lowerlimit of the price: ");
			lowerLimit=inp.nextInt();
			
			System.out.println("Enter the higherlimit of the price: ");
			higherLimit=inp.nextInt();
			
			Set<Map.Entry<String, Integer>> candySet=nameToPrice.entrySet();
			Iterator<Map.Entry<String, Integer>> candyIterator=candySet.iterator();
			while(candyIterator.hasNext()) {
				Map.Entry candyElement=(Map.Entry)candyIterator.next();
				int currentWeight=(int)candyElement.getValue();
				if(currentWeight >= lowerLimit && currentWeight<=higherLimit)
					System.out.println(candyElement.getKey());
			}
			
		}
		else{
			System.out.println("Enter the lowerlimit of the price: ");
			lowerLimit=inp.nextInt();
			
			System.out.println("Enter the higherlimit of the price: ");
			higherLimit=inp.nextInt();
			
			Set<Map.Entry<String, Integer>> candySet=nameToPrice.entrySet();
			Iterator<Map.Entry<String, Integer>> candyIterator=candySet.iterator();
			while(candyIterator.hasNext()) {
				Map.Entry candyElement=(Map.Entry)candyIterator.next();
				int currentPrice=(int)candyElement.getValue();
				if(currentPrice>=lowerLimit&&currentPrice<=higherLimit)
					System.out.println(candyElement.getKey());
			}
			
		}
}



}



	

