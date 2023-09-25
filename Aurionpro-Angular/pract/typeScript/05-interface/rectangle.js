"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.Rectangle = void 0;
var Rectangle = /** @class */ (function () {
    function Rectangle(_height, _width) {
        this._height = _height;
        this._width = _width;
    }
    Rectangle.prototype.getInfo = function () {
        return "height=".concat(this._height, " and width=").concat(this._width);
    };
    Rectangle.prototype.calculateArea = function () {
        return this._height * this._width;
    };
    return Rectangle;
}());
exports.Rectangle = Rectangle;
