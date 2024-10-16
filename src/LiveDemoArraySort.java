import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class LiveDemoArraySort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.xpath("//tr/th[1]")).click();
		
		List<WebElement> d= driver.findElements(By.cssSelector("tr td:nth-child(1)"));
//		d.click();
		List<String> d1=d.stream().map(s->s.getText()).collect(Collectors.toList());
		
		List<String> d2=d1.stream().sorted().collect(Collectors.toList());
		
		Assert.assertTrue(d1.equals(d2));
		
		
	//price of beans
//		List<String> price=d.stream().filter(s->s.getText().contains("Beans")).map(s->getPriceVeggies(s)).collect(Collectors.toList());
//		price.forEach(s->System.out.println(s));
		List<String> price;
		do {
			List<WebElement> d3= driver.findElements(By.cssSelector("tr td:nth-child(1)"));
			price=d3.stream().filter(s->s.getText().contains("Rice")).map(s->getPriceVeggies(s)).collect(Collectors.toList());
			price.forEach(s->System.out.println(s));
			if(price.size()<1){
				driver.findElement(By.xpath("//a[@aria-label='Next']")).click();
			}
		}while(price.size()<1);
		
//		LiveDemoArraySort aa=new LiveDemoArraySort();
		LiveDemoArraySort.getSearch(driver);
		
	}

	private static String getPriceVeggies(WebElement s) {
		// TODO Auto-generated method stub
		String val=s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return val;
	}
	public static void getSearch(WebDriver driver) {
		driver.findElement(By.id("search-field")).sendKeys("Rice");
		List<WebElement> products=driver.findElements(By.xpath("//tr/td[1]"));
		List<WebElement> p1=products.stream().filter(s->s.getText().contains("Rice")).collect(Collectors.toList());
		p1.stream().forEach(s->System.out.println(s.getText()));
		Assert.assertEquals(p1.size(), products.size());
		
	}

}
