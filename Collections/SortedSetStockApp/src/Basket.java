import java.util.Map;

public class Basket {
    private final Map<StockItem, Integer> list;
    private  final String name;

    public Basket(Map<StockItem, Integer> list, String name) {
        this.name = name;
        this.list = list;
    }

    public Map<StockItem, Integer> getList() {
        return list;
    }

    public String getName() {
        return name;
    }

    public int addToBasket(StockItem item, int quantity) {
        if(item != null) {
            int inBasket = list.getOrDefault(item, 0);
            list.put(item, inBasket + quantity);
            return inBasket;
        }

        return 0;

    }

    @Override
    public String toString() {
        String s = "\nShopping basket " + name + " contains " + list.size() + " items\n";
        double totalCost = 0.0;
        for (Map.Entry<StockItem, Integer> item : list.entrySet()) {
            s = s + item.getKey() + ". " + item.getValue() + " purchased\n";
            totalCost += item.getKey().getPrice() * item.getValue();
        }
        return s + "Total cost " + totalCost;
    }
}
