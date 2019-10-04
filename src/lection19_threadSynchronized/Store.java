package lection19_threadSynchronized;
import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.*;
public class Store {
    private Semaphore semaphore;
    private Map<Good, Integer> storeGoodsCategory;
    private List<Cashier> cashiers;

    public Store(Map<Good, Integer> storeGoods, Cashier... cashiers) {
        this.storeGoodsCategory = storeGoods;
        this.cashiers = Arrays.asList(cashiers);
        this.semaphore = new Semaphore(this.cashiers.size(), true);
    }

    public Set<Good> getAvailableGoods() {
        return this.storeGoodsCategory.keySet();
    }

    public Good getGood(Good good) {
        for (Map.Entry<Good, Integer> goodItems : this.storeGoodsCategory.entrySet()) {
            if (goodItems.getKey() == good && goodItems.getValue() > 0) {
                synchronized (this.storeGoodsCategory) {
                    this.storeGoodsCategory.put(goodItems.getKey(), goodItems.getValue() - 1);
                }
                return goodItems.getKey();
            }
        }
        return null;
    }

    public synchronized void putGoods(Good goodItem, int goodCount) {
        if (this.storeGoodsCategory.keySet().contains(goodItem)) {
            this.storeGoodsCategory.put(goodItem, this.storeGoodsCategory.get(goodItem) + goodCount);
        } else {
            this.storeGoodsCategory.put(goodItem, goodCount);
        }
    }

    public Receipt toQueue(Customer customer, Map<Good, Integer> goods) {
        Receipt receipt = null;
        try {
            this.semaphore.acquire();
            for (Cashier cashier : this.cashiers) {
                if (cashier.isAvailable()) {
                    BigDecimal paymentAmount = customer.payForGoods(cashier.calculateTotalAmountForCustomer(customer, goods));
                    receipt = cashier.serveCustomer(goods, paymentAmount);
                }
            }
            this.semaphore.release();
        } catch (InterruptedException e) {
            System.out.println("Thread has been interrupted");
        }
        return receipt;
    }
}
