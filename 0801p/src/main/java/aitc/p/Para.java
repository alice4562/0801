package aitc.p;

import java.util.logging.Logger;
/**
 * @author Azure
 */

public class Para extends Exception{
	
	private static Logger LOG = Logger.getLogger("Para");
	
	private String inputImagePath;
	private String oututImagePath;
	private String formatName;
	
	/**
	 * @param args 取得參數陣列
	 */
	public Para() {
		
	}
	public Para(String []args){
		if(args.length!=2||args==null) {//輸入陣列長度不是2
			LOG.info("There should be at latest 2 parameters");
			LOG.info("Usage: java -jar fontCreator*.jar [input file] [output file]");//輸出
		}
		else {//輸入陣列長度=2
			inputImagePath = args[0];
			oututImagePath = args[1];
			if(args[1].contains(".")) {//如果陣列2含"."
				String a[] = args[1].split("\\.");//將要輸出檔名拆分成兩個
				formatName = a[1];
			}
			else {
				LOG.info("Couldn't find format name");
			}
		}
		
	}
	/**
	 * {@summary}設定被轉換的檔案名稱
	 * @return 被轉換的檔案名稱
	 */
	public String getinputImagePath() {//回傳inputImagePath
		return inputImagePath;
	}
	/**
	 * {@summary}設定被轉出的檔案名稱
	 * @return 被轉出的檔案名稱
	 */
	public String getoututImagePath() {//回傳outputImagePath
		return oututImagePath;
	}
	/**
	 * {@summary}設定被轉出檔案的檔案格式
	 * @return 被轉出檔案的檔案格式
	 */
	public String getformatName() {//回傳formatName
		return formatName;
	}
	
	/**
	 * {@summary}設定被轉換的檔案名稱
	 * @param newinputImagePath被轉換的檔案名稱
	 */
	public void setinputImagePath(String newinputImagePath) {//儲存inputImagePath
		inputImagePath = newinputImagePath;
	}
	/**
	 * {@summary}}設定被轉出的檔案名稱
	 * @param newinputImagePath}被轉出的檔案名稱
	 */
	public void setoututImagePath(String newoutputImagePath) {//儲存outputImagePath
		oututImagePath = newoutputImagePath;
	}
	/**
	 * {@summary}}設定被轉出檔案的檔案格式
	 * @param newinputImagePath}被轉出檔案的檔案格式
	 */
	public void setformatName(String newformatName) {//儲存formatName
		formatName = newformatName;
	}
	
}
