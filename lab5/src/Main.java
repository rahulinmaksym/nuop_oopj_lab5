import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    static ArrayList<MeasuringTool> measuringTools = new ArrayList<>();

    public static void main(String[] args) {

        List<Material> materials = new ArrayList<>();
        materials.add(new Material("wood", 83, "Johnny"));
        materials.add(new Material("iron", 80, "Mark"));
        materials.add(new Material("plastic", 4554, "Richard"));
        materials.add(new Material("glass", 654, "Roor"));

        MeasuringTool measuringTool1 = new MeasuringTool(
                "lens", new double[] {20, 150, 150}, materials, State.WORKS, 1000);

        MeasuringTool measuringTool2 = new MeasuringTool(
                "ruler", new double[] {70, 30, 1070}, materials, State.WORKS, 100);

        MeasuringTool measuringTool3 = new MeasuringTool(
                "meow", new double[] {70, 80, 1070}, materials, State.WORKS, 500);

        MeasuringTool measuringTool4 = new MeasuringTool(
                "meow", new double[] {70, 80, 1070}, materials, State.WORKS, 600);

        measuringTools.add(measuringTool1);
        System.out.println(measuringTools);

        measuringTools.add(measuringTool2);
        System.out.println(measuringTools);

        addToIndex(1, measuringTool3);
        System.out.println(measuringTools);

        measuringTools.add(measuringTool4);
        System.out.println(measuringTools);

        removeFirst();
        System.out.println(measuringTools);

        System.out.println(findNameMatches("meow"));

        System.out.println(contains(measuringTool1));
        System.out.println(contains(measuringTool4));

        MeasuringTool[] measuringToolsArray = getArray();
        for(MeasuringTool measuringTool : measuringToolsArray) {
            System.out.println(measuringTool);
        }

        sortByPrice();
        System.out.println(measuringTools);
    }

    public static void addToIndex(int index, MeasuringTool measuringTool) {
        measuringTools.add(index, measuringTool);
    }

    public static void removeFirst() {
        measuringTools.removeFirst();
    }

    public static int findNameMatches(String name) {

        int matches = 0;

        for(MeasuringTool measuringTool : measuringTools) {
            if(measuringTool.getName().equals(name)) {
                matches++;
            }
        }

        return matches;
    }

    public static boolean contains(MeasuringTool measuringTool) {
        return measuringTools.contains(measuringTool);
    }

    public static MeasuringTool[] getArray() {
        return measuringTools.toArray(new MeasuringTool[measuringTools.size()]);
    }

    public static void sortByPrice() {
        Collections.sort(measuringTools, (o1, o2) -> o2.getPrice() - o1.getPrice());
    }
}