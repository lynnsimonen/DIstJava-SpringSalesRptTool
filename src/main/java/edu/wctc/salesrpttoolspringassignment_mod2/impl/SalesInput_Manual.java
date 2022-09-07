package edu.wctc.salesrpttoolspringassignment_mod2.impl;

import edu.wctc.salesrpttoolspringassignment_mod2.Sale;
import edu.wctc.salesrpttoolspringassignment_mod2.iface.SalesInput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SalesInput_Manual implements SalesInput {
    private static Scanner keyboard = new Scanner(System.in);
    @Override
    public List<Sale> salesInput() {
        String moreSales;
        String country = "";
        String taxes;
        String amount = "";
        String shipping = "shipping";
        double amountDouble;
        String countryInitial;
        Boolean check;
        List<Sale> salesRecords = new ArrayList<>();
        System.out.println("Please enter the data for the Sales Report:\n");
        do {
            System.out.println("Customer Name: ");
            String name = keyboard.next();
            do {
                System.out.println("U = USA\nI = India\nJ = Japan\nS = Scotland\n");
                System.out.println("Country: ");
                countryInitial = keyboard.next();
                if (countryInitial.equalsIgnoreCase("i")) {
                    country = "India";
                } else if (countryInitial.equalsIgnoreCase("u")) {
                    country= "United States";
                } else if (countryInitial.equalsIgnoreCase("J")) {
                    country="Japan";
                } else if (countryInitial.equalsIgnoreCase("s")) {
                    country="Scotland";
                }
            } while (!(countryInitial.toUpperCase().equals("U")) && !(countryInitial.toUpperCase().equals("J")) && !(countryInitial.toUpperCase().equals("I")) && !(countryInitial.toUpperCase().equals("S")));

            //-----------------------------------------------
            do {
                try {
                    do {
                        check = false;
                        System.out.println("Sale Amount: ");
                        amount = keyboard.next();
                        amountDouble = Double.parseDouble(amount);
                    } while (!(amountDouble >= 0) || !(amountDouble <= 1000000));
                }catch (NumberFormatException e)
                    {
                        System.out.println(amount + " is not an acceptable sale amount. Enter a number from 0 - 1000000.");
                        check = true;
                    }
            } while (check);

            //----------------------------------------------------
            do {
                System.out.println("Taxes: ");
                taxes = keyboard.next();
            }while (Integer.parseInt(taxes) >= Integer.parseInt(amount));
            Sale saleIndividual = new Sale(name, country, amount, taxes, shipping);
            salesRecords.add(saleIndividual);
            System.out.println("Would you like to add another line of sales input? Y or N \n");
            moreSales = keyboard.next();
        } while (moreSales.toUpperCase().equals("Y"));

        return salesRecords;
    }
}
