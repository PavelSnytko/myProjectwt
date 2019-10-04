package lection19_threadSynchronized;
import java.math.BigDecimal;
/*
 Магазин имеет перечень товаров (класс Good со свойствами: id, name, price, discount (0-0.89))
  {Пиво, Водка, чипсы, хлеб, молоко, селедка, кефир, батон, гречка, колбаски, йогурт и булочка из печки}.
 */

public class Good {
    private static int lastId = 0;
    private int id;
    private String name;
    private BigDecimal price;
    private double discount = 0;

    public Good(String name, BigDecimal price, double discount){
        this.id = ++lastId;
        this.name = name;
        this.price = price;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public double getDiscount() {
        return discount;
    }
}
