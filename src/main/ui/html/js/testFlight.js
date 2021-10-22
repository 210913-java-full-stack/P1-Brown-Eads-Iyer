(async function getFlight(){
            let response = await fetch("http://localhost:8080/AirportPrototype/flight");
            let json = await response.json();

            let table = document.getElementById("flightTable");

            for(let element of json){
                let parsedElement = {
                    flight_number: element.flight_number,
                    departure: element.departure,
                    destination: element.destination
                }
                let tr = table.insertRow(-1);
                for(let key in parsedElement) {
                    let cell = tr.insertCell(-1);
                    cell.innerHTML = parsedElement[key];
                }
            }
        })();