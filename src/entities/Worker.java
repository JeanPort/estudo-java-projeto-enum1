package entities;

import java.util.ArrayList;
import java.util.List;

import entities.enums.WorkerLevel;

public class Worker {

	private String nameString;
	private WorkerLevel level;
	private Double baseSalary;
	
	private Department department;
	
	private List<HourContract> contracts = new ArrayList<>();

	public Worker() {
	}

	public Worker(String nameString, WorkerLevel level, Double baseSalary, Department department) {
		this.nameString = nameString;
		this.level = level;
		this.baseSalary = baseSalary;
		this.department = department;
	}

	public String getNameString() {
		return nameString;
	}

	public void setNameString(String nameString) {
		this.nameString = nameString;
	}

	public WorkerLevel getLevel() {
		return level;
	}

	public void setLevel(WorkerLevel level) {
		this.level = level;
	}

	public Double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<HourContract> getContracts() {
		return contracts;
	}

	public void addContract(HourContract contract) {
		this.contracts.add(contract);
	}
	
	public void removeContract(HourContract contract) {
		this.contracts.remove(contract);
	}
	
	public double income(Integer year, Integer month) {
		
		
		double sumContract = 0.00;
		for (HourContract hourContract : contracts) {
			if (hourContract.getDate().getMonthValue() == month && hourContract.getDate().getYear() == year) {
				sumContract += hourContract.totalValue();
			}
		}
		
		sumContract += this.baseSalary;
		
		return sumContract;
	}

	@Override
	public String toString() {
		return "Name: "
				+ this.nameString
				+ "\n"
				+ "Department: "
				+ this.getDepartment().getName()
				+ "\n";
	}
	
	
}
