(async function getCities(){
            let response = await fetch("http://localhost:8080/AirportPrototype/city");
            let json = await response.json();

            let table = document.getElementById("cityTable");

            for(let element of json){
                let parsedElement = {
                    code: element.code,
                    city: element.city,
                    state: element.state
                }
                let tr = table.insertRow(-1);
                for(let key in parsedElement) {
                    let cell = tr.insertCell(-1);
                    cell.innerHTML = parsedElement[key];
                }
            }
        })();
