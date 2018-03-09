# clj-microservice-lein-template
Leiningen template to generate a stub Clojure microservice

1. Clone the repository
2. Install the template into local repository
```
$ lein install
```
3. Switch to another directory and start developing your new Clojure microservice
```
$ lein new clj-microservice foo
$ cd foo
$ lein test
2018-03-09 20:32:29.007 INFO  org.eclipse.jetty.util.log - Logging initialized @1996ms

lein test foo.core-test

lein test foo.server-test
2018-03-09 20:32:29.953 INFO  foo.server - Starting web server on port 3339
2018-03-09 20:32:29.965 INFO  org.eclipse.jetty.server.Server - jetty-9.2.10.v20150310
2018-03-09 20:32:29.980 INFO  o.e.jetty.server.ServerConnector - Started ServerConnector@2314f013{HTTP/1.1}{0.0.0.0:3339}
2018-03-09 20:32:29.980 INFO  org.eclipse.jetty.server.Server - Started @2971ms
2018-03-09 20:32:30.073 INFO  foo.server - Status request received
2018-03-09 20:32:30.096 INFO  foo.server - Stopping web server
2018-03-09 20:32:30.098 INFO  o.e.jetty.server.ServerConnector - Stopped ServerConnector@2314f013{HTTP/1.1}{0.0.0.0:3339}

Ran 3 tests containing 3 assertions.
0 failures, 0 errors.

$ lein run
markus@holly:~/Code/markus/clojure-playground/foo$ curl -s http://localhost:3334/status | jq .
{
  "alive": true,
  "message": "service is alive"
}
```
4. Have fun ;-)
