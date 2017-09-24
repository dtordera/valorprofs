package com.dvtrsc.valorprofs.ws.entities.pojos;

import java.sql.Timestamp;

/*
 * Product
 */

public class Product extends BaseEntity
{
	public int id;
	public String name;
	public Boolean available;
	public Float price;
	public String description;
	public Timestamp datecreated;
	public Timestamp lastupdated;
}
