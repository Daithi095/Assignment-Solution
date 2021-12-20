package ie.lyit.flight;

import java.util.ArrayList;

public class Booking extends Flight{
	
	// set variables that will be needed in the booking class
	double totalPrice;
	int bookingNo;
	static int nextUniqueBookingNumber=10000;
	Flight outbound = new Flight();
	Flight inbound = new Flight();

	// Create an ArrayList of Passenger objects called passengers
	ArrayList<Passenger> passengers = new ArrayList<Passenger>();
	
	//default constructor
	public Booking()
	{
		outbound= new Flight();
		inbound= new Flight();
		passengers = new ArrayList<Passenger>();
		bookingNo=nextUniqueBookingNumber;
		
	}
	//constructor using parameters so you can set a booking
	public Booking(Flight outbound, Flight inbound, ArrayList<Passenger> passengers) 
	{
		this.outbound=outbound;	// Set instance variable to parameter
		this.inbound=inbound;
		this.passengers=passengers;
		bookingNo=nextUniqueBookingNumber;
		nextUniqueBookingNumber+=1;
		totalPrice=calculatePrice();
		
	}
	//the to string method
	public String toStringOut(){
		return "Booking Number" + bookingNo 
				+ "Outbound Flight" + outbound.getFlightNumber() + " ==> "+outbound.getSource()+" to "+outbound.getDestination()
				+ outbound.getDate()+ " "+outbound.getTime()+" hours"
				+ "Passengers" + passengers 
				+"Total Price" + totalPrice + "Booking Number" + bookingNo 
				+ "Inbound Flight" + inbound.getFlightNumber() + " ==> "+inbound.getSource()+" to "+inbound.getDestination() 
				+ inbound.getDate()+ " "+inbound.getTime()+" hours"
				+ "Passengers" + passengers 
				+ "Total Price" + totalPrice;
		
		
	}

	   public boolean equals(Object obj){
		   	Booking bObject;
		   	if (obj instanceof Booking)
		   		bObject = (Booking)obj;
		   	else
		   		return false;

		   return this.outbound.equals(bObject.outbound) &&
				  this.inbound.equals(bObject.inbound) &&
				  this.passengers.equals(bObject.passengers) &&							
			      this.bookingNo == bObject.bookingNo; 						
		}
	   // this warning tells me that i++ isnt used so should be removed but it is 
	   //indeed needed so i used supress so it would run
	   @SuppressWarnings("unused")
	   //this returns a true or false based on if passenger is in the arraylist
	public boolean findPassenger(Passenger p)
	   {
		   
		   for(int i = 0; i < this.passengers.size(); i++)
		   {
			   Passenger check = this.passengers.get(i);
			   if (p == check)
			   {
				   return true;
			   }
			   else
					return false;
		   }
		return false;
		   
		

		   
	   }
	   
	   //this method calculates the price by getting the price of both flights and multiplying by how many passengers
	   public double calculatePrice()
	   {
		   
		   totalPrice= this.outbound.getPrice() + this.inbound.getPrice();
		   totalPrice= totalPrice*this.passengers.size();
		   return totalPrice;
		   
	   }
	   //set and get methods for a few variables
		public void setOutbound(Flight o){
			outbound = o;
		}
		public Flight getOutbound()
		{
			return outbound;
		}
		public void setInbound(Flight i){
			inbound = i;
		}
		public Flight getInbound()
		{
			return inbound;
		}
		public void setTotalPrice(double i){
			totalPrice = i;
		}
		public double getTotalPrice()
		{
			return totalPrice;
		}
		public int getBookingNo() {
			return bookingNo;
		}
		public ArrayList<Passenger> getPassengers()
		{
			return passengers;
		}
	
}


