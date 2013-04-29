package rps.utils;

/**
 * Normally i would use apache library
 * Bur requirement was to use ext. libraries only for tests
 */
public final class StringUtils {

    public static final String EMPTY_STRING = "";

    private StringUtils() {
    }

    public static String replaceString(final String input, final Object...params){
        if (input == null || input.isEmpty()){
            return EMPTY_STRING;
        }

        if (params == null || params.length == 0){
            return input;
        }

        String result = input;

        for(int index = 0; index < params.length; index++){
            result = result.replace("{" + index + "}", params[index].toString());
        }

        return result;
    }
}
