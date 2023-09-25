"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var rectangle_1 = require("./rectangle");
var rectangle = new rectangle_1.Rectangle(31, 33, 10, 20);
var shapes = [];
shapes.push(rectangle);
shapes.forEach(function (shape) {
    console.log(shape.getInfo());
    console.log(shape.calculateArea());
});
