package lection19_threadSynchronized;
import org.apache.log4j.Logger;

import java.math.BigDecimal;
import java.util.*;
/*
  Если корзина (ShoppingBasket) не пуста, то покупатель становится в единую очередь, которую обслуживают несколько касс от 1-3.
  Первая, освободившаяся касса, обслуживает первого из очереди покупателя.
  Время обслуживания пропорционально равно количеству покупок в корзине покупателя.
  Касса логирует все действия с товарами покупателя и формирует сумму покупки.
  Поток покупатель выдает случайным образом сумму больше или равную запрашиваемой.
  После этого Касса выдает чек, формирует объект Receipt (id, date, casseNo, List<Item>, totalSum, change).
  Где Item, класс идентифицирующий товарную позицию в чеке (Item: No -порядковый номер позиции, Good, quantity, cost, discount, discountAmount).
  Печатается текст чека Покупатель выходит из магазина и сообщает об этом.
 */
public class Cashier extends Thread{
    public static final Logger LOGGER = Logger.getLogger(Cashier.class);

    private int casseNo;
    private boolean isAvailable = true;
    private Customer currentCustomer;

    public Cashier(int casseNo) {
        this.casseNo = casseNo;
    }

    public boolean isAvailable() {
        return this.isAvailable;
    }

    public Receipt serveCustomer(Map<Good, Integer> goods, BigDecimal cash) {
        LOGGER.info(String.format("Касса %d: берет деньги у покупаетля %s", this.casseNo, this.currentCustomer.getCustomerName()));
        BigDecimal change = cash.subtract(calculateTotalAmount(this.currentCustomer, goods));

        Receipt receipt = generateReceipt(goods, change);

        LOGGER.info(String.format("Касса %d: печатает чек для покупателя %s", this.casseNo, this.currentCustomer.getCustomerName()));
        printReceipt(receipt);

        this.isAvailable = true;
        return receipt;
    }

    private Receipt generateReceipt(Map<Good, Integer> goods, BigDecimal change) {
        Receipt receipt = new Receipt();

        receipt.setCasseNo(this.casseNo);
        receipt.setItemList(convertGoodListToItemList(goods));
        receipt.setTotalSum(calculateTotalAmount(this.currentCustomer, goods));
        receipt.setChange(change);

        return receipt;
    }

    public BigDecimal calculateTotalAmountForCustomer(Customer customer, Map<Good, Integer> goods){
        this.isAvailable = false;
        this.currentCustomer = customer;

        LOGGER.info(String.format("Касса %d: обслуживает покупателя %s", this.casseNo, this.currentCustomer.getCustomerName()));
        try {
            LOGGER.info(String.format("Касса %d: принимает покупки у покупателя %s", this.casseNo, this.currentCustomer.getCustomerName()));
            sleep(calculateGoodsCount(goods));
        } catch (InterruptedException e) {e.printStackTrace();}
        LOGGER.info(String.format("Касса %d: формирует сумму покупки для покупателя %s", this.casseNo, this.currentCustomer.getCustomerName()));
        return calculateTotalAmount(customer, goods);
    }

    private BigDecimal calculateTotalAmount(Customer customer, Map<Good, Integer> goods) {
        List<Item> itemList = convertGoodListToItemList(goods);

        BigDecimal totalAmount = BigDecimal.valueOf(0);
        for (Item item : itemList) {
            BigDecimal newTotalAmount = totalAmount.add(item.getCost());
            totalAmount = newTotalAmount;
        }
        return totalAmount;
    }

    /*
      Метод для реализации требования:
     "Время обслуживания пропорционально равно количеству покупок в корзине покупателя"
     */
    private long calculateGoodsCount(Map<Good, Integer> goods) {
        long goodsCount = 0;
        for (Integer item : goods.values()) {
            goodsCount+= item;
        }
        return goodsCount;
    }


    private List<Item> convertGoodListToItemList(Map<Good, Integer> goods) {
        List<Item> itemList = new ArrayList<>();
        int itemNumber = 0;
        for (Map.Entry<Good, Integer> goodItem : goods.entrySet()) {
            Item item = new Item();

            item.setNo(++itemNumber);
            item.setGood(goodItem.getKey());
            item.setQuantity(goodItem.getValue());
            item.setDiscount(goodItem.getKey().getDiscount());
            item.setDiscountAmount(goodItem.getKey().getPrice().multiply(BigDecimal.valueOf(item.getDiscount())).multiply(BigDecimal.valueOf(item.getQuantity())));
            item.setCost(goodItem.getKey().getPrice().multiply(BigDecimal.valueOf(item.getQuantity())).subtract(item.getDiscountAmount()));

            itemList.add(item);
        }
        return itemList;
    }

    private void printReceipt(Receipt receipt) {
        System.out.println(receipt.toString());
    }
}
