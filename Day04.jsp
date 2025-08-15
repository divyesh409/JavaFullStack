<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%@page import="javax.servlet.http.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student & Admin Portal</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container mt-4">

<!-- ================= STUDENT REGISTER ================= -->
<div class="row mb-5">
  <div class="col-lg-6">
    <h3>Student Register</h3>
    <form class="form-control p-3" action="#" method="get">
        <input class="form-control mb-2" type="text" name="name" placeholder="Name" required/> 
        <input class="form-control mb-2" type="email" name="email" placeholder="Email" required/>
        <input class="form-control mb-2" type="password" name="password" placeholder="Password" required/>
        <button class="btn btn-success" name="submit" type="submit">Register</button>
    </form>
  </div>
</div>

<%
    // Handle student registration
    if (request.getParameter("submit") != null) {
        String Name = request.getParameter("name");
        String Email = request.getParameter("email");
        String Pass = request.getParameter("password");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/collegeStudent", "root", "Divyesh@2003");
            PreparedStatement pst = con.prepareStatement("INSERT INTO student_table (name,email,password) VALUES (?,?,?)");
            pst.setString(1, Name);
            pst.setString(2, Email);
            pst.setString(3, Pass);
            pst.executeUpdate();
            out.print("<div class='alert alert-success mt-2'>Registration Successful!</div>");
            con.close();
        } catch(Exception e) { out.print("<div class='alert alert-danger mt-2'>Error: "+e.getMessage()+"</div>"); }
    }
%>


<!-- ================= STUDENT LOGIN ================= -->
<div class="row mb-5">
  <div class="col-lg-6">
    <h3>Student Login</h3>
    <form class="form-control p-3" action="#" method="get">
        <input class="form-control mb-2" type="email" name="email1" placeholder="Email" required/>
        <input class="form-control mb-2" type="password" name="password1" placeholder="Password" required/>
        <button class="btn btn-primary" name="login" type="submit">Login</button>
    </form>
  </div>
  <div class="col-lg-6">
    <h3>Student Session Data</h3>
    <%
    if (request.getParameter("login") != null) {
        String Email1 = request.getParameter("email1");
        String Pass1  = request.getParameter("password1");

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/collegeStudent", "root", "Divyesh@2003");
        PreparedStatement ps1 = con1.prepareStatement("SELECT * FROM student_table WHERE email=? AND password=?");
        ps1.setString(1, Email1);
        ps1.setString(2, Pass1);
        ResultSet rs1 = ps1.executeQuery();

        if (rs1.next()) {
            HttpSession ses = request.getSession();
            ses.setAttribute("name", rs1.getString("name"));
            ses.setAttribute("email", rs1.getString("email"));
            ses.setAttribute("pass", rs1.getString("password"));
            out.print("<div class='alert alert-success'>Login Successful!</div>");
        } else {
            out.print("<div class='alert alert-danger'>Invalid Email or Password!</div>");
        }
        con1.close();
    }

    String Name3 = (String) session.getAttribute("name");
    String Email3 = (String) session.getAttribute("email");
    String Pass3 = (String) session.getAttribute("pass");

    if (Name3 != null) {
    %>
        <p><b>Name:</b> <%= Name3 %></p>
        <p><b>Email:</b> <%= Email3 %></p>
        <p><b>Password:</b> <%= Pass3 %></p>
    <% } %>
  </div>
</div>


<!-- ================= ADMIN LOGIN ================= -->
<div class="row mb-5">
  <div class="col-lg-6">
    <h3>Admin Login</h3>
    <form class="form-control p-3" action="#" method="get">
        <input class="form-control mb-2" type="email" name="email2" placeholder="Admin Email" required/>
        <input class="form-control mb-2" type="password" name="password2" placeholder="Password" required/>
        <button class="btn btn-dark" name="adminlogin" type="submit">Login</button>
    </form>
  </div>
</div>

<%
if (request.getParameter("adminlogin") != null) {
    String Email4 = request.getParameter("email2");
    String Pass4  = request.getParameter("password2");

    if ("divyeshkachave14@gmail.com".equals(Email4) && "Divyesh@2003".equals(Pass4)) {
        out.print("<div class='alert alert-success'>Admin Login Successful!</div>");

        // Show all registered students (only for Admin)
%>
        <h3>All Registered Students</h3>
        <table class="table table-bordered">
            <tr><th>Name</th><th>Email</th><th>Password</th></tr>
            <%
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/collegeStudent", "root", "Divyesh@2003");
                PreparedStatement ps = con.prepareStatement("SELECT * FROM student_table");
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
            %>
                <tr>
                    <td><%= rs.getString("name") %></td>
                    <td><%= rs.getString("email") %></td>
                    <td><%= rs.getString("password") %></td>
                </tr>
            <% }
              con.close();
            } catch(Exception e) { out.print("<p style='color:red'>"+e.getMessage()+"</p>"); }
            %>
        </table>
<%
    } else {
        out.print("<div class='alert alert-danger'>Invalid Admin Credentials!</div>");
    }
}
%>

</body>
</html>
