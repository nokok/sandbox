package net.nokok;

import net.nokok.inject.Injector;

import static net.nokok.inject.Injector.syntax.bind;

public class Library {

    public static void main(String[] args) {
        Injector injector = new Injector(
                bind(Base.class).to(Impl.class)
        );
        Base instance = injector.getInstance(Base.class);
        if (instance instanceof Impl) {
            // pass
        } else {
            throw new AssertionError();
        }
    }
}

interface Base {

}

interface A {

}

class AImpl implements A {

}

class Impl implements Base {

}