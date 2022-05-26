package assign_w4_d2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http:/leaftaps.com/opentaps/control/login");
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();

		driver.findElement(By.linkText("CRM/SFA")).click();

		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
		driver.findElement(By.xpath("//img[@alt='Lookup'][1]")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windowHandleslist = new ArrayList<String>(windowHandles);
		String firstwindow = windowHandleslist.get(1);
		driver.switchTo().window(firstwindow);
		driver.findElement(By.xpath("//a[@class='linktext']")).click();
		driver.switchTo().window(windowHandleslist.get(0));
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
		Set<String> windowHandles2 = driver.getWindowHandles();
		List<String> windowHandleslist2 = new ArrayList<String>(windowHandles2);
		String firstwindow1 = windowHandleslist2.get(1);
		driver.switchTo().window(firstwindow1);
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a)[2]")).click();
		driver.switchTo().window(windowHandleslist2.get(0));
		driver.findElement(By.linkText("Merge")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		System.out.println("the title of the page is :" + driver.getTitle());
		if (driver.getTitle().contains("view contact")) {
			System.out.println('\n' + "title is verified");
		}

	}

}
