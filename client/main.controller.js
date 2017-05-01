var x=0;
var app= angular.module('plunker',['ngRoute']);
         
app.config(['$routeProvider',function($routeProvider){
    $routeProvider
            .when('/movie-list',{
                templateUrl: 'movie-list.tmpl.html',
                controller: 'movielist'
            })
            .when('/movie-detail',{
                templateUrl: 'movie-detail.tmpl.html',
                controller: 'MovieDetail'
            })
            .when('/adduser',{
                templateUrl: 'adduser.html',
                controller: 'moviedetail'
            })
            .when('/sortby',{
                templateUrl: 'sortby.html',
                controller: 'moviedetail'
            })
            .otherwise({
               redirectTo: '/movie-list'
            });
        
}]);

app.controller('movielist', function($scope) {
            $scope.message = "This page will be used to display movie-lsit form";
         });
app.controller('moviedetail', function($scope) {
            $scope.message = "This page will be used to display movie-detail form";
         });         
         
app.controller('MovieDetail', function(userService,$routeParams){
            var movieVm = this;
            init();
            function init(){
                userService
                        .getUser($routeParams.title)
                        .then(function(data){
                            movieVm.movie=data;
                        }, function(error){
                            console.log(error);
                        })
            }
});

app.controller('UsersCtrl', function(userService){
    console.log("Hello World");   
    var mainVm=this;
    
        mainVm.title = 'Angular Example';
        userService.getUsers().then(function(response){
                   mainVm.users = response.data;
                   console.log(mainVm.users);
            });
      mainVm.addUser = function(){
        mainVm.newUser.id = mainVm.users.length + 1;
        mainVm.users.unshift(mainVm.newUser);
        
      };
      
      mainVm.deleteUser = function(id){
          console.log(id +" "+ mainVm.users.length);
//          _.remove(mainVm.user, function(u){        console.log(mainVm.users);

//              return u.id === id;
//      });
        for(x=0; x<mainVm.users.length;x++){
            if(mainVm.users[x].id===id){
                mainVm.users.splice(x,1);
                break;
            }
            
        }
        
      };
});
