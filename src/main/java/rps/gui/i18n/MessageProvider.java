package rps.gui.i18n;

public interface MessageProvider {

    public String getMessage(String code, Object... params);

    public String getMessage(String code);

}
