/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
  var x=0; 
//  var app= angular.module('plunker',[]);
    app.controller('UsersCtrl', function(userService){
       var mainVm=this;
   
        mainVm.title = 'Angular Example';
        mainVm.users={};
        mainVm.searchText="";
        userService.getUsers().then(function(xyz){
                   mainVm.users = xyz.data;
                   console.log(mainVm.users);
//                   mainVm.disp=1;
            });
      mainVm.addUser = function(){
        mainVm.newUser.id = mainVm.users.length + 1;
        mainVm.users.unshift(mainVm.newUser);
        console.log(mainVm.users);
        
      };
      
      mainVm.deleteUser = function(id){
          console.log(id +" "+ mainVm.users.length);

        for(x=0; x<mainVm.users.length;x++)
        {
            if(mainVm.users[x].id===id){
                mainVm.users.splice(x,1);
                break;
            }
            
        }
      };
 });  

