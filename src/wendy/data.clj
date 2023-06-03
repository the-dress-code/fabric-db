(ns wendy.data
  (:gen-class))

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

                   {#_#_:fabric/name "white multicolor small-floral cotton linen"
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
