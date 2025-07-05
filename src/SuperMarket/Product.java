package SuperMarket;

public class Product {
    private String name;
    private double price;
    private int quantity;
    private Shippable shippable;
    private Expirable expirable;
    public Product(String name ,double price,int quantity){
        this.name=name;
        this.price=price;
        this.quantity=quantity;
    }
    public Product(String name ,double price,int quantity,Shippable shippable){
        this.name=name;
        this.price=price;
        this.quantity=quantity;
        this.shippable=shippable;
    }
    public Product(String name ,double price,int quantity,Expirable expirable){
        this.name=name;
        this.price=price;
        this.quantity=quantity;
        this.expirable=expirable;
    }
    public Product(String name ,double price,int quantity,Shippable shippable,Expirable expirable){
        this.name=name;
        this.price=price;
        this.quantity=quantity;
        this.shippable=shippable;
        this.expirable=expirable;
    }
    public String getName(){
        return this.name;
    }
    public double getPrice(){
        return this.price;

    }
    public int getQuantity(){
        return this.quantity;
    }
    public boolean isExpirable(){
        return expirable!=null;
    }
    public boolean isShippable(){
        return shippable!=null;
    }
    public Expirable getExpirable(){
        return this.expirable;
    }
    public Shippable getShippable(){
        return this.shippable;
    }

    public void displayInfo() {
        System.out.println("            Product Name :"+getName());
        System.out.println("            Product Price :"+getPrice());
    }
}
