const express = require("express");
const EventEmitter = require("events");    //event emiter is a classd
const app = express()

let count  = 0;
const event = new EventEmitter();

event.on("countAPI",()=>{
    console.log("event called",count)
    count++
})

app.get("/",(req,res)=>{
    res.send("api called")
    event.emit("countAPI")
})

app.get("/search",(req,res)=>{
    res.send("search api called")
})

app.get("/update",(req,res)=>{
    res.send(" update api called")
})

app.listen(5000);