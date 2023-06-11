import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class SnapshotArray {
    List<int[]> storage;
    private int id = 0;

    public SnapshotArray(int length) {
        storage = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            storage.add(i, new int[101]);
        }
    }

    public void set(int index, int val) {
        if (val == 0) {
            val = Integer.MIN_VALUE + 1;
        }
        if (storage.get(index).length - 1 < this.id) {
            storage.set(index, expand(storage.get(index), id));
        }
        storage.get(index)[id] = val;

    }

    public int snap() {

        return id++;
    }

    public int get(int index, int snap_id) {
        int[] indexHistory = storage.get(index);
        if (indexHistory.length - 1 < snap_id) {
            snap_id = indexHistory.length - 1;
        }
        for (int i = snap_id; i >= 0; i--) {
            if (indexHistory[i] != 0) {
                return indexHistory[i] == Integer.MIN_VALUE + 1 ? 0 : indexHistory[i];
            }
        }
        return 0;
    }

    private int[] expand(int[] original, int idValue) {
        int size = original.length;
        return Arrays.copyOf(original, idValue + 1);
    }
}
class Pair{
    int id;
    int value;

    public Pair(int id, int value) {
        this.id = id;
        this.value = value;
    }
}
