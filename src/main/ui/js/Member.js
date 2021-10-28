/*
 * Again, we start with the event listeners for the 'buttons',
 * followed by the functions required to check a user in for their
 * flight and to cancel their ticket. Unlike other pages, it stays
 * here just in case the user has more than one ticket (to check in
 * or cancel). If they wish to purchase any or more tickets, theres
 * a button for that too, it just sends them to the flight page. The
 * log out button will clear the system storage and send the user
 * back to the log in screen.
 */

var form = document.getElementById("checkin-form");
checkButt.addEventListener("click", function(event) {
event.preventDefault();
console.log(checkinField.value);
marshall1(checkinField.value);
});

var form = document.getElementById("cancel-form");
cancelButt.addEventListener("click", function(event) {
event.preventDefault();
console.log(cancelField.value);
marshall2(cancelField.value);
});

logoutButt.addEventListener("click", function (event) {
    event.preventDefault();
    sessionStorage.clear();
    window.location.href = "Login.html";
});

async function marshall1(checkTik){
    let checkTicket = {
        ticket_num : checkTik,
        check_in : true
    }

    let response = await fetch("http://localhost:8080/P1-Brown-Eads-Iyer/booking", {
    //let response = await fetch("Proj1eads-env.eba-fbsax2xx.us-east-2.elasticbeanstalk.com/booking", {
        method: "POST",
        body: JSON.stringify(checkTicket)
    });

    if(response.status != 202){
        document.getElementById("checkin-form").reset();
        alert("Check In Failed");
    }
    else {window.location.href = "Member.html";}
    }

async function marshall2(cancelTik){
    let ticket = {ticket_num : cancelTik,}

    let response = await fetch("http://localhost:8080/P1-Brown-Eads-Iyer/booking", {
    //let response = await fetch("Proj1eads-env.eba-fbsax2xx.us-east-2.elasticbeanstalk.com/booking", {
        method: "DELETE",
        body: JSON.stringify(ticket)
    });

    if(response.status = 401){
        document.getElementById("cancel-form").reset();
        alert("Ticket Cancellation Failed");
    }
    else{
        window.location.href = "Member.html";
    }
}
