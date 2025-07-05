package SuperMarket;

import java.util.ArrayList;

public class Cart {
    private int customerId;
    private ArrayList<Item> items;
    private double subTotalPrice;
    private double totalWeight;
    private double shippingPrice;
    private double totalPrice;
    public Cart(int id){
        this.customerId=id;
        this.items=new ArrayList<Item>();
    }
    public void AddItem(Item item){
        this.items.add(item);
        if(item.product.isShippable()){
            this.totalWeight+=item.product.getShippable().getWeight()*item.getQuantitySold();
        }
        this.subTotalPrice+=item.getTotalPrice();
    }
    public double getSubTotalPrice(){
        return  this.subTotalPrice;
    }
    public double getShippingPrice(){
        this.shippingPrice=ShippingService.CalculateTotalShippingPrice(this.totalWeight);
        return this.shippingPrice;
    }
    public ArrayList<Item> getItems(){
        return this.items;
    }
    public double getTotalWeight(){
        return this.totalWeight;
    }
    public double getTotalPrice(){
        this.totalPrice=this.shippingPrice+this.subTotalPrice;
        return this.totalPrice;
    }
    public boolean isEmpty(){
        return items.isEmpty();
    }
    public void resetCart(){
        this.items=new ArrayList<Item>();
        this.totalWeight=0;
        this.subTotalPrice=0;
        this.totalPrice=0;
    }
    public void displayCart(){
        System.out.println("                                                                \u001B[32m Your Cart :) \u001B[0m");

        for(Item i:items){
            System.out.println(i.getQuantitySold() + " * " +i.product.getName()+"                        "+i.product.getPrice() +" $ ");
        }
        System.out.println("*********************************");

        System.out.println("SubTotalPrice :" +subTotalPrice+"$");
        System.out.println("ShippingPrice :" +getShippingPrice()+"$");
        System.out.println("TotalPrice :" +getTotalPrice()+"$");
    }
}
