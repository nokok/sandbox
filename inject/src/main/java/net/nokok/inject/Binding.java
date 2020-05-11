package net.nokok.inject;


import net.nokok.inject.internal.Dependencies;

public class Binding<Bind, Dep> {
    private final Key<Bind> key;
    private final Dependencies<Dep> dependencies;

    public Binding(Key<Bind> key, Dependencies<Dep> dependencies) {
        this.key = key;
        this.dependencies = dependencies;
    }

    public Key<Bind> getKey() {
        return key;
    }

    public Dependencies<Dep> getDependencies() {
        return dependencies;
    }
}
