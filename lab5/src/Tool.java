import java.util.*;

public abstract class Tool implements ITool {
    private String name;
    private double[] measurements;
    private List<Material> materials;
    private State state;
    public static int toolsMade = 0;

    Tool(String name, double[] measurements, List<Material> materials, State state) {
        this.name = name;
        this.measurements = measurements;
        this.materials = materials;
        this.state = state;
        toolsMade++;
    }

    Tool() {

        try {
            Scanner scn = new Scanner(System.in);

            System.out.println("Enter the name of the measuring tool: ");
            this.name = scn.nextLine();

            System.out.println("Enter the measurements of the measuring tool: ");
            System.out.println("Height: ");
            double height = scn.nextDouble();
            System.out.println("Width: ");
            double width = scn.nextDouble();
            System.out.println("Length: ");
            double length = scn.nextDouble();
            scn.nextLine();
            this.measurements = new double[] {height, width, length};

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
        } catch(InputMismatchException e) {
            this.name = "name";
            this.measurements = new double[] {1, 1, 1};
            this.materials = new ArrayList<>();
            this.state = State.OFF;
        }

        toolsMade++;
    }

    public static void showToolsMade() {
        System.out.println(toolsMade);
    }

    @Override
    public String showState() {
        return switch (this.state) {
            case ON -> "On";
            case OFF -> "Off";
            case WORKS -> "Works";
            case BROKEN -> "Broken";
        };
    }

    @Override
    public String showMeasurements() {
        return "Height: " + measurements[0] + ", Width: " + measurements[1] + ", Length: " + measurements[2];
    }

    @Override
    public String toString() {
        return "MeasuringTool{" +
                "name='" + name + '\'' +
                ", measurements=" + Arrays.toString(measurements) +
                ", materials=" + materials +
                ", state=" + state +
                ", toolsMade=" + toolsMade +
                ", IS_A_THING=" + IS_A_THING +
                '}';
    }

    @Override
    public abstract void doSomething();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double[] getMeasurements() {
        return measurements;
    }

    public void setMeasurements(double[] measurements) {
        this.measurements = measurements;
    }

    public List<Material> getMaterials() {
        return materials;
    }

    public void setMaterials(List<Material> materials) {
        this.materials = materials;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
