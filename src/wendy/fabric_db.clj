(ns wendy.fabric-db
  (:gen-class))


(require '[datomic.api :as d])


(def db-uri "datomic:mem://fabric")


(d/create-database db-uri)


(def conn (d/connect db-uri))


@(d/transact conn [{:db/doc "Hiya, world! This is my fabric database."}])


(def fabric-schema [#_{:db/ident :fabric/name 
                     :db/valueType :db.type/string
                     :db/cardinality :db.cardinality/one
                     :db/doc "The name of the fabric"}

                    {:db/ident :fabric/fiber-origin
                     :db/valueType :db.type/ref
                     :db/cardinality :db.cardinality/many
                     :db/doc "The origin of the fabric's fibers"}

                    {:db/ident :fiber-origin/plant}
                    {:db/ident :fiber-origin/animal}
                    {:db/ident :fiber-origin/manufactured}  

                    {:db/ident :fabric/fiber-content
                     :db/valueType :db.type/ref
                     :db/cardinality :db.cardinality/many
                     :db/doc "The fiber content of the fabric"}

                    {:db/ident :fiber-content/linen}
                    {:db/ident :fiber-content/cotton}  
                    {:db/ident :fiber-content/polyester}
                    {:db/ident :fiber-content/rayon}
                    {:db/ident :fiber-content/wool}

                    {:db/ident :fabric/structure
                     :db/valueType :db.type/ref
                     :db/cardinality :db.cardinality/one
                     :db/doc "The structure of the fabric"}

                    {:db/ident :structure/woven}
                    {:db/ident :structure/knit}
                    {:db/ident :structure/non-woven}
                    {:db/ident :structure/felt}
                    {:db/ident :structure/skin}
                   
                    {:db/ident :fabric/type
                     :db/valueType :db.type/ref
                     :db/cardinality :db.cardinality/many
                     :db/doc "The type of fabric"}

                    {:db/ident :type/dressweight}
                    {:db/ident :type/bottomweight}
                    {:db/ident :type/jersey}
                    {:db/ident :type/flannel}
                    {:db/ident :type/activewear}

                    ;; possible additional types: challis, satin, denim, twill, chiffon, suiting, gabardine, 
                    ;; swimwear, lace, lining, interlock, home-dec, sweater-knit

                    {:db/ident :fabric/pattern
                     :db/valueType :db.type/ref
                     :db/cardinality :db.cardinality/one
                     :db/doc "The pattern on the fabric"}

                    {:db/ident :pattern/solid}
                    {:db/ident :pattern/stripe}      
                    {:db/ident :pattern/geometric}      
                    {:db/ident :pattern/small-floral}      
                    {:db/ident :pattern/med-floral}

                    {:db/ident :fabric/color
                     :db/valueType :db.type/ref
                     :db/cardinality :db.cardinality/many
                     :db/doc "The color of the fabric"}

                    {:db/ident :color/blue}
                    {:db/ident :color/green}
                    {:db/ident :color/white}
                    {:db/ident :color/brown}
                    {:db/ident :color/gray}
                    {:db/ident :color/black}
                    {:db/ident :color/multicolor}

                    {:db/ident :fabric/color-intensity
                     :db/valueType :db.type/ref
                     :db/cardinality :db.cardinality/one
                     :db/doc "The intensity of the color of the fabric"}

                    {:db/ident :color-intensity/pale}
                    {:db/ident :color-intensity/light}     
                    {:db/ident :color-intensity/medium}     
                    {:db/ident :color-intensity/dark}

                    {:db/ident :fabric/weight
                     :db/valueType :db.type/ref
                     :db/cardinality :db.cardinality/one
                     :db/doc "The weight of the fabric"}

                    {:db/ident :weight/extra-lightweight}
                    {:db/ident :weight/lightweight}
                    {:db/ident :weight/mid-weight}
                    {:db/ident :weight/heavyweight}
                    {:db/ident :weight/coat-weight}

                    {:db/ident :fabric/length-yards
                     :db/valueType :db.type/float
                     :db/cardinality :db.cardinality/one
                     :db/doc "The length (as a float) of the fabric in yards"}

                    {:db/ident :fabric/width-inches
                     :db/valueType :db.type/long
                     :db/cardinality :db.cardinality/one
                     :db/doc "The width (as a long) of the fabric in inches"}

                    {:db/ident :fabric/country
                     :db/valueType :db.type/string
                     :db/cardinality :db.cardinality/one
                     :db/doc "The country of origin of the fabric"}

                    {:db/ident :fabric/source
                     :db/valueType :db.type/string
                     :db/cardinality :db.cardinality/one
                     :db/doc "The vendor who sold the fabric"}])


