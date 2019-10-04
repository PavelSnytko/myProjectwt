package lection19_threadSynchronized;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/*
  После этого Касса выдает чек, формирует объект Receipt (id, date, casseNo, List<Item>, totalSum, change).
 */
public class Receipt {
    private static int lastId = 0;
    private int id;
    private Date date;
    private int casseNo;
    private List<Item> itemList;
    private BigDecimal totalSum;
    private BigDecimal change;

    public Receipt() {
        this.id = ++lastId;
        this.date = new Date();
    }

    public Receipt(int casseNo, List<Item> itemList, BigDecimal totalSum, BigDecimal change) {
        this.id = ++lastId;
        this.date = new Date();
        this.casseNo = casseNo;
        this.itemList = itemList;
        this.totalSum = totalSum;
        this.change = change;
    }


    public int getCasseNo() {
        return casseNo;
    }

    public void setCasseNo(int casseNo) {
        this.casseNo = casseNo;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    public BigDecimal getTotalSum() {
        return totalSum;
    }

    public void setTotalSum(BigDecimal totalSum) {
        this.totalSum = totalSum;
    }

    public BigDecimal getChange() {
        return change;
    }

    public void setChange(BigDecimal change) {
        this.change = change;
    }

    @Override
    public String toString() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        String stringDate = dateFormat.format(this.date);
        String receiptHeader = String.format("Receipt %d%nCashier number %d%nDate %s%n", this.id, this.casseNo, stringDate);
        String receiptEnd = String.format("Total amount: %.2f. Change: %.2f", this.totalSum.doubleValue(), this.change.doubleValue());
        String receiptItemList = "";
        for (Item item : this.itemList) {
            receiptItemList = receiptItemList.concat(item.toString()).concat("\n");
        }

        return receiptHeader + receiptItemList + receiptEnd;
    }
}
