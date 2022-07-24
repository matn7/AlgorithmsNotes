package coursera.hashtables;

public class LinearProbingHashST<Key, Value> {
    private int m = 30001;
    private Value[] vals = (Value[]) new Object[m];
    private Key[] keys = (Key[]) new Object[m];

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % m;
    }

    public void put(Key key, Value val) {
        int i;
        for (i = hash(key); keys[i] != null; i = (i+1) % m) {
            if (keys[i].equals(key)) {
                break;
            }
        }
        keys[i] = key;
        vals[i] = val;
    }

    public Value get(Key key) {
        for (int i = hash(key); keys[i] != null; i = (i + 1) % m) {
            if (key.equals(keys[i])) {
                return vals[i];
            }
        }
        return null;
    }

}
