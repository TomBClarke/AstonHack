var name;
var socket;

function connect() {
    socket = new WebSocket("ws://localhost:3000"); // ("ws://82.46.212.232:32596");
    
//    socket.onopen = function() {
//        console.log("Sending Message");
//        socket.send("ping");
//    }
		
    socket.onmessage = function(s) {
		console.log("Recieved");
		console.log(s);

		$("#messages").append(
            $("<div></div>").text(s.data)
		);
    }
}

function send() {
    socket.send($("#input").val());
}

function close() {
    socket.close();
}
