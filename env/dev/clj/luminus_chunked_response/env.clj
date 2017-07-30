(ns luminus-chunked-response.env
  (:require [selmer.parser :as parser]
            [clojure.tools.logging :as log]
            [luminus-chunked-response.dev-middleware :refer [wrap-dev]]))

(def defaults
  {:init
   (fn []
     (parser/cache-off!)
     (log/info "\n-=[luminus-chunked-response started successfully using the development profile]=-"))
   :stop
   (fn []
     (log/info "\n-=[luminus-chunked-response has shut down successfully]=-"))
   :middleware wrap-dev})
