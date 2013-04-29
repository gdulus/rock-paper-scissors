package rps.gui;

public interface GUI {

    public String pull();

    public void push(String message);

    public void pushInfo(String message);

    public void pushWarning(String message);

    public void pushError(String message);

    public void pushHeader(String message);
}
