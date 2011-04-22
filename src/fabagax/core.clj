(ns fabagax.core
  (:require [appengine-magic.core :as ae])
  (:use compojure.core
        hiccup.core
        fabagax.views)
  (:gen-class))

(defroutes fabagax-app-handler
  (GET "/" req (homepage))
  (ANY "*" _ {:status 200
              :headers {"Content-Type" "text/plain"}
              :body "not found"}))

(ae/def-appengine-app fabagax-app #'fabagax-app-handler)

; Comment this out before deploying to GAE
; This is for restarting the webserver real quick with a C-c C-L or
; C-c C-k
;(ae/start fabagax-app)






