package com.leartocode;

import java.util.Scanner;

public class financialCalculator {


        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            // Prompt the user to choose a calculator
            System.out.println("Choose a calculator:");
            System.out.println("1. Mortgage calculator");
            System.out.println("2. Future value calculator");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                // Mortgage calculator
                System.out.print("Enter the principal amount: ");
                double principal = scanner.nextDouble();

                System.out.print("Enter the annual interest rate (as a decimal): ");
                double annualInterestRate = scanner.nextDouble();

                System.out.print("Enter the loan term in years: ");
                int loanTermInYears = scanner.nextInt();

                double monthlyInterestRate = annualInterestRate / 1200;
                int numberOfPayments = loanTermInYears * 12;

                double monthlyPayment = (principal * monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfPayments)) /
                        (Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1);

                double totalInterest = (monthlyPayment * numberOfPayments) - principal;

                System.out.printf("The monthly mortgage payment is $%.2f%n", monthlyPayment);
                System.out.printf("The total interest paid is $%.2f%n", totalInterest);
            } else if (choice == 2) {
                // Future value calculator
                System.out.print("Enter the deposit amount: ");
                double deposit = scanner.nextDouble();

                System.out.print("Enter the annual interest rate (as a decimal): ");
                double annualInterestRate = scanner.nextDouble();

                System.out.print("Enter the number of years: ");
                int years = scanner.nextInt();

                double futureValue = deposit * Math.pow(1 + annualInterestRate, years);

                double totalInterest = futureValue - deposit;

                System.out.printf(" future value is $%.2f%n", futureValue);
                System.out.printf(" total interest earned is $%.2f%n", totalInterest);
            } else {
                System.out.println("Invalid choice. choose 1 or 2.");
            }
        }


}
