(ns examples.counter.count-service-java-bridge
  (:import [examples.counter CountService])
  (:require [puppetlabs.trapperkeeper.core :refer [defservice]]
            [clojure.tools.logging :as log]))

(defservice count-service-java-bridge
  {:depends [[:count-service inc-and-get]]
   :provides []}
  (log/info "Count service java bridge initializing.")
  (let [cs (proxy [CountService] []
              (incAndGet [] (inc-and-get)))]
    (CountService/setInstance cs)
    ;(let [cs-instance (CountService/getInstance)]
    ;  (println "Calling inc and get!:"
    ;           (.incAndGet cs-instance)
    ;           (.incAndGet cs-instance))))
    )
  {})