Sistema Web para cadastro de livros da Biblioteca Unicesumar.

Tecnologias utilizadas
Java 17

Servlets (Jakarta)

JSP

HTML/CSS

Maven

Apache Tomcat 11

Funcionalidades
Cadastro de livros (título, autor, ano, ISBN)

Listagem dos livros cadastrados

Exclusão de livros da lista

Validação de entradas

Exibição de mensagens de erro

Organização em camadas (MVC)
Model: Livro.java

Controller: LivroServlet.java

View: index.jsp

Utilitários: gen_html_book.java, gen_ISBN.java

Exceções: LivroException.java

Requisitos atendidos
Padrão MVC

Servlets e JSP

Validações completas

Separação de responsabilidades

Código limpo e legível
