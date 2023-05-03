public class Apple extends Goods {
    /*
     Данный класс является примером применения сразу двух принципов а именно Open-closed principle что заключается в
     расширении функционала класса Goods а также принцыпа Liskov substitution principle так как данный клас может логически
     выполнять роль класса-родителя
    */
    private String color;

    public Apple(String name, int price, int rating, int discount, String company) {
        super(name, price, rating, discount, company);
    }

    public void setAppleColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}
