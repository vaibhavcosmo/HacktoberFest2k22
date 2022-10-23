const express =  require('express');
require('./config_mongoose');
const Product= require('./pruducts')

const app = express();
app.use(express.json());


app.get('/search/:key',async (req,res)=>{
    console.log(req.params.key);
    let data  = await Product.find({
        "$or":[                                         //or meand find in multiple
            {"name":{$regex:req.params.key}},
            {"brand":{$regex:req.params.key}}                //using regex
        ]
    });
    res.send(data);
})

app.listen(5000);