<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="myApp">
<head>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.min.js"></script>
<script>
var app = angular.module("myApp", []);
app.controller("myController", function() {
  this.members = [
    { name:"Tanaka", age:16 },
    { name:"Yamada", age:26 },
    { name:"Suzuki", age:36 },
  ];
  this.onAdd = function() {
    this.members.push({ name:this.name, age:this.age });
    this.name = this.age = "";
  };
  this.onDel = function() {
    for (var i = 0; i < this.members.length; i++) {
      if (this.members[i].checked) {
        this.members.splice(i--, 1);
      }
    }
  };
});
</script>
</head>
<body ng-controller="myController as myCtrl">
 <div>
  <input type="text" ng-model="myCtrl.name">(<input type="text" ng-model="myCtrl.age">)
  <button ng-click="myCtrl.onAdd()">Add</button>
 </div>
 <div ng-repeat="member in myCtrl.members">
  <input type="checkbox" ng-model="member.checked">{{member.name}}({{member.age}})
 </div>
 <div><button ng-click="myCtrl.onDel()">Del</button></div>
 <hr><pre>{{myCtrl|json}}</pre><hr>
</body>
</html>