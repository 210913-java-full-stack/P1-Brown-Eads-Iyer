    /*
     * Again, we start with the event listeners for the 'buttons',
     * followed by the functions required to check a user in for their
     * flight and to cancel their ticket. Unlike other pages, it stays
     * here just in case the user has more than one ticket (to check in
     * or cancel). If they wish to purchase any or more tickets, theres
     * a button for that too, it just sends them to the flight page.
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

    async function marshall1(checkTik){
        let checkTicket = {
            ticket_num : checkTik,
            check_in : true
        }

        let response = await fetch("http://localhost:8080/P1-Brown-Eads-Iyer/booking", {
            method: "POST",
            body: JSON.stringify(checkTicket)
        });

        if(response.status != 202){
            document.getElementById("checkin-form").reset();
            alert("Check In Failed");
        }
        else {window.location.href = "Member.html";}

    async function marshall2(cancelTik){
        let ticket = {ticket_num : cancelTik,}

        let response = await fetch("http://localhost:8080/P1-Brown-Eads-Iyer/booking", {
            method: "POST",
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
}