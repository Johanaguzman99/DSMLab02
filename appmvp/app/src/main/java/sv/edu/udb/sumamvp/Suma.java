package sv.edu.udb.sumamvp;

public interface Suma {
    interface View{
        void mostrarResultado(String resultado);
        void mostrarErrores(String error);
    }
    interface Presenter{
        void mostrarResultado(String result);
        void sumar(String[] data);
        void mostrarErrores(String error);
    }
    interface Model{
        void sumar(String[] data);
    }
}
