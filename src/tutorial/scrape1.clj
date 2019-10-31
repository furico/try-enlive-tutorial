(ns tutorial.scrape1
  (:require [net.cgrand.enlive-html :as html]))

(def ^:dynamic *base-url* "https://news.ycombinator.com")

(defn fetch-url [url]
  (html/html-resource (java.net.URL. url)))

(defn hn-headlines []
  (map html/text (html/select (fetch-url *base-url*) [:td.title :a])))
