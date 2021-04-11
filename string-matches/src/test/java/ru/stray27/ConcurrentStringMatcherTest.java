package ru.stray27;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConcurrentStringMatcherTest {

    @Test
    public void concurrentMatchesTrueTest() {
       boolean ret = ConcurrentStringMatcher.matches("JetBrains is the best company ever", "(J).*(B).*");
        assertTrue(ret);
    }

    @Test
    public void concurrentMatchesFalseTest() {
        boolean ret = ConcurrentStringMatcher.matches("Yandex is the best company ever", "(J).*(B).*");
        assertFalse(ret);
    }

    @Test
    public void concurrentMatchesTimeoutTest() {
        boolean ret = ConcurrentStringMatcher.matches("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aa?aa?aa?aa?aa?aa?aa?aa?aa?aa?aa?aa?aa?aa?aa?aa?aa?aa?aa?aa?aa?aa?aa?aa?aa?aa?aa?aa?aa?aa?aa?aa?aa?aa?aa?aa?aa?aa?aa?aa?aa?aa?aa?aa?aa?aa?aa?aa?aa?aa?aa?aa?aa?aa?aa?aa?aa?aa?aa?aa?aa?aa?aa?aa?aa?aa?aa?aa?aa?aa?aa?aa?aa?aa?aa?aa?aa?aa?aa?aa?aa?aa?aa?aa?");
        assertFalse(ret);
    }

}