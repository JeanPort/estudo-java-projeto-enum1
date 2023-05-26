package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {

	public static void main(String[] args) {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		Locale.setDefault(Locale.US);
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter departament's name: ");
		Department department = new Department(scanner.next());
		
		System.out.print("Enter worker data: ");
		
		System.out.print("Name: ");
		scanner.nextLine();
		String name = scanner.nextLine();
		
		System.out.print("Level: ");
		WorkerLevel lvl = WorkerLevel.valueOf(scanner.next());
		
		System.out.print("Base salary: ");
		double salary = scanner.nextDouble();
		
		Worker worker = new Worker(name, lvl, salary, department);
		
		System.out.print("How many contracts to this worker? ");
		int numberContracts = scanner.nextInt();
		
		for (int i = 1; i <= numberContracts; i++) {
			System.out.println("Enter contract #" + i);
			System.out.print("Date (DD/MM/YYY): ");
			LocalDate  date = LocalDate.parse(scanner.next(), formatter);
			
			System.out.print("Value per hour: ");
			double valuePerHour = scanner.nextDouble();
			
			System.out.print("Duration: ");
			int hours = scanner.nextInt();
			
			HourContract hourContract = new HourContract(date, valuePerHour, hours);
			worker.addContract(hourContract);
		}
		
		System.out.println("Enter month and year to calculate income");
		System.out.print("Month: ");
		int month = scanner.nextInt();
		
		System.out.print("Year: ");
		int year = scanner.nextInt();
		
		System.out.println(worker);
		System.out.println("Income for " + month+ "/" + year + ": " + String.format("%.2f", worker.income(year, month)));
		scanner.close();
	}

}
