package rps.gui;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;
import org.testng.Assert;

@RunWith(PowerMockRunner.class)
@PrepareForTest(GUIFactory.Type.class)
public class GUIFactoryTest {

    @Test
    public void types_shouldBeDefinedOne(){
        Assert.assertEquals(1, GUIFactory.Type.values().length);
    }

    @Test(expected = IllegalArgumentException.class)
    public void produce_nullInput_shouldThrownAnException(){
        GUIFactory.produce(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void produce_notExistingType_shouldThrownAnException(){
        GUIFactory.Type mockType = PowerMockito.mock(GUIFactory.Type.class);
        Whitebox.setInternalState(mockType, "name", "NON_EXISTING_ENUM");
        Whitebox.setInternalState(mockType, "ordinal", 1);
        PowerMockito.mockStatic(GUIFactory.Type.class);
        PowerMockito.when(GUIFactory.Type.values()).thenReturn(new GUIFactory.Type[]{GUIFactory.Type.BASH, mockType});
        GUIFactory.produce(mockType);
    }

    @Test
    public void produce_bashType_shouldReturnBashGUI(){
        Assert.assertTrue(GUIFactory.produce(GUIFactory.Type.BASH) instanceof BashGUI);
    }
}
