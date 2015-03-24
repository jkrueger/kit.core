(ns kit.core
  (:require-macros [kit.core :as core]))

(def clj->json (comp js/JSON.stringify clj->js))

(defn error? [x]
  (or (and (vector? x) (= :error (first x)))
      (instance? js/Error x)
      (instance? cljs.core.ExceptionInfo x)))

(defn ok? [x]
  (not (error? x)))

(defn enable-source-maps []
  (.install (js/require "source-map-support")))

(defn module-system?
  "Checks if a CommonJS style module system is present"
  []
  (and (core/exists? js/module) (.-exports js/module)))