@(d/transact conn fabric-schema)


(def initial-fabrics [{#_#_:fabric/name "light blue green mid-weight linen"
                    :fabric/fiber-origin :fiber-origin/plant
                    :fabric/fiber-content :fiber-content/linen
                    :fabric/structure :structure/woven
                    :fabric/type  :type/dressweight
                    :fabric/pattern :pattern/solid
                    :fabric/color [:color/blue :color/green]
                    :fabric/color-intensity :color-intensity/light
                    :fabric/weight :weight/mid-weight
                    :fabric/length-yards 5.0
                    :fabric/width-inches 59
                    :fabric/country "Eastern Europe"
                    :fabric/source "fabrics-store.com"}

                   {#_#_:fabric/name "dark green mid-weight linen"
                    :fabric/fiber-origin :fiber-origin/plant
                    :fabric/fiber-content :fiber-content/linen
                    :fabric/structure :structure/woven
                    :fabric/type :type/dressweight
                    :fabric/pattern :pattern/solid
                    :fabric/color :color/green
                    :fabric/color-intensity :color-intensity/dark
                    :fabric/weight :weight/mid-weight
                    :fabric/length-yards 5.0
                    :fabric/width-inches 59
                    :fabric/country "Eastern Europe"
                    :fabric/source "fabrics-store.com"}

                   {#_#_:fabric/name "dark green light-weight linen"
                    :fabric/fiber-origin :fiber-origin/plant
                    :fabric/fiber-content :fiber-content/linen
                    :fabric/structure :structure/woven
                    :fabric/pattern :pattern/solid
                    :fabric/color :color/green
                    :fabric/color-intensity :color-intensity/dark
                    :fabric/weight :weight/lightweight
                    :fabric/length-yards 2.0
                    :fabric/width-inches 58
                    :fabric/country "Eastern Europe"
                    :fabric/source "fabrics-store.com"}

                   {#_#_:fabric/name "medium brown mid-weight linen"
                    :fabric/fiber-origin :fiber-origin/plant
                    :fabric/fiber-content :fiber-content/linen
                    :fabric/structure :structure/woven
                    :fabric/type :type/dressweight
                    :fabric/pattern :pattern/solid
                    :fabric/color :color/brown
                    :fabric/color-intensity :color-intensity/medium
                    :fabric/weight :weight/mid-weight
                    :fabric/length-yards 4.0
                    :fabric/width-inches 59
                    :fabric/country "Eastern Europe"
                    :fabric/source "fabrics-store.com"}


                   {#_#_:fabric/name "black multi floral rayon challis"
                    :fabric/fiber-origin :fiber-origin/manufactured
                    :fabric/fiber-content :fiber-content/rayon
                    :fabric/structure :structure/woven
                    :fabric/type :type/dressweight
                    :fabric/pattern :pattern/small-floral
                    :fabric/color [:color/black :color/multicolor]
                    :fabric/color-intensity :color-intensity/dark
                    :fabric/weight :weight/lightweight
                    :fabric/length-yards 2.0
                    :fabric/width-inches 54
                    :fabric/country "China"
                    :fabric/source "Joann Fabrics"}

                   {#_#_:fabric/name "light blue cotton"
                    :fabric/fiber-origin :fiber-origin/plant
                    :fabric/fiber-content :fiber-content/cotton
                    :fabric/structure :structure/woven
                    :fabric/type  :type/dressweight
                    :fabric/pattern :pattern/solid
                    :fabric/color :color/blue
                    :fabric/color-intensity :color-intensity/light
                    :fabric/weight :weight/mid-weight
                    :fabric/length-yards 2.0
                    :fabric/width-inches 45
                    :fabric/country "unknown"
                    :fabric/source "vintage"}

                   {#_#_:fabric/name "white multicolor small floral cotton linen"
                    :fabric/fiber-origin :fiber-origin/plant
                    :fabric/fiber-content [:fiber-content/linen :fiber-content/cotton]
                    :fabric/structure :structure/woven
                    :fabric/type  :type/bottomweight
                    :fabric/pattern :pattern/small-floral
                    :fabric/color [:color/white :color/multicolor]
                    :fabric/color-intensity :color-intensity/medium
                    :fabric/weight :weight/mid-weight
                    :fabric/length-yards 1.0
                    :fabric/width-inches 45
                    :fabric/country "unknown"
                    :fabric/source "vintage"}

                   {#_#_:fabric/name "black mid-weight cotton lycra knit"
                    :fabric/fiber-origin :fiber-origin/plant
                    :fabric/fiber-content :fiber-content/cotton
                    :fabric/structure :structure/knit
                    :fabric/type  :type/jersey
                    :fabric/pattern :pattern/solid
                    :fabric/color :color/black
                    :fabric/color-intensity :color-intensity/dark
                    :fabric/weight :weight/mid-weight
                    :fabric/length-yards 2.0
                    :fabric/width-inches 54
                    :fabric/country "unknown"
                    :fabric/source "Sew Sassy Fabrics"}

                   {#_#_:fabric/name "pale gray brown lightweight cotton"
                    :fabric/fiber-origin :fiber-origin/plant
                    :fabric/fiber-content :fiber-content/cotton
                    :fabric/structure :structure/woven
                    :fabric/type  :type/dressweight
                    :fabric/pattern :pattern/solid
                    :fabric/color [:color/brown :color/gray]
                    :fabric/color-intensity :color-intensity/pale
                    :fabric/weight :weight/lightweight
                    :fabric/length-yards 3.0
                    :fabric/width-inches 144
                    :fabric/country "unknown"
                    :fabric/source "Ikea"}

                   {#_#_:fabric/name "medium gray lightweight wool"
                    :fabric/fiber-origin :fiber-origin/animal
                    :fabric/fiber-content :fiber-content/wool
                    :fabric/structure :structure/woven
                    :fabric/type  :type/dressweight
                    :fabric/pattern :pattern/solid
                    :fabric/color :color/gray
                    :fabric/color-intensity :color-intensity/medium
                    :fabric/weight :weight/lightweight
                    :fabric/length-yards 3.0
                    :fabric/width-inches 54
                    :fabric/country "unknown"
                    :fabric/source "vintage"}])


