package net.nokok.inject;

public class ClassKey<T> extends Key<T> {

    protected ClassKey(Class<T> keyClass) {
        super(keyClass);
    }
}
