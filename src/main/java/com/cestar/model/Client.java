/**
 * 
 */
package com.cestar.model;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * 
 */
@ManagedBean(name = "emp")
@SessionScoped
public class Client {

	private int id ;
	private String name ;
	private String contact ;
	private String itemshipped ;
	private String datereceived ;
	private String dateshipped ;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getItemshipped() {
		return itemshipped;
	}
	public void setItemshipped(String itemshipped) {
		this.itemshipped = itemshipped;
	}
	public String getDatereceived() {
		return datereceived;
	}
	public void setDatereceived(String datereceived) {
		this.datereceived = datereceived;
	}
	public String getDateshipped() {
		return dateshipped;
	}
	public void setDateshipped(String dateshipped) {
		this.dateshipped = dateshipped;
	}
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Client(int id, String name, String contact, String itemshipped, String datereceived, String dateshipped) {
		super();
		this.id = id;
		this.name = name;
		this.contact = contact;
		this.itemshipped = itemshipped;
		this.datereceived = datereceived;
		this.dateshipped = dateshipped;
	}
	@Override
	public String toString() {
		return "Client [id=" + id + ", name=" + name + ", contact=" + contact + ", itemshipped=" + itemshipped
				+ ", datereceived=" + datereceived + ", dateshipped=" + dateshipped + "]";
	}
	
	
}
