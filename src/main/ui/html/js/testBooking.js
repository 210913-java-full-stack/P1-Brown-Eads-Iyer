(async function getBooking(){
            let response = await fetch("http://localhost:8080/AirportPrototype/booking");
            let json = await response.json();

            let table = document.getElementById("bookingTable");

            for(let element of json){
                let parsedElement = {
                    ticket_num: element.ticket_num,
                    check_in: element.check_in,
                    flight_number: element.flight_number,
                    ssn: element.ssn
                }
                let tr = table.insertRow(-1);
                for(let key in parsedElement) {
                    let cell = tr.insertCell(-1);
                    cell.innerHTML = parsedElement[key];
                }
            }
        })();