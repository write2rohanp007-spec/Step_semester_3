package fundamentals.assigment_problems;

/**
 * Week 1 Assignment - Problem 4: The Warehouse Inventory Balancer
 */
public class WarehouseInventoryBalancer {

    public static void analyzeInventory(int[] sectionA, int[] sectionB) {
        int totalA = 0, totalB = 0;
        for (int value : sectionA) {
            totalA += value;
        }
        for (int value : sectionB) {
            totalB += value;
        }

        String status = (totalA == totalB) ? "Balanced" : "Not Balanced";

        int highest = sectionA[0];
        String highestSection = "Section A";
        int highestIndex = 0;

        for (int i = 0; i < sectionA.length; i++) {
            if (sectionA[i] > highest) {
                highest = sectionA[i];
                highestSection = "Section A";
                highestIndex = i;
            }
        }
        for (int i = 0; i < sectionB.length; i++) {
            if (sectionB[i] > highest) {
                highest = sectionB[i];
                highestSection = "Section B";
                highestIndex = i;
            }
        }

        System.out.printf("Section A Total: %d | Section B Total: %d | Status: %s | Highest Quantity: %d (%s, Item %d)%n",
                totalA, totalB, status, highest, highestSection, highestIndex + 1);
    }

    public static void main(String[] args) {
        analyzeInventory(new int[]{20, 15, 30}, new int[]{25, 10, 30});
    }
}
