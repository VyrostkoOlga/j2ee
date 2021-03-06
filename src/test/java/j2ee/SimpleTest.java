package j2ee;

import static org.junit.Assert.*;
import impls.SimpleWarehouse;
import interfaces.IWarehouse;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import excs.NoSuchGoodException;

public class SimpleTest {
	
	private ApplicationContext ctx;
	
	public SimpleTest()
	{
		ctx = new ClassPathXmlApplicationContext( "/beans.xml" );
	}

	@Test
	public void testCreatingBeans() 
	{
		IWarehouse wh = (SimpleWarehouse)ctx.getBean("WH1");
		System.out.println(wh.getInfo());
		((AbstractApplicationContext) ctx).close();
	}
	
	@Test
	public void testGettingGood1()
	{
		ApplicationContext ctx = new ClassPathXmlApplicationContext( "/beans.xml" );
		IWarehouse wh = (SimpleWarehouse)ctx.getBean("WH1");
		try 
		{
			wh.getOneGood("apple", 10);
		} catch (NoSuchGoodException e) 
		{
			fail(e.getMessage());
		}
		int qty = wh.getCtgs().get(0).getGoods().get(0).getQty();
		assertEquals(qty, 0);
	}
	
	@Test
	public void testGettingGood2()
	{
		ApplicationContext ctx = new ClassPathXmlApplicationContext( "/beans.xml" );
		IWarehouse wh = (SimpleWarehouse)ctx.getBean("WH1");
		try 
		{
			wh.getOneGood("strowberries", 3);
		} catch (NoSuchGoodException e) 
		{
			fail(e.getMessage());
		}
		System.out.println("After going some work");
		System.out.println(wh.getInfo());
	}

}
