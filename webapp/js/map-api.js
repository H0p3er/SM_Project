"use strict";

const CONFIGURATION = {
    "ctaTitle": "Checkout",
    "mapOptions": { "center": { "lat": 21.025077, "lng": 105.845302 }, "fullscreenControl": false, "mapTypeControl": false, "streetViewControl": false, "zoom": 10, "zoomControl": true, "maxZoom": 20, "mapId": "" },
    "mapsApiKey": "AIzaSyBwP0X6TIpLo617cSCYnsRizeoFJ1jbYIM",
    "capabilities": { "addressAutocompleteControl": true, "mapDisplayControl": true, "ctaControl": true }
};
//AIzaSyBwP0X6TIpLo617cSCYnsRizeoFJ1jbYIM
//AIzaSyBoeZl8U9Ls5z0-4TFRvEr83smHlkzxphA

const SHORT_NAME_ADDRESS_COMPONENT_TYPES =
    new Set(['street_number', 'administrative_area_level_1', 'postal_code']);

const ADDRESS_COMPONENT_TYPES_IN_FORM = [
    'location',
    'administrative_area_level_2',
    'administrative_area_level_1'
];

async function importLibrary(){
    const {Place} = await google.maps.importLibrary("places");
}


function getFormInputElement(componentType) {
	console.log(document.getElementById(`workplace${componentType}`));
    return document.getElementById(`workplace${componentType}`);
}

function fillInAddress(place) {
    function getComponentName(componentType) {
        console.log(place.address_components);
        for (const component of place.address_components || []) {
            if (component.types[0] === componentType) {
                return SHORT_NAME_ADDRESS_COMPONENT_TYPES.has(componentType) ?
                    component.short_name :
                    component.long_name;
                    
            }
        }
        return '';
    }

    function getComponentText(componentType) {
        return (componentType === 'location') ?
            `${getComponentName('street_number')} ${getComponentName('route')}` :
            getComponentName(componentType);
    }

    for (const componentType of ADDRESS_COMPONENT_TYPES_IN_FORM) {
        getFormInputElement(componentType).value = getComponentText(componentType);
        console.log(getFormInputElement(componentType).value);
    }
}
function renderAddress(place, map, marker) {
    map.setZoom(18);
    if (place.geometry && place.geometry.location) {
        map.setCenter(place.geometry.location);
        marker.position = place.geometry.location;
    } else {
        marker.position = null;
    }
}

async function initMap() {
    const { Map } = google.maps;
    const { AdvancedMarkerElement } = google.maps.marker;
    const { Autocomplete } = google.maps.places;

    const mapOptions = CONFIGURATION.mapOptions;
    mapOptions.mapId = mapOptions.mapId || 'DEMO_MAP_ID';
    mapOptions.center = mapOptions.center || { lat: 21.025077, lng: 105.845302 };

    const map = new Map(document.getElementById('gmp-map'), mapOptions);
    const marker = new AdvancedMarkerElement({ map });
    const autocomplete = new Autocomplete(getFormInputElement('location'), {
        fields: ['address_components', 'geometry', 'name'],
        types: ['address'],
    });

    autocomplete.setComponentRestrictions({
        country: ["vn"],
      });
    autocomplete.addListener('place_changed', () => {
        const place = autocomplete.getPlace();
        if (!place.geometry) {
            // User entered the name of a Place that was not suggested and
            // pressed the Enter key, or the Place Details request failed.
            window.alert(`No details available for input: '${place.name}'`);
            return;
        }
        renderAddress(place, map, marker);
        fillInAddress(place);
    });
}

