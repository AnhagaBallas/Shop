import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Basket implements BasketIn {
    private static List<Goods> shopList;

    public Basket() {
        shopList = new ArrayList<>();
    }

    public void addToBasket(Goods goods) {
        shopList.add(goods);
    }

    public void showBasket() {
        System.out.println("содержимое корзины");
        if (shopList.isEmpty()) {
            System.out.println("Ваша корзина пуста");
        }
        for (int i = 0; i < shopList.size(); i++) {
            int f = i;
            f++;
            System.out.println(f + ") " + shopList.get(i).toString());
        }
    }

    public void filterBasketByPrice() {
        Collections.sort(shopList);

    }

    public void filterBasketByCompany() {
        String company = shopList.get(0).getCompany();
        List<Goods> listCompany1 = new ArrayList<>();
        List<Goods> listCompany2 = new ArrayList<>();
        for (int i = 0; i < shopList.size(); i++) {
            if (shopList.get(i).getCompany().equals(company)) {
                listCompany1.add(shopList.get(i));
            } else {
                listCompany2.add(shopList.get(i));
            }
        }
        for (int i = 0; i < listCompany2.size(); i++) {
            listCompany1.add(listCompany2.get(i));
        }
        shopList = listCompany1;
    }

    public List<Goods> getShopList() {
        return shopList;
    }

    public void emptyBasket() {
        shopList.clear();
    }


}
