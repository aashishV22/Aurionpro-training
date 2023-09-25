"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var rectangle_1 = require("./rectangle");
var rectangle = new rectangle_1.Rectangle(10, 20);
var shapes = [];
shapes.push(rectangle);
var rectangle2 = new rectangle_1.Rectangle(16, 20);
shapes.push(rectangle2);
shapes.forEach(function (shape) {
    console.log(shape.calculateArea());
});
