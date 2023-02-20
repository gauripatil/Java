public class Main {
    private static StockList stockList = new StockList();
    public static void main(String[] args) {
        StockItem item = new StockItem("bread", 0.86, 100);
        stockList.addStock(item);

        item = new StockItem("cake", 1.10, 7);
        stockList.addStock(item);

        item = new StockItem("car", 12.50, 2);
        stockList.addStock(item);

        item = new StockItem("chair", 62.0, 10);
        stockList.addStock(item);

        item = new StockItem("cup", 0.50, 200);
        stockList.addStock(item);

        item = new StockItem("door", 72.95, 4);
        stockList.addStock(item);

        item = new StockItem("juice", 2.50, 36);
        stockList.addStock(item);

        item = new StockItem("phone", 96.99, 35);
        stockList.addStock(item);

        item = new StockItem("towel", 2.40, 80);
        stockList.addStock(item);

        item = new StockItem("vase", 8.76, 40);
        stockList.addStock(item);

        System.out.println(stockList);

        for(String s: stockList.Items().keySet()) {
            System.out.println(s);
        }
    }
}