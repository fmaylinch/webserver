
// --- Call the functions you want to try ---
//basics();
//functions();
//functions2();
//arrays();
//objects();
//classes();
//dom();
//events();
input();


/** Basics: variables, if, while, for */
function basics() {

    // var message = "hello js"; // var is the old keyword
    const name = "Ferran";
    const school = "BTS";

    console.log("I'm " + name + " and I'm in " + school);
    console.log(`I'm ${name} and I'm in ${school}`);

    const age = 20;

    if (age >= 18) {
        console.log("adult");
    } else {
        console.log("not adult");
    }

    let i = 1;
    while (i <= 5) {
        console.log(i);
        i++;
    }

    for (let j = 1; j <= 5; j++) {
        console.log(j);
    }
}

/** Functions, parameters, arguments, return */
function functions() {

    let result = sum(4, 6);
    console.log("The result is " + result);

    greet("BTS class");

    function greet(name) {
        console.log("Hello " + name);
    }

    function sum(x, y) {
        return x + y;
    }
}

/** Functions, anonymous functions and arrow functions */
function functions2() {

    function sayHello(name) {

        console.log("Hello " + name);
    }

    let sayHi = function(name) {

        console.log("Hi " + name);
    };

    let sayBye = (name) => {

        console.log("bye " + name);
    };

    sayHello("class");
    sayHi("again");
    sayBye("people");

    let sum1 = function(a,b) {
        return a + b;
    };

    let sum2 = (a,b) => a + b;

    console.log( "sum: " + sum1(2, 3) );
    console.log( "sum: " + sum2(2, 3) );
}

/** Arrays, creating, adding (push), looping */
function arrays() {

    let array = [2, 4, 6];
    let array2 = [ ];

    array.push(8);
    array.push(10);

    let x = array[1];

    console.log("x = " + x);
    console.log(array);
    console.log("array = " + array);

    for (let i = 0; i < array.length; i++) {
        console.log("Value at index " + i + " is " + array[i]);
    }

    for (let value of array) {
        console.log(value);
    }
}

/** Objects, properties */
function objects()
{

    let car1 = {
        name: "Ferrari",
        color: "red",
        maxSpeed: 300,
        available: true
    };

    let car2 = {
        name: "Ford",
        maxSpeed: 200,
        available: false,
        weight: 1000
    };

    console.log(car1.name + " has color " + car1.color);
    console.log(car2.name + " weights " + car2.weight);

    car2.owner = "Alessandro";

    console.log(car2.name + " is owned by " + car2.owner);

    // Advanced way to access object properties
    let attribute = "maxSpeed";
    console.log("The property " + attribute + " of car1 is " + car1[attribute]);
}

/** Classes, constructor, methods, creating objects */
function classes() {

    class Car {

        // You don't declare the fields

        constructor(name, maxSpeed) {
            this.name = name;
            this.maxSpeed = maxSpeed;
            this.speed = 0;
        }

        accelerate(amount) {
            this.speed += amount;
        }
    }

    let car = new Car("Audi", 250);
    car.accelerate(50);
    car.accelerate(20);

    // This is a simple object, not created from class
    let car2 = {
        name: "Opel",
        speed: 100
    };

    console.log("Now the " + car.name + " is running at " + car.speed);
    console.log("Now the " + car2.name + " is running at " + car2.speed);

    console.log(car);
    console.log(car2);
}

/**
 * Access and modify the DOM (Document Object Model). That means modifying the web page.
 * The DOM is the internal representation of the web page.
 * The browser creates the DOM from the HTML.
 */
function dom() {

    // Get an element and modify its content
    let text = document.getElementById("text");
    text.textContent = "Message set from JavaScript";

    // Create a new element (paragraph) and set its content
    let paragraph = document.createElement("p");
    paragraph.textContent = "This is a new paragraph";

    // Add the paragraph to an existing element in the page, so it's visible
    let container = document.getElementById("container");
    container.appendChild(paragraph);
}

/** Events, executing a function when some event occurs */
function events() {

    // Create a button
    let button = document.createElement("button");
    button.textContent = "Display products";

    // Listen to clicks on the button
    button.addEventListener("click", displayProducts);
    //button.onclick = displayProducts;

    // Add the button to the web page
    let container = document.getElementById("container");
    container.appendChild(button);

    function displayProducts() {

        // Getting an element from the HTML
        let container = document.getElementById("container");

        // Create an array of objects
        let array = [{name: "tv", price: 200}, {name: "pen", price: 5}];

        let div = document.createElement("div");

        for (let value of array) {
            // Create a new element (paragraph)
            let paragraph = document.createElement("p");
            // Change the content of the paragraph
            paragraph.textContent = value.name + " costs " + value.price;
            // Add the paragraph to the container (so it is displayed)
            div.appendChild(paragraph);
        }

        container.appendChild(div);
    }
}

/**
 * Use addEventListener and arrow functions
 * Use const if variable doesn’t change
 * Use good names
 * Use string interpolation
 *
 * In the HTML, write an <input> and a <button>.
 *
 * Write your name here: [    ] (ok)
 * Hello NAME! (displayed when button is clicked)
 *
 */
function input() {

    const okButton = document.getElementById("ok-button");
    okButton.addEventListener("click", function() {

        const nameInput = document.getElementById("name-input");
        const name = nameInput.value;

        const p = document.createElement("p");
        p.textContent = `Hello ${name}!`; // "Hello " + name + "!";

        const container = document.getElementById("container");
        container.appendChild(p);
    });
}
