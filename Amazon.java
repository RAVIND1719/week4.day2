package assign_w4_d2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {
	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Oneplus 9pro", Keys.ENTER);
		String price = driver.findElement(By.className("a-price-whole")).getText();
		System.out.println("price of mobile:" + price);
		String review = driver.findElement(By.xpath("//span[@class='a-size-base s-underline-text'][1]")).getText();
		System.out.println("review:" + review);
		driver.findElement(By.xpath("//span[contains(@class,'a-size-medium a-color-base')][1]")).click();
		Set<String> windowHandles1 = driver.getWindowHandles();
		List<String> windowHandleslist = new ArrayList<String>(windowHandles1);
		String string = windowHandleslist.get(1);
		driver.switchTo().window(windowHandleslist.get(1));
		// screenshot
		File sourceImage = driver.getScreenshotAs(OutputType.FILE);
		File destImage = new File("./snaps/IMG002.png");
		FileUtils.copyFile(sourceImage, destImage);
		driver.findElement(By.id("add-to-cart-button")).click();
		Thread.sleep(2000);
		String total = driver.findElement(By.xpath("//span[@id='attach-accessory-cart-subtotal']")).getText();

		System.out.println("Total:" + total);
		driver.close();

	}
}
