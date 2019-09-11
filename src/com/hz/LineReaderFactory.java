package com.hz;

public class LineReaderFactory {

    public static ConsoleReader GetConsoleReader() {

        return new ConsoleReader();
    }

    public static MyFileReader GetFileReader() {

        String loc = "c:\\tmp\\test.txt";
        MyFileReader reader = new MyFileReader(loc);

        return reader;
    }
}
