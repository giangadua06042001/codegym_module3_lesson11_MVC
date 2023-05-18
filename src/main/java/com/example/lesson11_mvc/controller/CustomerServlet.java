package com.example.lesson11_mvc.controller;

import com.example.lesson11_mvc.model.Customer;
import com.example.lesson11_mvc.service.CustomerInterface;
import com.example.lesson11_mvc.service.ManagerCustomer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = "/customers")
public class CustomerServlet extends HttpServlet {
    private CustomerInterface customerInterface = new ManagerCustomer();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action=request.getParameter("action");
        if (action==null){
            action="";
        }
        switch (action){
            case "create":
                createCustomer(request,response);
                break;
            case "update":
                updateCustomer(request,response);
            case "delete":
                deleteCustomer(request,response);
                break;
        }

     }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
              showList(request,response);
                break;
            case "edit":
                showEditFrom(request,response);
                break;
            case "delete":
                showDeleteFrom(request,response);
                break;
            case "view":

                break;
            default:
                listCustomers(request,response);
                break;
        }
    }

    private void listCustomers(HttpServletRequest request, HttpServletResponse response) {
        List<Customer> customerList = this.customerInterface.ShowList();
        request.setAttribute("list", customerList);
        RequestDispatcher dispatcher=request.getRequestDispatcher("WEB-INF/View/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void showList(HttpServletRequest request,HttpServletResponse response){
        RequestDispatcher dispatcher=request.getRequestDispatcher("WEB-INF/View/create.jsp");
        try {
            dispatcher.forward(request,response);
        }catch (ServletException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    private void createCustomer(HttpServletRequest request,HttpServletResponse response){
        String name=request.getParameter("name");
        String email=request.getParameter("email");
        String address=request.getParameter("address");
        int id=(int) (Math.random()*1000);
        Customer customer=new Customer(id,email,name,address);
        this.customerInterface.save(customer);
        RequestDispatcher dispatcher=request.getRequestDispatcher("WEB-INF/View/list.jsp");
        request.setAttribute("creat",customer);
        try {
            dispatcher.forward(request,response);
        }catch (ServletException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    private void showEditFrom(HttpServletRequest request,HttpServletResponse response){
        int id=Integer.parseInt(request.getParameter("Id"));
        Customer customer=this.customerInterface.findById(id);
        RequestDispatcher dispatcher;
        if(customer==null){
            dispatcher=request.getRequestDispatcher("error-404.jsp");
        }else {
            request.setAttribute("newCustomer",customer);
            dispatcher=request.getRequestDispatcher("WEB-INF/View/edit.jsp");
        }
        try {
            dispatcher.forward(request,response);
        }catch (ServletException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    private void updateCustomer(HttpServletRequest request,HttpServletResponse response){
        int id=Integer.parseInt(request.getParameter("Id"));
        String newName=request.getParameter("name");
        String newEmail=request.getParameter("email");
        String newAddress=request.getParameter("address");
        Customer customer=this.customerInterface.findById(id);
        RequestDispatcher dispatcher;
        if(customer==null){
            dispatcher=request.getRequestDispatcher("error-404.jsp");
        }
        else {
            customer.setName(newName);
            customer.setEmail(newEmail);
            customer.setAddress(newAddress);
            this.customerInterface.update(id,customer);
            request.setAttribute("newCustomer",customer);
            request.setAttribute("message","newMessage");
            dispatcher=request.getRequestDispatcher("WEB-INF/View/edit.jsp");
        }
        try {
           dispatcher.forward(request,response);
        }catch (ServletException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    private void showDeleteFrom(HttpServletRequest request,HttpServletResponse response){
        int id=Integer.parseInt(request.getParameter("Id"));
        Customer customer=this.customerInterface.findById(id);
        RequestDispatcher dispatcher;
        if(customer==null){
            dispatcher=request.getRequestDispatcher("error-404.jsp");
        }else {
            request.setAttribute("newCustomer",customer);
            dispatcher=request.getRequestDispatcher("WEB-INF/View/delete.jsp");

        }
        try{
            dispatcher.forward(request,response);
        }catch (ServletException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    private void deleteCustomer(HttpServletRequest request,HttpServletResponse response){
        int id=Integer.parseInt(request.getParameter("Id"));
        Customer customer=this.customerInterface.findById(id);
        RequestDispatcher dispatcher;
        if(customer==null){
            dispatcher=request.getRequestDispatcher("error-404.jsp");
        }else {
            this.customerInterface.remove(id);
        }
        try {
            response.sendRedirect(" WEB-INF/View/delete.jsp");
        }catch (IOException e){
            e.printStackTrace();
        }
    }


}
