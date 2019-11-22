// add pageTitle
let pageTitle = "My Shopping List";
// add groceries
let groceries = ["Bacon", "Bread", "Milk", "Cheese", "Hot Dogs", "Tomatoes", "Cereal", "Soda", "Chips", "Lettuce"];

/**
 * This function will get a reference to the title and set its text to the value
 * of the pageTitle variable that was set above.
 */
function setPageTitle() {
  document.title = pageTitle;
}

/**
 * This function will loop over the array of groceries that was set above and add them to the DOM.
 */
function displayGroceries() {
    let groceriesElement = document.getElementById("groceries");

    groceries.forEach((grocery)=>{
      let groceryElement = document.createElement("li");
      groceryElement.innerText = grocery;
      groceriesElement.appendChild(groceryElement);
    })
}

/**
 * This function will be called when the button is clicked. You will need to get a reference
 * to every list item and add the class completed to each one
 */
function markCompleted() {
  let groceryElements = document.getElementById("groceries").children;

  for( let grocery of groceryElements ) {
    grocery.classList.add("completed");
  }
}

setPageTitle();

displayGroceries();

// Don't worry too much about what is going on here, we will cover this when we discuss events.
document.addEventListener('DOMContentLoaded', () => {
  // When the DOM Content has loaded attach a click listener to the button
  const button = document.querySelector('.btn');
  button.addEventListener('click', markCompleted);
});
