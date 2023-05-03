import java.util.List;

public interface BasketIn {

    public void addToBasket(Goods goods);

    public void showBasket();


    public void filterBasketByPrice();

    public void filterBasketByCompany();

    public List<Goods> getShopList();

    public void emptyBasket();
}
