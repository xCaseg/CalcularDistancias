package Grafos;

public class Edge{
    
    GraphNode target= new GraphNode(); //Es el nodo objetivo o destino
    Integer cost= null;
    
      
public Edge() {//Para crear aristas vacías
    }      

public GraphNode getTarget() {
    return target;
    }      

public void setTarget(GraphNode target) {
        this.target = target;
    }      

public Integer getCost() {
        return cost;
    }      

public void setCost(Integer cost) {
        this.cost = cost;
    }



}