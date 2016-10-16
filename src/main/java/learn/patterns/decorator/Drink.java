package learn.patterns.decorator;

/**
 * 咖啡主体超类
 * Created by @Just on 2016/10/9.
 */
public abstract class Drink {
    public String description=""; //描述
    private float price = 0f;     //价格
    public String getDescription() {
        return description + "-" + this.price;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public float getPrice() {
        return price;
    }
    public void setPrice(float price) {
        this.price = price;
    }

    /**
     *  总价格(再被咖啡单品继承、调料装饰后将会递归调用)
     * @return float
     */
    public abstract float cost();
}
