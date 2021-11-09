package com.jack.Java8Homework;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Emp {
	private int id;
	private String name;
	private int age;
	private String gender;
	private String dept;
	private int yearOfJoining;
	private double salary;

	void getNameSalary() {
		System.out.println("Name: " + name + "||" + "Salary" + salary);
	}

	public static void main(String[] args) {

		// List of employee objects
		List<Emp> emps = new ArrayList<>();
		emps.add(new Emp(111, "Loel", 24, "Male", "CS", 2010, 120000));
		emps.add(new Emp(112, "Jack", 39, "Male", "CS", 2007, 150000));
		emps.add(new Emp(113, "Laura", 28, "Female", "Mechanical", 2016, 500000));
		emps.add(new Emp(114, "Pratik", 45, "Male", "Mechanical", 2000, 1000000));
		emps.add(new Emp(115, "Anna", 22, "Female", "CS", 2021, 720000));
		emps.add(new Emp(116, "Annie", 37, "Female", "CS", 2019, 75000));
		emps.add(new Emp(117, "Richard", 57, "Male", "Mechanical", 1995, 372000));

		System.out.println("_______________________________");
		System.out.println("Employee Information");
		System.out.println("--------------------------------");

		// Outputs count of male and female employees
		int maleCount = emps.stream().filter(e -> e.getGender().equals("Male")).collect(Collectors.toList()).size();
		int femaleCount = emps.stream().filter(e -> e.getGender().equals("Female")).collect(Collectors.toList()).size();
		System.out.println("Number of male employees: " + maleCount);
		System.out.println("Number of female employees: " + femaleCount);
		System.out.println("--------------------------------");

		// Outputs average age of male and female employees

		List<Emp> maleAvgAgeSum = emps.stream().filter(e -> e.getGender().equals("Male")).collect(Collectors.toList());
		int mAgeSum = 0;
		for (Emp e : maleAvgAgeSum) {
			mAgeSum += e.getAge();
		}

		int mAvgAge = mAgeSum / maleCount;
		System.out.println("Average age of male employees: " + mAvgAge);

		List<Emp> femAvgAgeSum = emps.stream().filter(e -> e.getGender().equals("Female")).collect(Collectors.toList());

		int fAgeSum = 0;
		for (Emp e : femAvgAgeSum) {
			fAgeSum += e.getAge();
		}

		int fAvgAge = fAgeSum / femaleCount;

		System.out.println("Average age of female employees: " + fAvgAge);
		System.out.println("--------------------------------");

		// Outputs employee with the highest salary

		Comparator<Emp> comparator = Comparator.comparing(Emp::getSalary);
		Emp highSal = emps.stream().max(comparator).get();

		System.out.println("Highest employee salary:");
		System.out.println("Name: " + highSal.getName());
		System.out.println("Salary: $" + highSal.getSalary());
		System.out.println("--------------------------------");

		// Outputs all the names of employees who have joined after 2016
		System.out.println("Employees who joined after 2016:");

		emps.stream().filter(e -> e.getYearOfJoining() > 2016).collect(Collectors.toList())
				.forEach(e -> System.out.println(e.getName()));

		System.out.println("--------------------------------");

		// Outputs the employee with the earliest join date
		Comparator<Emp> comp = Comparator.comparing(Emp::getYearOfJoining);
		Emp senior = emps.stream().min(comp).get();

		System.out.println("Most senior employee:");
		System.out.println(senior.getName() + ", joined in " + senior.getYearOfJoining());
		System.out.println("--------------------------------");

		// Outputs the number of employees in each department
		int csSize = emps.stream().filter(e -> e.getDept().equals("CS")).collect(Collectors.toList()).size();
		int mechSize = emps.stream().filter(e -> e.getDept().equals("Mechanical")).collect(Collectors.toList()).size();

		System.out.println("Number of employees in CS department: " + csSize);
		System.out.println("Number of employees in Mechanical department: " + mechSize);
		System.out.println("--------------------------------");

		// Outputs number of male and female employees in each dept
		int femCS = emps.stream().filter(e -> e.getDept().equals("CS") && e.getGender().equals("Female"))
				.collect(Collectors.toList()).size();
		int maleCS = emps.stream().filter(e -> e.getDept().equals("CS") && e.getGender().equals("Male"))
				.collect(Collectors.toList()).size();
		int fMech = emps.stream().filter(e -> e.getDept().equals("Mechanical") && e.getGender().equals("Female"))
				.collect(Collectors.toList()).size();
		int mMech = emps.stream().filter(e -> e.getDept().equals("Mechanical") && e.getGender().equals("Male"))
				.collect(Collectors.toList()).size();

		System.out.println("Number of women in CS: " + femCS);
		System.out.println("Number of men in CS: " + maleCS);
		System.out.println("Number of women in Mechanical: " + fMech);
		System.out.println("Number of men in Mechanical: " + mMech);
		System.out.println("--------------------------------");

		// Outputs average salary of male and female employees
		List<Emp> mTotal = emps.stream().filter(e -> e.getGender().equals("Male")).collect(Collectors.toList());
		int mSals = 0;
		for (Emp m : mTotal) {

			mSals += m.getSalary();
		}
		double maleAvgSal = mSals / maleCount; // maleCount initiated in line 44, total amount of males

		System.out.println("Average Male Salary: $" + maleAvgSal);

		List<Emp> fTotal = emps.stream().filter(e -> e.getGender().equals("Female")).collect(Collectors.toList());
		int fSals = 0;
		for (Emp f : fTotal) {

			fSals += f.getSalary();
		}
		double femaleAvgSal = fSals / femaleCount; // femaleCount initiated in line 45, total amount of females

		System.out.println("Average Female Salary: $" + femaleAvgSal);
		System.out.println("--------------------------------");

		// Outputs employees younger and older than 30 years
		System.out.println("Employees younger than 30:");

		emps.stream().filter(e -> e.getAge() < 30).collect(Collectors.toList())
				.forEach(e -> System.out.println(e.getName()));

		System.out.println("\nEmployees older than 30:");

		emps.stream().filter(e -> e.getAge() >= 30).collect(Collectors.toList())
				.forEach(e -> System.out.println(e.getName()));
		System.out.println("--------------------------------");

		// Outputs names of all employees in each department
		System.out.println("Names of CS employees:");

		emps.stream().filter(e -> e.getDept().equals("CS")).collect(Collectors.toList())
				.forEach(e -> System.out.println(e.getName()));

		System.out.println("\nNames of Mechanical employees:");

		emps.stream().filter(e -> e.getDept().equals("Mechanical")).collect(Collectors.toList())
				.forEach(e -> System.out.println(e.getName()));

	}
}
