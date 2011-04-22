(ns fabagax.views
  (:require [appengine-magic.services.user :as u])
  (:use hiccup.core
        fabagax.helpers
        ))

(defn layout
  [body]
  (html
   [:head
    [:title "Fabagax"]
    (cssfile "style.css")]
   [:body
    [:div {:id "header"}
     [:h1 "Fabagax"]
     (if (u/user-logged-in?)
       (do
         [:p
          "Logged in as "
          (u/current-user)
          (if (u/user-admin?)
           " (Admin)")
          ". "
          (link-to (u/logout-url) "Logout")])
       [:p (link-to (u/login-url) "Login")])
     [:p "My journey learning Clojure, Compojure, Emacs and Swank for web development on Google App Engine"]]
    [:div {:id "content"} body]
    [:div {:id "footer"} "All rights reserved Fabagax, Alvin Lai 2011"]]
   (google-analytics "UA-22731879-2")))

(defn homepage
  []
  (layout
   (html
    [:h2 "What's this?"]
    [:ul
     [:li
     "This is a webpage powered by "
     (link-to "http://clojure.org" "Clojure")
     " hosted on "
     (link-to "https://appengine.google.com" "Google App Engine")
     " run by "
     (link-to "http://alvinlai.com" "Alvin Lai")
      "."]
     [:li "I made this for several purposes:"
      [:ul
       [:li "Learn and document my journey in learning Clojure"]
       [:li "Practise deploying it online for real world practise"]]]
     ]
    ;; 
    [:h3 "Todos"]
    [:ol
     [:li "Get stylesheets running working"]
     [:li "Now I really don't know already, don't you think so?"]]
    [:h3 "Questions"]
    [:ul
     [:li "Should style templates be standalone, like in Rails?"]]
    ;;
    [:h3 "Thoughts"]
    [:p "I'm really beginning to enjoy web development in Clojure even though I'm just doing a few simple things now:"
     [:ul
      [:li "Building a static webpage using this templating library called "
       (link-to "https://github.com/weavejester/hiccup" "Hiccup")]
      [:li "paredit is a must have because with it, you don't need to care about paren matching! It's really really nice!"]]
     [:h3 "GAE Deploy Notes"]
     [:ul
      [:li ";comment (ae/serve your-app) right before you compile to run on Google App Engine."]
      [:li "lein appengine-prepare"]
      [:li "appcfg.sh update war/"]]
     ]) ))
