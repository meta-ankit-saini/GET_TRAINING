const express = require('express');
const fileupload = require('express-fileupload');
const PORT = 3000;

const app = express();

app.use('/assets' , express.static('assets'));

app.get('/' , function(req , res){
  res.sendFile(__dirname + '/index.html');
});

app.listen(PORT, function() {
  console.log('Express server listening on port ', PORT); // eslint-disable-line
});
// C:\Users\ankit.saini_metacube\Documents\UI\Assignment8\Parking.html