import java.util.*;

public class LengthMeasuringTool extends MeasuringTool {

    private String name;
    private double[] measurements;
    private double warrantyTerm;
    private List<Material> materials;
    private State state;
    private Integer price;

    LengthMeasuringTool(String name, double[] measurements, double warrantyTerm, List<Material> materials, State state, Integer price) {
        super(name, measurements, materials, state, price);

        this.name = name;
        this.measurements = measurements;
        this.warrantyTerm = warrantyTerm;
        this.materials = materials;
        this.state = state;
        this.price = price;
    }

    LengthMeasuringTool() {
        super("meow", new double[] {1, 1, 1}, new ArrayList<>(), State.OFF, 1);

        try {
            Scanner scn = new Scanner(System.in);

            System.out.println("Enter the name of the measuring tool: ");
            this.name = scn.nextLine();
            super.setName(this.name);

            System.out.println("Enter the measurements of the measuring tool: ");
            System.out.println("Height: ");
            double height = scn.nextDouble();
            System.out.println("Width: ");
            double width = scn.nextDouble();
            System.out.println("Length: ");
            double length = scn.nextDouble();
            scn.nextLine();
            this.measurements = new double[] {height, width, length};
            super.setMeasurements(this.measurements);

            System.out.println("Enter the warranty term: ");
            this.warrantyTerm = scn.nextDouble();
            scn.nextLine();

            List<Material> materials = new ArrayList<>();
            while(true) {
                Material material = new Material();
                System.out.println("Enter the name of the material (type 'exit' to stop): ");
                String materialName;
                materialName = scn.nextLine();
                if(materialName.equals("exit")) {
                    break;
                }
                System.out.println("Enter the quantity of the material: ");
                int quantity = scn.nextInt();
                scn.nextLine();
                System.out.println("Enter dealer's name: ");
                String dealerName;
                dealerName = scn.nextLine();
                material.setName(materialName);
                material.setQuantity(quantity);
                material.setDealerName(dealerName);
                materials.add(material);
            }
            this.materials = materials;
            super.setMaterials(this.materials);

            while(true) {
                System.out.println("Enter tool's state: ");
                System.out.println("Available states: ");
                System.out.println("1 - ON");
                System.out.println("2 - OFF");
                System.out.println("3 - WORKS");
                System.out.println("4 - BROKEN");
                int state = scn.nextInt();
                if(state > 0 && state < 5) {
                    switch(state) {
                        case(1):
                            this.state = State.ON;
                            break;
                        case(2):
                            this.state = State.OFF;
                            break;
                        case(3):
                            this.state = State.WORKS;
                            break;
                        case(4):
                            this.state = State.BROKEN;
                            break;
                        default:
                            this.state = State.BROKEN;
                            break;
                    }
                    break;
                } else {
                    System.out.println("Invalid state. Try again.");
                }
            }
            super.setState(this.state);
        } catch(InputMismatchException e) {
            this.name = "name";
            this.measurements = new double[] {1, 1, 1};
            this.warrantyTerm = 1;
            this.materials = new ArrayList<>();
            this.state = State.OFF;
        }
    }

    @Override
    public void doSomething() {
        System.out.println("Measuring length...");
    }

    @Override
    public String toString() {
        return "MeasuringTool{" +
                "name='" + name + '\'' +
                ", measurements=" + Arrays.toString(measurements) +
                ", warrantyTerm=" + warrantyTerm +
                ", materials=" + materials +
                ", state=" + state +
                ", toolsMade=" + toolsMade +
                ", IS_A_THING=" + IS_A_THING +
                '}';
    }

    public double getWarrantyTerm() {
        return warrantyTerm;
    }

    public void setWarrantyTerm(double warrantyTerm) {
        this.warrantyTerm = warrantyTerm;
    }
}
