<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html data-theme="dark">
  <head>
    <title>JSP - Hello World</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@picocss/pico@2/css/pico.min.css"/>
  </head>
  <body>
    <main class="container">
      <div class>
        <h1>Calculadora</h1>
      </div>
      <form action="calculadora" method="post">
        <input type="text" name="num1" id="num1" placeholder="Número 1" required/>
        <input type="text" name="num2" id="num2" placeholder="Número 2" required/>
        <select name="operacion" aria-label="select" required>
          <option selected disabled value="">Operación</option>
          <option value="sumar">Sumar</option>
          <option value="restar">Restar</option>
          <option value="multiplicar">Multiplicar</option>
          <option value="dividir">Dividir</option>
          <option value="ordenar">Ordenar el Número</option>
          <option value="impar">Cúal es impar</option>
        </select>
        <input type="submit" value="Calcular"/>
      </form>
      <div>
        <h2>Resultado</h2>
        <% if (request.getAttribute("resultado") != null) {
          %>
        <p><%=request.getAttribute("resultado")%></p>
        <%}%>
      </div>
    </main>
  </body>
</html>