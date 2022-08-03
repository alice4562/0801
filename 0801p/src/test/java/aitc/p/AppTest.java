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
    
  /* @Test
    public void testParaNull() {
    	Para t = new Para(null);
		assertEquals("Usage: java -jar fontCreator*.jar [input file] [output file]",t.getMessage());
    	
    }*/
    
    @Test
    public void testParaEmpty() {
    	Para t = new Para(new String[0]);
    	assertEquals("Usage: java -jar fontCreator*.jar [input file] [output file]",t.getMessage());
    }
    
    @Test
    public void testParaLessThanTwo() {
    	Para t = new Para(new String[] {"/tmp//test/test"});
    	assertEquals("Usage: java -jar fontCreator*.jar [input file] [output file]",t.getMessage());
    }
    
    @Test
    public void testParaWithoutSubName() {
    	Para t = new Para(new String[] {"/tmp/test/test","tmp/test/test"});
    	assertEquals("Couldn't find format name",t.getMessage());
    }
    
    @Test
    public void testParaGetSetCorrect() {
    	Para t= new Para(new String[] {"/tmp/test/in","/tmp/test/out","bmp"});
    	if(t == new Para(new String[] {"/tmp/test/in","/tmp/test/out","bmp"})) {
    		assertEquals("/tmp/test/in",t.getinputImagePath());
			assertEquals("/tmp/test/out",t.getoututImagePath());
			assertEquals("bmp",t.getformatName());
    	}
    	else {
    		assertEquals("Should not be here",t.getMessage());
    	}
    }
    
    @Test
    public void testParaTwoParaGetSetCorrect() {
    	Para t = new Para(new String[] {"/tmp/test/in","/tmp/test/out.bmp"});
    	if(t ==  new Para(new String[] {"/tmp/test/in","/tmp/test/out.bmp"})) {
    		assertEquals("/tmp/test/in",t.getinputImagePath());
    		assertEquals("/tmp/test/out.bmp",t.getoututImagePath());
    		assertEquals("bmp",t.getformatName());
    	}
    	else {
    		assertEquals("Should not be here",t.getMessage());
    	}
    }
    
    @Test
    public void testImageConvertorNull() {
    	ImageConvertor t = new ImageConvertor(null);
    	assertEquals("Parameters should not be null",t.getMessage());
    }
    
    @Test
    public void testImageConvertorInputFileNotFound() {
    	ImageConvertor t = new ImageConvertor(new Para(new String[] {"/tmp/test/in","/tmp/test/out.bmp"}));
    	if(t != new ImageConvertor(new Para(new String[] {"/tmp/test/in","/tmp/test/out.bmp"}))) {
    		assertTrue(t.getMessage().startsWith("Open o write file failed"));
    		assertEquals("Should not be here",t.getMessage());
    	}
    	
    }
    
    @Test
    public void testImageConvrotrOUtputFileFail() {
    	
    }
    
    @Test
    public void testImageConvertorSuccToBmp() {
    	
    }


}
