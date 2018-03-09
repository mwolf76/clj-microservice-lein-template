(defproject {{ns-name}} "0.1.0-SNAPSHOT"
  :description "No description yet"
  
  :dependencies [
                 [org.clojure/clojure "1.8.0"]
                 [ring/ring-jetty-adapter "1.4.0"]
                 [compojure "1.5.0"]
                 [ring/ring-json "0.4.0"]
                 [org.clojure/tools.logging "0.3.1"]
                 [ch.qos.logback/logback-classic "1.1.7"] 
                 [org.slf4j/slf4j-api "1.7.21"]
                 [com.stuartsierra/component "0.3.1"]]

  :profiles {
             :test {
                    :dependencies [[clj-http "2.1.0"]]}}

  :main {{ns-name}}.core)
