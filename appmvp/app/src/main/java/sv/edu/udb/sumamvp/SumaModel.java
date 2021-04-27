package sv.edu.udb.sumamvp;

public class SumaModel implements Suma.Model {
    private Suma.Presenter presenter;
    private int resultado;

    public SumaModel(Suma.Presenter presenter){
        this.presenter = presenter;
    }

    @Override
    public void sumar(String[] data) {
        if (data[0].equals("") && data[1].equals("")){
            presenter.mostrarErrores("Campos vacios!");
        } else if (data[0].equals("")) {
            presenter.mostrarErrores("Numero 1 vacio!");
        }else if(data[1].equals("")){
            presenter.mostrarErrores("Numero 2 vacio!");
        }
         else {
            resultado = Integer.parseInt(data[0] )+ Integer.parseInt(data[1]);
            presenter.mostrarResultado(String.valueOf(resultado));
        }
    }
}
