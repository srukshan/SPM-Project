<%@page import="com.Controller.Complexity.TypeOfComplexity"%>
<%@page import="com.Model.Complexity"%>
<%@page import="com.Controller.Complexity.SizeComplexity"%>
<%@page import="com.sun.org.apache.xpath.internal.compiler.Keywords"%>
<%@page import="com.Controller.*"%>
<%@page import="java.util.List"%>
<%@page import="java.util.*"%>
<%@page import="java.nio.file.*"%>
<%@page import="java.util.*"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.Model.File"%>

<%
	int lineCount = 0;
	String file_name = request.getParameter("fileName");
	File file = FileController.readFileInList(file_name);
	Iterator<String> itr = file.GetLineIterator();
	Memorizer memorizer = new Memorizer();
%>
<table border=1 width=100%>
	<tr>
		<td>Line</td>
		<td>Program Statement</td>
		<td>Tokens identified</td>
		<td>CS</td>
		<td>Ctc</td>
		<td>Cnc</td>
		<td>Ci</td>
		<td>TW</td>
		<td>Cps</td>
		<td>Cr</td>
	</tr>
	<%
		while (itr.hasNext()) {
			lineCount++;
			String line = itr.next();
			Complexity sizeComplexity = new SizeComplexity(line).GetComplexity();
			memorizer.Memorize(line);
			Complexity typeComplexity = new TypeOfComplexity(line).GetComplexity();
	%>

		<tr>
			<td><%=lineCount%></td>
			<td><%=line%></td>
			<td><%=sizeComplexity.getKeywords()%></td>
			<%
				int TW= typeComplexity.getScore() +memorizer.GetNestingComplexity().getScore() +memorizer.GetInheritanceComplexity().getScore();
				int Cps = sizeComplexity.getScore() * TW;
			%>
			<td><%=sizeComplexity.getScore()%></td>
			<td><%=typeComplexity.getScore()%></td>
			<td><%=memorizer.GetNestingComplexity().getScore()%></td>
			<td><%=memorizer.GetInheritanceComplexity().getScore()%></td>
			<td><%=TW%></td>
			<td><%=Cps%></td>
			<td><%=memorizer.GetRecursionComplexity().getScore()%></td>
			
		</tr>
	<% } %>
</table>