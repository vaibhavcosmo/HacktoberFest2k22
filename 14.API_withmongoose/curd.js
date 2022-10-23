const mongoose = require('mongoose');
mongoose.connect("mongodb://localhost:27017/e-comm");             //connect to db
    
    const ProductSchema = new mongoose.Schema({
        name:String,
        price:Number,
        brand:String,
        type:String
    });


const inserData  = async ()=>{
const ProductModels =new mongoose.model('pruducts',ProductSchema);       //first parameter is collection name and second paramter is schema

let data = new ProductModels(
    {
    name:"navio", 
    price:1000, 
    brand:"chinhao", 
    type:"smartphone"
});

let result = await data.save();
console.log(result)
}

//inserData();

const updateInDB =async  () => {
    const Product = mongoose.model('pruducts', ProductSchema);
    let data =await  Product.updateOne(
        { name: "s30"},
        {$set:{price: 550}}
    )
    console.log(data)
}

//updateInDB();

const deleteInDB = async ()=>{
    const Product = mongoose.model('pruducts', ProductSchema);
    let data = await Product.deleteOne({name:"a69"})
    console.log(data);
}

//deleteInDB();

const findInDB = async ()=>{
    const Product = mongoose.model('pruducts', ProductSchema);
    let data = await Product.find({name:'axio'})
    console.log(data);
}

findInDB();