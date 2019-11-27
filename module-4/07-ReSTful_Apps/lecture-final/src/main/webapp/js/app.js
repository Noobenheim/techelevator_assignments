var techelevator = window.techelevator || {};

let app = techelevator.app = (function () {

    //States
    const states = [
        {
            "name": "Alabama",
            "abbreviation": "AL"
        },
        {
            "name": "Alaska",
            "abbreviation": "AK"
        },
        {
            "name": "American Samoa",
            "abbreviation": "AS"
        },
        {
            "name": "Arizona",
            "abbreviation": "AZ"
        },
        {
            "name": "Arkansas",
            "abbreviation": "AR"
        },
        {
            "name": "California",
            "abbreviation": "CA"
        },
        {
            "name": "Colorado",
            "abbreviation": "CO"
        },
        {
            "name": "Connecticut",
            "abbreviation": "CT"
        },
        {
            "name": "Delaware",
            "abbreviation": "DE"
        },
        {
            "name": "District Of Columbia",
            "abbreviation": "DC"
        },
        {
            "name": "Federated States Of Micronesia",
            "abbreviation": "FM"
        },
        {
            "name": "Florida",
            "abbreviation": "FL"
        },
        {
            "name": "Georgia",
            "abbreviation": "GA"
        },
        {
            "name": "Guam",
            "abbreviation": "GU"
        },
        {
            "name": "Hawaii",
            "abbreviation": "HI"
        },
        {
            "name": "Idaho",
            "abbreviation": "ID"
        },
        {
            "name": "Illinois",
            "abbreviation": "IL"
        },
        {
            "name": "Indiana",
            "abbreviation": "IN"
        },
        {
            "name": "Iowa",
            "abbreviation": "IA"
        },
        {
            "name": "Kansas",
            "abbreviation": "KS"
        },
        {
            "name": "Kentucky",
            "abbreviation": "KY"
        },
        {
            "name": "Louisiana",
            "abbreviation": "LA"
        },
        {
            "name": "Maine",
            "abbreviation": "ME"
        },
        {
            "name": "Marshall Islands",
            "abbreviation": "MH"
        },
        {
            "name": "Maryland",
            "abbreviation": "MD"
        },
        {
            "name": "Massachusetts",
            "abbreviation": "MA"
        },
        {
            "name": "Michigan",
            "abbreviation": "MI"
        },
        {
            "name": "Minnesota",
            "abbreviation": "MN"
        },
        {
            "name": "Mississippi",
            "abbreviation": "MS"
        },
        {
            "name": "Missouri",
            "abbreviation": "MO"
        },
        {
            "name": "Montana",
            "abbreviation": "MT"
        },
        {
            "name": "Nebraska",
            "abbreviation": "NE"
        },
        {
            "name": "Nevada",
            "abbreviation": "NV"
        },
        {
            "name": "New Hampshire",
            "abbreviation": "NH"
        },
        {
            "name": "New Jersey",
            "abbreviation": "NJ"
        },
        {
            "name": "New Mexico",
            "abbreviation": "NM"
        },
        {
            "name": "New York",
            "abbreviation": "NY"
        },
        {
            "name": "North Carolina",
            "abbreviation": "NC"
        },
        {
            "name": "North Dakota",
            "abbreviation": "ND"
        },
        {
            "name": "Northern Mariana Islands",
            "abbreviation": "MP"
        },
        {
            "name": "Ohio",
            "abbreviation": "OH"
        },
        {
            "name": "Oklahoma",
            "abbreviation": "OK"
        },
        {
            "name": "Oregon",
            "abbreviation": "OR"
        },
        {
            "name": "Palau",
            "abbreviation": "PW"
        },
        {
            "name": "Pennsylvania",
            "abbreviation": "PA"
        },
        {
            "name": "Puerto Rico",
            "abbreviation": "PR"
        },
        {
            "name": "Rhode Island",
            "abbreviation": "RI"
        },
        {
            "name": "South Carolina",
            "abbreviation": "SC"
        },
        {
            "name": "South Dakota",
            "abbreviation": "SD"
        },
        {
            "name": "Tennessee",
            "abbreviation": "TN"
        },
        {
            "name": "Texas",
            "abbreviation": "TX"
        },
        {
            "name": "Utah",
            "abbreviation": "UT"
        },
        {
            "name": "Vermont",
            "abbreviation": "VT"
        },
        {
            "name": "Virgin Islands",
            "abbreviation": "VI"
        },
        {
            "name": "Virginia",
            "abbreviation": "VA"
        },
        {
            "name": "Washington",
            "abbreviation": "WA"
        },
        {
            "name": "West Virginia",
            "abbreviation": "WV"
        },
        {
            "name": "Wisconsin",
            "abbreviation": "WI"
        },
        {
            "name": "Wyoming",
            "abbreviation": "WY"
        }
    ];

    function popCrumb() {
        const ul = document.querySelector('.breadcrumb ul');
        ul.lastChild.remove();
    }

    function clearCrumb() {
        document.querySelectorAll('.crumb-sub-nav').forEach(x => x.remove());
    }

    function addCrumb(title) {
        const ul = document.querySelector('.breadcrumb ul');
        const li = document.createElement('li');
        li.classList.add('crumb-sub-nav');
        const a = document.createElement('a');
        a.href = '#';
        a.innerText = title;
        li.appendChild(a);
        ul.appendChild(li);
    }

    function loadParks() {
        return fetch(techelevator.apiUrl + 'parks/')
            .then(response => response.json())
            .then(data => {
                techelevator.app.parks = data;
            });
    }

    function loadWeather(parkcode) {
        const apiUrl = techelevator.apiUrl + `parks/${parkcode}/weather/`;
        return fetch(apiUrl)
            .then(response => response.json());
    }

    function renderParkView(parkcode) {
        const park = techelevator.app.parks.filter(x => x.parkCode === parkcode)[0];
        addCrumb(park.parkName);

        const detail = document
            .getElementById('park-detail')
            .content
            .cloneNode(true);

        const imageUrl = techelevator.imageUrl + "parks/"

        const previewTemplate = document.getElementById('park-preview').content;

        const preview = renderParkPreview(previewTemplate, imageUrl, park);

        //we don't need the outer preview link, just its child tiles

        const info = detail.getElementById('park-info')
        Array.from(preview.querySelector('a').children).forEach(elm => info.appendChild(elm));

        loadWeather(parkcode)
            .then(weatherList => {

                const weatherSection = detail.getElementById('park-weather');
                const weatherTemplate = document.getElementById('weather').content;
                const weatherUrl = techelevator.imageUrl + "weather/";
                weatherList.forEach(weather => {
                    const weatherNode = weatherTemplate.cloneNode(true);
                    let forecast = weather.forecast;
                    if (forecast === 'partly cloudy') {
                        forecast = 'partlyCloudy';
                    }
                    weatherNode.querySelector('img').src = weatherUrl + `${forecast}.png`;
                    weatherNode.querySelector('.high-temp').innerText = weather.highTemp;
                    weatherNode.querySelector('.low-temp').innerText = weather.lowTemp;
                    weatherSection.appendChild(weatherNode);
                })

                const main = document.getElementById('main-content');
                Array.from(main.children).forEach(x => x.remove());
                main.append(detail);
            });
    }

    function renderParkPreview(preview, imageUrl, park) {
        const entry = preview.cloneNode(true);
        entry.querySelector('a').addEventListener('click', (event) => {
            event.preventDefault();
            renderParkView(park.parkCode)
        });
        entry.querySelector('img').src = imageUrl + park.parkCode.toLowerCase() + ".jpg";
        const content = entry.querySelector('.te-content');
        content.querySelector('.title').innerText = park.parkName;
        content.querySelector('.subtitle').innerText = park.state;
        content.querySelector('.content').innerText = park.description;
        return entry;
    }

    function renderHome() {

        const main = document
            .getElementById('home')
            .content
            .cloneNode(true);

        const parkList = main.getElementById('park-list');
        const imageUrl = techelevator.imageUrl + "parks/"
        const preview = document
            .getElementById('park-preview')
            .content;
        console.log("rendering main content");
        loadParks()
            .then(() => {
                const renderedParks =
                    techelevator.app.parks.map(park => renderParkPreview(preview, imageUrl, park));
                renderedParks.forEach(entry => parkList.appendChild(entry));
                const mainContent = document.getElementById('main-content');
                Array.from(mainContent.children).forEach(child => child.remove());
                mainContent.appendChild(main);

            });
    }

    function renderSurvey() {
        console.log("rendering survey");
        const survey = document.getElementById('survey').content.cloneNode(true);

        const parkSelect = survey.getElementById('park-dd');
        techelevator.app.parks.forEach(park => {
            const elm = document.createElement('option');
            elm.value = park.parkCode;
            elm.innerText = park.parkName;
            parkSelect.appendChild(elm);


        });

        const stateSelect = survey.getElementById('state-dd');
        states.forEach(state => {
            const opt = document.createElement('option');
            opt.innerText = state['name'];
            opt.value = state['abbreviation'];
            stateSelect.appendChild(opt);
        })

        // survey.getElementById('survey-button').addEventListener('click', event => {
        //     event.preventDefault();
        //     console.log("submitting survey");
        //     return false;

        // })

        survey.querySelector('form').addEventListener('submit', event => {
            event.preventDefault();

            const formData = new FormData(event.target);

            const formObject = {};
            formData.forEach((value, key) => formObject[key] = value);

            fetch(techelevator.apiUrl + "surveys", {
                headers: {
                    'Content-Type': 'application/json'
                },
                method: 'POST',
                body: JSON.stringify(formObject)
            }).then(response => response.json())
                .then(data => { console.log('survey result:'); console.log(data) })
                .then(renderHome());



            return false;
        })


        const mainContent = document.getElementById('main-content');
        Array.from(mainContent.children).forEach(child => child.remove());
        mainContent.appendChild(survey);
    }

    function init() {
        window.addEventListener('DOMContentLoaded', () => {

            const li = document.querySelector('.breadcrumb ul li');
            const clickHome = (event) => {
                event.preventDefault();
                clearCrumb();
                renderHome();
            };
            li.addEventListener('click', clickHome);

            document.getElementById('home-button').addEventListener('click', clickHome);

            document.getElementById('survey-button').addEventListener('click', renderSurvey);

            renderHome();
        })
    }

    return {
        parks: [],
        loadParks: loadParks,
        renderHome: renderHome,
        init: init

    };
})();

techelevator.app = app;

techelevator.app.init();