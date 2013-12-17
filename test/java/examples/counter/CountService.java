package examples.counter;

/**
 * Created by cprice on 12/17/13.
 */
public abstract class CountService {

    public abstract int incAndGet();

    private static CountService instance;

    public static CountService getInstance() {
        return instance;
    }

    public static void setInstance(CountService cs) {
        instance = cs;
    }

}
