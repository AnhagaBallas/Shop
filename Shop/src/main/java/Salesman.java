import java.util.List;

public class Salesman implements SellerActions,ReturnBuyI {
    /*
     Данный класс продавца выполняет лишь соответствующие ему логические функции покупки, рекомендации товара,
     соответственное реализуя принцип Single Responsibility Principle
    */
    private static int days;
    private Basket basket = new Basket();

    public Goods askRecomendation(List<Goods> shopList) {
        Goods recomendation = shopList.get(0);
        for (int i = 1; i < shopList.size() - 1; i++) {
            if (shopList.get(0).getRating() < shopList.get(i).getRating()) {
                recomendation = shopList.get(i);
            }
        }

        return recomendation;

    }

    public void buy() {
        List basketList = basket.getShopList();
        if (basketList.size() > 5) {
            days = 10;
            System.out.println("Вы совершили покупку заказа " + basketList.toString());
            System.out.println("Время доставки составляет " + days + " дней");
        } else if (basket.getShopList().isEmpty()) {
            System.out.println("Ваша корзина пуста, не удалось совершить покупку");
        } else if (basketList.size() < 5) {
            days = 5;
            System.out.println("Вы совершили покупку заказа " + basketList.toString());
            System.out.println("Время доставки составляет " + days + " дней");
        }

    }

    public void returnBuy(Basket basket) {
        System.out.println("Вы отменили заказ");
        basket.emptyBasket();

    }

    public int getDays() {
        return days;
    }
}
