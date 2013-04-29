package rps.gui.i18n;

import org.junit.Before;
import org.junit.Test;
import org.testng.Assert;
import rps.utils.StringUtils;

public class SimpleMessageProviderTest {

    SimpleMessageProvider messageProvider;

    @Before
    public void setUp() throws Exception {
        messageProvider = new SimpleMessageProvider();
    }

    @Test
    public void getMessageWithoutArgs_nullParam_shouldReturnEmptyString(){
        Assert.assertEquals(StringUtils.EMPTY_STRING, messageProvider.getMessage(null));
    }

    @Test
    public void getMessageWithoutArgs_emptyStringParam_shouldReturnEmptyString(){
        Assert.assertEquals(StringUtils.EMPTY_STRING, messageProvider.getMessage(StringUtils.EMPTY_STRING));
    }

    @Test
    public void getMessageWithoutArgs_nonExistingKey_shouldReturnKey(){
        Assert.assertEquals("evil.message.key", messageProvider.getMessage("evil.message.key"));
    }

    @Test
    public void getMessageWithoutArgs_validKey_shouldReturnMessage(){
        String message = messageProvider.getMessage("evil.message.key");
        Assert.assertNotNull(message);
        Assert.assertNotEquals(StringUtils.EMPTY_STRING, message);
        Assert.assertTrue(message.length() > 0);
    }

    @Test
    public void getMessageWithArgs_nullParam_shouldReturnEmptyString(){
        Assert.assertEquals(StringUtils.EMPTY_STRING, messageProvider.getMessage(null, "replacement"));
    }

    @Test
    public void getMessageWithArgs_emptyStringParam_shouldReturnEmptyString(){
        Assert.assertEquals(StringUtils.EMPTY_STRING, messageProvider.getMessage(StringUtils.EMPTY_STRING, "replacement"));
    }

    @Test
    public void getMessageWithArgs_nonExistingKey_shouldReturnKey(){
        Assert.assertEquals("evil.message.key", messageProvider.getMessage("evil.message.key", "replacement"));
    }

    @Test
    public void getMessageWithArgs_validKey_shouldReturnMessage(){
        String message = messageProvider.getMessage("evil.message.key", "replacement");
        Assert.assertNotNull(message);
        Assert.assertNotEquals(StringUtils.EMPTY_STRING, message);
        Assert.assertTrue(message.length() > 0);
    }

    @Test
    public void getMessageWithArgs_testReplacement_shouldReplace(){
        String message = messageProvider.getMessage("game.matchTypeDesc.HUMAN_VS_HUMAN", "replacement");
        Assert.assertEquals("replacement - player vs player", message);
    }
}
