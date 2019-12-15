package test.designpattern.proxy;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import test.designpattern.proxy.service.OrderService;


public class Test {
	
	public static void main(String[] args) {
		Order order = new Order();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date date;
		try {
			date = simpleDateFormat.parse("2019/09/08");
			order.setCreateTime(date.getTime());
			OrderService orderService =  new OrderServiceStaticProxy(new OrderServiceImpl());
			orderService.createOrder(order);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
