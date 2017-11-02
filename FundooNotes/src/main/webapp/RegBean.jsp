<jsp:useBean  id = "bean" class = "com.bridgeIt.fundooNotes.model.UserModel" scope = "request" >
<jsp:setProperty name = "bean" property = "rEmail"/>
<jsp:setProperty name = "bean" property = "rPassWord"/>
<jsp:setProperty name = "bean" property = "rPhnNo"/>
</jsp:useBean>
<jsp:forward  page = "Registration.do"/>		
