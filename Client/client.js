var name;
var socket;

function initialiseSocket() {
    console.log("Setting up socket");
    
    socket = new WebSocket("ws://localhost:3000");
    
    socket.onmessage = function(s) {
		console.log("Recieved");
		console.log(s);
        
        var message = $.parseJSON(s.data);

		$("#messages").append(
            $("<div></div>")
                .attr("class", "message-container")
                .append($("<div></div>")
                    .attr("class", "message-sender")
                    .text(message.sender))
                .append($("<div></div>")
                    .attr("class", "message-sender")
                    .text(message.text))
		);
    }
}

function registerName() {
    socket.send(JSON.stringify({
        type: "nameset",
        newName: $("#name").val()
    }));
}

function send() {
    socket.send($("#input").val());
}

function close() {
    socket.close();
}