@(d/transact conn initial-fabrics)


(def db (d/db conn))


(d/q '[:find ?e
       :where [?e :fabric/pattern :pattern/solid]]
      (d/db conn))
;; => #{[17592186045459] [17592186045460] [17592186045461] [17592186045462] [17592186045464] [17592186045466] [17592186045467] [17592186045468]}


(def all-blue-plant-fabrics
  "A query to return all the blue and plant fabric entity ids"
  '[:find ?e
    :where [?e :fabric/color :color/blue]
           [?e :fabric/fiber-origin :fiber-origin/plant]])


(d/q all-blue-plant-fabrics db)
;; => #{[17592186045459] [17592186045464]}


(def blue-plant-eids-set (d/q all-blue-plant-fabrics db))

; Do something to the eid that is inside the vector, inside the set.

(defn inc-set 
  [coll]
  (inc (first coll)))

(map inc-set blue-plant-eids-set)
;; => (17592186045460 17592186045465)

; Get just one value.

(ffirst blue-plant-eids-set)
;; => 17592186045459

; Resolve one ATTRIBUTE/VALUE eid to its corresponding value.

(d/touch (d/entity db 17592186045455))
;; => #:db{:id 17592186045455, :ident :weight/mid-weight}

(map val (d/touch (d/entity db 17592186045455)))
;; => (:weight/mid-weight)

