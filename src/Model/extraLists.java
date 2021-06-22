package Model;

import java.util.List;
import java.lang.reflect.Constructor;

public class extraLists <T> extends Satellit{
    private List<T> ts;

    public extraLists(List<T> ts) {
        this.ts = ts;
    }

}