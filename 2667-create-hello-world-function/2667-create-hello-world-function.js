/**
 * @return {Function}
 */
var createHelloWorld = function() {
    
    return function(...args) {
       return f();
    }
    function f(){
        return "Hello World";
    }
};

/**
 * const f = createHelloWorld();
 * f(); // "Hello Word"
 */