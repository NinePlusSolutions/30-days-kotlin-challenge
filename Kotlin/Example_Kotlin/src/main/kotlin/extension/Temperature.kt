package extension
//Extension properties
class Temperature (var celsius: Float)

var Temperature.fahrenheit: Float
    get() = (celsius *9/5) + 32
    set(value) {
        celsius = (value - 32) *5 / 9
    }