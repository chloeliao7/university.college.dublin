# Import Requests and json modules
import requests
import json

# openweathermap API key and URL
API_KEY = "015875585e5ac83b793835e137d645f7"
API_URL = "http://api.openweathermap.org/data/2.5/forecast/daily?q="

# Number of days to fetch data for
days_count = 16

# The city and country code to get data for
city_name = "Berlin"
country_code = "DE"

# the request URL with all the values in place
request_url = API_URL + city_name + "," + country_code + "&cnt=" + str(days_count) + "&APPID=" + API_KEY

# Making the request. This returns a JSON data from the API
res = requests.get(request_url)
weather_date = json.loads(res.text)

# Write the JSON data returned from API to weather_data.json file
with open('../data/weather_data.json', 'w') as outfile:
    json.dump(weather_date, outfile)
