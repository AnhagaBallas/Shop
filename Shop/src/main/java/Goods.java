public class Goods implements Comparable<Goods> {
    private String name;
    private int price;
    private int rating;
    private int discount;
    private String company;

    public Goods(String name, int price, int rating, int discount, String company) {
        this.name = name;
        this.price = price;
        this.rating = rating;
        this.discount = discount;
        this.company = company;
    }

    /*
    Данный класс является примером применения принципа Dependency inversion
    principle
   */
    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", rating=" + rating +
                ", discount=" + discount +
                ", company='" + company + '\'' +
                '}';
    }

    public int getDiscount() {
        return discount;
    }

    public int getRating() {
        return rating;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public String getCompany() {
        return company;
    }

    /*
    Данный класс является примером применения принципа Dependency inversion
    principle
    */
    @Override
    public int compareTo(Goods o) {
        return this.getPrice() - o.getPrice();
    }

}
