/**
 * 
 */
package com.m7md.CouponSystemWS.jerseyServlet;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Response;

import com.couponSystem.beans.Category;
import com.couponSystem.beans.Coupon;
import com.couponSystem.classes.CouponSystemException;

/**
 * @author scary
 *
 */
public interface CustomerService {
	/**
	 * 
	 * @param coupon
	 * @return
	 */
	Response purchaseCoupon(Coupon coupon, HttpServletRequest request) throws CouponSystemException;

	/**
	 * 
	 * @return
	 */
	List<Coupon> getAllPurchasedCoupons(HttpServletRequest request) throws CouponSystemException;

	/**
	 * 
	 * @param category
	 * @return
	 */
	List<Coupon> getAllPurchasedCouponsByType(Category category, HttpServletRequest request)
			throws CouponSystemException;

	/**
	 * 
	 * @param price
	 * @return
	 */
	List<Coupon> getAllPurchasedCouponsByprice(Double price, HttpServletRequest request) throws CouponSystemException;

	/**
	 * 
	 * @param user
	 * @param pass
	 * @return
	 */
	Response login(String user, String pass, HttpServletRequest request) throws CouponSystemException;
}
