
public class Material {

    private String name;
    private int quantity;
    private String dealerName;

    public Material() {
        this.name = "name";
        this.quantity = 1;
        this.dealerName = "dealer";
    }

    public Material(String dealerName, int quantity, String name) {
        this.dealerName = dealerName;
        this.quantity = quantity;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Material{" +
                "name='" + name + '\'' +
                ", quantity=" + quantity +
                ", dealerName='" + dealerName + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDealerName() {
        return dealerName;
    }

    public void setDealerName(String dealerName) {
        this.dealerName = dealerName;
    }
}
