package com.hz;

import java.io.FileNotFoundException;
import java.io.IOException;

public abstract class LineReader {

    public abstract String readLine()
            throws FileNotFoundException, IOException;
}
