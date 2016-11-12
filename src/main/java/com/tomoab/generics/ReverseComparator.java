package com.tomoab.generics;

import java.util.Comparator;

class ReverseComparator<T> implements Comparator<T> {

    private final Comparator<T> delegateComparator;

    ReverseComparator(final Comparator<T> delegateComparator) {
        this.delegateComparator = delegateComparator;
    }

    public int compare(final T left, final T right) {
        return -1 * delegateComparator.compare(left, right);
    }
}
