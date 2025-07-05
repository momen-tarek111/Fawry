package SuperMarket;

public class Shippable implements IShippable{
    private double weight;
    private String name;
    public  Shippable(String name,double weight){
        this.weight=weight;
        this.name=name;
    }
    @Override
    public String getName(){
        return this.name;
    }
    @Override
    public double getWeight(){
        return this.weight;
    }
}
