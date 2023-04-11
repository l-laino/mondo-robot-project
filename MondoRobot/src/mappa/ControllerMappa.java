package mappa;

public class ControllerMappa {
    private ModelMappa m;
    private int dim;

    public ControllerMappa(int dim){
        this.dim = dim;
        m = new ModelMappa(this.dim);
    }
}
