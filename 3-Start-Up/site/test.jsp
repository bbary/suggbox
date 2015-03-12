<table border='2' style="margin-left: 600px;font-size: 20px;font-family: cursive;color: blue" bordercolor="#09A7F5" >
	<tr>
		<td>site</td>
		<td>téléphone</td>
		<td>abrégé</td>
 
	</tr>
	<%
	  ArrayList list =new ArrayList();
	  list=(ArrayList)request.getAttribute("maListe");
	  Iterator monIterator=list.iterator();
	  while(monIterator.hasNext()){
		  site Site =(site)monIterator.next();
	%>	  
		<tr>
		   <td><%=Site.getLibelle() %>  </td>
		   <td><%=Site.getNumero() %></td>
		   <td><%=Site.getDirect() %></td>
		</tr>  
	<% 	
	  }
	%>
 
 
</table>