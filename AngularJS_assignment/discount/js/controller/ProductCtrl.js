var fa = angular.module('app.controller',[])
  fa.controller('ProductCtrl',['productFactory','$scope',function(productFactory,$scope)
          {
            $scope.product={};
            setInterval(function(){
            productFactory.getData()
            .then(function(res){
            	console.log("hello");
              $scope.product = res;
              console.log($scope.product);
              })},50000)

console.log("hello");
          }]);
