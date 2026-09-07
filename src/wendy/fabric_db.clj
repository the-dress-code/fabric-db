(ns wendy.fabric-db
  (:gen-class)
  (:require [datomic.api :as d]
            [wendy.schema :as s]
            [wendy.data :as data]
            [clojure.string :as str]))

(def db-uri "datomic:mem://fabric")

(d/create-database db-uri)
;; (d/delete-database uri)

(def conn (d/connect db-uri))

@(d/transact conn [{:db/doc "Hiya, world! This is my fabric database project."}])

@(d/transact conn s/fabric-schema)

@(d/transact conn data/initial-fabrics)

;; use / eval this db var only if you specifically want a fixed point in time to query against.

(def db (d/db conn))

;;;;;;;;;;;;;; BUILD A NAME FROM AN ENTITY ID.

(defn all-attrib-values
  "Takes an entity id, and returns a map of all the entity's attributes and attribute values."
  [eid]
  (d/touch (d/entity db eid)))

(defn get-five-vals
  "Takes an entity map, gets the attribute values of five attributes, and returns them in a list"
  [map]
  (let [intensity (:fabric/color-intensity map)
        color (:fabric/color map)
        weight (:fabric/weight map)
        content (:fabric/fiber-content map)
        structure (:fabric/structure map)]
    (list intensity color weight content structure)))

(defn giga-flatten
  "Takes one 'coll', checks for sets within, returns sets if they exist, puts single items into vectors if any. Returns a list."
  [coll]
  (mapcat
   (fn [x]
     (if (set? x)
       x
       [x]))
   coll))

(defn build-a-name
   "Take an eid and give me the constructed name of the entity."
  [eid]
  (->> eid
      all-attrib-values
      get-five-vals
      giga-flatten
      (map name)
      (str/join " ")))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;; Experimental stuff from September 2026

(all-attrib-values 17592186045464)

(def all-attrib-values-light-blue-cotton
  (all-attrib-values 17592186045464))


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;


;; Whats going on here, pulled from examples.clj

(d/q '[:find ?e
       :where [?e :fabric/pattern :pattern/solid]]
      (d/db conn))
;; => #{[17592186045459] [17592186045460] [17592186045461] [17592186045462] [17592186045464] [17592186045466] [17592186045467] [17592186045468]}
;; result after loading buffer once after fresh repl start


;; => #{[17592186045537] [17592186045538] [17592186045543] [17592186045544] [17592186045545] [17592186045546] [17592186045548] [17592186045550] [17592186045551] [17592186045552] [17592186045459] [17592186045460] [17592186045461] [17592186045462] [17592186045464] [17592186045466] [17592186045467] [17592186045468] [17592186045473] [17592186045474] [17592186045475] [17592186045476] [17592186045478] [17592186045480] [17592186045481] [17592186045482] [17592186045487] [17592186045488] [17592186045489] [17592186045490] [17592186045492] [17592186045494] [17592186045495] [17592186045496] [17592186045501] [17592186045502] [17592186045503] [17592186045504] [17592186045506] [17592186045508] [17592186045509] [17592186045510] [17592186045515] [17592186045516] [17592186045517] [17592186045518] [17592186045520] [17592186045522] [17592186045523] [17592186045524] [17592186045529] [17592186045530] [17592186045531] [17592186045532] [17592186045534] [17592186045536]}

;; returns a map of a bunch of EIDs i guess, but this is way more than the 10 or so in my dataset. what gives?
;; this is 56 items, maybe you transacted the seed data 7 times. 8 of your 10 fabrics are solid → 7 × 8 = 56.
;; maybe (d/delete-database db-uri) to the file then create again


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

all-attrib-values-light-blue-cotton
;; => {:fabric/weight :weight/mid-weight, 
;;    :fabric/type #{:type/dressweight}, 
;;    :fabric/pattern :pattern/solid, 
;;    :fabric/color #{:color/blue}, 
;;    :fabric/length-yards 2.0, 
;;    :fabric/color-intensity :color-intensity/light, 
;;    :fabric/source "vintage", 
;;    :fabric/fiber-origin #{:fiber-origin/plant}, 
;;    :fabric/fiber-content #{:fiber-content/cotton}, 
;;    :fabric/structure :structure/woven, 
;;    :db/id 17592186045464, 
;;    :fabric/width-inches 45, 
;;    :fabric/country "unknown"}
