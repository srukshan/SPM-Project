<%@page import="com.sun.org.apache.xpath.internal.compiler.Keywords"%>
<%@page import="com.fileRead.*"%>
<%@page import="java.util.List"%>
<%@page import="java.util.*"%>
<%@page import="java.nio.file.*"%>
<%@page import="java.util.*"%>
<%@page import="java.util.Iterator"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
		FileReadController frc = new FileReadController();

		String action = "" + request.getParameter("action");
		System.out.println(">>>>>>>>>>>>>>>>>>>>>action>>>>>>>>>>" + action);

		String file_name = "" + request.getParameter("fileName");
		System.out.println(file_name);
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
			List l = frc.readFileInList(file_name);
			System.out.println(l.size());
			Iterator<String> itr = l.iterator();

			String line = null;

			String[] keywords = new String[] { "import", "void", "double", "int", "float", "String", "println", "cout",
					"if", "for", "while", "switch", "case", "\n", "endl" };
			int keywordSize = keywords.length;

			String[] ariOperators = new String[] { "+", "-", "*", "/", "%", "++", "--" };
			int aoSize = ariOperators.length;

			String[] numbers = new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "0" };
			int numSize = numbers.length;

			String[] relOperators = new String[] { "==", "!=", ">", "<", ">=", "<=" };
			int roSize = relOperators.length;

			String[] logicOperators = new String[] { "&&", "||", "!" };
			int loSize = logicOperators.length;

			String[] assignOperators = new String[] { "+=", "-=", "*=", "/=", ">>>=", "|=", "&=", "<<=", ">>=", "%=",
					"^=" };
			int asgnSize = assignOperators.length;

			String[] bitwiseOperators = new String[] { "|", "^", "~", "<<", ">>", "<<<", ">>>" };
			int bitSize = bitwiseOperators.length;

			int j = 0;
			int i = 0;

			String k[] = null;
			while (itr.hasNext()) {
				j++;
				String a = itr.next();

				line = a.replace("(", " ");
				line = line.replace(")", " ");
				line = line.replace(";", " ");
				int Cs = 0;
				int Cps = 0;
				int Ctc = 0;
				int Ci = 0;
				int TW = 0;
				int Cnc = 0;
				int Cr = 0;

				String KeyWords = "";
				for (i = 0; i < keywordSize; i++) {
					if (line.contains(keywords[i])) {
						System.out.print(keywords[i] + " , ");
						KeyWords += keywords[i] + " , ";
						Cs++;
					}
				}

				for (i = 0; i < aoSize; i++) {
					int x = 0;
					String[] split = line.split(" ");

					for (x = 0; x < split.length; x++) {
						if (split[x].equals(ariOperators[i])) {
							System.out.print(ariOperators[i] + " , ");
							KeyWords += ariOperators[i] + " , ";
							Cs++;
						}
					}
				}
				
				String numberRep = a.replaceAll("[^0-9]+", " ");
				int numberRepCount = numberRep.trim().split(" ").length;
				Cs += numberRepCount;
				numberRep = numberRep.trim();
				String[] splits = numberRep.split(" ");

				for (int x = 0; x < numberRepCount; x++) {
					KeyWords += splits[x] + " , ";
				}

				/* for (i = 0; i < numSize; i++) {
					int x = 0;
					String[] split = line.split(" ");
				
					for (x = 0; x < split.length; x++) {
						if (split[x].equals(numbers[i])) {
							System.out.print(numbers[i] + " , ");
							KeyWords += numbers[i] + " , ";
							Cs++;
						}
					}
				} */

				for (i = 0; i < roSize; i++) {
					int x = 0;
					String[] split = line.split(" ");

					for (x = 0; x < split.length; x++) {
						if (split[x].equals(relOperators[i])) {
							System.out.print(relOperators[i] + " , ");
							KeyWords += relOperators[i] + " , ";
							Cs++;
						}
					}
				}

				for (i = 0; i < loSize; i++) {
					int x = 0;
					String[] split = line.split(" ");

					for (x = 0; x < split.length; x++) {
						if (split[x].equals(logicOperators[i])) {
							System.out.print(logicOperators[i] + " , ");
							KeyWords += logicOperators[i] + " , ";
							Cs++;
						}
					}
				}

				for (i = 0; i < asgnSize; i++) {
					int x = 0;
					String[] split = line.split(" ");

					for (x = 0; x < split.length; x++) {
						if (split[x].equals(assignOperators[i])) {
							System.out.print(assignOperators[i] + " , ");
							KeyWords += assignOperators[i] + " , ";
							Cs++;
						}
					}
				}
				for (i = 0; i < bitSize; i++) {
					int x = 0;
					String[] split = line.split(" ");

					for (x = 0; x < split.length; x++) {
						if (split[x].equals(bitwiseOperators[i])) {
							System.out.print(bitwiseOperators[i] + " , ");
							KeyWords += bitwiseOperators[i] + " , ";
							Cs++;
						}
					}
				}
		%>

		<tr>
			<td><%=j%></td>
			<td><%=a%></td>
			<td><%=KeyWords%></td>
			<%
				TW= Ctc +Cnc +Ci;
				Cps = Cs * TW;
			%>
			<td><%=Cs%></td>
			<td><%=Ctc%></td>
			<td><%=Cnc%></td>
			<td><%=Ci%></td>
			<td><%=TW%></td>
			<td><%=Cps%></td>
			<td><%=Cr%></td>
			
		</tr>


		<%
			//System.out.println(i+" "+itr.next());
				System.out.println(a);
			}
		%>
	</table>
</body>
</html>