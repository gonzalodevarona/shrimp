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
import java.util.*;

public class SeaPort{



	//ATTRIBUTES
	private String companyName;
	private String address;
	private String phone;
	private String nit;

	//RELATIONSHIPS

	private ArrayList<Container> containers;

	//METHODS

	/**
	* SeaPort constructor
	* @param companyName A String which is the company's name <br>
	* @param address A String which is the company's address <br>
	* @param phone A String which is the company's phone <br>
	* @param nit A String which is the company's nit
	*/

	public SeaPort(String companyName, String address, String phone, String nit){
		this.companyName = companyName;
		this.address = address;
		this.phone = phone;
		this.nit = nit;

		 containers = new ArrayList<Container>();

	}

	/**
	* Creates a new Container object with the given parameters so it can be added to the container ArrayList, meaning that a new container 
	* has been added to the sea port's containers
	*
	* @param id A String which is the unique ID for a new container <br>
	* @param weight A double which is the weight (in Kg) for a new container <br>
	* @param type A char which is the type of container that the new container is. It can be a (Dry Van 20), b (Dry Van 40) or t (Tank container) <br>
	* @param description A String which is the cargo's description of the new container (what the container has inside) <br>
	* @param arriving A boolean which indicates if the new container is arriving (true) of leaving (false) <br>
	* @param days An int which indicates how many days has/had spent the new container in the dock 
	*/

	public void addContainer(String id, double weight, char type, String description, boolean arriving, int days){
		Container newContainer = new Container(id, weight, type, description, arriving, days);
		containers.add(newContainer);
	}



	/**
	* Checks in every container of the container's ArrayList if the container's type is tank container and if it is arriving, if both conditions are true
	* then the program sums 1 to the counter
	*
	* @return an <code>integer</code> which means how many containers are arriving and are tank containers out of every container in the dock
	*/

	public int requestTankContainerAmount(){
		int quantity = 0;

		for(int i = 0 ; i < containers.size() ; i++){
			if(containers.get(i).getType() == 't' && containers.get(i).getInput()){
				++quantity;
			}
		}

		return quantity;
	}




	/**
	* Checks in every container of the container's ArrayList if the container is arriving, if the condition is true, nothing happens, but otherwise,
	* the container in matter is added to the <code>ArrayList<Container></code> that will be returned
	*
	* @return an <code>ArrayList<Container></code> which is every container that is leaving from all containers in the dock
	*/

	public ArrayList<Container> getOutputContainers(){
		ArrayList<Container> theList = new ArrayList<Container>();

		for(int i = 0 ; i < containers.size() ; i++){
			if(containers.get(i).getInput()){
			} else { theList.add(containers.get(i));}
		}

		return theList;
	}


} //final