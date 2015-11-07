if (Meteor.isClient) {
  Session.setDefault('name', '');
  Template.login.events({
    'submit form': function(e) {
      e.preventDefault();
      var name = event.target.name.value;
      if (name == "") {
        console.log("No name entered.");
      } else {
        console.log(name);
        //Example of adding p's:
        // $('#disp_name').append(
        //   $('<p></p>').text(name)
        // );
        //Call Rowan's thing here. 
      }
    }
  });
}
