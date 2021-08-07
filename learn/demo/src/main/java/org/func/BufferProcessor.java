package org.func;

import java.io.BufferedReader;
import java.io.IOException;

@FunctionalInterface
public interface BufferProcessor {
    String process(BufferedReader b) throws IOException;
}
