(async function getUsers(){
            let response = await fetch("http://localhost:8080/AirportPrototype/user");
            let json = await response.json();

            let table = document.getElementById("userTable");

            for(let element of json){
                let parsedElement = {
                    ssn: element.ssn,
                    fName: element.fName,
                    lName: element.lName,
                    password: element.password
                }
                let tr = table.insertRow(-1);
                for(let key in parsedElement) {
                    let cell = tr.insertCell(-1);
                    cell.innerHTML = parsedElement[key];
                }
            }
        })();