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

	public SeaPort(String companyName, String address, String phone, String nit){
		this.companyName = companyName;
		this.address = address;
		this.phone = phone;
		this.nit = nit;

		 containers = new ArrayList<Container>();

	}

	public void addContainer(String id, double weight, char type, String description, boolean arriving, int days){
		Container newContainer = new Container(id, weight, type, description, arriving, days);
		containers.add(newContainer);
	}


	public int requestTankContainerAmount(){
		int quantity = 0;

		for(int i = 0 ; i < containers.size() ; i++){
			if(containers.get(i).getType() == 't' && containers.get(i).getInput()){
				++quantity;
			}
		}

		return quantity;
	}


	public ArrayList<Container> getOutputContainers(){
		ArrayList<Container> theList = new ArrayList<Container>();

		for(int i = 0 ; i < containers.size() ; i++){
			if(containers.get(i).getInput()){
			} else { theList.add(containers.get(i));}
		}

		return theList;
	}


} //final