/** 
 * @author Thomas VanderBruggen - tvanderbruggen
 * CIS175 - Spring 2021
 * 2/21/2021
 */

import java.util.List;
import java.util.Scanner;

import controller.RacecarItemHelper;
import model.RacecarItem;

public class StartProgram {
	static Scanner in = new Scanner(System.in);
	static RacecarItemHelper raceHelper = new RacecarItemHelper(); 
	public static void main(String[] args) {
		menu(); 
	}
	public static void menu() { 
		System.out.println("---- Thomas's Database of Cars ----");
		boolean run = true; 
		while (run) { 
			System.out.println("\n");
			System.out.println("   Select function");
			System.out.println("   1. View all cars in database");
			System.out.println("   2. Add a car to the database");
			System.out.println("   3. Edit a car on the database");
			System.out.println("   4. Remove a car from the database"); 
			System.out.println("   If you would like to stop, type any number not listed");
			System.out.println("   Your selection: ");
			int selection = in.nextInt(); 
			in.nextLine(); 
			if (selection == 1) {
				viewAll(); 
			}else if (selection == 2)  {
				addCar(); 
			}else if (selection == 3) { 
				RacecarItem car = searchForCar(); 
				updateCar(car); 
			}else if (selection == 4) { 
				removeCar(); 
			}else { 
				raceHelper.cleanUp(); 
				System.out.println("Bye");
				run = false;
			}
			
		}
	}
	
	private static void removeCar() {
		System.out.println("   Please enter the make: ");
		String make = in.nextLine(); 
		System.out.println("   Please enter the model: ");
		String model = in.nextLine(); 
		System.out.println("   Please enter the race series: ");
		String series = in.nextLine(); 
		raceHelper.deleteItem(make, model, series); 
		System.out.println("   Deleted.");
		
	}
	private static RacecarItem searchForCar() {
		RacecarItem car = null; 
		System.out.println("   How would you like to search for the car? ");
		printSearchableComponents(); 
		int selection = in.nextInt(); 
		in.nextLine();
		if (selection == 1) { 
			System.out.println("   Enter the make of the car: ");
			String make = in.nextLine(); 
			displayList(raceHelper.searchByMake(make)); 
			System.out.println("   Enter the ID you wish to edit: ");
			int id = in.nextInt(); 
			car = raceHelper.searchByID(id); 
			System.out.println("Retrieved: " + car.returnCarInfo());
		}else if (selection == 2) { 
			System.out.println("   Enter the model of the car: ");
			String model = in.nextLine(); 
			displayList(raceHelper.searchByModel(model)); 
			System.out.println("   Enter the ID you wish to edit: ");
			int id = in.nextInt(); 
			car = raceHelper.searchByID(id); 
			System.out.println("Retrieved: " + car.returnCarInfo());
		}else if (selection == 3) {
			System.out.println("   Enter the series the car is in: ");
			String series = in.nextLine(); 
			displayList(raceHelper.searchBySeries(series)); 
			System.out.println("   Enter the ID you wish to edit: ");
			int id = in.nextInt(); 
			car = raceHelper.searchByID(id); 
			System.out.println("Retrieved: " + car.returnCarInfo());
		}else if (selection == 4) { 
			System.out.println("   Enter the  horsepower of the car: ");
			int hp = in.nextInt(); 
			displayList(raceHelper.searchByHorsePower(hp)); 
			System.out.println("   Enter the ID you wish to edit: ");
			int id = in.nextInt(); 
			car = raceHelper.searchByID(id); 
			System.out.println("Retrieved: " + car.returnCarInfo()); 
		}else if (selection == 5) { 
			System.out.println("   Enter the cylinder arrangement of the car: "); 
			String arrangement = in.nextLine(); 
			displayList(raceHelper.searchByCylinderArrangement(arrangement)); 
			System.out.println("   Enter the ID you wish to edit: ");
			int id = in.nextInt(); 
			car = raceHelper.searchByID(id); 
			System.out.println("Retrieved: " + car.returnCarInfo());
		}else if (selection == 6) { 
			System.out.println("   Enter the displacement of the car: "); 
			String displacement = in.nextLine(); 
			displayList(raceHelper.searchByEngineDisplacement(displacement)); 
			System.out.println("   Enter the ID you wish to edit: ");
			int id = in.nextInt(); 
			car = raceHelper.searchByID(id); 
			System.out.println("Retrieved: " + car.returnCarInfo());
			
		}
		return car; 
	}
	private static void addCar() {
		System.out.println("   Enter the make: ");
		String make = in.nextLine(); 
		System.out.println("   Enter the model: ");
		String model = in.nextLine(); 
		System.out.println("   Enter the series: ");
		String series = in.nextLine(); 
		System.out.println("   Enter the horsepower: ");
		int hp = in.nextInt(); 
		in.nextLine();
		System.out.println("   Enter the cylinder arrangement: ");
		String arrangement = in.nextLine(); 
		System.out.println("   Enter the displacement: ");
		String displacement = in.nextLine(); 
		RacecarItem car = new RacecarItem(make, model, arrangement, displacement, hp, series); 
		raceHelper.addItem(car);
	}
	private static void viewAll() {
		List<RacecarItem> cars = raceHelper.showAllCars(); 
		System.out.println("\n\n\n");
		for (RacecarItem car : cars) { 
			System.out.println(car.getId() + "| " + car.returnCarInfo());
		}
		
	}
	private static void displayList(List<RacecarItem> list) {
		for (RacecarItem car : list) { 
			System.out.println(car.getId() + "| " + car.returnCarInfo());
		}
	}
	private static void printSearchableComponents() {
		System.out.println("   1. Make"); 
		System.out.println("   2. Model");
		System.out.println("   3. Series");
		System.out.println("   4. Minimum Horsepower");
		System.out.println("   5. Cylinder Arrangement");
		System.out.println("   6. Engine Displacement");
	}
	private static void printEditableComponents() {
		System.out.println("   1. Make"); 
		System.out.println("   2. Model");
		System.out.println("   3. Series");
		System.out.println("   4. Horsepower");
		System.out.println("   5. Cylinder Arrangement");
		System.out.println("   6. Engine Displacement"); 
	}
	private static void updateCar(RacecarItem car) { 
		printEditableComponents(); 
		System.out.println("   Enter the component you would like to update: "); 
		int componentSelect = in.nextInt(); 
		in.nextLine();
		if (componentSelect == 1) { 
			System.out.println("   Please enter the updated make: ");
			String make = in.nextLine(); 
			car.setMake(make);
			raceHelper.updateItem(car); 
		}else if (componentSelect == 2) { 
			System.out.println("   Enter the model of the car: ");
			String model = in.nextLine(); 
			car.setModel(model);
			raceHelper.updateItem(car);
		}else if (componentSelect == 3) { 
			System.out.println("   Enter the race series the car is in: " ); 
			String series = in.nextLine(); 
			car.setSeries(series);
			raceHelper.updateItem(car);
		}else if (componentSelect == 4) { 
			System.out.println("   Enter the updated horsepower: ");
			int hp = in.nextInt(); 
			car.setHorsePower(hp);
			raceHelper.updateItem(car);
		}else if (componentSelect == 5) { 
			System.out.println("   Enter the updated cylinder arrangement: ");
			String arrangement = in.nextLine(); 
			car.setArrangement(arrangement);
			raceHelper.updateItem(car); 
		}else if (componentSelect == 6) {
			System.out.println("   Enter the updated engine displacement: ");
			String displacement = in.nextLine(); 
			car.setDisplacement(displacement);
			raceHelper.updateItem(car);
		}
	}

}
