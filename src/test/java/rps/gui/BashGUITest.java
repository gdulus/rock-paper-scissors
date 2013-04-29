package rps.gui;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.testng.Assert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

@RunWith(PowerMockRunner.class)
@PrepareForTest({BufferedReader.class, InputStream.class})
public class BashGUITest {

    @Test
    public void push_nullParam_shouldDoNothing(){
        BufferedReader mockBufferedReader = Mockito.mock(BufferedReader.class);
        PrintStream mockPrintStream = Mockito.mock(PrintStream.class);

        BashGUI gui = new BashGUI(mockBufferedReader, mockPrintStream);
        gui.push(null);

        Mockito.verify(mockPrintStream, Mockito.never()).println(Mockito.anyString());
    }

    @Test
    public void push_emptyParam_shouldPrint(){
        BufferedReader mockBufferedReader = Mockito.mock(BufferedReader.class);
        PrintStream mockPrintStream = Mockito.mock(PrintStream.class);

        BashGUI gui = new BashGUI(mockBufferedReader, mockPrintStream);
        gui.push("");

        Mockito.verify(mockPrintStream).print(BashGUI.ANSI_RESET);
        Mockito.verify(mockPrintStream).println("");
    }

    @Test
    public void push_notEmptyParam_shouldPrint(){
        BufferedReader mockBufferedReader = Mockito.mock(BufferedReader.class);
        PrintStream mockPrintStream = Mockito.mock(PrintStream.class);

        BashGUI gui = new BashGUI(mockBufferedReader, mockPrintStream);
        gui.push("test");

        Mockito.verify(mockPrintStream).print(BashGUI.ANSI_RESET);
        Mockito.verify(mockPrintStream).println("test");
    }

    @Test
    public void pushInfo_nullParam_shouldDoNothing(){
        BufferedReader mockBufferedReader = Mockito.mock(BufferedReader.class);
        PrintStream mockPrintStream = Mockito.mock(PrintStream.class);

        BashGUI gui = new BashGUI(mockBufferedReader, mockPrintStream);
        gui.pushInfo(null);

        Mockito.verify(mockPrintStream, Mockito.never()).println(Mockito.anyString());
    }

    @Test
    public void pushInfo_emptyParam_shouldPrint(){
        BufferedReader mockBufferedReader = Mockito.mock(BufferedReader.class);
        PrintStream mockPrintStream = Mockito.mock(PrintStream.class);

        BashGUI gui = new BashGUI(mockBufferedReader, mockPrintStream);
        gui.pushInfo("");

        Mockito.verify(mockPrintStream).print(BashGUI.ANSI_GREEN);
        Mockito.verify(mockPrintStream).println("");
    }

    @Test
    public void pushInfo_notEmptyParam_shouldPrint(){
        BufferedReader mockBufferedReader = Mockito.mock(BufferedReader.class);
        PrintStream mockPrintStream = Mockito.mock(PrintStream.class);

        BashGUI gui = new BashGUI(mockBufferedReader, mockPrintStream);
        gui.pushInfo("test");

        Mockito.verify(mockPrintStream).print(BashGUI.ANSI_GREEN);
        Mockito.verify(mockPrintStream).println("test");
    }

    @Test
    public void pushWarning_nullParam_shouldDoNothing(){
        BufferedReader mockBufferedReader = Mockito.mock(BufferedReader.class);
        PrintStream mockPrintStream = Mockito.mock(PrintStream.class);

        BashGUI gui = new BashGUI(mockBufferedReader, mockPrintStream);
        gui.pushWarning(null);

        Mockito.verify(mockPrintStream, Mockito.never()).println(Mockito.anyString());
    }

    @Test
    public void pushWarning_emptyParam_shouldPrint(){
        BufferedReader mockBufferedReader = Mockito.mock(BufferedReader.class);
        PrintStream mockPrintStream = Mockito.mock(PrintStream.class);

        BashGUI gui = new BashGUI(mockBufferedReader, mockPrintStream);
        gui.pushWarning("");

        Mockito.verify(mockPrintStream).print(BashGUI.ANSI_YELLOW);
        Mockito.verify(mockPrintStream).println("");
    }

    @Test
    public void pushWarning_notEmptyParam_shouldPrint(){
        BufferedReader mockBufferedReader = Mockito.mock(BufferedReader.class);
        PrintStream mockPrintStream = Mockito.mock(PrintStream.class);

        BashGUI gui = new BashGUI(mockBufferedReader, mockPrintStream);
        gui.pushWarning("test");

        Mockito.verify(mockPrintStream).print(BashGUI.ANSI_YELLOW);
        Mockito.verify(mockPrintStream).println("test");
    }

