<html>
<head>
<title>Home</title>
<META HTTP-EQUIV="Pragma" CONTENT="no-cache">
<meta content="text/html; charset=UTF-8" http-equiv="content-type">
			<link type="text/css" rel="stylesheet" href="mlm.css">
			<link rel="stylesheet" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.16/themes/base/jquery-ui.css" type="text/css" media="all" />
			<link rel="stylesheet" href="http://static.jquery.com/ui/css/demo-docs-theme/ui.theme.css" type="text/css" media="all" />
			<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js" type="text/javascript"></script>
			<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.16/jquery-ui.min.js" type="text/javascript"></script>
			<script src="http://jquery-ui.googlecode.com/svn/tags/latest/external/jquery.bgiframe-2.1.2.js" type="text/javascript"></script>
			<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.16/i18n/jquery-ui-i18n.min.js" type="text/javascript"></script>
</head>
<script>
		function getChildren(a) {
			url = 'multiple.php?id='+a+"&t="+new Date();
//			alert(url);
			$.get(url, function(data) {
//				alert(data);
				$('#View'+a).html(data);
			});
		}
		function getSingle(a) {
			url = 'view.php?id='+a+"&t="+new Date();
//			alert(url);
			$.get(url, function(data) {
//				alert(data);
				$('#View').html(data);
			});
		}
		function searchVal() {
			url = 'result.php?firstname='+$('#firstname').val()+'&lastname='+$('#lastname').val()+"&t="+new Date();
			$.get(url, function(data) {
				alert(data);
				$('#SearchResult').html(data);
			});
		}
		function addRec(a) {
			$("#aparentid").val(a);
			$("#add").dialog('open');
		}
		function trueAdd() {
			str = $("input").serialize();
			url = 'trueAdd.php?'+str+"&t="+new Date();
//			alert(url);
			$.get(url, function(data) {
//				alert(data);
				$("#add").dialog('close');
			});
		}
		function updateRec(a,first,last,plan,user,pass) {
			$("#upersonid").val(a);
			$("#ufirstname").val($.trim(first+""));
			$("#ulastname").val($.trim(last+""));
			$("#uplantype").val($.trim(plan+""));
			$("#uusername").val($.trim(user+""));
			$("#upassword").val($.trim(pass+""));
			$("#update").dialog('open');
		}
		function trueUpdate() {
			str = $("input").serialize();
			url = 'trueUpdate.php?'+str+"&t="+new Date();
			alert(url);
			$.get(url, function(data) {
				alert(data);
				$("#update").dialog('close');
			});
		}
</script>
<body>
<form name="test">
<table width="100%" border="1">
	<tr>
		<td colspan="2">
		<center>
		<h1>Multi Level Marketing</h1>
		</center>
		</td>
	</tr>
	<tr valign="top">
		<td class="left">
			<table>
				<tr>
					<td colspan="2"><h2>Search Panel</h2></td>
				</tr>
				<tr>
					<td>First Name:</td>
					<td><input type="text" name="firstname" id="firstname" style=width:150px;/><br />
					</td>
				</tr>
				<tr>
					<td>Last Name:</td>
					<td><input type="text" name="lastname" id="lastname" style=width:150px;/><br /></td>
				</tr>
				<tr>
					<td colspan="2"><input type="button" value="Search" onclick="searchVal()"></td>
				</tr>
				<tr>
					<td colspan="2">
						<div id="SearchResult"></div>
					</td>
				</tr>
			</table>
		</td>
		<td class="right">
			<div id="View"></div>
		</td>
	</tr>
	<tr>
		<td colspan="2" class="bottom">Copyright
		� 2011 mysoftlabs.com</td>
	</tr>
</table>

</form>
<div style="visibility:hidden">
	<div id="add">
		<input type = "hidden" name="aparentid" id="aparentid"/>
		<table>
			<tr>
				<td>Lastname: </td>
				<td><input type = "text" name="alastname"/></td>
			</tr>
			<tr>
				<td>Firstname: </td>
				<td><input type = "text" name="afirstname"/></td>
			</tr>
			<tr>
				<td>Username: </td>
				<td><input type = "text" name="ausername"/></td>
			</tr>
			<tr>
				<td>Password: </td>
				<td><input type = "text" name="apassword"/></td>
			</tr>
			<tr>
				<td>Plan: </td>
				<td>
					<select name="aplantype" id="aplantype">
						<option value="Plan A">Plan A</option>
						<option value="Plan B">Plan B</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>
				</td>
				<td>
					<input type="button" value="Save" onclick="trueAdd()"/>
				</td>
			</tr>
		</table>
	</div>
	<div id="update">
		<input type = "hidden" name="upersonid" id="upersonid"/>
		<table>
			<tr>
				<td>Lastname: </td>
				<td><input type = "text" name="ulastname" id="ulastname"/></td>
			</tr>
			<tr>
				<td>Firstname: </td>
				<td><input type = "text" name="ulastname" id="ulastname"/></td>
			</tr>
			<tr>
				<td>Username: </td>
				<td><input type = "text" name="uusername" id="uusername"/></td>
			</tr>
			<tr>
				<td>Password: </td>
				<td><input type = "text" name="upassword" id="upassword"/></td>
			</tr>
			<tr>
				<td>Plan: </td>
				<td>
					<select name="uplantype" id="uplantype">
						<option value="Plan A">Plan A</option>
						<option value="Plan B">Plan B</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>
				</td>
				<td>
					<input type="button" value="Save" onclick="trueUpdate()"/>
				</td>
			</tr>
		</table>
	</div>
</div>
<script>
$("#add").dialog({ autoOpen: false, title: 'Add Record' });
$("#update").dialog({ autoOpen: false, title: 'Update Record' });
</script>
</body>
</html>
