package edu.wctc.salesrpttoolspringassignment_mod2;

public class Sale {
    private String customerName;
    private String country;
    private String salesAmount;
    private String salesTax;
    private String shippingCharge;

    public Sale(String customerName, String country, String salesAmount, String salesTax, String shippingCharge){
        this.customerName=customerName;
        this.country=country;
        this.salesAmount=salesAmount;
        this.salesTax=salesTax;
        this.shippingCharge=shippingCharge;
    }

    public Sale(String shippingCharge){
        this.shippingCharge=shippingCharge;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCountry() {
        return country;
    }

    public String getSalesAmount() {
        return salesAmount;
    }
    public void setSalesAmount(String salesAmount) {
        this.salesAmount = salesAmount;
    }

    public  String getSalesTax() {return salesTax; }

    public void setSalesTax(String salesTax) {
        this.salesTax = salesTax;
    }

    public String getShippingCharge() {return shippingCharge; }

    public void setShippingCharge(String shippingCharge) {
        this.shippingCharge = shippingCharge;
    }

}
