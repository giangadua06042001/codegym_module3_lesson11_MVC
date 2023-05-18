package com.example.lesson11_mvc.controller;

import com.example.lesson11_mvc.model.Product;
import com.example.lesson11_mvc.service.ProductIterface;
import com.example.lesson11_mvc.service.productService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Intermidiary", value = "/demo")
public class Intermidiary extends HttpServlet {
    private ProductIterface productIterface= new productService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException , IOException{

    }
    protected void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException ,IOException{
        String  vehicle=request.getParameter("action");
        if(vehicle==null){
            vehicle="";
        }
        switch (vehicle){
            case "showList":
                break;
            case "update":
                break;
            default:
                showList(request,response);
        }
    }
    private void showList(HttpServletRequest request,HttpServletResponse response){
        List<Product> productList=this.productIterface.findAll();
        request.setAttribute("List",productList);
        RequestDispatcher dispatcher=request.getRequestDispatcher("View/showlist.jsp");
        try {
            dispatcher.forward(request,response);
        }catch (ServletException e){
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

}
