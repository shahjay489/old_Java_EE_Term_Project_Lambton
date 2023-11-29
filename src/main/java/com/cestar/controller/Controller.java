/**
 * 
 */
package com.cestar.controller;

import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.cestar.dao.ClientDao;
import com.cestar.model.Client;

/**
 * 
 */

@ManagedBean(name = "ctlr")
@SessionScoped
public class Controller {
	
	ClientDao obj = new ClientDao();

	int old_id = 0;

	public List<Client> display() {

		List<Client> emps = obj.displayRecs();

		return emps;

	}
	
	public String insert(Client emp_from_insert_page) {

		obj.insertRec(emp_from_insert_page);

		return "display";

	}
	
	public String edit(int id_from_edit_btn_in_display_page) {
		
		old_id = id_from_edit_btn_in_display_page ;
		
		Client emp_to_edit = obj.getRecById(id_from_edit_btn_in_display_page);
		
		Map<String , Object>  session_map = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		
		session_map.put("emp_to_edit_in_edit_page",emp_to_edit );
		
		return "edit" ;
	}
	
	public String update(Client emp_edited_in_edit_page) {
		
		System.out.println(old_id);
		
		obj.updateById(emp_edited_in_edit_page, old_id);
		
		return "display";
		
	}
	
	public String delete(int id_from_delete_btn) {
		
		obj.deleteRec(id_from_delete_btn);
		
		return "display";
		
	}
	
	
	public String goToInsert() {
		
		return "insert";
	}
	
	

}
