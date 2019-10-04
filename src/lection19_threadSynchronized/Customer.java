package lection19_threadSynchronized;
import org.apache.log4j.Logger;

import java.math.BigDecimal;
import java.util.*;
/*
  Поток "Покупатель" логирует свои действия в магазине
  (Например: Покупатель n зашел в магазин. Покупатель n выбрал товар M в количестве 2 и т.д.).
  Покупатель может положить в корзину от 0 до к товаром разным количеством (для каждого потока покупателя определяется случайным образом).
  Если покупатель ничего не выбрал, то он логирует это и покидает магазин.
  Если корзина (ShoppingBasket) не пуста, то покупатель становится в единую очередь, которую обслуживают несколько касс от 1-3.
  Первая, освободившаяся касса, обслуживает первого из очереди покупателя.
  Время обслуживания пропорционально равно количеству покупок в корзине покупателя.
 */

public class Customer extends Thread {
    public static final Logger LOGGER = Logger.getLogger(Customer.class);

    private String name;
    private Store store;
    private ShoppingBasket shoppingBasket;
    private Map<Good, Integer> buyList;

    public Customer(String name, Store store) {
        this.name = name;
        this.store = store;
        this.shoppingBasket = new ShoppingBasket();
        this.buyList = generateBuyList();
    }

    public String getCustomerName() {
        return this.name;
    }

    public ShoppingBasket getShoppingBasket(){
        return this.shoppingBasket;
    }
    @Override
    public void run() {
        LOGGER.info(String.format("Покупатель %s зашел в магазин", this.name));

        for (Map.Entry<Good, Integer> item : this.buyList.entrySet()) {
            if(item.getValue() > 0) {
                for (int i = 0; i < item.getValue(); i++) {
                    getGood(item.getKey());
                }
            }
        }
        LOGGER.info(String.format("Покупатель %s взял все нужные товары", this.name));
        LOGGER.info(String.format("Покупатель %s пошел в очередь к кассам", this.name));
        this.store.toQueue(this, this.shoppingBasket.getAllGoods());
    }

    private Map<Good, Integer> generateBuyList() {
        Random rm = new Random();
        Map<Good, Integer> buyList = new HashMap<>();
        Set<Good> storeAvailableGoods = store.getAvailableGoods();
        for (Good good : storeAvailableGoods) {
            buyList.put(good, rm.nextInt(3));
        }
        return buyList;
    }


    public void getGood(Good good) {
        Good item = this.store.getGood(good);
        LOGGER.info(String.format("Покупатель %s взял товар %s", this.name, item.getName()));
        this.shoppingBasket.addGood(item);
        LOGGER.info(String.format("Покупатель %s положил товар %s в корзину", this.name, item.getName()));
    }


    public Map<Good, Integer> getGoodsFromShoppingBasket() {
        return this.shoppingBasket.getAllGoods();
    }

    /**
     * Поток покупатель выдает случайным образом сумму больше или равную запрашиваемой.
     */
    public BigDecimal payForGoods(BigDecimal goodsCost) {
        BigDecimal paymentAmount = goodsCost.add(goodsCost.multiply(BigDecimal.valueOf(Math.random())));
        LOGGER.info(String.format("Покупатель %s оплачивает покупку товаров: %.2f", this.name, paymentAmount.doubleValue()));
        return paymentAmount;
    }


}
