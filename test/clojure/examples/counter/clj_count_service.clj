(ns examples.counter.clj-count-service
  (:require [puppetlabs.trapperkeeper.core :refer [defservice]]
            [clojure.tools.logging :as log]))

(defservice count-service
  {:depends  []
   :provides [inc-and-get]}
  (log/info "############## Counter service starting up.")
  (let [counter (atom 0)]
    {:inc-and-get (fn [] (swap! counter inc))}))
