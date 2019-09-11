package com.hz;

import java.io.* ;

public class MyFileReader extends LineReader {

    private String _location;

    public MyFileReader(String location) {
        _location = location;
    }

    public String readLine()
            throws FileNotFoundException, IOException {

        BufferedReader brTest = new BufferedReader(
                new FileReader(_location));

        String line = brTest.readLine();

        return line;
    }
}
