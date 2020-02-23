/**
 * Created by yanchao on 2020/2/23.
 */


function breakWork() {
    var input = $("#input").val();
    input = input.replace(/\s+/g, "");
    if (input == null || input == "") {
        alert("please input the word")
        return false;
    }
    console.log(input);
    $.ajax({
        type: "GET",
        contentType: "application/json;charset=UTF-8",
        url: "/word/break/" + input,
        success: function (result) {
            console.log(result);
            if (result.code == 200) {
                $("#output").text("");
                for(var i = 0; i < result.data.length; i++){
                    //$("#output").text(result.data[i]);
                    $("#output").append("<span>"+result.data[i]+"</span><br>");//新增
                }
            } else {
                $("#output").text("");
                alert(result.msg)
            }
        },
        error: function (e) {
            alert("unknow internal error")
        }
    });
}


function breakUserWork() {
    var input = $("#input").val();
    input = input.replace(/\s+/g, "")

    if (input == null || input == "") {
        alert("please input the word")
        return false;
    }
    console.log(input);
    $.ajax({
        type: "GET",
        contentType: "application/json;charset=UTF-8",
        url: "/word/user/break/" + input,
        success: function (result) {
            console.log(result);
            if (result.code == 200) {
                $("#output").text("");
                for(var i = 0; i < result.data.length; i++){
                    //$("#output").text(result.data[i]);
                    $("#output").append("<span>"+result.data[i]+"</span><br>");//新增
                }
            } else {
                $("#output").text("");
                alert(result.msg)
            }
        },
        error: function (e) {
            alert("unknow internal error")
        }
    });
}


function breakUserLocalWork() {
    var input = $("#input").val();
    input = input.replace(/\s+/g, "");
    if (input == null || input == "") {
        alert("please input the word")
        return false;
    }
    console.log(input);
    $.ajax({
        type: "GET",
        contentType: "application/json;charset=UTF-8",
        url: "/word/userLocal/break/" + input,
        success: function (result) {
            console.log(result);
            if (result.code == 200) {
                $("#output").text("");
                for(var i = 0; i < result.data.length; i++){
                    //$("#output").text(result.data[i]);
                    $("#output").append("<span>"+result.data[i]+"</span><br>");//新增
                }
            } else {
                $("#output").text("");
                alert(result.msg)
            }
        },
        error: function (e) {
            alert("unknow internal error")
        }
    });
}


function save() {
    var input = $("#input").val();
    input = input.replace(/\s+/g, "");
    if (input == null || input == "") {
        alert("please input the word")
        return false;
    }
    $.ajax({
        type: "POST",
        ContentType:"application/x-www-form-urlencoded;charset=UTF-8",
        url: "/word/user/save",
        data: {
            words: input
        },
        traditional: true,
        success: function (result) {
            console.log(result);
            if (result.code == 200) {
                alert(result.msg)
            } else {
                alert(result.msg)
            }
        },
        error: function (e) {
            alert("unknow internal error")
        }
    });
}