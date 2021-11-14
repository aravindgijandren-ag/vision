package com.wolfpack.vision.helper;

import java.util.Collection;

public interface Converter<I,O> {
    O convert(I input);
}
