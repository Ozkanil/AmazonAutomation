package utilities;

import org.openqa.selenium.JavascriptExecutor;

public class JSUtils {

    public static void scrollDownByJS() {
        JavascriptExecutor jsexecutor = ((JavascriptExecutor) Driver.getDriver());
        jsexecutor.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }


}
