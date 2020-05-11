package net.nokok.inject;

import net.nokok.inject.internal.Dependencies;

import java.util.Objects;

public class BindingBuilder {
    public static class KeyBuilder<Type> {

        private final Class<Type> keyClass;

        public KeyBuilder(Class<Type> keyClass) {
            this.keyClass = Objects.requireNonNull(keyClass);
        }

        public <Impl extends Type> Binding<Type, Impl> to(Class<Impl> clazz) {
            Key<Type> key = Key.of(keyClass);
            Dependencies<Impl> dependencies = Dependencies.find(clazz);
            return new Binding<>(key, dependencies);
        }

        public <I extends Type> Binding<Type, I> toInstance(I instance) {
            return null;
        }

        public KeyBuilder<Type> qualifiedWith(String qualifiedKey) {
            return null;
        }

    }
}
