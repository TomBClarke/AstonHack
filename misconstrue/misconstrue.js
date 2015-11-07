if (Meteor.isClient) {
  Template.login.events({
    'submit form': function(e) {
      e.preventDefault();
      var name = event.target.name.value;
      if (name == "") {
        console.log("No name entered.");
      } else {
        console.log(name);
        //Call Rowan's thing here.
      }
    }
  });
}
