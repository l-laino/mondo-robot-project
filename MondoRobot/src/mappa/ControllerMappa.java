package mappa;

import components.*;


public class ControllerMappa {
    private ModelMappa m;
    private int dim;

    public ControllerMappa(int dim){
        this.dim = dim;
        m = new ModelMappa(this.dim);
        createMap(m.mat);
    }
    public void createMap (Caselle [][] mat)
    {
        for (int x = 0; x < dim; x++)
        {
            for (int y = 0; y < dim; y++)
            {
                if (x == 0 || x == dim-1 || y == 0 || y == dim-1) {
                    mat[x][y] = new Muro();
				}
				else {
					mat[x][y] = new Vuota();					
				}
             }
        }
    }
    
    public class ModelMappa {
        private Caselle mat[][];
    
        public ModelMappa(int dim) {
            this.mat = new Caselle[dim][dim];
        }

        public Caselle[][] getMat() {
            return mat;
        }
        
        
    }
}

