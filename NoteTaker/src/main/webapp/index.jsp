<%@page import="org.hibernate.Query"%>
<%@page import="java.util.List"%>
<%@page import="com.helper.FactoryProvider"%>
<%@page import="org.hibernate.Session"%>
<%@page import="com.todo.Note"%>
<html>
    <head>
    <%@include file="all_js_css.jsp" %>
        <title>NoterMaker</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
    
   <%--<%@include file="navbar.jsp" %> --%>
   
   <%
   
   Session s=FactoryProvider.getFactory().openSession();
   Query q=s.createQuery("from Note");
   List<Note> list=q.list();
   
   //int noteId=Integer.parseInt(request.getParameter("noteId").trim());
   //Session s1 =FactoryProvider.getFactory().openSession();
   //Note note=(Note)s1.get(Note.class, noteId);
   
   
  
   
   %>
        <% for(Note note:list){
        %>
        
        
      									<form action="UpdateServlet" method="get" enctype="multipart/formdata">
      									
                                                <!-- Modal -->
                                                <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                                  <div class="modal-dialog">
                                                    <div class="modal-content">
                                                      <div class="modal-header">
                                                        <h5 class="modal-title" id="exampleModalLabel">Update Details</h5>
                                                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                                      </div>
                                                      <div class="modal-body mb-1">
                                                  
                                                        <input class="form-control" type="text" value="<%= note.getCustomer_name()  %>" aria-label="default input example"><br>
                                                        <input class="form-control" type="text" value="<%= note.getContent() %>" aria-label="default input example"><br>
                                                        <input class="form-control" type="text" value="<%= note.getMobile_number() %>" aria-label="default input example"><br>
                                                      </div>
                                                      <div class="modal-footer">
                                                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                                        <a type="button" class="btn btn-success" href="UpdateServlet?note_id=<%= note.getId() %>">Save changes</a>
                                                      </div>
                                                    </div>
                                                  </div>
                                                </div>    
												</form> 
												
												
												<% } %> 
        <section class="vh-100" style="background-color: #eee;">
            <div class="container py-5 h-100">
                <div class="row d-flex justify-content-center align-items-center h-100">
                    <div class="col col-lg-9 col-xl-9">
                        <div class="card rounded-4">
                            <div class="card-body p-4">

                                <h4 class="text-center my-3 pb-3">Noter Maker App</h4>

                                <form action="SaveNoteServlet" method="post" enctype="multipart/form-data"
                                    class="row row-cols-lg-auto g-3 justify-content-center align-items-center mb-4 pb-2" >
                                    <div class="form-outline">
                                        <input type="text" id="form1" class="form-control" name="customer_name" required/>
                                        <label class="form-label" for="form1" >Customer Name</label>
                                    </div>
                                    <div class="col-12">

                                        <div class="form-outline">
                                            <input type="text" id="form1" class="form-control" name="content" required />
                                            <label class="form-label" for="form1" >Todo list</label>
                                        </div>

                                    </div>
                                    <div class="form-outline">
                                        <input type="tel" id="form1" class="form-control" name="mobile_number" required />
                                        <label class="form-label" for="form1" >Mobile number</label>
                                    </div>

                                    <div class="col-12">
                                        <button type="submit"
                                            class="btn btn-primary" onclick="save()">Save</button>
                                            <!-- <button onclick="alert1()" class="btn btn-primary" type="button">check</button> -->
                                    </div>
                                </form>
                                

                                <table class="table table-hover" id="table">
                                    <thead>
                                        <tr>
                                            <th scope="col">S.No</th>
                                            <th scope="col">Customer Name</th>
                                            <th scope="col">Todo item</th>
                                            <th scope="col">Mobile Number</th>
                                            <th scope="col">Date</th>
                                            <th scope="col">Status</th>
                                            <th scope="col">Actions</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <%
                                    for(Note note:list)
                                    {
                                    %>
                                        <tr>
                                                <td><% out.println(note.getId()); %></td>
                                                <td><% out.println(note.getCustomer_name()); %></td>
                                                <td><%out.println(note.getContent()); %></td>
                                                <td><%out.println(note.getMobile_number()); %></td>
                                                <td><% out.println(note.getAddedDate()); %></td>
                                                <td>In progress</td>
                                                <td><!-- <button type="submit" id="edit"class="edit btn btn-success">Edit</button>  -->
                                                <!-- Button Edit modal -->
                                                <a type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
                                                  Edit
                                                </a>
												
                                                    <a type="button"
                                                    class="btn btn-danger" href="DeleteServlet?note_id=<%= note.getId() %>" onclick="delete1()">Delete</a>
                                                </td>
                                                </tr>
                                                <% }
                                    			
                                    			s.close();
                                                %>
                                    </tbody>
                                </table>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </body>
    <!-- MDB -->
    <%@include file="all_js_css.jsp" %>
 

</html>