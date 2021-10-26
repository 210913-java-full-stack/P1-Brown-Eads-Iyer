       /*
        * The flight page will load a flight table when the page loads and then listen
        * for a mouse click so that it can send the necessary information to the server
        * so that the user can 'purchase' anywhere between 1 and 10 tickets.
        */


        var form = document.getElementById("form_2");
        purchaseButt.addEventListener("click", function (event) {
            event.preventDefault();
            console.log(fnum.value);
            console.log(sessionStorage.getItem("SSN"));
            marshall1(fnum.value, ssn.value, pass.value);
        });

        async function marshall1(flightNum, ssn, pass){
            let book = {
                flight_id : flightNum,
                ssn : sessionStorage.getItem("SSN"),
                ticket_num : null
            }

            for (let i = 0; i < pass; i++) {
                let response = await fetch("http://localhost:8080/P1-Brown-Eads-Iyer/booking", {
                method: "POST",
                body: JSON.stringify(book)
            })
        };
        }
        async function getFlight() {

            let response = await fetch("http://localhost:8080/P1-Brown-Eads-Iyer/flight");
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
        };
