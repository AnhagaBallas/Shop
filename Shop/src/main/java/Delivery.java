public class Delivery implements ReturnBuyI {
    private Salesman salesman = new Salesman();

    public void trackPath() {
        System.out.println("Ваша посылка придет к вам через " + salesman.getDays());
    }

    public void returnBuy(Basket basket) {
        System.out.println("Вы отменили заказ");
        basket.emptyBasket();

    }
}
