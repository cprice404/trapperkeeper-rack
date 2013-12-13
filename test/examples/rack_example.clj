(ns examples.rack-example
  (:require [puppetlabs.trapperkeeper.core :refer [defservice]]
            [clojure.tools.logging :as log]))

(defservice rack-webservice
  {:depends [[:rack-webserver-service add-rack-handler]]
   :provides [shutdown]}
  (log/info "Rack hello sinatra webservice starting up!")
  (add-rack-handler "./src/ruby" "/hello-sinatra")
  {:shutdown (fn [] (log/info "Rack hello sinatra webservice shutting down!"))})
