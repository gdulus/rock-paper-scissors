package rps.game.player;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;
import org.testng.Assert;

@RunWith(PowerMockRunner.class)
@PrepareForTest(PlayerFactory.Type.class)
public class PlayerFactoryTest {

    @Test
    public void types_shouldBeDefinedTwo(){
        Assert.assertEquals(2, PlayerFactory.Type.values().length);
    }

    @Test(expected = IllegalArgumentException.class)
    public void produce_nullInput_shouldThrownAnException(){
        PlayerFactory.produce(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void produce_notExistingType_shouldThrownAnException(){
        PlayerFactory.Type mockType = PowerMockito.mock(PlayerFactory.Type.class);
        Whitebox.setInternalState(mockType, "name", "NON_EXISTING_ENUM");
        Whitebox.setInternalState(mockType, "ordinal", 2);
        PowerMockito.mockStatic(PlayerFactory.Type.class);
        PowerMockito.when(PlayerFactory.Type.values()).thenReturn(new PlayerFactory.Type[]{PlayerFactory.Type.COMPUTER, PlayerFactory.Type.HUMAN, mockType});
        PlayerFactory.produce(mockType);
    }

    @Test
    public void produce_humanType_shouldReturnHumanPlayer(){
        Assert.assertTrue(PlayerFactory.produce(PlayerFactory.Type.HUMAN) instanceof HumanPlayer);
    }

    @Test
    public void produce_computerType_shouldReturnComputerPlayer(){
        Assert.assertTrue(PlayerFactory.produce(PlayerFactory.Type.COMPUTER) instanceof ComputerPlayer);
    }
}
