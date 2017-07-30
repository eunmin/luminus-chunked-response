(ns luminus-chunked-response.env
  (:require [clojure.tools.logging :as log]))

(def defaults
  {:init
   (fn []
     (log/info "\n-=[luminus-chunked-response started successfully]=-"))
   :stop
   (fn []
     (log/info "\n-=[luminus-chunked-response has shut down successfully]=-"))
   :middleware identity})
