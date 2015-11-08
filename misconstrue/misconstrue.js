if (Meteor.isClient) {
  //Holds which page is being displayed:
  Session.setDefault('page', 'login');

  //Handles the login template:
  Template.login.events({
    //Reacts to the button press.
    'submit form': function(e) {
      //Stops form reloading the page.
      e.preventDefault();
      //Gets the name the user entered.
      var name = event.target.name.value;
      if (name == "") {
        alert("No name entered.");
      } else {
        registerName(name);
        send(JSON.stringify({ 'type': 'groupget' }));
        BlazeLayout.render( 'applicationLayout', { main: 'selectPerson' } );
      }
    }
  });

<<<<<<< HEAD
  Template.selectPerson.events({
=======
    Template.selectPerson.events({
>>>>>>> something
    //Reacts to the button press.
    'submit form': function(e) {
      //Stops form reloading the page.
      e.preventDefault();
      send(JSON.stringify({ 'type': 'groupnew' }));
      BlazeLayout.render( 'applicationLayout', { main: 'chat' } );
    }
  });

  Template.chat.events({
    //Reacts to the button press.
    'submit form': function(e) {
      //Stops form reloading the page.
      e.preventDefault();
      //Gets the words the user entered.
      var words = event.target.chatMsg.value;
      if (words == "") {
        alert("No text entered.");
      } else {
        send(words);
      }
    }
  });
 
<<<<<<< HEAD
}
=======
}
>>>>>>> something
