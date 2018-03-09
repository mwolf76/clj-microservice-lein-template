(ns {{ns-name}}.core
  (:require 
   [com.stuartsierra.component :as component]
   [clojure.tools.logging :as log]
   [{{ns-name}}.server :as server]))

(defn production-system
  [config-options]
  (component/system-map
   :web-server (server/make-web-server 
                (:port config-options))))

(defn -main
"Starts the whole system"
[& args]
(log/info "Service starting...")
(let 
    [the-system 
     (production-system {:port 3334})]
  
  (component/start the-system)
  (log/info "Service running")))
