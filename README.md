# GRE-case-study
Code base showing my implementation of the API Consumption case study solution
This is a REST API application that is designed to retrieve data points from the Twin-Cities Metro Transit Web Services portal.

It is made up of 4 model classes that map to json objects in the Metro Transit REST API service end point.

The NextTripApiController class is classified as a REST Controller and consists of 5 handler methods, each configured to generate outputs that can be fed in as arguments to subsequent request handlers.

HTTP requests can be sent to these methods either through a web brower or client tool, like Postman.

Begin by running the application from the main method of the ApiConsumptionApplication class.

An array of routes can be generated by passing the string http://localhost:8080/metrotransit/routes to the REST controller

Next, an array of directions can be acquired by passing the request http://localhost:8080/metrotransit/directions/{route}, with "route" being a path variable that is passed as a method parameter

We can proceed to get the array of stops along a given route in a particular direction by passing the request format http://localhost:8080/metrotransit/stops/{route}/{direction}

The time it takes to the start of the next trip for the given route, direction, and stop is found with the request format http://localhost:8080/metrotransit/nextrip/{route}/{direction}/{stop}

Finally, the solution to the case problem can be found by passing the string format http://localhost:8080/metrotransit/time/{route}/{direction}/{stop}

The output is in a string format. Example: "5 - Brooklyn Ctr - Fremont - 26th Av - Chicago - MOA" "7th St and Olson Memorial Hwy" "NORTHBOUND" 7 Min
