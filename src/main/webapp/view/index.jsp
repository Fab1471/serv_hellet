<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title>Cadastro de Livros - Biblioteca Unicesumar</title>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />

  <!-- Estilização completa para formulário e exibição dos livros -->
  <style>
    /* Reset e estilo geral da página */
    body {
      margin: 0;
      padding: 0;
      font-family: 'Roboto', sans-serif;
      background: #f2f5f9;
      display: flex;
      justify-content: center;
      align-items: center;
      min-height: 100vh;
      flex-direction: column;
    }

    /* Container principal do formulário */
    .container-form {
      background-color: #ffffff;
      padding: 40px;
      border-radius: 12px;
      box-shadow: 0 6px 20px rgba(0, 0, 0, 0.1);
      width: 100%;
      max-width: 500px;
      margin-bottom: 40px;
    }

    h2 {
      text-align: center;
      color: #004080;
      margin-bottom: 30px;
    }

    label {
      display: block;
      margin-bottom: 8px;
      font-weight: bold;
      color: #333;
    }

    input[type="text"] {
      width: 100%;
      padding: 10px;
      border-radius: 6px;
      border: 1px solid #ccc;
      margin-bottom: 20px;
      font-size: 14px;
    }

    .button-submit {
      display: block;
      width: 100%;
      padding: 12px;
      background-color: #004080;
      color: white;
      font-weight: bold;
      font-size: 16px;
      border: none;
      border-radius: 6px;
      cursor: pointer;
      transition: background-color 0.3s ease;
    }

    .button-submit:hover {
      background-color: #0066cc;
    }

    footer {
      text-align: center;
      font-size: 12px;
      color: #777;
      margin-top: 20px;
    }

    .error-message {
      color: red;
      font-weight: bold;
      margin-bottom: 20px;
      text-align: center;
    }

    /* Estilo da lista de livros renderizada dinamicamente */
    .lista {
      background-color: #fff;
      padding: 20px;
      margin-bottom: 20px;
      width: 100%;
      max-width: 500px;
      box-shadow: 0 4px 10px rgba(0,0,0,0.08);
      border-radius: 12px;
    }

    .lista p {
      margin: 4px 0;
    }

    .lista form {
      margin-top: 10px;
    }

    .lista button {
      background-color: #e63946;
      color: white;
      border: none;
      padding: 8px 16px;
      border-radius: 6px;
      cursor: pointer;
      font-weight: bold;
    }

    .lista button:hover {
      background-color: #d62828;
    }
  </style>
</head>

<body>

<!-- Container principal do formulário -->
<div class="container-form">
  <h2>Cadastro de Livros</h2>

  <%-- Exibição de mensagem de erro, se existir --%>
  <%
    String mensagemErro = (String) request.getAttribute("mensagemErro");
    if (mensagemErro != null && !mensagemErro.isEmpty()) {
  %>
  <div class="error-message">
    <%= mensagemErro %>
  </div>
  <%
    }
  %>

  <%-- Formulário de cadastro de livro --%>
  <form action="livros" method="post">
    <input type="hidden" name="action" value="create" />

    <label for="titulo">Título:</label>
    <input type="text" name="titulo" id="titulo" required />

    <label for="autor">Autor:</label>
    <input type="text" name="autor" id="autor" required />

    <label for="ano">Ano de Publicação:</label>
    <input type="text" name="ano" id="ano" required pattern="\d{4}" title="Ano com 4 dígitos" />

    <label for="isbn">ISBN:</label>
    <input type="text" name="isbn" id="isbn" required />

    <button type="submit" class="button-submit">Cadastrar Livro</button>
  </form>

  <footer>
    Biblioteca Unicesumar - Sistema Web · 2025
  </footer>
</div>

<!-- Lista de livros exibida dinamicamente via Servlet -->
<%= request.getAttribute("htmlLivros") %>

</body>
</html>
