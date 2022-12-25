package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class travel {
@Id 
@GeneratedValue(strategy=GenerationType.AUTO)

private int id;
private int travelId;
private String name;
private String description;

travel() {}

travel(int travelId,String name, String description)
{
	this.setTravelId(travelId);
	this.setName(name);
	this.setDescription(description);
}
public int getTravelId()
{
	return travelId;
}
public void setTravelId(int travelId)
{
	this.travelId=travelId;
}
public String getName()
{
	return name;
}
public void setName(String name)
{
	this.name=name;
}
public String getDescription()
{
	return description;
}
public void setDescription(String description)
{
	this.description=description;
}
}

