(ns user
  (:require [mount.core :as mount]
            luminus-chunked-response.core))

(defn start []
  (mount/start-without #'luminus-chunked-response.core/repl-server))

(defn stop []
  (mount/stop-except #'luminus-chunked-response.core/repl-server))

(defn restart []
  (stop)
  (start))


