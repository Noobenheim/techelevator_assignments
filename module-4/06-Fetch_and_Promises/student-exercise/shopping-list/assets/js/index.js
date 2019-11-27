document.addEventListener("DOMContentLoaded", (event)=>{
    const loadButton = document.querySelector(".loadingButton");
    const template = document.getElementById("shopping-list-item-template");
    const list = document.querySelector("ul");

    loadButton.addEventListener("click", (event)=>{
        fetch("https://techelevator-pgh-teams.azurewebsites.net/api/techelevator/shoppinglist").then(response=>response.json()).then((data)=>{
            data.forEach((grocery)=>{
                // see if item exists
                let exists = false;
                list.querySelectorAll("li span").forEach((current)=>{
                    exists = exists || current.innerText==grocery.name;
                });
                if( !exists ) {
                    let item = document.importNode(template.content, true).querySelector("li");
                    let name = document.createElement("span");
                    name.innerText = grocery.name;
                    item.appendChild(name);
                    if( grocery.completed ) {
                        item.querySelector("i").classList.add("completed");
                    }
                    list.appendChild(item);
                }
            });
        });
    });
});