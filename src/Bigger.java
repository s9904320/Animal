/**
 * 比較大小
 */
public class Bigger implements Comparator{
    @Override
    public boolean compare(float before, float after) {
        return before > after;
    }
}
