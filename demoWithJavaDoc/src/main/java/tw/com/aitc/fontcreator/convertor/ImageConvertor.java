package tw.com.aitc.fontcreator.convertor;

import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import tw.com.aitc.fontcreator.exception.ImageConvertorException;
import tw.com.aitc.fontcreator.setting.Parameters;

/**
 * @author Hanhsuan
 * {@summary} 使用javax.imageio.ImageIO進行圖片格式轉換
 */
public class ImageConvertor {
    private Parameters para = null;

    /**
     * 
     * @param para 設定有輸入、輸出及輸出檔案格式之 Parameters 物件
     * @throws ImageConvertorException
     */
    public ImageConvertor(Parameters para) throws ImageConvertorException{
        if(para == null) throw new ImageConvertorException("parameters should not be null");
        this.para = para;
    }

    /**
     * {@summary} 執行圖片檔案格式轉換
     * @return 轉換成功為 ture
     * @throws ImageConvertorException
     */
    public boolean convertor() throws ImageConvertorException{
        try(FileInputStream inputStream = new FileInputStream(para.getInputImagePath());
            FileOutputStream outputStream = new FileOutputStream(para.getOutputImagePath())){
            BufferedImage inputImage = ImageIO.read(inputStream);
            int w = inputImage.getWidth();
            int h = inputImage.getHeight();
            int[] pixels = new int[w * h];
            inputImage.getRGB(0, 0, w, h, pixels, 0, w);
            BufferedImage cleanedInputImage = new BufferedImage(w, h, BufferedImage.TYPE_3BYTE_BGR);
            cleanedInputImage.setRGB(0, 0, w, h, pixels, 0, w);
            return ImageIO.write(cleanedInputImage, para.getFormatName(), outputStream);
        }catch(IOException e){
            throw new ImageConvertorException("Open or write file failed!!! [" + e.getMessage() + "]");
        }
    }
}
