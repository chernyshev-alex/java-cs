package com.acme;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TriesTest {
    @Test
    void testPrefixTreeSearch() {
        Tries t  = new Tries();
        t.insert("apple");
        assertEquals(true, t.search("apple"));
        assertEquals(false, t.search("app"));
        assertEquals(true, t.startWith("apple"));
    }

}