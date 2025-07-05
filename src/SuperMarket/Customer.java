package SuperMarket;

public class Customer extends User{

    private int customerId;
    private double balance;
    private Cart cart;
    public Customer(int id,String userName,String email,String password,boolean isAdmin,double balance){
        super(userName,email,password,isAdmin);
        this.customerId=id;
        this.balance=balance;
        this.cart=new Cart(this.customerId);
    }
    public Cart getCart(){
        return this.cart;
    }
    public double getBalance(){
        return this.balance;
    }
    public void setBalance(double balance){
        this.balance=balance;
    }

}
