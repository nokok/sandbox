package net.nokok

import net.nokok.inject.Key
import net.nokok.inject.internal.Dependencies
import spock.lang.Specification

class DependencySpec extends Specification {

    static class A {}

    static class B {
        B(String s) {

        }
    }

    def "build dependency"() {
        def d = Dependencies.find(clazz)

        expect:
        d.dependencies == dependencies

        where:
        clazz || dependencies
        A     || []
        B     || [Key.of(String)]
    }
}
