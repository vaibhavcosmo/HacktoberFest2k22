module.exports = req_Filter=(req,res,next)=>{
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