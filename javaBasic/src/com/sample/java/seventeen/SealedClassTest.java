package com.sample.java.seventeen;

public class SealedClassTest   {  

}


sealed class Shape permits Circle, Rectangle, Square {
    // common properties and methods for shapes
}

final non-sealed class Circle extends Shape {
    // properties and methods specific to Circle
}

final non-sealed class Rectangle extends Shape {
    // properties and methods specific to Rectangle
}

final non-sealed class Square extends Shape {
    // properties and methods specific to Square
}  