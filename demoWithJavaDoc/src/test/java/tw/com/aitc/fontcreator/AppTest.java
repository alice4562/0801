package tw.com.aitc.fontcreator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.FileInputStream;
import java.io.IOException;

import org.junit.jupiter.api.Test;

import tw.com.aitc.fontcreator.convertor.ImageConvertor;
import tw.com.aitc.fontcreator.exception.ImageConvertorException;
import tw.com.aitc.fontcreator.exception.ParametersException;
import tw.com.aitc.fontcreator.setting.Parameters;

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
    public void testParametersNull(){
        try {
            new Parameters(null);
        } catch (ParametersException e) {
            assertEquals("There should be at latest 2 parameters", e.getMessage());
        }
    }

    @Test
    public void testParametersEmpty(){
        try {
            new Parameters(new String[0]);
        } catch (ParametersException e) {
            assertEquals("There should be at latest 2 parameters", e.getMessage());
        }
    }

    @Test
    public void testParametersLessThanTwo(){
        try {
            new Parameters(new String[]{"/tmp//test/test"});
        } catch (ParametersException e) {
            assertEquals("There should be at latest 2 parameters", e.getMessage());
        }
    }

    @Test
    public void testParametersWithoutSubName(){
        try {
            new Parameters(new String[]{"/tmp/test/test", "/tmp//test/test"});
        } catch (ParametersException e) {
            assertEquals("Couldn't find format name", e.getMessage());
        }
    }

    @Test
    public void testParametersGetSetCorrect(){
        try {
            Parameters para = new Parameters(new String[]{"/tmp/test/in", "/tmp/test/out", "bmp"});
            assertEquals("/tmp/test/in", para.getInputImagePath());
            assertEquals("/tmp/test/out", para.getOutputImagePath());
            assertEquals("bmp", para.getFormatName());
        } catch (ParametersException e) {
            assertEquals("Should not be here", e.getMessage());
        }
    }

    @Test
    public void testParametersTwoParametersGetSetCorrect(){
        try {
            Parameters para = new Parameters(new String[]{"/tmp/test/in", "/tmp/test/out.bmp"});
            assertEquals("/tmp/test/in", para.getInputImagePath());
            assertEquals("/tmp/test/out.bmp", para.getOutputImagePath());
            assertEquals("bmp", para.getFormatName());
        } catch (ParametersException e) {
            assertEquals("Should not be here", e.getMessage());
        }
    }

    @Test
    public void testImageConvertorNull(){
        try {
            new ImageConvertor(null);
        } catch (ImageConvertorException e) {
            assertEquals("parameters should not be null", e.getMessage());
        }
    }

    @Test
    public void testImageConvertorInputFileNotFound(){
        try {
            new ImageConvertor(new Parameters(new String[]{"/tmp/test/in", "/tmp/test/out.bmp"}));
        } catch (ImageConvertorException e) {
            assertTrue(e.getMessage().startsWith("Open or write file failed!!!"));
        } catch (ParametersException e) {
            assertEquals("Should not be here", e.getMessage());
        }
    }

    @Test
    public void testImageConvertorOutputFileFail(){
        try {
            ClassLoader cl = AppTest.class.getClassLoader();
            new ImageConvertor(new Parameters(new String[]{cl.getResource("logo-red.png").getPath(), "/out.bmp"}));
        } catch (ImageConvertorException e) {
            assertTrue(e.getMessage().startsWith("Open or write file failed!!!"));
        } catch (ParametersException e) {
            assertEquals("Should not be here", e.getMessage());
        }
    }

    @Test
    public void testImageConvertorSuccToBmp(){
        try {
            ClassLoader cl = AppTest.class.getClassLoader();
            String inputFile = cl.getResource("logo-red.png").getPath();
            String outputFile = inputFile.replace("png", "bmp");
            new ImageConvertor(new Parameters(new String[]{inputFile, outputFile})).convertor();
            try(FileInputStream input = new FileInputStream(outputFile)){
                byte[] checkIt = new byte[2];
                input.read(checkIt);
                assertEquals("BM", new String(checkIt));
            }catch(IOException e){
                assertEquals("Should not be here", e.getMessage());
            }
        } catch (ImageConvertorException e) {
            assertEquals("Should not be here", e.getMessage());
        } catch (ParametersException e) {
            assertEquals("Should not be here", e.getMessage());
        }
    }
}
