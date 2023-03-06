/**
 * @author sunchuanjia
 * @Description
 * @create 2022-12-06 15:00
 */
public enum PriceRules{
    HALF_DISCOUNT("半价折扣", 0.5),
    Nine_DISCOUNT("九折折扣", 0.5),
    FIVE_DISCOUNT("五折折折扣", 0.5);

    private String rules;
    private Double weight;

    PriceRules(String rules, Double weight){
        this.rules = rules;
        this.weight = weight;
    }

    public String getRules(){
        return this.rules;
    }

    public double getWeight(){
        return this.weight;
    }
}
