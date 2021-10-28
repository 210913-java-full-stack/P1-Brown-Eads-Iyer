    /*
     * This is for the admin page and it needed two buttons and functions for each.
     * The buttons are actually hyper links so they have to be set up to listen for
     * the 'click'.
     * After the mouse click, the respective information is then sent to their functions.
     * The first function sends the necessary info to create a new flight. While the second
     * is se up to delete them. The third is so that a current flight table and manifest
     * table will load when ever the page loads (first time or refresh).
     */

    var form = document.getElementById("form_1");
    newFlightButt.addEventListener("click", function(event) {
    event.preventDefault();
    console.log(flightNumField.value);
    console.log(depart.value);
    console.log(dest.value);
    marshall1(flightNumField.value, depart.value, dest.value);
    });

    var form = document.getElementById("delFlightForm");
    delFlightButt.addEventListener("click", function(event) {
    event.preventDefault();
    console.log(delFlightField.value);
    marshall2(delFlightField.value);
    });

    logoutButt.addEventListener("click", function (event) {
        event.preventDefault();
        sessionStorage.clear();
        window.location.href = "Login.html";
        });

    async function marshall1(flightNum, depart, dest){
        let createFlight = {
            flight_number: flightNum,
            flight_num : null,
            departureCode : depart,
            destinationCode : dest
        }

        let response = await fetch("http://localhost:8080/AirportPrototype/flight", {
            method:"POST",
            body: JSON.stringify(createFlight)
        });
    }
    async function marshall2(flightNum){
        let deleteFlight = {
            flight_number: flightNum
        }

        let response = await fetch("http://localhost:8080/AirportPrototype/flight", {
            method:"DELETE",
            body: JSON.stringify(deleteFlight)
        });
    }
    async function loadTables() {
        let response = await fetch("http://localhost:8080/AirportPrototype/flight");
                let json = await response.json();

                let table = document.getElementById("flight-body");

                for (let element of json) {
                    let parsedElement = {
                        Flight_Number: element.flight_number,
                        From: element.departureCode,
                        To: element.destinationCode
                    }
                    let tr = table.insertRow(-1);
                    for (let key in parsedElement) {
                        let cell = tr.insertCell(-1);
                        cell.innerHTML = parsedElement[key];
                    }
                }
        let response2 = await fetch("http://localhost:8080/AirportPrototype/booking");
                let json2 = await response2.json();

                let table2 = document.getElementById("manifest");

                for (let element of json2) {
                    let parsedElement = {
                        Ticket_Number: element.ticket_num,
                        Flight_Number: element.flight.flight_number,
                        Customer_ID: element.user.ssn,
                        Checked_In: element.check_in
                    }
                    let tr = table2.insertRow(-1);
                    for (let key in parsedElement) {
                        let cell = tr.insertCell(-1);
                        cell.innerHTML = parsedElement[key];
                }
            }
        };