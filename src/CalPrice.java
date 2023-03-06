import java.util.List;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-12-06 14:59
 */
public class CalPrice {
    public static void main(String[] args) {
        Product product = new Product();
        CalPrice calPrice = new CalPrice();
        product.rulesCodeList.add("半价折扣");
        Double price = calPrice.getPrice(product);
        System.out.println("最终价格: " + price);
    }
    public Double getPrice(Product product){
        double basePrice = product.basePrice;
        for (String code : product.rulesCodeList){
            for (PriceRules rule : PriceRules.values()){
                if (rule.getRules().equals(code)){
                    basePrice *= rule.getWeight();
                }
            }
        }
        return basePrice;
    }
}
