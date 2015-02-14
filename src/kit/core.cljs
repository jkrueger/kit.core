(ns kit.core)

(def clj->json (comp js/JSON.stringify clj->js))

(defn error? [x]
  (or (and (vector? x) (= :error (first x)))
      (instance? js/Error x)
      (instance? cljs.core.ExceptionInfo x)))

(defn ok? [x]
  (not (error? x)))

(defn enable-source-maps []
  (.install (js/require "source-map-support")))
