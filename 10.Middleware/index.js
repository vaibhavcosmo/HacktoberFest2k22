const { response } = require('express');
const express = require('express');

const app = express(); //express by default after import is not in executable state;
const req_Filter = require('./middleware') //middlware in a different file

const route = express.Router();// when apply the middleware on multiple routes
route.use(req_Filter)

//exapmle of the middleware of age <18
const reqFilter=(req,res,next)=>{
    if(!req.query.age){
        res.send("Please provide age");
    }
    else if(req.query.age<18){
        res.send("You should be above 18");
    }
    else{
        next();         //must have next(); will not proceed if dont have next func.
    }
    //console.log('reqFilter')
}

//app.use(reqFilter); //initate the middleware //this method is application based middleware all the rourtes will be effected

app.get('/',(req,res)=>{
    res.send("welcome to response page");
})

app.get('/users',req_Filter,(req,res)=>{  //passing in a specific route will apply only on it. 
    res.send("welcome to users page");
})

route.get('/contact',(req,res)=>{
    res.send("welcome to Contact page");
})

app.use('/',route);

app.listen(5000);