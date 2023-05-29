(ns wendy.examples
  (:gen-class))

(d/q '[:find ?e
       :where [?e :fabric/pattern :pattern/solid]]
      (d/db conn))

(def all-blue-plant-fabrics
  "A query to return all the blue and plant fabric entity ids"
  '[:find ?e
    :where [?e :fabric/color :color/blue]
           [?e :fabric/fiber-origin :fiber-origin/plant]])

(def blue-plant-eids (d/q all-blue-plant-fabrics db))

(def color-intensity-of-blue-plant-fabric 
  "A query to return all blue & plant fabric entity ids and the color intensity eids"
  '[:find ?e ?color-intensity
    :where [?e :fabric/color :color/blue]
           [?e :fabric/fiber-origin :fiber-origin/plant]
           [?e :fabric/color-intensity ?color-intensity]])

(d/q color-intensity-of-blue-plant-fabric db)

(d/entity db 17592186045464)

(d/pull db '[*] 17592186045464)

(d/touch (d/entity db 17592186045464))

(def poo 2)
;; => #'wendy.examples/poo

wendy.fabric-db/all-attrib-values-light-blue-cotton
;; => {:fabric/weight :weight/mid-weight, :fabric/type #{:type/dressweight}, :fabric/pattern :pattern/solid, :fabric/color #{:color/blue}, :fabric/length-yards 2.0, :fabric/color-intensity :color-intensity/light, :fabric/source "vintage", :fabric/fiber-origin #{:fiber-origin/plant}, :fabric/fiber-content #{:fiber-content/cotton}, :fabric/structure :structure/woven, :db/id 17592186045464, :fabric/width-inches 45, :fabric/country "unknown"}