    @Test
    public void pushError_nullParam_shouldDoNothing(){
        BufferedReader mockBufferedReader = Mockito.mock(BufferedReader.class);
        PrintStream mockPrintStream = Mockito.mock(PrintStream.class);

        BashGUI gui = new BashGUI(mockBufferedReader, mockPrintStream);
        gui.pushError(null);

        Mockito.verify(mockPrintStream, Mockito.never()).println(Mockito.anyString());
    }

    @Test
    public void pushError_emptyParam_shouldPrint(){
        BufferedReader mockBufferedReader = Mockito.mock(BufferedReader.class);
        PrintStream mockPrintStream = Mockito.mock(PrintStream.class);

        BashGUI gui = new BashGUI(mockBufferedReader, mockPrintStream);
        gui.pushError("");

        Mockito.verify(mockPrintStream).print(BashGUI.ANSI_RED);
        Mockito.verify(mockPrintStream, Mockito.times(3)).println("");
    }

    @Test
    public void pushError_notEmptyParam_shouldPrint(){
        BufferedReader mockBufferedReader = Mockito.mock(BufferedReader.class);
        PrintStream mockPrintStream = Mockito.mock(PrintStream.class);

        BashGUI gui = new BashGUI(mockBufferedReader, mockPrintStream);
        gui.pushError("test");

        Mockito.verify(mockPrintStream).print(BashGUI.ANSI_RED);
        Mockito.verify(mockPrintStream, Mockito.times(2)).println("");
        Mockito.verify(mockPrintStream).println("test");
    }

    @Test
    public void pushHeader_nullParam_shouldDoNothing(){
        BufferedReader mockBufferedReader = Mockito.mock(BufferedReader.class);
        PrintStream mockPrintStream = Mockito.mock(PrintStream.class);

        BashGUI gui = new BashGUI(mockBufferedReader, mockPrintStream);
        gui.pushHeader(null);

        Mockito.verify(mockPrintStream, Mockito.never()).println(Mockito.anyString());
    }

    @Test
    public void pushHeader_emptyParam_shouldPrint(){
        BufferedReader mockBufferedReader = Mockito.mock(BufferedReader.class);
        PrintStream mockPrintStream = Mockito.mock(PrintStream.class);

        BashGUI gui = new BashGUI(mockBufferedReader, mockPrintStream);
        gui.pushHeader("");

        Mockito.verify(mockPrintStream).print(BashGUI.ANSI_GREEN);
        Mockito.verify(mockPrintStream, Mockito.times(2)).println(BashGUI.HEADER_VISUALISATION);
        Mockito.verify(mockPrintStream).println("");
    }

    @Test
    public void pushHeader_notEmptyParam_shouldPrint(){
        BufferedReader mockBufferedReader = Mockito.mock(BufferedReader.class);
        PrintStream mockPrintStream = Mockito.mock(PrintStream.class);

        BashGUI gui = new BashGUI(mockBufferedReader, mockPrintStream);
        gui.pushHeader("test");

        Mockito.verify(mockPrintStream).print(BashGUI.ANSI_GREEN);
        Mockito.verify(mockPrintStream, Mockito.times(2)).println(BashGUI.HEADER_VISUALISATION);
        Mockito.verify(mockPrintStream).println("test");
    }

    @Test
    public void pull_exception_shouldReturnEmptyString() throws Exception {
        BufferedReader mockBufferedReader = Mockito.mock(BufferedReader.class);
        Mockito.when(mockBufferedReader.readLine()).thenThrow(IOException.class);
        PrintStream mockPrintStream = Mockito.mock(PrintStream.class);

        BashGUI gui = new BashGUI(mockBufferedReader, mockPrintStream);
        Assert.assertEquals("", gui.pull());
    }

    @Test
    public void pull_validInput_shouldReturnLine() throws Exception {
        BufferedReader mockBufferedReader = Mockito.mock(BufferedReader.class);
        Mockito.when(mockBufferedReader.readLine()).thenReturn("test");
        PrintStream mockPrintStream = Mockito.mock(PrintStream.class);

        BashGUI gui = new BashGUI(mockBufferedReader, mockPrintStream);
        Assert.assertEquals("test", gui.pull());
    }

}
