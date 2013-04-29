package rps.gui.i18n;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;
import org.testng.Assert;

@RunWith(PowerMockRunner.class)
@PrepareForTest(MessageProviderFactory.Type.class)
public class MessageProviderFactoryTest {

    @Test
    public void types_shouldBeDefinedOne(){
        Assert.assertEquals(1, MessageProviderFactory.Type.values().length);
    }

    @Test(expected = IllegalArgumentException.class)
    public void produce_nullInput_shouldThrownAnException(){
        MessageProviderFactory.produce(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void produce_notExistingType_shouldThrownAnException(){
        MessageProviderFactory.Type mockType = PowerMockito.mock(MessageProviderFactory.Type.class);
        Whitebox.setInternalState(mockType, "name", "NON_EXISTING_ENUM");
        Whitebox.setInternalState(mockType, "ordinal", 1);
        PowerMockito.mockStatic(MessageProviderFactory.Type.class);
        PowerMockito.when(MessageProviderFactory.Type.values()).thenReturn(new MessageProviderFactory.Type[]{MessageProviderFactory.Type.SIMPLE, mockType});
        MessageProviderFactory.produce(mockType);
    }

    @Test
    public void produce_simpleType_shouldReturnBashGUI(){
        Assert.assertTrue(MessageProviderFactory.produce(MessageProviderFactory.Type.SIMPLE) instanceof SimpleMessageProvider);
    }

}
