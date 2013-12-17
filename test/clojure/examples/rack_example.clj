(ns examples.rack-example
  (:require [puppetlabs.trapperkeeper.core :refer [defservice]]
            [clojure.tools.logging :as log]))

(defservice hello-sinatra-service
  {:depends [[:rack-webserver-service add-rack-handler]]
   :provides [shutdown]}
  (log/info "Rack hello sinatra webservice starting up!")
  (add-rack-handler "./test/ruby/hello-sinatra" "/hello-sinatra")
  {:shutdown (fn [] (log/info "Rack hello sinatra webservice shutting down!"))})

(defservice sinatra-consumer-service
  {:depends [[:rack-webserver-service add-rack-handler]]
   :provides [shutdown]}
  (log/info "Rack sinatra consumer webservice starting up!")
  (add-rack-handler "./test/ruby/sinatra-service-consumer" "/sinatra-consumer")
  {:shutdown (fn [] (log/info "Rack sinatra consumer webservice shutting down!"))})
