import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Spliterator;
import java.util.function.Consumer;

public class Randoms implements Iterable<Integer> {
    private int min;
    private int max;
    protected Random random;
    private ArrayList<Integer> array;

    public Randoms(int min, int max) {
        this.random = new Random();
        this.array = new ArrayList<>();
        this.min=min;
        this.max=max;
    }


    @Override
    public Iterator<Integer> iterator() {
        Iterator<Integer> result = new Iterator<>() {
            private int ind;

            @Override
            public boolean hasNext() {
                array.add(random.nextInt(min,max+1));
                if (ind < array.size()) return true;
                return false;
            }

            @Override
            public Integer next() {
                if (this.hasNext()) return array.get(ind++);
                return null;
            }
        };
        return result;
    }

    @Override
    public void forEach(Consumer<? super Integer> action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator<Integer> spliterator() {
        return Iterable.super.spliterator();
    }

}