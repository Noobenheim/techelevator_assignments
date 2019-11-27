document.addEventListener("DOMContentLoaded", (event)=>{
    const nerdButton = document.getElementById("nerdButton");
    const randomButton = document.getElementById("randomButton");
    const kanyeButton = document.getElementById("kanyeButton");

    const includeExplicit = true;

    const nerdURL = "http://api.icndb.com/jokes/random?"+(includeExplicit?"":"exclude=explicit&")+"limitTo=nerdy";
    const randomURL = "http://api.icndb.com/jokes/random"+(includeExplicit?"":"?exclude=explicit");
    const kanyeURL = "https://api.kanye.rest";

    nerdButton.addEventListener("click", (event)=>{
        setImage("hero");
        loadURL(nerdURL, event);
    });
    randomButton.addEventListener("click", (event)=>{
        setImage("hero");
        loadURL(randomURL, event);
    });
    kanyeButton.addEventListener("click", (event)=>{
        setImage("kanye");
        loadURL(kanyeURL, event, "quote");
    })
});

function setMessage(message) {
    const messageElement = document.getElementById("message");
    messageElement.innerText = message;
}
function setImage(img) {
    const imgElement = document.getElementsByTagName("img")[0];
    imgElement.src = "etc/"+img+".jpg";
}

function loadURL(url, event, index=null) {
    const originalText = event.target.innerText;
    event.target.innerText = "Loading...";
    event.target.disabled = true;

    fetch(url).then( response =>response.json() ).then((body)=>{
        if( index == null )
            setMessage(body.value.joke);
        else
            setMessage(body[index]);
        event.target.innerHTML = originalText;
        event.target.disabled = false;
    });
}