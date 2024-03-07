package Utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Helper {
    public static void CaptureScreenshot(WebDriver driver, String screenshotname) {

        Path destination = Paths.get("./screenshots", screenshotname + ".png");
        try {
            Files.createDirectories(destination.getParent());
            FileOutputStream outputStream = new FileOutputStream(destination.toString());
            outputStream.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
            outputStream.close();
        } catch (IOException e) {
            System.out.println("Exception when taking screen shot :" + e.getMessage());
        }
    }
}
