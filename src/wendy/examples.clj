(ns wendy.examples
  (:gen-class)
  (:require [datomic.api :as d]
            [wendy.fabric-db :as fabric-db]))

(d/q '[:find ?e
       :where [?e :fabric/pattern :pattern/solid]]
      (d/db wendy.fabric-db/conn))

(def all-blue-plant-fabrics
  "A query to return all the blue and plant fabric entity ids"
  '[:find ?e
    :where [?e :fabric/color :color/blue]
           [?e :fabric/fiber-origin :fiber-origin/plant]])

;; db is not defined here so will error
(def blue-plant-eids (d/q all-blue-plant-fabrics db))

(def color-intensity-of-blue-plant-fabric
  "A query to return all blue & plant fabric entity ids and the color intensity eids"
  '[:find ?e ?color-intensity
    :where [?e :fabric/color :color/blue]
           [?e :fabric/fiber-origin :fiber-origin/plant]
           [?e :fabric/color-intensity ?color-intensity]])

;; db is not defined here so will error
(d/q color-intensity-of-blue-plant-fabric db)

;; db is not defined here so will error
(d/entity db 17592186045464)

;; db is not defined here so will error
(d/pull db '[*] 17592186045464)

;; db is not defined here so will error
(d/touch (d/entity db 17592186045464))

wendy.fabric-db/all-attrib-values-light-blue-cotton
;; => {:fabric/weight :weight/mid-weight, :fabric/type #{:type/dressweight}, :fabric/pattern :pattern/solid, :fabric/color #{:color/blue}, :fabric/length-yards 2.0, :fabric/color-intensity :color-intensity/light, :fabric/source "vintage", :fabric/fiber-origin #{:fiber-origin/plant}, :fabric/fiber-content #{:fiber-content/cotton}, :fabric/structure :structure/woven, :db/id 17592186045464, :fabric/width-inches 45, :fabric/country "unknown"}
