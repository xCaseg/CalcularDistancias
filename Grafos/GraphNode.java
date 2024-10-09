package Grafos;

import java.util.ArrayList;


    public class GraphNode {
        
    private String name = new String();//Identificador del grafo
    private ArrayList<Edge> edges = new ArrayList<>();//Listado de vértices
    

    public GraphNode() {//Para crear nodos vacíos
        }      

    public String getName() {
        return name;
        }      

    public void setName(String name) {
        this.name = name;
    }      

    public ArrayList<Edge> getEdges() {
        return edges;
        }      

    public void setEdges(ArrayList<Edge> edges) {
        this.edges = edges;
        }
    

        
}//Graph node        
