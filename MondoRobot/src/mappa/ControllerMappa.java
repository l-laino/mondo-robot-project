package mappa;

import components.*;


public class ControllerMappa {
    private ModelMappa m;
    

    public ControllerMappa(int dim){
        m = new ModelMappa(dim);
        createMap(m.mat, dim);
    }
    public void createMap (Caselle [][] mat, int dim)
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
        private int dim;
    
        public ModelMappa(int dim) {
            this.dim = dim;
            this.mat = new Caselle[dim][dim];
        }

        public Caselle[][] getMat() {
            return mat;
        }
        
        
    }
}

