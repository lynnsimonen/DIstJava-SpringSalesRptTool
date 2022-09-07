package edu.wctc.salesrpttoolspringassignment_mod2.impl;
import edu.wctc.salesrpttoolspringassignment_mod2.Sale;
import edu.wctc.salesrpttoolspringassignment_mod2.iface.SalesInput;
import edu.wctc.salesrpttoolspringassignment_mod2.iface.ShippingPolicy;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SalesInput_Csv implements SalesInput {
    private ShippingPolicy shipping;
    @Override
    public List<Sale> salesInput() {
        //read the records line by line then split line into tokens base ons comma delimiter
        List<Sale> sales = new ArrayList<>();
        try {

            File myFile = new File("C:\\Users\\lynns\\Documents\\WCTC\\2022_Fall_WCTC\\DistributedJava\\SalesRptTool-SpringAssignment_Mod2\\src\\main\\java\\edu\\wctc\\salesrpttoolspringassignment_mod2\\Files\\SalesInput.txt");
            Scanner readFile = new Scanner(myFile);
            while (readFile.hasNextLine()) {
                String data = readFile.nextLine();

                String[] saleData = data.split(",");

                String name = saleData[0];
                String country = saleData[1];
                String amount = saleData[2];
                String taxes = saleData[3];
                String shipping = "shipping";
                String[] newSalesData = new String[saleData.length+1];
                for (int i = 0; i<saleData.length; i++) {
                    newSalesData[i] = saleData[i];
                    newSalesData[newSalesData.length-1] = "shipping";
                }
                //newSalesData[newSalesData.length-1] = "shipping";
                //List<String> newSaleData = new ArrayList<>(Arrays.asList(saleData));
                //newSaleData.add("shipping");
                //saleData = newSalesData.toArray(saleData);

                //Sale saleIndividual = new Sale(name, country, amount, taxes, shipping);
                Sale saleIndividual = new Sale(newSalesData[0], newSalesData[1], newSalesData[2], newSalesData[3], newSalesData[4]);
                sales.add(saleIndividual);
                //System.out.println(saleIndividual);
            }
            readFile.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred: " + e);
        }
        return sales;
    }
}

