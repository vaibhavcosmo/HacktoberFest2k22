const express =  require('express');
// require('./config_mongoose');
// const Product= require('./pruducts')
const multer = require('multer');

const app = express();
//app.use(express.json());

const upload = multer({
    storage: multer.diskStorage({
        destination: function(req,file,cb){
            cb(null,"uploads")
        },
        filename:function(req,file,cb){
            cb(null,file.fieldname + Date.now() + ".jpg")
        }
    })
}).single("user_file");

app.post("/upload", upload, (req,res)=>{
    res.send("ok")
})



app.listen(5000);