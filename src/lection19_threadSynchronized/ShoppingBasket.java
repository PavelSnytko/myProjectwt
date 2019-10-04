package lection19_threadSynchronized;
import java.util.*;
public class ShoppingBasket {
    private Map<Good, Integer> goods;

    public ShoppingBasket(){
        this.goods = new HashMap<>();
    }

    public void addGood(Good goodItem){
        if(this.goods.keySet().contains(goodItem)){
            this.goods.put(goodItem, this.goods.get(goodItem) + 1);
        }else {
            this.goods.put(goodItem, 1);
        }
    }

    public Map<Good, Integer> getAllGoods(){
        Map<Good, Integer> goods = new HashMap<>(this.goods);
        this.goods.clear();
        return goods;
    }

    public Good getGood(){
        for (Map.Entry<Good, Integer> goodItems : this.goods.entrySet()){
            if(goodItems.getValue() > 0){
                this.goods.put(goodItems.getKey(), goodItems.getValue() - 1);
                return goodItems.getKey();
            }
        }
        return null;
    }

    public Good getGood(Good good){
        if(this.goods.containsKey(good) && this.goods.get(good) > 0){
            this.goods.put(good, this.goods.get(good) - 1);
            return good;
        }else{
            return null;
        }
    }
}
