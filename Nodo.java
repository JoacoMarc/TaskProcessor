package Implementacion;
import Interfaz.NodoI;
public class Nodo implements NodoI {

    private String _info;

    public Nodo(){
        this._info = null;
    }

    public Nodo(String info) {
        this._info = info;
    }

    @Override
    public void setInfo(String info) {
        this._info = info;
    }

    @Override
    public String getInfo() {
        return this._info;
    }

}
