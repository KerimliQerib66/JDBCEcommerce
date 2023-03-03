package Bean;

public class Products {
    private int ID;
    private String name;
    private String description;
    private int price;

    @Override
    public String toString() {
        return "Products{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }

    public Products() {

    }

    public Products(int ID, String name, String description, int price) {
        this.ID = ID;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
