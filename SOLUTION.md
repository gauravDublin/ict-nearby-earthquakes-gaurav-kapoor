#### Git Repository
Simple clone https://github.com/gauravDublin/ict-nearby-earthquakes-gaurav-kapoor.git and run `info.earthquake.Application::main()`

#### Sample Run (When you run the application, You get the console message)

Please enter the latitude and longitude of a city (each seperated by new Line)

40.730610
-73.935242

Fetching the data from USGS database.....Waiting...

------------------------------------------------------------------------------

*************   Top 10 nearest earthquake *************

M 5.0 - Prince Edward Islands region || 2612.42
M 4.4 - 240km N of Okha, Russia || 4344.99
M 4.9 - 169km SSE of Amsterdam Island, France || 4436.15
M 4.5 - 26km ESE of Pamandzi, Mayotte || 4861.76
M 4.6 - 26km ESE of Pamandzi, Mayotte || 4864.23
M 4.8 - 35km E of Pamandzi, Mayotte || 4868.78
M 4.5 - 16km ESE of Pamandzi, Mayotte || 4869.46
M 4.6 - 14km E of Pamandzi, Mayotte || 4873.73
M 4.9 - Bouvet Island region || 5145.44
M 4.1 - 209km SSE of Ol'ga, Russia || 5154.73



#### Improvements
Every run of the application fetches the data from USGS endpoint, Cache can be implemented to reduce api call.<br />
More test coverage <br />



