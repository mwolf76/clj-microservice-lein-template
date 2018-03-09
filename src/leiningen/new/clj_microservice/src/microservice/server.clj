(ns {{ns-name}}.server
  (require
   [com.stuartsierra.component :as component]
   [clojure.tools.logging :as log]
   [compojure.core :refer :all]
   [compojure.route :as route]
   [ring.middleware.json :refer [wrap-json-response wrap-json-body]]
   [ring.adapter.jetty :as jetty]))

(defn make-routes
  []
  (routes
   (GET "/status" []
        (log/info "Status request received")
        {:status 200 :body {:alive true :message "service is alive"}})
   (route/not-found "Route not found\n")))

(defn make-handler
  []
  (-> 
   (make-routes)
   wrap-json-response))

(defn start
  [port]
  (log/info "Starting web server on port" port)
  (jetty/run-jetty (make-handler)
                   {:port port
                    :join? false}))

(defn kill
  [server]
  (log/info "Stopping web server")
  (.stop server))

(defrecord WebServer [port]
  component/Lifecycle

  (start 
    [component]
    (assoc component :server (start port)))

  (stop 
    [{server :server :as component}]
    (assoc component :server (kill server))))

(defn make-web-server [port]
  (map->WebServer {:port port}))

