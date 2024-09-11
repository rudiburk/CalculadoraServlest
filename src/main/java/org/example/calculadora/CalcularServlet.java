package org.example.calculadora;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "Calculadora", value = "/calculadora")
public class CalcularServlet extends HttpServlet {

    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String num1= req.getParameter("num1");
        String num2= req.getParameter("num2");
        String operacion= req.getParameter("operacion");
        String resultado ="";
        String errorMensaje="";

        if (parseo(num1) && parseo(num2)) {
            int num1int = Integer.parseInt(num1);
            int num2int = Integer.parseInt(num2);

            switch (operacion) {
                case "sumar":
                    resultado = "Resultado: " + (num1int + num2int);
                    break;
                case "restar":
                    resultado = "Resultado: " + (num1int - num2int);
                    break;
                case "multiplicar":
                    resultado = "Resultado: " + (num1int * num2int);
                    break;
                case "dividir":
                    if (num2int != 0) {
                        resultado = "Resultado: " + (num1int / num2int);
                    } else {
                        errorMensaje = "No se pude dividir por 0";
                    }
                    break;
                case "ordenar":
                    resultado = "Número 1: " + Math.min(num1int, num2int) + ", Número 2: " + Math.max(num1int, num2int);
                    break;
                case "impar":
                    resultado = (num1int % 2 != 0) ? "Número 1 es impar" : (num2int % 2 != 0) ? "Número 2 es impar" : "Ninguno es impar";
                    break;

                default:
                    errorMensaje = "Operación inválida";
                    break;
            }
        }else{
                errorMensaje = "Ingresa solo números enteros";
        }
        if (errorMensaje !="") {
            req.setAttribute("errorMensaje", errorMensaje);
            req.getRequestDispatcher("error.jsp").forward(req,resp);
            return;
        }
        req.setAttribute("resultado", resultado);
        req.getRequestDispatcher("index.jsp").forward(req,resp);
    }
    private boolean parseo(String str) {
        if (str == null) {
            return false;
        }
        try {
            Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }


    public void destroy() {
    }
}