package aitc.p;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.IOException;

import org.junit.Test;

import aitc.p.ImageConvertor;
import aitc.p.Para;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }
    
    @Test
    public void testParaNull() {
    	try {
            new Para(null);
        } catch (Exception e) {
            assertEquals("There should be at latest 2 parameters", e.getMessage());
        }
    	
    }
    
    @Test
    public void testParaEmpty() {
    	try {
            new Para(new String[0]);
        } catch (Exception e) {
            assertEquals("There should be at latest 2 parameters", e.getMessage());
        }
    }
    
    @Test
    public void testParaLessThanTwo() {
    	try {
            new Para(new String[]{"/tmp//test/test"});
        } catch (Exception e) {
            assertEquals("There should be at latest 2 parameters", e.getMessage());
        }
    }
    
    @Test
    public void testParaWithoutSubName() {
    	  try {
              new Para(new String[]{"/tmp/test/test", "/tmp//test/test"});
          } catch (Exception e) {
              assertEquals("Couldn't find format name", e.getMessage());
          }
    }
    
   /* @Test
    public void testParaGetSetCorrect() {
    	try {
            Para para = new Para(new String[]{"/tmp/test/in", "/tmp/test/out", "bmp"});
            assertEquals("/tmp/test/in", para.getinputImagePath());
            assertEquals("/tmp/test/out", para.getoututImagePath());
            assertEquals("bmp", para.getformatName());
        } catch (Exception e) {
            assertEquals("Should not be here", e.getMessage());
        }
    }*/
    
    @Test
    public void testParaTwoParaGetSetCorrect() {
    	try {
            Para para = new Para(new String[]{"/tmp/test/in", "/tmp/test/out.bmp"});
            assertEquals("/tmp/test/in", para.getinputImagePath());
            assertEquals("/tmp/test/out.bmp", para.getoututImagePath());
            assertEquals("bmp", para.getformatName());
        } catch (Exception e) {
            assertEquals("Should not be here", e.getMessage());
        }
    }
    
    @Test
    public void testImageConvertorNull() {
    	try {
            new ImageConvertor(null);
        } catch (Exception e) {
            assertEquals("parameters should not be null", e.getMessage());
        }
    }
    
    @Test
    public void testImageConvertorInputFileNotFound() {
    	try {
            new ImageConvertor(new Para(new String[]{"/tmp/test/in", "/tmp/test/out.bmp"}));
        } catch (Exception e) {
            assertTrue(e.getMessage().startsWith("Open or write file failed!!!"));
            assertEquals("Should not be here", e.getMessage());
        }
    	
    }
    @Test
    public void testImageConvertorOutputFileFail(){
        try {
            ClassLoader cl = AppTest.class.getClassLoader();
            new ImageConvertor(new Para(new String[]{cl.getResource("logo-red.png").getPath(), "/out.bmp"}));
        } catch (Exception e) {
            assertTrue(e.getMessage().startsWith("Open or write file failed!!!"));
            assertEquals("Should not be here", e.getMessage());
        }
    }

    @Test
    public void testImageConvertorSuccToBmp(){
        try {
            ClassLoader cl = AppTest.class.getClassLoader();
            String inputFile = cl.getResource("logo-red.png").getPath();
            String outputFile = inputFile.replace("png", "bmp");
            new ImageConvertor(new Para(new String[]{inputFile, outputFile})).getconvertor();
            try(FileInputStream input = new FileInputStream(outputFile)){
                byte[] checkIt = new byte[2];
                input.read(checkIt);
                assertEquals("BM", new String(checkIt));
            }catch(IOException e){
                assertEquals("Should not be here", e.getMessage());
            }
        } catch (Exception e) {
            assertEquals("Should not be here", e.getMessage());
        }
    }


}
