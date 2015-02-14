(ns kit.core)

(defmacro ? [a & ks]
  `(aget ~a ~@(map #(if (keyword? %) (name %) %) ks)))

(defmacro ! [a k v]
  `(aset ~a ~(name k) ~v))
