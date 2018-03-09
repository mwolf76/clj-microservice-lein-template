(ns leiningen.new.clj-microservice
  (:use [leiningen.new.templates :only [renderer name-to-path sanitize-ns ->files]]))

(def render (renderer "clj-microservice"))

(defn clj-microservice
  [name]
  (let [data {:name name
              :ns-name (sanitize-ns name)
              :sanitized (name-to-path name)}]
    (->files data ["src/{{sanitized}}/server.clj" (render "src/microservice/server.clj" data)]
["project.clj" (render "project.clj" data)]
["test/{{sanitized}}/server_test.clj" (render "test/microservice/server_test.clj" data)]
["src/{{sanitized}}/core.clj" (render "src/microservice/core.clj" data)]
["test/{{sanitized}}/core_test.clj" (render "test/microservice/core_test.clj" data)]
["resources/logback.xml" (render "resources/logback.xml")]
)))