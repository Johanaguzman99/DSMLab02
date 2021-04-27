package sv.edu.udb.sumamvp;

public class SumaPresenter implements Suma.Presenter {
    private Suma.View view;
    private Suma.Model suma;

    public SumaPresenter(Suma.View view){
        this.view = view;
        suma = new SumaModel(this);
    }
    @Override
    public void mostrarResultado(String result) {
        if (view != null){
            view.mostrarResultado(result);
        }
    }

    @Override
    public void sumar(String[] data) {
        if (view != null){
        suma.sumar(data);
        }
    }

    @Override
    public void mostrarErrores(String error) {
        if (view != null){
            view.mostrarErrores(error);
        }
    }
}
