// =============================================================================
// firebase
// =============================================================================
var query = firebase.database().ref("todolist/"+params.id); //https://github.com/time2hack/movie-db/blob/master/src/js/controllers/edit.js
query.once("value").then(fillData) //Fire Query

// =============================================================================
// JQuery - Crud
// =============================================================================

$("ul").on("click", "li", function(){ // Check Off Specific Todos By Clicking
	$(this).toggleClass("completed");
});
$("ul").on("click", "span", function(event){ // Click on X to delete Todo
	$(this).parent().fadeOut(500,function(){
		$(this).remove(); // one that will take it out of the dom 
		// firebase.database().ref("movies").child(key).remove(); // one that will take it out of firebase
	});
	event.stopPropagation();
});

// Date.now() for the timestamp; // look on jquery for timestamp // Jquery, Date Picker; 
$("input[type='text']").keypress(function(event){
	if(event.which === 13){ // grabbing new todo text from input
		var todoText = $(this).val();
		$(this).val(""); // create a new li and add to ul
		$("ul").append("<li><span><i class='fa fa-trash'></i></span> " + todoText + "</li>")
		// add to database : Firebase :) => 
	}
});

$(".fa-plus").click(function(){
	$("input[type='text']").fadeToggle();
});

// =============================================================================
// Update //Fill the form data
// =============================================================================

function fillData(snap) {
  var data = snap.val();
  console.log(data)
  $('#movieName').val(data.movieName);
  $('#releaseYear').val(data.releaseYear);
  $('#generes').val((data.generes || []).join(', '))
  $('#duration').val(data.duration);
  $('#directors').val((data.directors || []).join(', '))
  $('#actors').val((data.actors || []).join(', '))
  $('#imdbUrl').val(data.imdbUrl);
}

//Save function (similar to Adding the data. 
//This time we don't generate new key but utlize the one received from Router parameter
function saveMovie(movie) {
  var uid = firebase.auth().currentUser.uid;
  var postKey = params.id; //Params is received from the Router
  var updates = {};
  updates['/movies/' + postKey] = movie;
  updates['/user-movies/' + uid + '/' + postKey] = movie;
  return database.ref().update(updates);
}

// =============================================================================
// Read
// =============================================================================

var query = firebase.database().ref("movies").limitToFirst(20);
query.once("value")
  .then(function(snapshot) {
    snapshot.forEach(renderSingleSnapshot);
  }).then(function(){
    $(document).find('#list').html(markup);
  });
var renderSingleSnapshot = function(singleSnapshot){
}
