/**
 * 
 */
package com.m7md.CouponSystemWS.jerseyServlet;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Response;

import com.couponSystem.beans.Company;
import com.couponSystem.beans.Customer;
import com.couponSystem.classes.CouponSystemException;

/**
 * @author scary
 *
 */
public interface AdminService {
	/**
	 * 
	 * @param company
	 * @return
	 */
	Response createCompany(Company company, HttpServletRequest request) throws CouponSystemException;

	/**
	 * 
	 * @param company
	 * @return
	 */
	Response removeCompany(Company company, HttpServletRequest request) throws CouponSystemException;

	/**
	 * 
	 * @param company
	 * @return
	 */
	Response updateCompany(Company company, HttpServletRequest request) throws CouponSystemException;

	/**
	 * 
	 * @param id
	 * @return
	 */
	Response getCompany(int id, HttpServletRequest request) throws CouponSystemException;

	/**
	 * 
	 * @return
	 */
	Response getAllCompanies(HttpServletRequest request) throws CouponSystemException;

	/**
	 * 
	 * @param customer
	 * @return
	 */
	Response createCustomer(Customer customer, HttpServletRequest request) throws CouponSystemException;

	/**
	 * 
	 * @param customer
	 * @return
	 */
	Response removeCustomer(Customer customer, HttpServletRequest request) throws CouponSystemException;

	/**
	 * 
	 * @param customer
	 * @return
	 */
	Response updateCustomer(Customer customer, HttpServletRequest request) throws CouponSystemException;

	/**
	 * 
	 * @param id
	 * @return
	 */
	Response getCustomer(int id, HttpServletRequest request) throws CouponSystemException;

	/**
	 * 
	 * @return
	 */
	Response getAllCustomers(HttpServletRequest request) throws CouponSystemException;

	/**
	 * 
	 * @param user
	 * @param pass
	 * @return
	 */
	Response login(String user, String pass, HttpServletRequest request) throws CouponSystemException;

}
