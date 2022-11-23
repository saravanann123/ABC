package hotelbooking;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {
	WebDriver driver;

	public void getdriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	public void maximizewindow() {
		driver.manage().window().maximize();

	}

	public void enterApplnurl(String url) {
		driver.get(url);
	}

	// public void gettitle() {
	// driver.getTitle();
	// }
	//
	// public void getcurrenturl() {
	// driver.getCurrentUrl();
	// }

	public WebElement findElementByid(String id) {
		WebElement findElement = driver.findElement(By.id(id));
		return findElement;
	}

	public WebElement findElementByxpath(String xpath) {

		WebElement findElement = driver.findElement(By.xpath(xpath));
		return findElement;
	}

	public WebElement findElementByname(String name) {
		WebElement findElement = driver.findElement(By.name(name));
		return findElement;
	}

	public String getattribute(WebElement element) {
		String attribute = element.getAttribute("value");
		return attribute;
	}

	public void txtinput(WebElement element, String value) {
		element.sendKeys(value);
	}

	public void click(WebElement element) {
		element.click();
	}

	public String gettext(WebElement element) {
		String text = element.getText();
		return text;
	}

	public void movetoelement(WebElement element) {
		Actions x = new Actions(driver);
		x.moveToElement(element).perform();
		// driver.findElement(By.xpath(xpath)).click();
	}

	public void draganddrop(WebElement source, WebElement destination) {
		Actions x = new Actions(driver);
		x.dragAndDrop(source, destination).perform();
	}

	public void screenshot(String path) throws Exception {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File screenshotAs = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(path);
		FileUtils.copyFile(screenshotAs, file);
	}

	public void keyboardactions(Keys shift, WebElement element, String input) {
		Actions actions = new Actions(driver);
		actions.keyDown(shift).sendKeys(element, input).keyUp(shift).perform();
	}

	public void doubleclick(WebElement element) {
		Actions actions = new Actions(driver);
		actions.doubleClick(element).perform();
	}

	public void alertaccept() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	public void alertdismiss() {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}

	public Alert alert(String input) {
		Alert alert = driver.switchTo().alert();
		return alert;
	}

	public void jssetattribute(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value',’Ranjith’)", element);
	}

	public void jsgetattribute(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Object executeScript = js.executeScript("arguments[0].getAttribute('value')", element);
		String string = executeScript.toString();
		System.out.println(string);
	}

	public void elementsendKeys(WebElement element, String data) {
		element.sendKeys(data);

	}

	public String elementgetAttributeValue(WebElement element) {
		String attribute = element.getAttribute("value");
		return attribute;

	}

	public void elementclick(WebElement element) {
		element.click();

	}

	public void jsclick(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", element);
	}

	public void frameid(String id) {
		driver.switchTo().frame(id);
	}

	public void frameelement(WebElement element) {
		driver.switchTo().frame(element);
	}

	public void frameindex(int index) {
		driver.switchTo().frame(index);
	}

	public void parentframe() {
		driver.switchTo().parentFrame();
	}

	public List<WebElement> noofframes(String id) {
		List<WebElement> list = (List<WebElement>) driver.findElement(By.tagName(id));
		int size = list.size();
		System.out.println(size);
		return list;
	}

	public void childwindow() {
		String parent = driver.getWindowHandle();
		Set<String> both = driver.getWindowHandles();
		for (String x : both) {
			if (!parent.equals(x)) {
				driver.switchTo().window(x);
			}
		}
	}

	public void backtoparentwindow() {
		String parent = driver.getWindowHandle();
		Set<String> both = driver.getWindowHandles();
		for (String x : both) {
			if (parent.equals(x)) {
				driver.switchTo().window(x);
			}
		}
	}

	public void windowhandling(int index) {
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> li = new ArrayList<String>();
		li.addAll(windowHandles);
		String x = li.get(index);
		driver.switchTo().window(x);
	}

	public void navigateto(String url) {
		driver.navigate().to(url);
	}

	public void navigateback() {
		driver.navigate().back();
	}

	public void navigateforward() {
		driver.navigate().forward();
	}

	public void navigaterefresh() {
		driver.navigate().refresh();
	}

	public void selectbyindex(WebElement element, int index) {
		Select s = new Select(element);
		s.selectByIndex(index);
	}

	public void selectbyvalue(WebElement element, String value) {
		Select s = new Select(element);
		s.selectByValue(value);
	}

	public void selectbyvisibletext(WebElement element, String text) {
		Select s = new Select(element);
		s.selectByVisibleText(text);
	}

	public void deselectall(WebElement element) {
		Select s = new Select(element);
		s.deselectAll();
	}

	public void deselectbyindex(WebElement element, int index) {
		Select s = new Select(element);
		s.deselectByIndex(index);
	}

	public void deselectbyvalue(WebElement element, String value) {
		Select s = new Select(element);
		s.deselectByValue(value);
	}

	public void deselectbyvisibletext(WebElement element, String text) {
		Select s = new Select(element);
		s.deselectByVisibleText(text);
	}

	public void ismultiplet(WebElement element) {
		Select s = new Select(element);
		boolean b = s.isMultiple();
		System.out.println(b);
	}

	public void getfirstselectedoption(WebElement element) {
		Select s = new Select(element);
		WebElement firstSelectedOption = s.getFirstSelectedOption();
		System.out.println(firstSelectedOption);
	}

	public void getoptions(WebElement element) {
		Select s = new Select(element);
		List<WebElement> options = s.getOptions();
		for (int i = 0; i < options.size(); i++) {
			options.get(i);
		}
	}

	public void jsscrolldown(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeAsyncScript("arguments[0].Scrollintoview(true)", element);
	}

	public void jsscrollup(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeAsyncScript("arguments[0].Scrollintoview(false)", element);
	}

	public void nooftables() {
		List<WebElement> findElements = driver.findElements(By.tagName("table"));
		int size = findElements.size();
		System.out.println(size);
	}

	public void gettextxt(int index) {
		List<WebElement> findElements = driver.findElements(By.tagName("table"));
		WebElement a = findElements.get(index);
		List<WebElement> findElements2 = a.findElements(By.tagName("tr"));
		for (WebElement x : findElements2) {
			String text = x.getText();
			System.out.println(text);
		}
	}

	public void gettextweb(int index) {
		List<WebElement> e = driver.findElements(By.tagName("table"));
		WebElement ee = e.get(index);
		String text = ee.getText();
		System.out.println(text);
	}

	public void quit() {
		driver.quit();
	}

	public void close() {
		driver.close();
	}

	public String excelread(String path, String sheet, int i, int j) throws Exception {
		String value = null;
		return value;
	}

	public String getDataFromCell(String sheetName, int rownum, int cellnum) throws IOException {
		String res = "";
		File file = new File("C:\\Users\\HP\\eclipse-workspace\\Maven\\EXcel\\hotel.xlsx");
		FileInputStream a = new FileInputStream(file);
		Workbook work = new XSSFWorkbook(a);
		Sheet sheet1 = work.getSheet(sheetName);
		Row row = sheet1.getRow(rownum);
		Cell cell = row.getCell(cellnum);
		CellType cellType = cell.getCellType();
		switch (cellType) {
		case STRING:
			res = cell.getStringCellValue();
			break;
		case NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {
				Date dateCellValue = cell.getDateCellValue();
				SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy");
				res = s.format(dateCellValue);

			} else {
				double numericCellValue = cell.getNumericCellValue();
				long l = Math.round(numericCellValue);
				if (numericCellValue == l) {
					res = String.valueOf(l);
				} else {
					res = String.valueOf(numericCellValue);
				}
			}
		default:
			break;
		}
		return res;
	}

	public void updateDatainCell(String sheetName, int rowNum, int cellNum, String oldData, String newData)
			throws IOException {
		File file = new File("C:\\Users\\HP\\eclipse-workspace\\Maven\\EXcel\\hotel.xlsx");
		FileInputStream a = new FileInputStream(file);
		Workbook work = new XSSFWorkbook(a);
		Sheet sheet1 = work.getSheet(sheetName);
		Row row = sheet1.getRow(rowNum);
		Cell cell = row.getCell(cellNum);
		String stringCellValue = cell.getStringCellValue();
		if (stringCellValue.equals(oldData)) {
			cell.setCellValue(newData);
		}
		FileOutputStream out = new FileOutputStream("C:\\Users\\HP\\eclipse-workspace\\Maven\\EXcel\\hotel.xlsx");
		work.write(out);
	}

	public void insertCellData(String sheetName, int rowNum, int cellNum, String cellvalue) throws IOException {

		File file = new File("C:\\Users\\HP\\eclipse-workspace\\Maven\\EXcel\\hotel.xlsx");
		FileInputStream a = new FileInputStream(file);
		Workbook work = new XSSFWorkbook(a);
		Sheet sheet1 = work.getSheet(sheetName);
		Row row = sheet1.createRow(rowNum);
		Cell cell = row.createCell(cellNum);
		cell.setCellValue(cellvalue);
		FileOutputStream out = new FileOutputStream(file);
		work.write(out);

		
	}

	public void getselectedoption(WebElement element) {
		Select s = new Select(element);
		List<WebElement> options = s.getAllSelectedOptions();
		for (WebElement x : options) {
			String text = x.getText();
			System.out.println(text);
		}
	}

	public void implicitywait() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	public void fluentwait(int sec, int interval) {
		FluentWait w = new FluentWait(driver).withTimeout(Duration.ofSeconds(sec))
				.pollingEvery(Duration.ofSeconds(interval)).ignoring(NoSuchElementException.class);
	}
}