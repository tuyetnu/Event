function previewImg() {
    var m = document.getElementById("inputfile");
    var n = document.getElementById("img");
    n.src = m.value;
}
function checkEmpty() {
    t = document.getElementById("user");
    if (t.value.length == 0) {
        alert("Username must not be blank!");
        return false;
    }
    t = document.getElementById("pass");
    if (t.value.length == 0) {
        alert("Password must not be blank!");
        return false;
    }
}
function checkEmptyRegister() {
    t = document.getElementById("user");
    if (t.value.length == 0) {
        alert("Username must not be blank!");
        return false;
    }
    t = document.getElementById("name");
    if (t.value.length == 0) {
        alert("Fullname must not be blank!");
        return false;
    }
    t = document.getElementById("pass");
    if (t.value.length == 0) {
        alert("Password must not be blank!");
        return false;
    }
    k = document.getElementById("confirm");
    if (k.value.length == 0) {
        alert("Confirm must not be blank!");
        return false;
    }
    if (k.value != t.value) {
        alert("Confirm must match password be blank!");
        return false;
    }
}

function checkPost() {
    var today = new Date();
    var startDate = document.getElementById("startDate");
    alert(today + "  " + startDate);
    return false;
}