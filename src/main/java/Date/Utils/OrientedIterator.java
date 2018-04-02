package Date.Utils;

public interface OrientedIterator<E> {
    enum Orientation{UP, DOWN}

    boolean hasNext(Orientation orient);

    E next(Orientation orient);

}
