package rps.utils;

import org.junit.Assert;
import org.junit.Test;

public class StringUtilsTest {

    @Test
    public void replaceString_nullInput_shouldReturnEmptyString(){
        Assert.assertEquals(StringUtils.EMPTY_STRING, StringUtils.replaceString(null));
    }

    @Test
    public void replaceString_emptyStringInput_shouldReturnEmptyString(){
        Assert.assertEquals(StringUtils.EMPTY_STRING, StringUtils.replaceString(StringUtils.EMPTY_STRING));
    }

    @Test
    public void replaceString_noParams_shouldReturnInput(){
        Assert.assertEquals("test", StringUtils.replaceString("test"));
    }

    @Test
    public void replaceString_paramsExistsButNoPlaceholderInInput_shouldReturnInput(){
        Assert.assertEquals("test", StringUtils.replaceString("test", "replacement"));
    }

    @Test
    public void replaceString_paramsExistsAndPlaceholderInInputButWrongIndex_shouldReturnInput(){
        Assert.assertEquals("test {1}", StringUtils.replaceString("test {1}", "replacement"));
    }

    @Test
    public void replaceString_paramsExistsAndPlaceholderInInput_shouldReturnInput(){
        Assert.assertEquals("test replacement", StringUtils.replaceString("test {0}", "replacement"));
    }
}
