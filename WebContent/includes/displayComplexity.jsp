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
<%@page import="com.Model.CodeFile"%>
<%@page import="com.Model.Line"%>

<%
	
	FileController.startAnalyzing();

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
		for(CodeFile file: FileController.GetFileList()) {
			
			for(Line line: file.getLines()) {
	%>

	<tr>
		<td> <%= line.getLineIndex() %> </td>
		<td> <%= line %> </td>
		<td> <%= line.getSizeComplexity().keywordsToString() %> </td>
		
		<%
			int TW = line.getRecursion().getScore();
			int Cps = line.getSizeComplexity().getScore() * TW;
		%>
		
		<td> <%= line.getSizeComplexity().getScore() %> </td>
		<td> <%= line.getNesting().getScore() %> </td>
		<td> <%= TW %> </td>
		<td> <%= Cps %> </td>
		<td> <%= line.getRecursion().getScore() %> </td>
	</tr>
	
	<% 
			}
		} 
	%>
</table>