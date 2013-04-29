package rps.gui;

import rps.utils.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

class BashGUI implements GUI {

    static final String ANSI_RESET = "\u001B[0m";

    static final String ANSI_GREEN = "\u001B[32m";

    static final String ANSI_YELLOW = "\u001B[33m";

    static final String ANSI_RED = "\u001B[31m";

    static final String HEADER_VISUALISATION = "--------------------------";

    private final BufferedReader reader;

    private final PrintStream printStream;

    BashGUI(BufferedReader reader, PrintStream printStream) {
        this.reader = reader;
        this.printStream = printStream;
    }

    @Override
    public String pull() {
        try {
            return reader.readLine();
        } catch (final IOException exception){
            return StringUtils.EMPTY_STRING;
        }
    }

    @Override
    public void push(final String message) {
        if (message != null){
            resetColor();
            printStream.println(message);
        }
    }

    @Override
    public void pushInfo(final String message) {
        if (message != null){
            setColor(ANSI_GREEN);
            printStream.println(message);
        }
    }

    @Override
    public void pushWarning(String message) {
        if (message != null){
            setColor(ANSI_YELLOW);
            printStream.println(message);
        }
    }

    @Override
    public void pushError(String message) {
        if (message != null){
            setColor(ANSI_RED);
            emptyLine();
            printStream.println(message);
            emptyLine();
        }
    }

    @Override
    public void pushHeader(String header) {
        if (header != null){
            setColor(ANSI_GREEN);
            printStream.println(HEADER_VISUALISATION);
            printStream.println(header);
            printStream.println(HEADER_VISUALISATION);
        }
    }

    private void emptyLine(){
        printStream.println(StringUtils.EMPTY_STRING);
    }

    private void setColor(final String color){
        printStream.print(color);
    }

    private void resetColor(){
        printStream.print(ANSI_RESET);
    }
}