(-> (first (map val (d/touch (d/entity db 17592186045455)))) name name)
;; => "mid-weight"

; another way: resolve one attrib eid to its cooresponding value.

(d/ident db 17592186045455)
;; => :weight/mid-weight

(-> (d/ident db 17592186045455) name)
;; => "mid-weight"

; if given an eid for a fabric, can you build a name?

; step 1 - get all the values of all the attributes

(d/touch (d/entity db 17592186045464))
;; => {:fabric/weight :weight/mid-weight, :fabric/type #{:type/dressweight}, :fabric/pattern :pattern/solid, :fabric/color #{:color/blue}, :fabric/length-yards 2.0, :fabric/color-intensity :color-intensity/light, :fabric/source "vintage", :fabric/fiber-origin #{:fiber-origin/plant}, :fabric/fiber-content #{:fiber-content/cotton}, :fabric/structure :structure/woven, :db/id 17592186045464, :fabric/width-inches 45, :fabric/country "unknown"}

; step 2 - make this a fn. "When you have functionality, capture it."

(defn all-eid-values [eid]
  (d/touch (d/entity db eid)))
;; => #'wendy.fabric-db/all-eid-values

(all-eid-values 17592186045464)
;; => {:fabric/weight :weight/mid-weight, :fabric/type #{:type/dressweight}, :fabric/pattern :pattern/solid, :fabric/color #{:color/blue}, :fabric/length-yards 2.0, :fabric/color-intensity :color-intensity/light, :fabric/source "vintage", :fabric/fiber-origin #{:fiber-origin/plant}, :fabric/fiber-content #{:fiber-content/cotton}, :fabric/structure :structure/woven, :db/id 17592186045464, :fabric/width-inches 45, :fabric/country "unknown"}

(def all-eid-values-light-blue-cotton 
  (all-eid-values 17592186045464))
;; => #'wendy.fabric-db/all-eid-values-light-blue-cotton

; step 3

; what values do you want in your name?

; in this order,

; :fabric/color-intensity
; :fabric/color
; :fabric/weight.
; :fabric/fiber-content
; :fabric/structure

; can you get those values out of your entity map?

all-eid-values-light-blue-cotton
;; => {:fabric/weight :weight/mid-weight, :fabric/type #{:type/dressweight}, :fabric/pattern :pattern/solid, :fabric/color #{:color/blue}, :fabric/length-yards 2.0, :fabric/color-intensity :color-intensity/light, :fabric/source "vintage", :fabric/fiber-origin #{:fiber-origin/plant}, :fabric/fiber-content #{:fiber-content/cotton}, :fabric/structure :structure/woven, :db/id 17592186045464, :fabric/width-inches 45, :fabric/country "unknown"}

(:fabric/weight all-eid-values-light-blue-cotton)
;; => :weight/mid-weight

(-> (:fabric/weight all-eid-values-light-blue-cotton) name)
;; => "mid-weight"

; write an fn that takes a entity map and key. returns one attrib value as a name.

(-> (:fabric/weight all-eid-values-light-blue-cotton) name)
;; => "mid-weight"

; Remove the namespace later, not now, bc some values can't be resolved to names without further processing.

; FYI future me took out name-resolving fn of this helper fn.

(defn get-yr-val
  [key map]
  (key map))
;; => #'wendy.fabric-db/get-yr-val

(get-yr-val :fabric/weight all-eid-values-light-blue-cotton)
;; => :weight/mid-weight

; write a function that takes an entity map, and uses your helper function to return something you need for your name.

(defn to-the-edge
  [map]
  (get-yr-val :fabric/weight map))
;; => #'wendy.fabric-db/to-the-edge

(to-the-edge {:fabric/weight :weight/mid-weight, :fabric/type #{:type/dressweight}, :fabric/pattern :pattern/solid, :fabric/color #{:color/blue}, :fabric/length-yards 2.0, :fabric/color-intensity :color-intensity/light, :fabric/source "vintage", :fabric/fiber-origin #{:fiber-origin/plant}, :fabric/fiber-content #{:fiber-content/cotton}, :fabric/structure :structure/woven, :db/id 17592186045464, :fabric/width-inches 45, :fabric/country "unknown"})
;; => :weight/mid-weight

; next step: modify your function to return 2 yr-vals

;  when you want to do some work and store function calls into vars that you want to use later… 
;  use let below - bind the result of this to a var.

(defn to-the-edge
  [entity-map]
  (let [x (get-yr-val :fabric/weight entity-map)]
    x))
;; => #'wendy.fabric-db/to-the-edge

(to-the-edge {:fabric/weight :weight/mid-weight, :fabric/type #{:type/dressweight}, :fabric/pattern :pattern/solid, :fabric/color #{:color/blue}, :fabric/length-yards 2.0, :fabric/color-intensity :color-intensity/light, :fabric/source "vintage", :fabric/fiber-origin #{:fiber-origin/plant}, :fabric/fiber-content #{:fiber-content/cotton}, :fabric/structure :structure/woven, :db/id 17592186045464, :fabric/width-inches 45, :fabric/country "unknown"})
;; => :weight/mid-weight

; next step: modify your function to return 2 yr-vals

;  when you want to do some work and store function calls into vars that you want to use later… 
;  use let below - bind the result of this to a var.

(defn to-the-edge
  [entity-map]
  (let [x (get-yr-val :fabric/color-intensity entity-map)
        y (get-yr-val :fabric/color entity-map)]
    x y))
;; => #'wendy.fabric-db/to-the-edge

(to-the-edge {:fabric/weight :weight/mid-weight, :fabric/type #{:type/dressweight}, :fabric/pattern :pattern/solid, :fabric/color #{:color/blue}, :fabric/length-yards 2.0, :fabric/color-intensity :color-intensity/light, :fabric/source "vintage", :fabric/fiber-origin #{:fiber-origin/plant}, :fabric/fiber-content #{:fiber-content/cotton}, :fabric/structure :structure/woven, :db/id 17592186045464, :fabric/width-inches 45, :fabric/country "unknown"})
;; => #{:color/blue}

; hmm, this is only 1 val, not 2 val. how to fix?

; My helper fn get-yr-val seems to do the same as to-the-edge now since i took out the name-resolve, so i think get-yr-val redundant. i'll consolidate get-yr-val and to-the-edge and now write "get-the-val".

(defn get-the-val
  [key map]
  (key map))
;; => #'wendy.fabric-db/get-the-val

(get-the-val :fabric/color-intensity all-eid-values-light-blue-cotton)
;; => :color-intensity/light

; next step: modify your function to return 2 yr-vals
;  when you want to do some work and store function calls into vars that you want to use later… use let.
;  use let below - bind the result of this to a var.

; what if i destructure like this....

(defn get-some-vals 
  [{a :fabric/weight 
    b :fabric/type}]
  (list a b))
;; => #'wendy.fabric-db/get-some-vals

(get-some-vals {:fabric/weight :weight/mid-weight
                :fabric/type #{:type/dressweight}})
;; => (:weight/mid-weight #{:type/dressweight})

; Use let:

(defn get-some-vals-2
  [map]
  (let [intensity (:fabric/color-intensity map)
        color (:fabric/color map)]
    (list intensity color)))
;; => #'wendy.fabric-db/get-some-vals-2

(get-some-vals-2 {:fabric/weight :weight/mid-weight, :fabric/type #{:type/dressweight}, :fabric/pattern :pattern/solid, :fabric/color #{:color/blue}, :fabric/length-yards 2.0, :fabric/color-intensity :color-intensity/light, :fabric/source "vintage", :fabric/fiber-origin #{:fiber-origin/plant}, :fabric/fiber-content #{:fiber-content/cotton}, :fabric/structure :structure/woven, :db/id 17592186045464, :fabric/width-inches 45, :fabric/country "unknown"})
;; => (:color-intensity/light #{:color/blue})




;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;




; ideas for later:

; (map val hashmap) will map val over your entity map and return the value of all entity attributes.

(map val {:fabric/weight :weight/mid-weight, :fabric/type #{:type/dressweight}, :fabric/pattern :pattern/solid, :fabric/color #{:color/blue}, :fabric/length-yards 2.0, :fabric/color-intensity :color-intensity/light, :fabric/source "vintage", :fabric/fiber-origin #{:fiber-origin/plant}, :fabric/fiber-content #{:fiber-content/cotton}, :fabric/structure :structure/woven, :db/id 17592186045464, :fabric/width-inches 45, :fabric/country "unknown"})
;; => (:weight/mid-weight
;;     #{:type/dressweight}
;;     :pattern/solid
;;     #{:color/blue}
;;     2.0
;;     :color-intensity/light
;;     "vintage"
;;     #{:fiber-origin/plant}
;;     #{:fiber-content/cotton}
;;     :structure/woven
;;     17592186045464
;;     45
;;     "unknown")



;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;



(def color-intensity-of-blue-plants 
  "A query to return all the blue and plant fabric entity ids and the ids for 1 attribute's entity id (color intensity)"


  '[:find ?e ?color-intensity
    :where [?e :fabric/color :color/blue]
           [?e :fabric/fiber-origin :fiber-origin/plant]
           [?e :fabric/color-intensity ?color-intensity]])
;; => #'wendy.fabric-db/color-intensity-of-blue-plants


(d/q color-intensity-of-blue-plants db)
;; => #{[17592186045464 17592186045450] [17592186045459 17592186045450]}


(d/entity db 17592186045464)
;; => #:db{:id 17592186045464}


(d/pull db '[*] 17592186045464)
;; => {:fabric/weight #:db{:id 17592186045455},
;;     :fabric/type [#:db{:id 17592186045432}],
;;     :fabric/pattern #:db{:id 17592186045437},
;;     :fabric/color [#:db{:id 17592186045442}],
;;     :fabric/length-yards 2.0,
;;     :fabric/color-intensity #:db{:id 17592186045450},
;;     :fabric/source "vintage",
;;     :fabric/fiber-origin [#:db{:id 17592186045419}],
;;     :fabric/fiber-content [#:db{:id 17592186045423}],
;;     :fabric/structure #:db{:id 17592186045427},
;;     :db/id 17592186045464,
;;     :fabric/width-inches 45,
;;     :fabric/country "unknown"}


(d/touch (d/entity db 17592186045464))
;; => {:fabric/weight :weight/mid-weight, :fabric/type #{:type/dressweight}, :fabric/pattern :pattern/solid, :fabric/color #{:color/blue}, :fabric/length-yards 2.0, :fabric/color-intensity :color-intensity/light, :fabric/source "vintage", :fabric/fiber-origin #{:fiber-origin/plant}, :fabric/fiber-content #{:fiber-content/cotton}, :fabric/structure :structure/woven, :db/id 17592186045464, :fabric/width-inches 45, :fabric/country "unknown"}
