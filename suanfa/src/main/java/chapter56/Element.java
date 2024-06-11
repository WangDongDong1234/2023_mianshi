package chapter56;

/**
 * 放入背包的元素
 */

public class Element {
    /**
     * 物品名称
     */
    private String name;

    /**
     * 物品价值
     */
    private int value;

    /**
     * 物品花费
     */
    private int cost;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
