package lection19_threadSynchronized;
import java.math.BigDecimal;
/*
 Item, класс идентифицирующий товарную позицию в чеке (Item: No -порядковый номер позиции, Good, quantity, cost, discount, discountAmount).
 */
public class Item {
    private int no;
    private Good good;
    private int quantity;
    private BigDecimal cost;
    private double discount;
    private BigDecimal discountAmount;

    public Item() {
    }

    public Item(int number, Good good, int quantity, BigDecimal cost, double discount, BigDecimal discountAmount) {
        this.no = number;
        this.good = good;
        this.quantity = quantity;
        this.cost = cost;
        this.discount = discount;
        this.discountAmount = discountAmount;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Good getGood() {
        return good;
    }

    public void setGood(Good good) {
        this.good = good;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public BigDecimal getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(BigDecimal discountAmount) {
        this.discountAmount = discountAmount;
    }

    @Override
    public String toString() {
        return String.format("%d. %-20s (%d) Cost: %.2f. Discount: %.2f", this.no, this.good.getName(), this.quantity, this.cost.doubleValue(), this.discountAmount.doubleValue());
    }
}
