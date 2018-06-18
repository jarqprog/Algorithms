package com.jarq.algorithms.flatteningList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FlatteningList {

    public Object[] flatten(Object... toTransform) {

        List<Object> flattened = new ArrayList<>();

        for (Object obj : toTransform) {
            if (obj instanceof Object[]) {
              flattened.addAll(Arrays.asList(flatten( (Object[]) obj)) );
            } else {
              flattened.add(obj);
            }
        }

        return flattened.toArray(new Object[0]);
    }
}
