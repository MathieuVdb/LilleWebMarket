package src.controller;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import framework.Controller;



public class SecurityController extends Controller
{
    public void indexAction(HttpServletRequest request, HttpServletResponse response)
    {
    	if(request.getUserPrincipal() != null){
            addFlash(request, "error", "Vous êtes déjà connecté !");
    		redirect(response, request.getContextPath());
        } else if(request.getDispatcherType() == javax.servlet.DispatcherType.FORWARD)
            redirect(response, request.getContextPath() + "/login");
        else
        	render("security:login", request, response, "Connexion");
    }

    public void loginAction(HttpServletRequest request, HttpServletResponse response)
    {
        redirect(response, request.getContextPath());
    }

    public void logoutAction(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        request.logout();
        redirect(response, request.getContextPath());
    }
}