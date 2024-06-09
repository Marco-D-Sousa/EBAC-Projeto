package ebac.exception;

public class TipoChaveNotFound extends Exception{

    private static final long serialVersionUID = -1389494676398525746L;

    public TipoChaveNotFound(String msg) {
        this(msg, null);
    }

    public TipoChaveNotFound(String msg, Throwable e) {
        super(msg, e);
    }
}
