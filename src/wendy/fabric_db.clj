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


(type blue-plant-eids-set)
;; => java.util.HashSet


(map identity blue-plant-eids-set)
;; => ([17592186045459] [17592186045464])

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;


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
; this is an entity map

(type (d/entity db 17592186045464))
;; => datomic.query.EntityMap


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
