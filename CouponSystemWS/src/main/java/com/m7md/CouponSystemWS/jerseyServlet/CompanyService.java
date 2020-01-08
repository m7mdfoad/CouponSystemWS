/**
 * 
 */
package com.m7md.CouponSystemWS.jerseyServlet;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Response;

import com.couponSystem.beans.Category;
import com.couponSystem.beans.Coupon;
import com.couponSystem.classes.CouponSystemException;

/**
 * @author scary
 *
 */
public interface CompanyService {
	/**
	 * 
	 * @param coupon
	 * @return
	 */
	Response createCoupon(Coupon coupon, HttpServletRequest request) throws CouponSystemException;

	/**
	 * 
	 * @param coupon
	 * @return
	 */
	Response removeCoupon(Coupon coupon, HttpServletRequest request) throws CouponSystemException;

	/**
	 * 
	 * @param coupon
	 * @return
	 */
	Response updateCoupon(Coupon coupon, HttpServletRequest request) throws CouponSystemException;

	/**
	 * 
	 * @param id
	 * @return
	 */
	Response getCoupon(int id, HttpServletRequest request) throws CouponSystemException;

	/**
	 * 
	 * @return
	 */
	Response getAllCoupons(HttpServletRequest request) throws CouponSystemException;

	/**
	 * 
	 * @param category
	 * @return
	 */
	Response getCouponsByType(Category category, HttpServletRequest request) throws CouponSystemException;

	/**
	 * 
	 * @param user
	 * @param pass
	 * @return
	 */
	Response login(String user, String pass, HttpServletRequest request) throws CouponSystemException;

}
