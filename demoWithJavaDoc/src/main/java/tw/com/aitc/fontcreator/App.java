package tw.com.aitc.fontcreator;

import java.util.logging.Logger;

import tw.com.aitc.fontcreator.convertor.ImageConvertor;
import tw.com.aitc.fontcreator.exception.ImageConvertorException;
import tw.com.aitc.fontcreator.exception.ParametersException;
import tw.com.aitc.fontcreator.setting.Parameters;

/**
 * @author Hanhsuan
 * {@summary}簡易圖片檔案格式範例
*/
public class App 
{
    private static Logger LOG = Logger.getLogger("App");
    public static void main( String[] args )
    {
        try{
            LOG.info(new ImageConvertor(new Parameters(args)).convertor() ? "convert success!!!" : "convert failed!!!");
        }catch(ParametersException e){
            LOG.severe("Process Error:[" + e.getMessage() + "]");
            LOG.severe("Usage: java -jar fontCreator*.jar [input file] [output file] [format]\n or java -jar fontCreator*.jar [input file] [output file end with format]");
        }catch(ImageConvertorException e){
            LOG.severe("Open or write file failed!!! [" + e.getMessage() + "]");
        }
    }
}
