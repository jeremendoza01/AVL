import javax.swing.JOptionPane;

public class prueba {
    ArbolAVL avl= new ArbolAVL();

    public void capturar(){
        int dato;
        dato=Integer.parseInt(JOptionPane.showInputDialog("Ingresa el numero: "));

        avl.insertar(dato);
        JOptionPane.showMessageDialog(null,"Nodo "+dato+" agregado...");
    }

public void imprimir(){
    int d;
     d=Integer.parseInt(JOptionPane.showInputDialog("ARBOL AVL\n\nIngrese una opcion: \nInOrden(1)\nPreOrden(2)\nPostOrden(3)"));
                switch(d){
                    case 1:
                        if(!avl.estaVacio()){
                            System.out.println("Arbol en InOrden");
                            avl.inOrden(avl.obtenerRaiz());
                        }else{
                            JOptionPane.showMessageDialog(null, "El arbol esta vacio");
                        }
                        break;
                    case 2:
                        if(!avl.estaVacio()){
                            System.out.println("Arbol en PreOrden");
                           avl.preorden(avl.obtenerRaiz());
                        }else{
                            JOptionPane.showMessageDialog(null, "El arbol esta vacio");
                        }
                        break;
                    case 3:
                        if(!avl.estaVacio()){
                            System.out.println("Arbol en PostOrden");
                          avl.postOrden(avl.obtenerRaiz());
                        }else{
                            JOptionPane.showMessageDialog(null, "El arbol esta vacio");
                        }
                        break;
                }
                JOptionPane.showMessageDialog(null, "Mostrado en consola...");
}
  
    public static void main(String[] args) {
        prueba clase = new prueba();
     int r=0;

        do{
        r=Integer.parseInt(JOptionPane.showInputDialog("Ingrese una opcion: \nIngresar(1)\nImprimir(2)\nSalir(3)"));
        switch(r){
            case 1:
              clase.capturar();
                break;
            case 2:
         clase.imprimir();
                break;
            case 3:
                
                break;
            case 4:
                break;

            default:JOptionPane.showMessageDialog(null, "La opcion esta incorrecta");
        }
        }while(r!=3);
    }
}