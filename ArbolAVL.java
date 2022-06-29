import javax.swing.JOptionPane;

public class ArbolAVL {
    private NodoArbolAVL raiz;

    public ArbolAVL() {
        this.raiz = null;
    }

    public NodoArbolAVL obtenerRaiz() {
        return raiz;
    }

    // buscar
    public NodoArbolAVL buscar(int d, NodoArbolAVL r) {
        if (raiz == null) {
            return null;
        } else if (r.dato == d) {
            return r;
        } else if (r.dato < d) {
            return buscar(d, r.hijoDerecho);
        } else {
            return buscar(d, r.hijoIzquierdo);
        }
    }

    // obtener factor de equilibrio
    public int obtenerFE(NodoArbolAVL x) {
        if (x == null) {
            return -1;
        } else {
            return x.fe;
        }
    }

    // rotacion simple a la izquierda
    public NodoArbolAVL rotacionIzquierda(NodoArbolAVL c) {
        NodoArbolAVL auxiliar = c.hijoIzquierdo;
        c.hijoIzquierdo = auxiliar.hijoDerecho;
        auxiliar.hijoDerecho = c;
        c.fe = Math.max(obtenerFE(c.hijoIzquierdo), obtenerFE(c.hijoDerecho)) + 1; // obtiene el maximo
        auxiliar.fe = Math.max(obtenerFE(auxiliar.hijoIzquierdo), obtenerFE(auxiliar.hijoDerecho)) + 1;
        return auxiliar;
    }

    // rotacion simple derecha
    public NodoArbolAVL rotacionDerecha(NodoArbolAVL c) {
        NodoArbolAVL auxiliar = c.hijoDerecho;
        c.hijoDerecho = auxiliar.hijoIzquierdo;
        auxiliar.hijoIzquierdo = c;
        c.fe = Math.max(obtenerFE(c.hijoIzquierdo), obtenerFE(c.hijoDerecho)) + 1; // obtiene el maximo
        auxiliar.fe = Math.max(obtenerFE(auxiliar.hijoIzquierdo), obtenerFE(auxiliar.hijoDerecho)) + 1;
        return auxiliar;
    }

    // rotacion doble a la der
    public NodoArbolAVL rotacionDobleIzquierda(NodoArbolAVL c) {
        NodoArbolAVL temporal;
        c.hijoIzquierdo = rotacionDerecha(c.hijoIzquierdo);
        temporal = rotacionIzquierda(c);
        return temporal;

    }

    // rotacion doble a la izq
    public NodoArbolAVL rotacionDobleDerecha(NodoArbolAVL c) {
        NodoArbolAVL temporal;
        c.hijoDerecho = rotacionIzquierda(c.hijoDerecho);
        temporal = rotacionDerecha(c);
        return temporal;
    }

    // insertar avl
    public NodoArbolAVL insertarAVL(NodoArbolAVL nuevo, NodoArbolAVL subAr) {
        NodoArbolAVL nuevoPadre = subAr;
        if (nuevo.dato < subAr.dato) {
            if (subAr.hijoIzquierdo == null) {
                subAr.hijoIzquierdo = nuevo;
            } else {
                subAr.hijoIzquierdo = insertarAVL(nuevo, subAr.hijoIzquierdo);
                if ((obtenerFE(subAr.hijoIzquierdo) - obtenerFE(subAr.hijoDerecho) == 2)) {
                    if (nuevo.dato < subAr.hijoIzquierdo.dato) {
                        nuevoPadre = rotacionIzquierda(subAr);
                    } else {
                        nuevoPadre = rotacionDobleIzquierda(subAr);
                    }
                }
            }
        } else if (nuevo.dato > subAr.dato) {
            if (subAr.hijoDerecho == null) {
                subAr.hijoDerecho = nuevo;
            } else {
                subAr.hijoDerecho = insertarAVL(nuevo, subAr.hijoDerecho);
                if ((obtenerFE(subAr.hijoDerecho) - obtenerFE(subAr.hijoIzquierdo) == 2)) {
                    if (nuevo.dato > subAr.hijoDerecho.dato) {
                        nuevoPadre = rotacionDerecha(subAr);
                    } else {
                        nuevoPadre = rotacionDobleDerecha(subAr);
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Nodo duplicado");
        }

        // actualizar altura
        if ((subAr.hijoIzquierdo == null) && (subAr.hijoDerecho != null)) {
            subAr.fe = subAr.hijoDerecho.fe + 1;
        } else if ((subAr.hijoDerecho == null) && (subAr.hijoIzquierdo != null)) {
            subAr.fe = subAr.hijoIzquierdo.fe + 1;
        } else {
            subAr.fe = Math.max(obtenerFE(subAr.hijoIzquierdo), obtenerFE(subAr.hijoDerecho)) + 1;
        }
        return nuevoPadre;
    }

    // insertar normal
    public void insertar(int d) {
        NodoArbolAVL nuevo = new NodoArbolAVL(d);
        if (raiz == null) {
            raiz = nuevo;
        } else {
            raiz = insertarAVL(nuevo, raiz);
        }
    }

    // recorridos
    // recorrer in orden
    public void inOrden(NodoArbolAVL r) {
        if (r != null) {
            inOrden(r.hijoIzquierdo);
            System.out.println(r.dato);
            inOrden(r.hijoDerecho);
        }
    }

    // recorrer en preorden
    public void preorden(NodoArbolAVL r) {
        if (r != null) {
            System.out.println(r.dato);
            preorden(r.hijoIzquierdo);
            preorden(r.hijoDerecho);
        }
    }

    // recorrer postorden
    public void postOrden(NodoArbolAVL r) {
        if (r != null) {
            postOrden(r.hijoIzquierdo);
            postOrden(r.hijoDerecho);
            System.out.println(r.dato);
        }
    }

    public boolean estaVacio() {
        return raiz == null;
    }
}


    
	

	
		
	
 
	 
		

     
     
            
            
               
            
                
            
             
            
        
    	

     
     
            
            
            
            
        
    	

    	 
     
          
          
          
              
            
            
    	

    	 
     
          
          
          
              
            
            
    	

     
    	  
        
         
          
        

    

    	 
     
        
         
          
        
    	

    	 
     
          
            
                
                  
              
                  
                      
                        
                          
                      
                          
                    
                
            
             
                
                  
              
                  
                      
                        
                          
                      
                          
                    
                
            
          
            
        

         
                
                
                       
                
                
                
        
           
    	

     
    	  
         
            
              
            
              
         
    	

     
	  
	  
	     
		    
			
			
			
		

     
 
	     
	 
		    
			
			
			

     
	 
            
	 
	 
            
			
			

     
	  

	
