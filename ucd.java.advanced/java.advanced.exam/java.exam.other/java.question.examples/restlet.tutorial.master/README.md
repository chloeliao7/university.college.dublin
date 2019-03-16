# restlet-tutorial
This is the sample code from an older (but still popular) RESTlet framework tutorial I have on YouTube.  It is using a fairly ancient version of the framework, but you all have been asking for it, so here it is! 

It is currently using the 1.1.6 version of the RESTlet framework.  

Sample curl commands:

# List all the widget resources as json
curl -v -H "Accept: application/json" http://localhost:8100/widgets

# List all the widget resources as html.
curl -v -H "Accept: text/html" http://localhost:8100/widgets

# List widget "1" resource as json
curl -v -H "Accept: application/json" http://localhost:8100/widgets/1

# update widget "1" with a new name
curl -v -H "Accept: application/json" -X PUT -d "id=1&name=my updated name" http://localhost:8100/widgets/1

# create a new widget resource
curl -v -X POST -d "name=a dandy new widget" http://localhost:8100/widgets
