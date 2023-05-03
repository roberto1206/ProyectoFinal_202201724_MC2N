/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Clases;

import static Ventanas.VentanaPrincipal.R_repaint;
import static Ventanas.VentanaPrincipal.ingresarNodoOrigen;
import static Ventanas.VentanaPrincipal.jPanel1;
import java.awt.Color;

/**
 *
 * @author fredy-18
 */
public class Algoritmo_Prim {
    
    private int cumulado;
   private int aristaMenor;
   private int  fin;
   private boolean estaNodo=false;
   private boolean aumentaTamano;
   private int nodoApuntado;  
   private int nodoApuntador;
   private int tamano;
   private int arsitaMayor;
   private  Arboles arboles;
   private int tope;
   private  int  nodoOrigen;
   
   
   
   public Algoritmo_Prim(Arboles arbol , int top ,int aristaMayor ){
       this.cumulado = 0;
       this.aristaMenor = 0;
       this.fin = 0;
       this.estaNodo=false;
       this.aumentaTamano = false;
       this.nodoApuntado = 0;  
       this.nodoApuntador = 0;
       this.tamano = 1;
       this. arsitaMayor=aristaMayor;
       this.arboles = arbol;
       this.tope = top;
   }

    public int getCumulado() {
        return cumulado;
    }
  
   
  public void prim(){
      this.nodoOrigen= ingresarNodoOrigen("Ingrese Nodo Origen..","nodo Origen No existe",tope);
       jPanel1.paint(jPanel1.getGraphics());
       R_repaint(tope,arboles);
       arboles.crearEnArbol(tope);
       arboles.setEnArbol(0, nodoOrigen);
       //algoritmo de Prim ---->>
       do{
           this.aristaMenor = this.arsitaMayor;
           this.fin=2;
            for (int j = 0; j < tamano; j++) {
                for (int k = 0; k < tope; k++){
                    if(arboles.getmAdyacencia(k, arboles.getEnArbol(j))==1){
                        for (int h = 0; h < tamano; h++) {
                             if(arboles.getEnArbol(h)==k ){
                                 this.estaNodo=true; 
                                 break;
                             }
                        }
                        if(estaNodo==false){
                            if(arboles.getmCoeficiente(k, arboles.getEnArbol(j))<=aristaMenor && arboles.getmCoeficiente(k, arboles.getEnArbol(j))>0 ){
                                 aristaMenor=arboles.getmCoeficiente(k, arboles.getEnArbol(j));
                                 this.nodoApuntado=k;
                                 this.aumentaTamano=true;
                                 this.nodoApuntador=arboles.getEnArbol(j);
                                 this.fin=1;
                            }
                        }
                        this.estaNodo=false;
                    }
                }
            }//fin  for (int j = 0; j < tamano; j++)              
         if(aumentaTamano==true){
                    Pintar.pintarCamino(jPanel1.getGraphics(),arboles.getCordeX(nodoApuntador), arboles.getCordeY(nodoApuntador),arboles.getCordeX(nodoApuntado), arboles.getCordeY(nodoApuntado),Color.red); 
                    Pintar.clickSobreNodo(jPanel1.getGraphics(),arboles.getCordeX(nodoApuntador), arboles.getCordeY(nodoApuntador), null,Color. red);
                    Pintar.clickSobreNodo(jPanel1.getGraphics(),arboles.getCordeX(nodoApuntado), arboles.getCordeY(nodoApuntado), null, Color.red);                                  
                    arboles.setEnArbol(tamano, nodoApuntado);
                    this.tamano++;
                    this.aumentaTamano=false;
                    this.cumulado += this.aristaMenor;
         }
        }while(fin<2);
   }
    
}
