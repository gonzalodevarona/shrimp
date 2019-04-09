/*
 * ˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜
 * ID
 * UNIVERSIDAD ICESI (CALI-COLOMBIA)
 * DEPARTAMENTO TIC - ALGORTIMOS Y PROGRAMACIÓN I
 * SHRIMP que se duerme sofware
 * @AUTHOR: RAGNAR LODBROK <gonzalo.de1@correo.icesi.edu.co>
 * @LAST UPDATE DATE: 8 APRIL 2019
 * ˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜
 */

package model;



public class Container{

	//CONSTANTS

	public final static char TANKCONTAINER = 't';
	public final static char DRYVAN20 = 'a';
	public final static char DRYVAN40 = 'b';
	public final static double BASECOST = 2000000;
	public final static double DAYCOSTBYARRIVING = 100000;
	public final static double DAYCOSTBYLEAVING = 150000;


	//ATTRIBUTES
	private String id;
	private double weight;
	private char type;
	private String description;
	private boolean arriving;
	private int days;
	private double cost;


	//METHODS

	/**
	* Container constructor
	*
	* @param id A String which is the container's unique ID <br>
	* @param weight A double which is the container's weight <br>
	* @param type A char which is the container's type (dry van 20, dry van 40, tank container) <br>
	* @param description A String which is the container's cargo description<br>
	* @param input A boolean which indicates if the container is arrving (true) or leaving (false)<br>
	* @param days An int which indicates how many days has/had spent the new container in the dock 
	*/

	public Container(String id, double weight, char type, String description, boolean input, int days){
		this.id = id;
		this.weight = weight;
		this.type = type;
		this.description = description;
		arriving = input;
		this.days = days;

		cost = calculateCost();
	}



	/**
	* This method calculates the final cost of a container, depending if it is arrving or leaving. If it is arrving the final cost is 
	* <code>DAYCOSTBYLEAVING * days</code>. If it is leaving the final cost is <code>(days * DAYCOSTBYARRIVING) + (BASECOST * weight)</code>
	*
	* @return A double which returns the final cost of a container, it is used to assign <code>cost</code> in the Container constructor
	*/

	public double calculateCost(){
		double finalCost = 0.0;

		if(arriving){
			finalCost = DAYCOSTBYLEAVING * days;
		} else{finalCost = (days * DAYCOSTBYARRIVING) + (BASECOST * weight);}

		return finalCost;
	}



	/**
	* Get the <code>weight</code> <br>
	*
	* @return A double which is the container's weight 
	*/

	public  double getWeight() {
	return weight;
	}



	/**
	* Get the <code>arriving</code> value <br>
	*
	* @return A boolean which indicates if the container is arrving (true) or leaving (false)
	*/

	public  boolean getInput() {
	return arriving;
	}



	/**
	* Get the <code>type</code> <br>
	*
	* @return A char which is the type of a container (dry van 20, dry van 40, tank container) 
	*/

	public  char getType() {
	return type;
	}



	/**
	* Get the unique <code>id</code> <br>
	*
	* @return A String which is the unique ID of a container
	*/

	public  String getId() {
	return id;
	}
	


} //final