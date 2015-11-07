if (Meteor.isClient) {
  //Holds which page is being displayed:
  Session.setDefault('page', 'login');

  //Handles the login template:
  Template.login.events({
    //Reacts to the button pres.
    'submit form': function(e) {
      //Stops form reloading the page.
      e.preventDefault();
      //Gets the name the user enterd.
      var name = event.target.name.value;
      if (name == "") {
        console.log("No name entered.");
      } else {
        //Got a name, let's try to connect.
        console.log(name);
        //Call Rowan's thing here. Could do with error handling.
        BlazeLayout.render( 'applicationLayout', { main: 'chat' } );
      }
    }
  });

  
}
