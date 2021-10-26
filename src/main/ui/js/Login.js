/*
 * There are 2 "buttons" to listen for on the login page, one
 * to login the user, another to create one. They both have their
 * own functions but ultimately lead to the 'members' page. There
 * is now a session storage device to store the users ssn so the
 * program can use it throughout to make other changes without
 * repeatedly requesting the user to input it. Also, if an admin
 * uses the ss of "0000" and password of "0000", they will be
 * sent to the admin page.
 */

    var form = document.getElementById("login-form");
    insub.addEventListener("click", function(event) {
    event.preventDefault();
    if((loginssn.value == 0000)&&(loginpass.value == 0000)){
    window.location.href = "Admin.html";
    }
    else{
    console.log(loginssn.value);
    console.log(loginpass.value);
    marshall1(loginssn.value, loginpass.value);
    }});

    var form = document.getElementById("create-form");
    createSub.addEventListener("click", function(event) {
    event.preventDefault();
    console.log(first.value);
    console.log(last.value);
    console.log(pass.value);
    console.log(ssn.value);
    marshall2(first.value, last.value, pass.value, ssn.value);
    });

    async function marshall1(lSsn, lPass){
        let user = {
            ssn : lSsn,
            password : lPass,
        }

        let response = await fetch("http://localhost:8080/P1-Brown-Eads-Iyer/user", {
            method: "GET",
        });

        if(response.status != 200){
            document.getElementById("loginForm").reset();
            alert("Login Failed");
        }
        else{
            sessionStorage.setItem("SSN", loginssn.value)
            alert(sessionStorage.getItem("SSN"));
            window.location.href = "Member.html";
        }
    }
    async function marshall2(cFirst, cLast, cPass, cSsn){
        let user = {
            fName : cFirst,
            lName : cLast,
            password : cPass,
            ssn : cSsn
        }

        let response = await fetch("http://localhost:8080/P1-Brown-Eads-Iyer/user", {
            method: "POST",
            body: JSON.stringify(user)
        });

        if(response.status != 202){
            document.getElementById("loginForm").reset();
            alert("Login Failed");
        }
        else{
            sessionStorage.setItem("SSN", ssn.value)
            window.location.href = "Member.html";
        }
    }
