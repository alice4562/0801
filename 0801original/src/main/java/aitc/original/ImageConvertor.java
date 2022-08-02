package aitc.original;

import java.util.logging.Logger;//導入方法依賴的package包/類
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileInputStream;
/**
 * @author Azure
 *{@summary}圖片格式轉換
 */
class ImageConvertor{
	private static Logger LOG = Logger.getLogger("ImageConvertor");
	private Para a;
	
	/**
	 * @param newa 類別para的物件
	 */
	public ImageConvertor(Para a){
		if(a==null) {//para參數是空的
			LOG.info("Parameters should not be null");//輸出
		}
		this.a = a;
	}
	
	/**
	 * {@summary}執行圖片格式轉換
	 * @return 轉換成功=true，轉換失敗=false
	 */
	public boolean convertor(){
		try(FileInputStream inputStream = new FileInputStream(a.getinputImagePath());//讀取的輸入檔案
	        FileOutputStream outputStream = new FileOutputStream(a.getoututImagePath()))//讀取的輸出檔案
			{
				BufferedImage inputImage = ImageIO.read(inputStream);//建立圖片Buffered物件
				int w = inputImage.getWidth();//要輸出的寬度
				int h = inputImage.getHeight();//要輸出的高度
				int []pixels = new int [w*h];//像素
				inputImage.getRGB(0, 0, w, h, pixels, 0, w);//三色
	            BufferedImage cleanedInputImage = new BufferedImage(w, h, BufferedImage.TYPE_3BYTE_BGR);//建立空白buffered物件
	            cleanedInputImage.setRGB(0, 0, w, h, pixels, 0, w);
	            return ImageIO.write(cleanedInputImage, a.getformatName(), outputStream);//輸出圖片
				
			}
			catch(IOException e){//(例外處理的變數)
	           LOG.info("Open or write file failed!!!");//發生時如何處理
	           return false;
			}
	}
	
}
