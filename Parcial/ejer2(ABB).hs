--Gaston Martin
data BiTree a = Nill | Nod (BiTree a) a (BiTree a)

sizeTree :: BiTree a -> Int
sizeTree Nill = 0 
sizeTree (Nod izq a der) = 1 + sizeTree izq + sizeTree der 

altTree :: BiTree a -> Int
altTree Nill = 0
altTree(Nod izq a der) = 1 + max (altTree izq) (altTree der)

preorden :: (Ord a) => Abb a -> [a]
preorden Nill = []
preorden (Nod actual izq der) = [actual] ++ preorden izq ++ preorden der

inorden :: (Ord a) => Abb a -> [a]
inorden Nill = []
inorden (Nod actual izq der) = inorden izq ++ [actual] ++ inorden der

postorden :: (Ord a) => Abb a -> [a]
postorden Nill = []
postorden (Nod actual izq der) = postorden izq ++ postorden der ++ [actual]

insertarNodo :: (Ord a) => a -> Abb a -> Abb a
insertarNodo nuevoElem Nill = Nod nuevoElem Nill Nill
insertarNodo nuevoElem (Nod a izq der)
 | nuevoElem <= a = Nod a (insertarNodo nuevoElem izq) der
 | nuevoElem > a = Nod a izq (insertarNodo nuevoElem der)

buscarNodo :: (Ord a) => a -> BiTree a -> Bool
buscarNodo elemBuscar Nil = False
buscarNodo elemBuscar (Nod a izq der)
 | elemBuscar == a = True
 | elemBuscar < a = buscarNodo elemBuscar izq
 | otherwise = buscarNodo elemBuscar der