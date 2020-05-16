//可以用fiddler来理解request格式
// 1. post json , set contentType, set data: JSON.stringify(obj)
// server @RequestBody Bean bean
$.ajax({
    url: "/postData",
    type: "POST",
    data: JSON.stringify({name: "tom", age: 22, other: "abcde"}),
    contentType: "application/json", //指定，以解决Content type 'application/x-www-form-urlencoded;charset=UTF-8' not supported
    success: function(data, textStatus, jqXHR) {
        console.log(arguments.length, arguments);
        console.log(data);
        alert(1);
    },
    error: function (errorInfo) {
        console.log(errorInfo);
    }
});

// 2. post form， set data: obj
// server Bean bean， no @RequestBody
$.ajax({
    url: "/postData2",
    type: "POST",
    data: {name: "tom", age: 22, other: "abcde"},
    //contentType: "application/json", //指定，以解决Content type 'application/x-www-form-urlencoded;charset=UTF-8' not supported
    success: function(data, textStatus, jqXHR) {
        console.log(arguments.length, arguments);
        console.log(data);
        alert(2);
    },
    error: function (errorInfo) {
        console.log(errorInfo);
    }
})