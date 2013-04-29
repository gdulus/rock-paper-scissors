package rps.gui;

import rps.utils.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class BashGUI implements GUI {

    private static final String ANSI_RESET = "\u001B[0m";

    private static final String ANSI_GREEN = "\u001B[32m";

    private static final String ANSI_YELLOW = "\u001B[33m";

    private static final String ANSI_RED = "\u001B[31m";

    private static final String HEADER_VISUALISATION = "--------------------------";

    @Override
    public String pull() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            return br.readLine();
        } catch (final IOException exception){
            return null;
        }
    }

    @Override
    public void push(final String message) {
        resetColor();
        System.out.println(message);
    }

    @Override
    public void pushInfo(final String message) {
        setColor(ANSI_GREEN);
        System.out.println(message);
    }

    @Override
    public void pushWarning(String message) {
        setColor(ANSI_YELLOW);
        System.out.println(message);
    }

    @Override
    public void pushError(String message) {
        setColor(ANSI_RED);
        emptyLine();
        System.out.println(message);
        emptyLine();
    }

    @Override
    public void pushHeader(String header) {
        setColor(ANSI_GREEN);
        System.out.println(HEADER_VISUALISATION);
        System.out.println(header);
        System.out.println(HEADER_VISUALISATION);
    }

    private void emptyLine(){
        System.out.println(StringUtils.EMPTY_STRING);
    }

    private void setColor(final String color){
        System.out.print(color);
    }

    private void resetColor(){
        System.out.print(ANSI_RESET);
    }
}
