function check(form)
{
 if(form.userid.value == "myuserid" && form.pswrd.value == "mypswrd")
  {
    window.open('target.html')
  }
 else
 {
   alert("Error Password or Username")
  }
}