package aitc.original;//圖片讀取

import java.util.logging.Logger;//導入方法依賴的package包/類

/**
 * @author Azure
 */

public class App 
{
    private static Logger LOG = Logger.getLogger("App");
	
	public static void main( String[] args )
    {
		Para p = new Para(args);
		LOG.info(new ImageConvertor(p).convertor()?"convert success":"convert failed");
		
		
    }
}
