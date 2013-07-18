var directionsDisplay;
var directionsService = new google.maps.DirectionsService();
var map;
var content = document.getElementById("contenedorMapa");

function initialize() {
    directionsDisplay = new google.maps.DirectionsRenderer();
    var chicago = new google.maps.LatLng(-36.603311,-72.077622);
    var mapOptions = {
        zoom: 8,
        center: chicago,
        mapTypeId: google.maps.MapTypeId.ROADMAP
    };
    map = new google.maps.Map(document.getElementById('map-canvas'), mapOptions);
    directionsDisplay.setMap(map);
    directionsDisplay.setPanel(document.getElementById('directions-panel'));

//    var control = document.getElementById('panel');
//    control.style.display = 'block';
//    map.controls[google.maps.ControlPosition.TOP_CENTER].push(control);
}

function calcRoute() {
    var start = document.getElementById('start').value;
    var end = document.getElementById('end').value;
    var request = {
        origin: start,
        destination: end,
        travelMode: google.maps.DirectionsTravelMode.DRIVING
    };
    directionsService.route(request, function(response, status) {
        if (status == google.maps.DirectionsStatus.OK) {
            directionsDisplay.setDirections(response);
        }
    });
}

google.maps.event.addDomListener(content, 'load', initialize);