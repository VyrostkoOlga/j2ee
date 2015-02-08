import interfaces.IWarehouse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import excs.NoSuchGoodException;
import impls.SimpleWarehouse;


public class Runner 
{

	public static void main(String[] args) 
	{
		ApplicationContext ctx = new ClassPathXmlApplicationContext( "/beans.xml" );
		IWarehouse wh = ctx.getBean("WH1", IWarehouse.class);
		System.out.println(wh.getInfo());
		try 
		{
			wh.getOneGood("apple", 10);
		} catch (NoSuchGoodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("After going some work");
		System.out.println(wh.getInfo());
	}

}
