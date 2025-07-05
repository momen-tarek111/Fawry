package SuperMarket;

public class Item {
    public Product product;
    private int quantitySold;
    public Item(Product product,int quantitySold){
        this.product=product;
        this.quantitySold=quantitySold;
    }

    public int getQuantitySold(){
        return this.quantitySold;
    }
    public double getTotalPrice(){
        return this.getQuantitySold()*this.product.getPrice();
    }


}
