var name;
var socket;

initialiseSocket = function() {
    socket = new WebSocket("ws://localhost:5000");
    
    socket.onmessage = function(s) {
        var message = $.parseJSON(s.data);

<<<<<<< HEAD
        console.log(message);

=======
>>>>>>> something
        if (message.conversations) {
            showConversations(message.conversations);
            return;
        } 

		$("#messages").append(
            $("<div></div>")
                .attr("class", "message-container")
                .append($("<div></div>")
                    .attr("class", "message-sender")
                    .text(message.sender + ' says: ' + message.text))
		);
    }
}

registerName = function(name) {
    socket.send(JSON.stringify({
        'type': "nameset",
        'newName': name
    }));
}

goToGroup = function(groupIndex) {
    socket.send(JSON.stringify({
        'type': "groupset",
        'newGroup': groupIndex
    }));
}

send = function(words) {
    socket.send(words);
}

close = function() {
    socket.close();
}

showConversations = function(cs) {
    cs.forEach(function(c, ci) {
        $("#conversations").append(
            $("<div></div>")
                .attr('class', 'conversation')
                .text(c.members.join(", "))
                .on('click', function() { enterChatRoom(ci); })
        );
    });
}

enterChatRoom = function(ci) {
    socket.send(JSON.stringify({ 'type': 'groupset', 'newGroup': ci }));
    BlazeLayout.render( 'applicationLayout', { main: 'chat' } );
}