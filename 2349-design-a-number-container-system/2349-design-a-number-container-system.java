import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

class NumberContainers {
    private final Map<Integer, Integer> indexToNumber;
    private final Map<Integer, TreeSet<Integer>> numberToIndices;

    public NumberContainers() {
        indexToNumber = new HashMap<>();
        numberToIndices = new HashMap<>();
    }
    
    public void change(int index, int number) {
        // If the index already holds a number, remove the index from the old number's set
        if (indexToNumber.containsKey(index)) {
            int oldNumber = indexToNumber.get(index);
            if (oldNumber == number) {
                return; // No change needed
            }
            TreeSet<Integer> oldSet = numberToIndices.get(oldNumber);
            oldSet.remove(index);
            if (oldSet.isEmpty()) {
                numberToIndices.remove(oldNumber);
            }
        }
        
        // Map the index to the new number and add the index to the new number's sorted set
        indexToNumber.put(index, number);
        numberToIndices.computeIfAbsent(number, k -> new TreeSet<>()).add(index);
    }
    
    public int find(int number) {
        TreeSet<Integer> indices = numberToIndices.get(number);
        if (indices == null || indices.isEmpty()) {
            return -1;
        }
        return indices.first();
    }
}
