package aitc.p;//圖片讀取

import java.io.IOException;
import java.util.logging.Logger;//導入方法依賴的package包/類

/**
 * 
 * @author Azure
 *
 */

public class App 
{
    private static Logger LOG = Logger.getLogger("App");
	
	public static void main( String[] args ) throws IOException
    {
		Para p = new Para(args);
		ImageConvertor newp = new ImageConvertor(p);
		newp.getconvertor();
		LOG.info(newp.getimage()?"convert success.":"convert failed.");
		
		
    }
}
