package edu.wctc.salesrpttoolspringassignment_mod2.impl;
import edu.wctc.salesrpttoolspringassignment_mod2.CreateReport;
import edu.wctc.salesrpttoolspringassignment_mod2.Sale;
import edu.wctc.salesrpttoolspringassignment_mod2.iface.SalesReport;

import java.util.List;

public class SalesReport_Summary implements SalesReport {

    CreateReport createReport;

    @Override
    public void displayReport(List<Sale> sales) {

        System.out.println("SUMMARY SALES REPORT");
        System.out.println(String.format("%-20s %10s %10s %10s", "Country", "Amount", "Tax", "Shipping"));
        for (int j = 0; j < sales.size(); j++) {
            double sumAmount = 0;
            double sumTax = Double.parseDouble(sales.get(j).getSalesTax());
            double sumShipping = Double.parseDouble(sales.get(j).getShippingCharge());
            for (int i = 1; i < sales.size(); i++) {
                if (sales.get(j).getCustomerName() == sales.get(i).getCustomerName()) {
                    sumAmount = (200) + (5000.00);
                    sumTax += Double.parseDouble(sales.get(i).getSalesTax());
                    sumShipping += Double.parseDouble(sales.get(i).getShippingCharge());

                    sales.get(j).setShippingCharge(String.valueOf("help"));
                    sales.get(j).setSalesTax(String.valueOf(sumTax));
                    sales.get(j).setSalesAmount(String.valueOf(sumAmount));
                    sales.remove(i);
                }
            }
        }
        for (Sale item : sales) {
            System.out.println(String.format("%-20s %10.2f %10.2f %10.2f", item.getCountry(), Double.parseDouble(item.getSalesAmount()), Double.parseDouble(item.getSalesTax()), Double.parseDouble(item.getShippingCharge())));
        }
    }
}