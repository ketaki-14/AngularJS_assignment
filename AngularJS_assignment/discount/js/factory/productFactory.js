var fa = angular.module('app.factories',[])
  fa.factory('productFactory', function($http)
        {
          var product = {};
          var processResponse = function (res) {
            console.log(res)
            return res.data
          }
          

            product.getData = function(){
                return $http.get('../lang/data.json').then(processResponse)
            }

            return product
        });