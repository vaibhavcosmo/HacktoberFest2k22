const mongoose = require('mongoose');
const pruductSchema = new mongoose.Schema({
    name:String,
    price:Number,
    brand:String,
    type:String
})

module.exports = mongoose.model('pruducts',pruductSchema);