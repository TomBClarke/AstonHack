FlowRouter.route( '/login', {
  action: function() {
  	BlazeLayout.render( 'applicationLayout', { main: 'login' } ); 
    console.log( "login page!" );
  },
  name: 'login'
});

FlowRouter.route( '/selectPerson', {
  action: function() {
  	BlazeLayout.render( 'applicationLayout', { main: 'selectPerson' } );
    console.log( "selectPerson page!" );
  },
  name: 'selectPerson'
});

FlowRouter.route( '/chat', {
  action: function() {
  	BlazeLayout.render( 'applicationLayout', { main: 'chat' } );
    console.log( "chat page!" );
  },
  name: 'chat'
});
