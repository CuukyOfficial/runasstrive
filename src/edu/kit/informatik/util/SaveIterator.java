package edu.kit.informatik.util;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class SaveIterator<T> {

    private final List<T> iterate;
    private final Predicate<T> skip;
    private int index;

    public SaveIterator(List<T> iterator) {
        this.iterate = new ArrayList<>(iterator);
        this.skip = list -> !iterator.contains(list);
    }

    public boolean isFinished() {
        return this.index >= this.iterate.size();
    }

    public T previewNext() {
        return this.isFinished() ? this.iterate.get(0) : this.iterate.get(this.index);
    }

    public T next() {
        if (this.isFinished()) this.index = 0;
        T chosen = this.iterate.get(this.index);
        this.index++;
        return this.skip.test(chosen) ? this.next() : chosen;
    }

    public boolean isEqual(List<T> list) {
        return this.iterate.equals(list);
    }
}