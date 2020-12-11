package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import entities.Company;
import entities.Individual;
import entities.TaxPayer;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner read = new Scanner(System.in);

		List<TaxPayer> list = new ArrayList<TaxPayer>();

		System.out.print("Enter the number of taxpayers: ");
		int n = read.nextInt();

		for (int i = 1; i <= n; i++) {
			System.out.println("Taxpayer #" + i + " data:");
			System.out.print("Individual or company (i/c)?");
			char chr = read.next().charAt(0);
			System.out.print("Name: ");
			read.next();
			String name = read.nextLine();
			
			System.out.print("Anual income: ");
			Double anualIncome = read.nextDouble();
			if (chr == 'i') {
				System.out.print("Health expenditures: ");
				Double healthExpenditures = read.nextDouble();
				list.add(new Individual(name, anualIncome, healthExpenditures));
			} else if (chr == 'c') {
				System.out.print("Number of employees: ");
				Integer numberOfEmployees = read.nextInt();
				list.add(new Company(name, anualIncome, numberOfEmployees));
			}

		}

		System.out.println();
		System.out.println("TAXES PAID: ");

		for (TaxPayer tp : list) {
			System.out.println(tp.getName() + ": $ " + String.format("%.2f", tp.tax()));

		}

		System.out.println();
		
		double amount = 0.0;
		for (TaxPayer tp : list) {
			amount += tp.tax();
		}

		System.out.printf("TOTAL TAXES: $ " + String.format("%.2f", amount));

		read.close();
	}

}
