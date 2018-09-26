
console.log("products.js loaded!");

// This calls the ProductsApiController to get the products...
axios.get('/api/products')
    .then(function (response) {

        // ... and here we get the products
        let products = response.data;

        console.log("Displaying products");

        let productsDiv = document.getElementById("products");

        let productsHtml = "";

        for (product of products) {
            productsHtml += "<p>" + product.name + " costs " + product.price + "</p>";
        }

        productsDiv.innerHTML = productsHtml;
    });


