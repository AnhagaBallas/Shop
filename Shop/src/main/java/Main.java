import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws WrongNumberException {
        boolean cycle = true;
        Basket basket = new Basket();
        Salesman salesman = new Salesman();
        Delivery delivery = new Delivery();
        List<Goods> goodsList = new ArrayList<>();
        Apple goods1 = new Apple("goods1", 1, 1, 0, "Company1");
        Goods goods2 = new Goods("goods2", 2, 2, 10, "Company2");
        Goods goods3 = new Goods("goods3", 3, 3, 30, "Company1");
        goodsList.add(goods1);
        goodsList.add(goods2);
        goodsList.add(goods3);
        String enterScreen = "Cписок возвозможных действий:\n" +
                "1)Список товаров\n" +
                "2)Выбор товара в корзину\n" +
                "3)Содержимое корзины\n" +
                "4)Фильтр корзины\n" +
                "5)Рекомедации к покупке\n" +
                "6)Совершить покупку\n" +
                "7)Возврат заказа\n" +
                "8)Треккинг заказа\n" +
                "9)Завершение работы";
        while (cycle == true) {
            System.out.println(enterScreen);
            int input = scanner.nextInt();
            wrongNumber(input, 1, 9);
            switch (input) {
                case 1:
                    for (int i = 0; i < goodsList.size(); i++) {
                        int f = i;
                        f++;
                        System.out.println((f) + ") " + goodsList.get(i).toString());
                    }
                    System.out.println("1) Вернуться в предыдущее меню");
                    input = scanner.nextInt();
                    if (input == 1) {
                        break;
                    }
                    wrongNumber(input, 1);

                case 2:
                    while (true) {
                        System.out.println("Выберете товар");
                        for (int i = 0; i < goodsList.size(); i++) {
                            int f = i;
                            f++;
                            System.out.println((f) + ") " + goodsList.get(i).toString());
                        }
                        input = scanner.nextInt();
                        basket.addToBasket(goodsList.get(input - 1));
                        System.out.println(goodsList.get(input - 1).getName() + " Успешно помещен в корзину");
                        System.out.println("1) Вернуться в предыдущее меню\n" +
                                "2) Продолжить выбор товара");
                        input = scanner.nextInt();
                        if (input == 1) {
                            break;
                        }
                        wrongNumber(input, 1, 2);
                    }
                    break;
                case 3:
                    basket.showBasket();
                    System.out.println("1) Вернуться в предыдущее меню");
                    input = scanner.nextInt();
                    if (input == 1) {
                        break;
                    }
                    wrongNumber(input, 1);


                case 4:
                    System.out.println("Выберете критерий сортировки\n"
                            + "1) Сортировка по цене товара\n"
                            + "2) Cортировка по фирме производителю");
                    input = scanner.nextInt();
                    switch (input) {
                        case 1:
                            basket.filterBasketByPrice();
                            break;
                        case 2:
                            basket.filterBasketByCompany();
                            break;
                    }
                    wrongNumber(input, 1, 2);
                    System.out.println("1) Вернуться в предыдущее меню");
                    input = scanner.nextInt();
                    if (input == 1) {
                        break;
                    }
                    wrongNumber(input, 1);

                case 5:
                    System.out.println("Продавец рекомендует к покупке " + salesman.askRecomendation(goodsList).toString());
                    System.out.println("1) Вернуться в предыдущее меню\n" +
                            "2) Добавить рекомендацию в корзину");
                    input = scanner.nextInt();
                    switch (input) {
                        case 1:
                            break;
                        case 2:
                            basket.addToBasket(salesman.askRecomendation(goodsList));
                            break;
                    }
                    if (input == 1) {
                        break;
                    }
                    wrongNumber(input, 1, 2);
                    break;

                case 6:
                    salesman.buy();
                    System.out.println("1) Вернуться в предыдущее меню");
                    input = scanner.nextInt();
                    if (input == 1) {
                        break;
                    }
                    wrongNumber(input, 1);
                    break;

                case 7:
                    salesman.returnBuy(basket);
                    System.out.println("1) Вернуться в предыдущее меню");
                    input = scanner.nextInt();
                    if (input == 1) {
                        break;
                    }
                    wrongNumber(input, 1);
                    break;


                case 8:
                    delivery.trackPath();
                    System.out.println("1) Вернуться в предыдущее меню");
                    input = scanner.nextInt();
                    if (input == 1) {
                        break;
                    }
                    wrongNumber(input, 1);
                    break;


                case 9:
                    cycle = false;
                    break;
            }

        }
    }

    public static void wrongNumber(int input, int boundaryFirst, int boundaryLast) throws WrongNumberException {
        if (input < boundaryFirst || input > boundaryLast) {
            throw new WrongNumberException("Некоректный ввод");
        }
    }

    public static void wrongNumber(int input, int boundary) throws WrongNumberException {
        if (input != boundary) {
            throw new WrongNumberException("Некоректный ввод");
        }
    }
}
