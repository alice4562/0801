package tw.com.aitc.fontcreator.setting;

import tw.com.aitc.fontcreator.exception.ParametersException;

/**
 * @author Hanhsuan
 * {@summary}對從 command line 輸入之參數進行處理
 */
public class Parameters {
    
    private String inputImagePath = "";
    private String outputImagePath = "";
    private String formatName = "";

    /**
     * @param args main 函式從 command line 所取得之參數陣列
     * @throws ParametersException
    */
    public Parameters(String[] args) throws ParametersException{
        if(args == null || args.length < 2){
            throw new ParametersException("There should be at latest 2 parameters");
        }
        this.inputImagePath = args[0];
        this.outputImagePath = args[1];
        if(args[1].contains(".")){
            this.formatName = (args.length < 3) ? args[1].split("\\.")[1] : args[2];
        }else if(!args[1].contains(".") && args.length == 3){
            this.formatName = args[2];
        }else{
            throw new ParametersException("Couldn't find format name");
        }
    }

    /**
     * {@summary} 設定待轉換之檔案名稱
     * @param inputImagePath 待轉換之檔案名稱
     */
    public void setInputImagePath(String inputImagePath) {
        this.inputImagePath = inputImagePath;
    }

    /**
     * {@summary} 設定轉出之檔案名稱
     * @param oututImagePath 轉出之檔案名稱
     */
    public void setOutputImagePath(String oututImagePath) {
        this.outputImagePath = oututImagePath;
    }

    /**
     * {@summary} 設定轉出檔案之檔案格式
     * @param formatName 轉出檔案之檔案格式
     */
    public void setFormatName(String formatName) {
        this.formatName = formatName;
    }

    /**
     * {@summary} 取得待轉換之檔案名稱
     * @return 待轉換之檔案名稱
     */
    public String getInputImagePath() {
        return inputImagePath;
    }

    /**
     * {@summary} 取得轉出之檔案名稱
     * @return 轉出之檔案名稱
     */
    public String getOutputImagePath() {
        return outputImagePath;
    }

    /**
     * {@summary} 取得轉出檔案之檔案格式
     * @return 轉出檔案之檔案格式
     */
    public String getFormatName() {
        return formatName;
    }
    
}
