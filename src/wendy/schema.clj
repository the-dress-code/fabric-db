(ns wendy.schema
  (:gen-class))

(def fabric-schema [{:db/ident :fabric/fiber-origin
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
