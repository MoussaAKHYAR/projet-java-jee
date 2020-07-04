package com.aegisi.controller;

import com.aegisi.dao.IMembre;
import com.aegisi.dao.MembreImpl;
import com.aegisi.entities.Membre;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/Membre", name = "membre")
public class MembreServlet extends HttpServlet {

    private IMembre membredao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        membredao = new MembreImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // resp.getWriter().println("ok");
        req.getRequestDispatcher("membre/add.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nom = req.getParameter("nom").toString();
        String prenom = req.getParameter("prenom").toString();
        String classe = req.getParameter("classe").toString();
        String numero = req.getParameter("numero").toString();

        Membre membre = new Membre();
        membre.setNom(nom);
        membre.setPrenom(prenom);
        membre.setClasse(classe);
        membre.setNumero(numero);

        int ok = membredao.add(membre);
        //resp.getWriter().println(ok);
        doGet(req, resp);
    }
}
