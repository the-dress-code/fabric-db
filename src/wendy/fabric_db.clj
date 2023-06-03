(ns wendy.fabric-db
  (:gen-class)
  (:require [datomic.api :as d]
            [wendy.schema :as s]
            [wendy.data :as data]))

(def db-uri "datomic:mem://fabric")

(d/create-database db-uri)

(def conn (d/connect db-uri))

@(d/transact conn [{:db/doc "Hiya, world! This is my fabric database project."}])

@(d/transact conn s/fabric-schema)

@(d/transact conn data/initial-fabrics)

(def db (d/db conn))

;;;;;;;;;;;;;; BUILD A NAME FROM AN ENTITY ID.

(defn all-attrib-values [eid]
"Takes an entity id, and returns a map of all the entity's attributes and attribute values."
  (d/touch (d/entity db eid)))

(defn get-five-vals [map]
"Takes an entity map, gets the attribute values of five attributes, and returns them in a list"
  (let [intensity (:fabric/color-intensity map)
        color (:fabric/color map)
        weight (:fabric/weight map)
        content (:fabric/fiber-content map)
        structure (:fabric/structure map)]
    (list intensity color weight content structure)))

(defn giga-flatten [coll]
"Takes one 'coll', checks for sets within, returns sets if they exist, puts single items into vectors if any. Returns a list."
  (mapcat 
   (fn [x] 
     (if (set? x) 
       x 
       [x])) 
   coll))

(defn build-a-name [eid]
 "Take an eid and give me the constructed name of the entity."
  (->> eid
      all-attrib-values
      get-five-vals
      giga-flatten
      (map name)
      (clojure.string/join " ")))
