package rps.game.engine;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;
import org.testng.Assert;
import rps.gui.GUI;
import rps.gui.i18n.MessageProvider;

@RunWith(PowerMockRunner.class)
@PrepareForTest(MatchType.class)
public class MatchFactoryTest {

    @Test(expected = IllegalArgumentException.class)
    public void produce_notExistingType_shouldThrownAnException(){
        GUI mockGUI = Mockito.mock(GUI.class);
        MessageProvider mockMessageProvider = Mockito.mock(MessageProvider.class);

        MatchType mockType = PowerMockito.mock(MatchType.class);
        Whitebox.setInternalState(mockType, "name", "NON_EXISTING_ENUM");
        Whitebox.setInternalState(mockType, "ordinal", 3);
        PowerMockito.mockStatic(MatchType.class);
        PowerMockito.when(MatchType.values()).thenReturn(new MatchType[]{
            MatchType.COMPUTER_VS_COMPUTER,
            MatchType.HUMAN_VS_COMPUTER,
            MatchType.HUMAN_VS_HUMAN,
            mockType
        });

        MatchFactory.produce(mockType, mockGUI, mockMessageProvider);
    }

    @Test
    public void types_shouldBeDefinedTwo(){
        Assert.assertEquals(3, MatchType.values().length);
    }

    @Test(expected = IllegalArgumentException.class)
    public void produce_nullInput_shouldThrownAnException(){
        GUI mockGUI = Mockito.mock(GUI.class);
        MessageProvider mockMessageProvider = Mockito.mock(MessageProvider.class);
        MatchFactory.produce(null, mockGUI, mockMessageProvider);
    }

    @Test
    public void produce_compVsComp_shouldReturnMatchComputerVsComputer(){
        GUI mockGUI = Mockito.mock(GUI.class);
        MessageProvider mockMessageProvider = Mockito.mock(MessageProvider.class);
        Assert.assertTrue(MatchFactory.produce(MatchType.COMPUTER_VS_COMPUTER, mockGUI, mockMessageProvider) instanceof MatchComputerVsComputer);
    }

    @Test
    public void produce_humanVsComp_shouldReturnMatchHumanVsComputer(){
        GUI mockGUI = Mockito.mock(GUI.class);
        MessageProvider mockMessageProvider = Mockito.mock(MessageProvider.class);
        Assert.assertTrue(MatchFactory.produce(MatchType.HUMAN_VS_COMPUTER, mockGUI, mockMessageProvider) instanceof MatchHumanVsComputer);
    }

    @Test
    public void produce_humanVsHuman_shouldReturnMatchHumanVsHuman(){
        GUI mockGUI = Mockito.mock(GUI.class);
        MessageProvider mockMessageProvider = Mockito.mock(MessageProvider.class);
        Assert.assertTrue(MatchFactory.produce(MatchType.HUMAN_VS_HUMAN, mockGUI, mockMessageProvider) instanceof MatchHumanVsHuman);
    }

}
