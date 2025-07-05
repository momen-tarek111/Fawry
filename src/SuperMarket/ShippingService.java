package SuperMarket;

public class ShippingService {
    private static final double SHIPPING_PRICE_PER_KG=30.0;
    public static double CalculateTotalShippingPrice(double totalWeight){
        return SHIPPING_PRICE_PER_KG*(totalWeight/1000);
    }
}
