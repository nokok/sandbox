package net.nokok.inject;

import net.nokok.inject.internal.Dependencies;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Injector {

    private final Map<Key<?>, Dependencies<?>> mappings;

    public Injector(Binding<?, ?>... bindings) {
        this.mappings = Arrays.stream(bindings).map(b -> Map.entry(b.getKey(), b.getDependencies())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    @SuppressWarnings("unchecked")
    public <T> T getInstance(Class<T> clazz) {
        Key<T> key = Key.of(clazz);
        Class<?> implClass = mappings.get(key).getKey().getKeyClass();
        List<Key<?>> dependencies = mappings.get(key).getDependencies();
        int parameterLength = dependencies.size();
        Class<?>[] parameterList = dependencies.stream().map(Key::getKeyClass).collect(Collectors.toList()).toArray(new Class<?>[parameterLength]);
        Object[] args = new Object[parameterLength];
        for (int i = 0; i < dependencies.size(); i++) {
            Key<?> dep = dependencies.get(i);
            args[i] = getInstance(dep.getKeyClass());
        }
        try {
            System.out.println("DEBUG: Parameters " + Arrays.toString(parameterList));
            if (parameterLength == 0) {
                return (T) implClass.getConstructor().newInstance();
            } else {
                return (T) implClass.getConstructor(parameterList).newInstance(args);
            }

        } catch (ReflectiveOperationException e) {
            throw new RuntimeException(e);
        }
    }

    public static class syntax {
        public static <T> BindingBuilder.KeyBuilder<T> bind(Class<T> i) {
            return new BindingBuilder.KeyBuilder<>(i);
        }
    }
}
