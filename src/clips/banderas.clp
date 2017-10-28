(deftemplate Pais
  (slot Nombre)
  (multislot Bandera)
)

(defrule lee_cantidad
  (initial-fact)
  =>
  (printout t "Por cuantos colores desea buscar? (uno,dos)" crlf)
  (assert (cantidad (read)))
)

(defrule uno
  (cantidad uno)
  =>
  (printout t "Introduzca el color: " crlf)
  (assert (color (read)))
)

(defrule un_color
  (color ?x)
  (or
  (Pais (Nombre ?nombre)(Bandera ?x $?))
  (Pais (Nombre ?nombre)(Bandera ? ?x ?))
  (Pais (Nombre ?nombre)(Bandera $? ?x))
  )
  =>
  (printout t "Banderas con color " ?x ": " ?nombre crlf)
  (assert (pais ?nombre)(color ?x))
)


(defrule dos
 (cantidad dos)
 =>
 (printout t "Introduzca los colores: " crlf)
 (bind ?colores (explode$ (readline)))
 (assert (color1 (nth$ 1 ?colores))
         (color2 (nth$ 2 ?colores)))
)

(defrule dos_colores
  (color1 ?x)
  (color2 ?y)
  (or
  (Pais (Nombre ?nombre)(Bandera ?x ?y ?))
  (Pais (Nombre ?nombre)(Bandera ?x ? ?y))
  (Pais (Nombre ?nombre)(Bandera ?y ?x ?))
  (Pais (Nombre ?nombre)(Bandera ?y ? ?x))
  (Pais (Nombre ?nombre)(Bandera ? ?y ?x))
  (Pais (Nombre ?nombre)(Bandera ? ?x ?y))
  )
  =>
  (printout t "Banderas con color " ?x " y " ?y ": " ?nombre crlf)
  (assert (pais ?nombre)(color1 ?x)(color2 ?y))
)



(deffacts colores_banderas
(Pais
(Nombre Colombia)
(Bandera azul rojo amarillo))

(Pais
(Nombre Argentina)
(Bandera azul amarillo blanco))

(Pais
(Nombre Bolivia)
(Bandera amarillo verde rojo))

(Pais
(Nombre Brazil)
(Bandera amarillo azul verde))

(Pais
(Nombre Chile)
(Bandera rojo azul blanco))

(Pais
(Nombre Ecuador)
(Bandera amarillo azul rojo))

(Pais
(Nombre Venezuela)
(Bandera amarillo azul rojo))

(Pais
(Nombre Paraguay)
(Bandera blanco azul rojo))
(Pais
(Nombre Peru)
(Bandera blanco rojo))

(Pais
(Nombre "Puerto Rico")
(Bandera blanco azul rojo))

(Pais
(Nombre Uruguay)
(Bandera amarillo azul blanco))

(Pais
(Nombre Alemania)
(Bandera amarillo negro rojo))

(Pais
(Nombre Italia)
(Bandera verde blanco rojo))

(Pais
(Nombre Mexico)
(Bandera verde blanco rojo))

(Pais
(Nombre Francia)
(Bandera azul blanco rojo))

(Pais
(Nombre Holanda)
(Bandera azul blanco rojo))

(Pais
(Nombre Inglaterra)
(Bandera azul blanco rojo))

(Pais
(Nombre USA)
(Bandera azul blanco rojo))

(Pais
(Nombre Japon)
(Bandera blanco rojo))

)
