//(function(){
//    'use strict';
 // var app=angular.module('plunker',[]);
  app.service('userService', function($http){
    //    userService.$inject = ['$http'];
   
    
        var self = this;
        self.getUsers = function(){
          //  return $http.get('https://learn.egen.io/courses/movielist.json')
          return $http.get('movielist.json');
//                  .then(function(response){
//                        return response.data;
//                      },function(error){
//                        return $q.reject(error.statusCode);
//          });
        };
    });
//})();