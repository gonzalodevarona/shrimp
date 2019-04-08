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

	public Container(String id, double weight, char type, String description, boolean input, int days){
		this.id = id;
		this.weight = weight;
		this.type = type;
		this.description = description;
		arriving = input;
		this.days = days;

		cost = calculateCost();
	}

	public double calculateCost(){
		double finalCost = 0.0;

		if(arriving){
			finalCost = DAYCOSTBYLEAVING * days;
		} else{finalCost = (days * DAYCOSTBYLEAVING) + (BASECOST * weight);}

		return finalCost;
	}

	public  double getWeight() {
	return weight;
	}

	public  boolean getInput() {
	return arriving;
	}

	public  char getType() {
	return type;
	}

	public  String getId() {
	return id;
	}
	


} //final