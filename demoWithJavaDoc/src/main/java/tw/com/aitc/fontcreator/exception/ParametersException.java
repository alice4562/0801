package tw.com.aitc.fontcreator.exception;

/**
 * @author Hanhsuan
 * {@summary} Parameters 物件使用之 Exception
 */
public class ParametersException extends Exception{
    public ParametersException(String s) {
        super(s);
    }

    /**
     * 
     * @param s 要輸出之字串
     * @param throwable 可拋出之 Exception
     */
    public ParametersException(String s, Throwable throwable) {
            super(s, throwable);
    }

    /**
     * @return Exception 要輸出之訊息
     */
    @Override
    public String getMessage() {
            String msg = super.getMessage();
            if (getCause() != null) {
                    msg = msg + ">> "
                              + (getCause() instanceof ParametersException ? "" : getCause().getClass().getName() + ": ")
                              + getCause().getMessage();
            }
            return msg;
    }
}
