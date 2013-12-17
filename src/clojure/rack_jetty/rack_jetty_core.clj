;; NOTE: this code is an adaptation of ring-jetty-handler.
;;  It adds some SSL utility functions, and
;;  provides the ability to dynamically register ring handlers.

(ns rack-jetty.rack-jetty-core
  "Adapter for the Rack Jetty webserver."
  (:import (org.eclipse.jetty.servlet ServletContextHandler ServletHolder
                                      DefaultServlet)
           (org.jruby.rack RackFilter RackServletContextListener)
           (org.eclipse.jetty.util.resource Resource))
  (:require [clojure.java.io :refer [file]]))

(defn add-rack-handler
  [webserver rack-path context-path]
  (let [handlers  (:handlers webserver)
        h         (ServletContextHandler. nil context-path ServletContextHandler/NO_SESSIONS)]
    (doto h
      (.addFilter RackFilter "/*" 0)
      (.setBaseResource (Resource/newResource (file rack-path)))
      (.addEventListener (RackServletContextListener.))

      (.setInitParameter
        "rackup"
        (str "$LOAD_PATH.unshift(\"" rack-path "\")\n"
             "require '" rack-path "/bundle/setup.rb'\n"
             (slurp (file rack-path "config.ru"))))
      (.setInitParameter "jruby.max.runtimes" "1")
      (.setInitParameter "jruby.runtime.env" "")
      (.setInitParameter "gem.path" "gems/jruby/1.9/gems")
      (.addServlet (ServletHolder. (DefaultServlet.)) "/"))

    (.addHandler handlers h)
    (.start h)
    h))