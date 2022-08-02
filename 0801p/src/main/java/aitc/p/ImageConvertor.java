package aitc.p;

import java.util.logging.Logger;//導入方法依賴的package包/類
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.File;
/**
 * @author Azure
 *{@summary}圖片格式轉換
 */
class ImageConvertor{
	private static Logger LOG = Logger.getLogger("ImageConvertor");
	
	private Para a;
	private File ainputstream,aoutputstream;
	private BufferedImage inputimage,cleanedinputimage;
	
	/**
	 * @param newa 類別para的物件
	 */
	public ImageConvertor(Para newa){
		if(newa==null) {//para參數是空的
			LOG.info("Parameters should not be null");//輸出
		}
		a = newa;
	}
	
	/**
	 * {@summary}設定讀取的輸入檔案
	 * @return 讀取的輸入檔案
	 */
	public File getinputStream() {
		ainputstream = new File(a.getinputImagePath());//讀取的輸入檔案
		return ainputstream;
	}
	/**
	 * {@summary}設定讀取的輸入檔案
	 * @param newainputstream 讀取的輸入檔案
	 */
	public void setinputStream(File newainputstream) {
		ainputstream = newainputstream;
	}
	/**
	 * {@summary}設定讀取的輸出檔案
	 * @return 讀取的輸出檔案
	 */
	public File getoutputstream() {
		aoutputstream = new File(a.getoututImagePath());//讀取的輸出檔案
		return aoutputstream;
	}
	/**
	 * {@summary}設定讀取的輸出檔案
	 * @param newaoutputstream 讀取的輸出檔案
	 */
	public void setoutputStream(File newaoutputstream) {
		aoutputstream = newaoutputstream;
	}
	
	/**
	 * {@summary}執行圖片格式轉換
	 * @return 轉換後的圖片
	 * @throws IOException
	 */
	public BufferedImage getconvertor() throws IOException {
		inputimage = ImageIO.read(getinputStream());//建立圖片Buffered物件
		int w = inputimage.getWidth();//要輸出的寬度
		int h = inputimage.getHeight();//要輸出的高度
		int []pixels = new int[w*h];//像素
		inputimage.getRGB(0,0,w,h,pixels,0,w);//三色
		cleanedinputimage = new BufferedImage(w,h,BufferedImage.TYPE_3BYTE_BGR);//建立空白buffered物件
		cleanedinputimage.setRGB(0, 0, w,h,pixels,0,w);
		ImageIO.write(cleanedinputimage,a.getformatName(),getoutputstream());//輸出圖片
		return cleanedinputimage;
	}
	/**
	 * {@summary}確認轉換成敗
	 * @return 轉換成功=true，轉換失敗=false
	 * @throws IOException
	 */
	public boolean getimage() throws IOException  {
		if(getconvertor()!=null) {
			return true;
		}
		else {
			LOG.info("Open or write file failed!!!");//發生時如何處理
	        return false;
		}
	}
	
}
