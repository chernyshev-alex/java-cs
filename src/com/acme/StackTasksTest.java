package com.acme;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class StackTasksTest {
    @Test
    void testIsValidParentheses() {
        Map<String, Boolean> map = new HashMap<String, Boolean>() {{
            put("()", true); put("()[]{}", true); put("(]", false); put("]", false);
        }};
        Set<Map.Entry<String, Boolean>> entries = map.entrySet();
        for (Map.Entry<String, Boolean> s : map.entrySet()) {
            assertEquals(new StackTasks().IsValidParentheses(s.getKey()), s.getValue());
        }
    }

}