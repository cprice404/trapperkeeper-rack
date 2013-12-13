(defproject puppetlabs/trapperkeeper-rack "0.1.0-SNAPSHOT"
  :description "We are trapperkeeper.  We are one."
  ;; Abort when version ranges or version conflicts are detected in
  ;; dependencies. Also supports :warn to simply emit warnings.
  ;; requires lein 2.2.0+.
  :pedantic? :abort
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [puppetlabs/kitchensink "0.3.1-SNAPSHOT"]
                 [org.eclipse.jetty/jetty-server "7.6.1.v20120215"]
                 [org.eclipse.jetty/jetty-servlet "7.6.1.v20120215"]
                 [org.clojure/tools.logging "0.2.6"]
                 [prismatic/plumbing "0.1.0"]
                 [org.jruby.rack/jruby-rack "1.1.13.3"]
                 [puppetlabs/trapperkeeper "0.1.0-SNAPSHOT"]]

  :repositories [["releases" "http://nexus.delivery.puppetlabs.net/content/repositories/releases/"]
                 ["snapshots" "http://nexus.delivery.puppetlabs.net/content/repositories/snapshots/"]]

  :source-paths ["src/clojure"]

  :profiles {:dev {:test-paths ["test-resources"]}
             :test {:dependencies [[puppetlabs/kitchensink "0.3.1-SNAPSHOT" :classifier "test"]]}}

  :main puppetlabs.trapperkeeper.main
  )
