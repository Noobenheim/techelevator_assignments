function buildRow(data) {
    const tr = document.createElement('tr');
    const posterCell = document.createElement('td');
    const imdbCell = document.createElement('td');
    const nameCell = document.createElement('td');
    const yearCell = document.createElement('td');
    const img = document.createElement('img');

    imdbCell.innerText = data.imdbID;
    nameCell.innerText = data.Title;
    yearCell.innerText = data.Year;

    if( data.Poster != "N/A" ) {
        img.src = data.Poster;
        img.setAttribute('class','img-responsive');
        img.setAttribute('class','img-thumbnail');

        posterCell.setAttribute('class','col-sm-2');
        posterCell.append(img);
    }

    tr.append(posterCell);
    tr.append(imdbCell);
    tr.append(nameCell);
    tr.append(yearCell);

    return tr; 
};

document.addEventListener("DOMContentLoaded", (event)=>{
    const searchButton = document.getElementById("btnSearch");
    const text = document.getElementById("movie");

    searchButton.addEventListener("click", (event)=>{
        startSearch();
    });
    text.addEventListener("keypress", (event)=>{
        if( event.key == "Enter" ) {
            startSearch();
        }
    });
});

function startSearch() {
    const table = document.getElementById("movieData");
    const text = document.getElementById("movie");
    const searchButton = document.getElementById("btnSearch");

    const url = "http://www.omdbapi.com/?apikey=3c047b89&s=";

    const originalText = searchButton.innerText;

    searchButton.innerText = "Loading...";
    searchButton.disabled = true;

    fetch(url+text.value).then( response=>response.json() ).then((body)=>{
        // remove all children
        let child = table.lastElementChild;
        while( child ) {
            table.removeChild(child);
            child = table.lastElementChild;
        }

        body.Search.forEach((data)=>{
            table.appendChild(buildRow(data))
        });
        // for( let data of body.Search ) {
        //     table.appendChild(buildRow(data));
        // }
        searchButton.innerText = originalText;
        searchButton.disabled = false;
    });
}