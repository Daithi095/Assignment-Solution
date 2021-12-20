package ie.lyit.testers;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import ie.lyit.flight.Booking;
import ie.lyit.flight.Date;
import ie.lyit.flight.Flight;
import ie.lyit.flight.Passenger;
import ie.lyit.flight.Time;



public class BookingTester {
	private Booking b1;
	private double totalPriceTest;
	@Before
	public void setUp() throws Exception {
		b1=new Booking();
	}
	

	ArrayList<Passenger> passengers = new ArrayList<Passenger>();
	Flight outbound=new Flight();
	
	Flight inbound=new Flight();
	
	@Test	
	public void testBookingOutInIntInt() {
		b1=new Booking(outbound, inbound, passengers);
		// Check b1’s outbound is outbound
		assertEquals(outbound,b1.getOutbound());
		// Check b1’s inbound is inbound
		assertEquals(inbound,b1.getInbound());
		// Check b1’s passenger list is the same 
		assertEquals(passengers,b1.getPassengers());
		//making sure booking number is 10000
		assertEquals("Total bookingNo should be 10000",10000,b1.getBookingNo());	
	}
	//tests setting the outbound flight
	@Test
	public void testSetOutbound() {
		Flight o = new Flight("2", "here", "there", new Date(25,12,2018), new Time(12,40), 16.99);
		b1.setOutbound(o);
		assertEquals(o,b1.getOutbound());
	}
	//tests setting the inbound flight
	@Test
	public void testSetInbound() {
		Flight i = new Flight("2", "here", "there", new Date(25,12,2018), new Time(12,40), 16.99);
		b1.setInbound(i);
		assertEquals(i,b1.getInbound());
	}
	//tests setting the total price
	@Test
	public void testSetTotal() {
		double i = 3000;
		b1.setTotalPrice(i);
		assertEquals(i,b1.getInbound());
	}
	//method tests calculating the price
	@Test
	public void testCalculatePrice() {
		Flight i = new Flight("2", "here", "there", new Date(25,12,2018), new Time(12,40), 16.99);
		Flight o = new Flight("2", "here", "there", new Date(25,12,2018), new Time(12,40), 16.99);
		b1.setInbound(i);
		b1.setOutbound(o);
		b1.calculatePrice();
		totalPriceTest = i.getPrice()+o.getPrice();
		assertEquals(totalPriceTest,b1.getTotalPrice());
	}
}
