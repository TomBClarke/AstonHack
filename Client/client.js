var name;
var socket;

function connect() {
    socket = new WebSocket("ws://82.46.212.232:32596");
    socket.onopen = function() {
        console.log("Sending Message");
        socket.send("ping");
    }
    socket.onmessage = function(s) {
        console.log("received: " + s);
    }
}

function send() {
    socket.send();
}

function close() {
    socket.close();
}