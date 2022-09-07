package edu.wctc.salesrpttoolspringassignment_mod2.impl;
import edu.wctc.salesrpttoolspringassignment_mod2.Sale;
import edu.wctc.salesrpttoolspringassignment_mod2.iface.SalesReport;

import java.util.List;

public class SalesReport_Full implements SalesReport {
    @Override
    public void displayReport(List<Sale> sales) {
        System.out.println("SALES DETAIL REPORT");
        System.out.println(String.format("%-25s %-20s %10s %10s %10s", "Customer", "Country", "Amount", "Tax", "Shipping"));
        for (Sale item : sales) {
            System.out.println(String.format("%-25s %-20s %10.2f %10.2f %10.2f", item.getCustomerName(), item.getCountry(), Double.parseDouble(item.getSalesAmount()), Double.parseDouble(item.getSalesTax()), Double.parseDouble(item.getShippingCharge())));
        }
    }
}
