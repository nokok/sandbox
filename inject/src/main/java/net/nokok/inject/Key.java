package net.nokok.inject;

import java.util.Objects;

public class Key<T> {

    private final Class<T> keyClass;
    private final String name;

    protected Key(Class<T> keyClass) {
        this.keyClass = keyClass;
        this.name = this.keyClass.getName();
    }

    public String getName() {
        return this.name;
    }

    public Class<T> getKeyClass() {
        return keyClass;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Key<?> key = (Key<?>) o;
        return Objects.equals(name, key.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public static <T> Key<T> of(Class<T> clazz) {
        return new ClassKey<>(clazz);
    }
}

