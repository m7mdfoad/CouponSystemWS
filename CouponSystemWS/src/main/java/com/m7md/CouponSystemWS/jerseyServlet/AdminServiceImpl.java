/**
 * 
 */
package com.m7md.CouponSystemWS.jerseyServlet;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.couponSystem.beans.Company;
import com.couponSystem.beans.Customer;
import com.couponSystem.classes.ClientType;
import com.couponSystem.classes.CouponSystemException;
import com.couponSystem.facade.AdminFacade;
import com.couponSystem.pool.LoginManager;

/**
 * @author scary
 *
 */
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/admin")
public class AdminServiceImpl implements AdminService {

	@Context
	HttpSession session;
	AdminFacade adminFacade;
	LoginManager loginManager = LoginManager.getInstance();

	public AdminServiceImpl() {
	}

	private AdminFacade getFacadeSession(HttpServletRequest request) {
		session = request.getSession();
		adminFacade = (AdminFacade) session.getAttribute("adminService");
		return adminFacade;
	}

	@Override
	@Path("createCompany")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@POST
	public Response createCompany(Company company, @Context HttpServletRequest request) {
		adminFacade = getFacadeSession(request);
		try {
			adminFacade.addCompany(company);
			return Response.status(Status.OK).entity(company + " created").build();
		} catch (CouponSystemException e) {
			return Response.status(Status.UNAUTHORIZED).entity(e.getMessage()).build();
		}
	}

	@Override
	@Path("removeCompany")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@DELETE
	public Response removeCompany(Company company, @Context HttpServletRequest request) {
		adminFacade = getFacadeSession(request);
		try {
			adminFacade.deleteCompany(company.getId());
			return Response.status(Status.OK).entity(company + " deleted").build();
		} catch (CouponSystemException e) {
			return Response.status(Status.UNAUTHORIZED).entity(e.getMessage()).build();
		}
	}

	@Override
	@Path("updateCompany")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@PUT
	public Response updateCompany(Company company, @Context HttpServletRequest request) {
		adminFacade = getFacadeSession(request);
		try {
			adminFacade.updateCompany(company);
			return Response.status(Status.OK).entity("updated").build();
		} catch (CouponSystemException e) {
			return Response.status(Status.UNAUTHORIZED).entity(e.getMessage()).build();
		}
	}

	@Override
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("getCompany/{id}")
	public Response getCompany(@PathParam("id") int id, @Context HttpServletRequest request) {
		Company company = new Company();
		adminFacade = getFacadeSession(request);
		try {
			company = adminFacade.getOneCompany(id);
			return Response.status(Status.OK).entity(company).build();
		} catch (CouponSystemException e) {
			return Response.status(Status.UNAUTHORIZED).entity(e.getMessage()).build();
		}

	}

	@Override
	@Path("getAllCompanies")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public Response getAllCompanies(@Context HttpServletRequest request) {
		List<Company> companies = new ArrayList<Company>();
		adminFacade = getFacadeSession(request);
		try {
			companies = adminFacade.getAllCompanies();
			return Response.status(Status.OK).entity(companies).build();
		} catch (CouponSystemException e) {
			return Response.status(Status.UNAUTHORIZED).entity(e.getMessage()).build();
		}
	}

	@Override
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("createCustomer")
	public Response createCustomer(Customer customer, @Context HttpServletRequest request) {
		adminFacade = getFacadeSession(request);
		try {
			adminFacade.addCustomer(customer);
			return Response.status(Status.OK).entity(customer + "created").build();
		} catch (CouponSystemException e) {
			return Response.status(Status.UNAUTHORIZED).entity(e.getMessage()).build();
		}
	}

	@Override
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("removeCustomer")
	public Response removeCustomer(Customer customer, @Context HttpServletRequest request) {
		adminFacade = getFacadeSession(request);
		try {
			adminFacade.deleteCustomer(customer.getId());
			return Response.status(Status.OK).entity(customer + "deleted").build();
		} catch (CouponSystemException e) {
			return Response.status(Status.UNAUTHORIZED).entity(e.getMessage()).build();
		}
	}

	@Override
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("updateCustomer")
	public Response updateCustomer(Customer customer, @Context HttpServletRequest request) {
		adminFacade = getFacadeSession(request);
		try {
			adminFacade.updateCustomer(customer);
			return Response.status(Status.OK).entity(customer + "updated").build();
		} catch (CouponSystemException e) {
			return Response.status(Status.UNAUTHORIZED).entity(e.getMessage()).build();
		}
	}

	@Override
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("getCustomer/{id}")
	public Response getCustomer(@PathParam("id") int id, @Context HttpServletRequest request) {
		adminFacade = getFacadeSession(request);
		Customer customer = new Customer();
		try {
			customer = adminFacade.getOneCustomer(id);
			return Response.status(Status.OK).entity(customer).build();
		} catch (CouponSystemException e) {
			return Response.status(Status.UNAUTHORIZED).entity(e.getMessage()).build();
		}
	}

	@Override
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("getAllCustomers")
	public Response getAllCustomers(@Context HttpServletRequest request) {
		adminFacade = getFacadeSession(request);
		List<Customer> customers = new ArrayList<Customer>();
		try {
			customers = adminFacade.getAllCustomers();
			return Response.status(Status.OK).entity(customers).build();
		} catch (CouponSystemException e) {
			return Response.status(Status.UNAUTHORIZED).entity(e.getMessage()).build();
		}
	}

	@Override
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("login")
	public Response login(@QueryParam("user") String user, @QueryParam("pass") String pass,
			@Context HttpServletRequest request) {
		adminFacade = getFacadeSession(request);
		try {
			adminFacade = (AdminFacade) loginManager.login(user, pass, ClientType.ADMINISTRATOR);
			return Response.status(Status.ACCEPTED).entity("login successfully").build();
		} catch (CouponSystemException e) {
			return Response.status(Status.UNAUTHORIZED).entity(e.getMessage()).build();
		}
	}

}
