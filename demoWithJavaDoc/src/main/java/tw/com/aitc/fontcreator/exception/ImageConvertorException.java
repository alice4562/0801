package tw.com.aitc.fontcreator.exception;

/**
 * @author Hanhsuan
 * {@summary} ImageConvertor 物件使用之 Exception
 */
public class ImageConvertorException extends Exception{
    public ImageConvertorException(String s) {
        super(s);
    }

    /**
     * 
     * @param s 要輸出之字串
     * @param throwable 可拋出之 Exception
     */
    public ImageConvertorException(String s, Throwable throwable) {
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
                              + (getCause() instanceof ImageConvertorException ? "" : getCause().getClass().getName() + ": ")
                              + getCause().getMessage();
            }
            return msg;
    }
}
