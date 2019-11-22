/**
 * Function to see if the location is summer depending on
 * where it is and what day/month it is
 * 
 * @param {number} month month number from 1-12
 * @param {number} day day of month
 * @param {String} hemisphere either northern or southern hemisphere
 */
function isSummer(month, day = 1, hemisphere = 'northern') {
  if (month === 7 || month === 8) {
    return hemisphere === 'northern';
  } else if (month === 6 && day >= 20) {
    return hemisphere === 'northern';
  } else if (month === 9 && day <= 20) {
    return hemisphere === 'northern';
  } else if (month === 1 || month === 2) {
    return hemisphere === 'southern';
  } else if (month === 12 && day >= 20) {
    return hemisphere === 'southern';
  } else if (month === 3 && day <= 20) {
    return hemisphere === 'southern';
  } else {
    return false;
  }
}

/**
 * Write a function called isAdmitted. It will check entrance
 * scores and return true if the students is admitted and
 * false if rejected. It takes three parameters:
 *
 *     * gpa
 *     * satScore (optional)
 *     * recommendation (optional)
 *
 * We admit them--return true--if:
 * gpa is above 4.0 OR
 * SAT score is above 1300 OR
 * gpa above 3.0 and they have a recommendation OR
 * SAT score is above 1200 and they have a recommendation
 * OTHERWISE reject it
 *
 * @param {number} gpa the GPA of the student, between 4.2 and 1.0
 * @param {number} [satScore=0] the student's SAT score
 * @param {boolean} [recommendation=false] does the student have a recommendation
 * @returns {boolean} true if they are admitted
 */
function isAdmitted(gpa, satScore=0, recommendation=false) {
  if( gpa > 4 ) return true;
  if( satScore > 1300 ) return true;
  if( gpa > 3 && recommendation ) return true;
  if( satScore > 1200 && recommendation ) return true;
  return false;
}

/**
 * Write a function called useParameterToFilterArray so that it takes an anonymous
 * function and uses that in `unfilteredArray` filter function. Return the result.
 *
 * @param {function} filterFunction the function to filter with
 * @returns {number[]} the filtered array
 */
let unfilteredArray = [1, 2, 3, 4, 5, 6];
function useParameterToFilterArray(filterFunction) {
  return unfilteredArray.filter(filterFunction);
}

/**
 * Write a function called makeNumber to take two strings
 * of digits, concatenate them together, and then return
 * the value back as a number.
 *
 * So if two strings are passed in "42293" and "443", then this function
 * should return the number 42293443.
 *
 * @param {string} first the first string of digits to concatenate
 * @param {string} [second=''] the second string of digits to concatenate
 * @returns {number} the resultant number
 */
function makeNumber(first, second='') {
    return parseInt(first+second);
}

/**
 * Write a function called addAll that takes an unknown number of parameters
 * and adds them all together. Return the result.
 *
 * @param {...number} num a series of numbers to add together
 * @returns {number} the sum of all the parameters (or arguments)
 */
function addAll() {
  let sum = 0;
  for( let argument of arguments ) {
    sum += argument;
  }
  return sum;
}

/*
 * Write and document a function called makeHappy that takes
 * an array and prepends 'Happy ' to the beginning of all the
 * words and returns them as a new array. Use the `map` function.
 */
/**
 * Prepends Happy to the beginning of each String in the array
 * 
 * @param {String[]} arr Array of Strings 
 * @returns {String[]} Array of Strings with Happy prepended
 */
function makeHappy(arr) {
  return arr.map((current)=>{
    return "Happy "+current;
  });
}

/*
 * Write and document a function called getFullAddressesOfProperties
 * that takes an array of JavaScript objects containing the
 * following keys:
 *     * streetNumber
 *     * streetName
 *     * streetType
 *     * city
 *     * state
 *     * zip
 *
 * and returns an array of strings that turns the JavaScript objects
 * into mailing addresses in the form of:
 *     streetNumber streetName streetType city state zip
 *
 * Use `map` and an anonymous function.
 */
/**
 * Joins the address information with spaces between
 * 
 * @param {object[]} objs Objects of streetNumber, streetName, streetType, city, state, and zip properties 
 * @returns {String[]} an array of Strings with the obj information joined by spaces
 */
function getFullAddressesOfProperties(objs) {
  return objs.map((obj) => {
    return `${obj.streetNumber} ${obj.streetName} ${obj.streetType} ${obj.city} ${obj.state} ${obj.zip}`;
  });
}

/*
 * Create and document a function called findLargest.
 *
 * Using `forEach`, find the largest element in an array.
 * It should work for strings and numbers.
 */
/**
 * Takes in an array and returns the largest element in the array
 * 
 * @param {object[]} arr Array of numbers/Strings
 * @returns {number} largest number in array
 */
function findLargest(arr) {
  if( arr == undefined || arr.length == 0 ) return null;
  let largest = arr[0];

  arr.forEach((num)=>{
    if( largest < num ) {
      largest = num;
    }
  });

  return largest;
}

/*
 * CHALLENGE
 * Create and document a function called getSumOfSubArrayValues.
 *
 * Take an array of arrays and add up all sub values and return
 * the sum. For instance, if you got this array as a parameter:
 * [
 *   [1, 2, 3],
 *   [2, 4, 6],
 *   [5, 10, 15]
 * ];
 *
 * You would return 48. To do this, you will use two nested `reduce`
 * calls with two anonymous functions.
 *
 * Read the tests to verify you have the correct behavior.
 */
/**
 * Takes in an array of arrays and adds all values contained
 * 
 * @param {number[][]} arr A two-dimensional array of numbers to add
 * @returns {number} 0 if arr is undefined, or the sum of all numbers
 */
function getSumOfSubArrayValues(arr) {
  if( arr == undefined ) return 0;
  return arr.reduce((reducer1, current1) => {
    return reducer1 + current1.reduce((reducer2, current2)=>{
      return reducer2+current2;
    }, 0);
  }, 0);
}