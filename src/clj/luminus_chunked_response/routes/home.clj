(ns luminus-chunked-response.routes.home
  (:require [luminus-chunked-response.layout :as layout]
            [compojure.core :refer [defroutes GET]]
            [ring.util.http-response :as response]
            [clojure.java.io :as io]
            [immutant.web.async :as async]
            [me.raynes.conch.low-level :as sh]))

(defroutes home-routes
  (GET "/tail" [file] (fn [request]
                        (let [proc (sh/proc "tail" "-f" file)
                              rd (io/reader (:out proc))]
                          (async/as-channel request
                            {:on-open (fn [stream]
                                        (loop [line (.readLine rd)]
                                          (async/send!
                                            stream
                                            (if (.sendStarted stream)
                                              line
                                              {:status 200 :headers {"Content-Type" "text/html"} :body line})
                                            {:close? (nil? line)})
                                          (when (not (nil? line))
                                            (recur (.readLine rd)))))})))))
