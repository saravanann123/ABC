package hotelbooking;

import java.io.IOException;

import org.openqa.selenium.WebElement;

public class Hotelbooking extends Baseclass {

	public static void main(String[] args) throws IOException, InterruptedException {
		Hotelbooking Hotel = new Hotelbooking();
		Hotel.booking();
	}

	public void booking() throws IOException, InterruptedException {

		getdriver();
		enterApplnurl("http://adactinhotelapp.com/");
		maximizewindow();
		implicitywait();
		WebElement byid = findElementByid("username");
		String name = getDataFromCell("Sheet1", 1, 0);
		elementsendKeys(byid, name);

		WebElement byid2 = findElementByid("password");
		String pass = getDataFromCell("Sheet1", 1, 1);
		elementsendKeys(byid2, pass);

		WebElement btn = findElementByid("login");
		elementclick(btn);

		WebElement location = findElementByid("location");
		String country = getDataFromCell("Sheet1", 1, 2);
		elementsendKeys(location, country);

		WebElement hotel = findElementByid("hotels");
		String a = getDataFromCell("Sheet1", 1, 3);
		elementsendKeys(hotel, a);

		WebElement room = findElementByid("room_type");
		String b = getDataFromCell("Sheet1", 1, 4);
		elementsendKeys(room, b);

		WebElement nos = findElementByid("room_nos");
		String c = getDataFromCell("Sheet1", 1, 5);
		elementsendKeys(nos, c);

		WebElement start = findElementByid("datepick_in");
		String date = getDataFromCell("Sheet1", 1, 6);
		start.clear();
		elementsendKeys(start, date);

		WebElement out = findElementByname("datepick_out");
		String date1 = getDataFromCell("Sheet1", 1, 7);
		out.clear();
		elementsendKeys(out, date1);

		WebElement adult = findElementByname("adult_room");
		String a1 = getDataFromCell("Sheet1", 1, 8);
		elementsendKeys(adult, a1);

		WebElement child = findElementByname("child_room");
		elementclick(child);

		String a2 = getDataFromCell("Sheet1", 1, 9);
		elementsendKeys(child, a2);
		elementclick(child);

		WebElement search = findElementByname("Submit");
		elementclick(search);

		WebElement radio = findElementByname("radiobutton_0");
		elementclick(radio);

		WebElement con = findElementByname("continue");
		elementclick(con);

		WebElement byid1 = findElementByid("first_name");
		String fn = getDataFromCell("Sheet1", 1, 10);
		elementsendKeys(byid1, fn);

		WebElement last = findElementByid("last_name");
		String fn1 = getDataFromCell("Sheet1", 1, 11);
		elementsendKeys(last, fn1);

		WebElement byid4 = findElementByid("address");
		String ln = getDataFromCell("Sheet1", 1, 12);
		elementsendKeys(byid4, ln);

		WebElement byid5 = findElementByid("cc_num");
		String cardn = getDataFromCell("Sheet1", 1, 13);
		elementsendKeys(byid5, cardn);

		WebElement byid6 = findElementByid("cc_type");
		String cardT = getDataFromCell("Sheet1", 1, 14);
		elementsendKeys(byid6, cardT);

		WebElement byid7 = findElementByid("cc_exp_month");
		String cardme = getDataFromCell("Sheet1", 1, 15);
		elementsendKeys(byid7, cardme);

		WebElement byid8 = findElementByid("cc_exp_year");
		String cardye = getDataFromCell("Sheet1", 1, 16);
		elementsendKeys(byid8, cardye);

		WebElement byid9 = findElementByid("cc_cvv");
		String cardN = getDataFromCell("Sheet1", 1, 17);
		elementsendKeys(byid9, cardN);

		WebElement book = findElementByid("book_now");
		elementclick(book);

		Thread.sleep(15);
		WebElement byid10 = findElementByid("order_no");
		String Orderid = getattribute(byid10);
		System.out.println(Orderid);
		String cellvalue = getDataFromCell("Sheet1", 1, 18);
		updateDatainCell("Sheet1", 1, 18, cellvalue, Orderid);
	}
}
