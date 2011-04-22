(ns fabagax.app_servlet
  (:gen-class :extends javax.servlet.http.HttpServlet)
  (:use fabagax.core)
  (:use [appengine-magic.servlet :only [make-servlet-service-method]]))


(defn -service [this request response]
  ((make-servlet-service-method fabagax-app) this request response))
